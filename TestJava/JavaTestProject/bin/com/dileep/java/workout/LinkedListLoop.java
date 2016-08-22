package com.dileep.java.workout;



public class LinkedListLoop {

	public static void main(String[] args) {
		Node node1 =  new Node("1");
		Node node2 =  new Node("2");
		Node node3 =  new Node("3");
		Node node4 =  new Node("4");
		Node node5 =  new Node("5");
		Node node6 =  new Node("6");
		Node node7 =  new Node("7");
		Node node8 =  new Node("8");
		Node node9 =  new Node("9");
		Node node10 =  new Node("10");
		node1.next =node2;
		node2.next =node3;
		node3.next =node4;
		node4.next =node5;
		node5.next =node6;
		node6.next =node7;
		node7.next =node8;
		node8.next =node9;
		node9.next =node10;
		node10.next = node1;
		System.out.println(""+isLoop(node1));
	}
	
	private static boolean isLoop(Node head){
		Node slowPointer =  head;
		Node fastPointer =  head;
		boolean isLooped = false;
		while(null != fastPointer && null != fastPointer.next){
			slowPointer =  slowPointer.next;
			fastPointer = fastPointer.next.next;
			System.out.println(slowPointer.val);
			System.out.println(fastPointer.val);
			if(slowPointer ==  fastPointer ){
				isLooped =  true;
				break;
			}
		}
		return isLooped;
	}
	
	static class Node{
		public Node next ;
		public String val;
		public Node(String val){
		this.val =  val;
		}
		public void print(){
			Node head = this;
			while (null != head )
			{
				System.out.println(head.val);
				head =  head.next;
			}
		
		}
	}
}
