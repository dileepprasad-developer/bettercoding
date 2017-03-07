import org.apache.spark.SparkContext
import org.apache.spark.SparkContext
import org.apache.spark.{ Logging, SparkContext, SparkConf }
import com.datastax.spark.connector._, org.apache.spark.SparkContext, org.apache.spark.SparkContext._, org.apache.spark.SparkConf


class Test {
case class Account (user_id: String, account_id: String, balance: Double, last_updated: java.util.Date);

case class User (user_id: String, city_name: String, country_code: String, dob: java.util.Date, email: String, first_name: String, gender: String, last_name: String,
middle_name: String, phone_number: String, state_name: String, street_address: String,  last_updated: java.util.Date , 
zip_code: String)
 
case class UserAccount (user_id: String, balance: Double, first: String, last: String, city: String, state: String)

val conf = new SparkConf(true).set("spark.cassandra.connection.host", "localhost")
val sc = new SparkContext(conf)

val accounts = sc.cassandraTable[Account]("order_management", "accounts")
val users = sc.cassandraTable[User]("order_management", "users")


val accountsByUserId = accounts.keyBy(f =>(f.user_id , f.last_updated) )
val usersByUserId = users.keyBy(f => (f.user_id , f.last_updated)) 

//Join the tables by the user_id
val joinedUsers = accountsByUserId.join(usersByUserId)

//Create RDD with a the new object type which maps to our new table
val userAccountObjects = joinedUsers.map(f => (new UserAccount(f._2._1.user_id, f._2._1.balance, f._2._2.first_name, f._2._2.last_name, f._2._2.city_name, f._2._2.state_name)))

//get the top ten results 
//val top10 = userAccountObjects.collect.toList.sortBy(_.user_id).reverse.take(10)

val sumOfList = userAccountObjects.groupBy ( _.user_id ).mapValues(_.map(_.balance).sum )

//val sumOfList = userAccountObjects.collect.toList.groupBy ( _.user_id ).aggregate(_.balance)

val newRdd = sc.parallelize(sumOfList)

//save to Cassandra
newRdd.saveToCassandra("order_management", "useraccounts")

}