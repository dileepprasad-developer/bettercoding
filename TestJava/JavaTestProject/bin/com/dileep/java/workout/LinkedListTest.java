package com.dileep.java.workout;


public class LinkedListTest {

	
	public static Node Insert(Node head,int x) {
		 	Node newNode= new Node();
		    newNode.data = x;
		    newNode.next = head;
		    return newNode;
	}
	public static Node InsertNth(Node head, int data, int position) {
	    
	    Node newNode =  new Node();
	    newNode.data= data;
	    Node tmp = head;
	    if( null == head){
	    	if(position > 0)
	    		return null;
	        head =  newNode;
	        return head;
	    }
	    int counter = 0;
	    while (null != head.next){
	        if(counter == position-1){
	            Node current = head.next;
	            head.next = newNode;
	            newNode.next =  current;
	            break;
	        } 
	       head =  head.next;
            counter++;

	    }
	    return tmp;
	}
	
	public static Node Delete(Node head, int position) {
		
		 Node beginning =  head;
		    if( null == head ){
		        return beginning;
		    }
		    if(position == 0)
		    	return head.next;
		    int counter = 1; 
		    while( null != head.next && counter < position ){
		    	counter++;
		    	head  =   head.next;
		    }
	         head.next =  head.next.next;
		    return beginning;
		}
	static void ReversePrint(Node head) {
		  // This is a "method-only" submission. 
		  // You only need to complete this method. 
		    while(head.next != null){
		        head.next = head;
		        head.next.next= head.next;
		    }
		    }
	public static void main(String[] args) {
		Node node1 =  new Node();
		Node node2 =  new Node();
		Node node3 =  new Node();
		Node node4 =  new Node();
		Node node5 =  new Node();
		Node node6 =  new Node();
		Node node7 =  new Node();
		Node node8 =  new Node();
		Node node9 =  new Node();
		Node node10 = new Node();
		node1.data=1;node2.data=2;node3.data=3;node4.data=4;node5.data=5;node6.data=6;node7.data=7;node8.data=8;node9.data=9;node10.data=10;
		node1.next =node2;
		node2.next =node3;
		node3.next =node4;
		node4.next =node5;
		node5.next =node6;
		node6.next =node7;
		node7.next =node8;
		node8.next =node9;
		node9.next =node10;
		//node1.print();
		
		/*Node node = Insert(node1,90);
		System.out.println(" node = "+node.data);
		node.print();*/
		
		/*Node nodeInsertNth = InsertNth(node1,90 , 5);
		System.out.println(" node = "+nodeInsertNth.data);
		nodeInsertNth.print();
		
		Node nodeDelete = Delete(node1 , 4);
		nodeDelete.print();*/
		
		  ReversePrint(node1);
		  node1.print();
	}
}
class Node {
    int data;
    Node next;
    public void print(){
    	Node head = this;
    	while(null!= head.next ){
    		System.out.println(head.data);
    		head =head.next;
    	}
    }
 }