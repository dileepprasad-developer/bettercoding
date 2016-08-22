package com.dileep.java.workout;

public class LinkedListExcersises {
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
	node1.print();
	
	Node reversed = reverseLinkedList(node1);
	 reversed.print();

	Node reversedRecur = revereseRecursively(reversed);
	reversedRecur.print();
	
	Node reversedKnodes =  revereseKNodes(reversedRecur , 5);
	reversedKnodes.print();
}

public static Node reverseLinkedList(Node head){
	
	Node previous = null; 
	Node next = null;
	Node current =  head;
	while (current != null){
		next = current.next;
		current.next =  previous;
		previous = current;
		current = next;
	}
	return previous;
}

public static Node revereseKNodes(Node head , int k){
	Node previous = null;
	Node next = null;
	Node current = head;
	int count =0;
	while(current != null && count < k){
		next =  current.next;
		current.next =  previous;
		previous =  current;
		current =next;
		count++;
	}
	if(next != null){
		head.next =revereseKNodes(next, k);
	}
	return previous ;
}

public static Node revereseRecursively(Node head){
	if(null == head.next){
		return head;
	}
	Node newHead = revereseRecursively(head.next);
	head.next.next=head;
	head.next= null;
	return newHead;
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
