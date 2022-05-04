/*
* Name:  	Lam, Simon
* Project: 	2
* Due:		February 1, 2013    
* Course: 	CS-240
*
* Description:
* This java file has the interface MyDeque<E>, class Node<E>, and class MyStack<E>. The MyDeque
* interface holds the templates for MyStack to implement. The Node class is made to create the Node
* object which makes this list a DoublyLinkedList. MyStack implements both class and interface to 
* create a stack for the RPN class.
*/

import java.lang.IndexOutOfBoundsException;
import java.util.EmptyStackException;
import java.lang.StringBuilder;

interface MyDeque<E> {
	void push(E e);
	E pop();
	E peek();
	int size();
}

class Node<E> {
	Node<E> prev;
	Node<E> next;
	E data;
	
	public Node(E data, Node<E> prev, Node<E> next) {
		this.data = data;
		this.prev = prev;
		this.next = next;
	}
}

public class MyStack<E> implements MyDeque<E>{

	private Node<E> head;
	private Node<E> tail;
	private int size = 0;
	
	public E pop() {
		if(size == 0)
			throw new IndexOutOfBoundsException();
		else {
			Node<E> temp = head.next;
			tail.next = temp;
			temp.prev = tail;
			head = temp;
		}
		size--;
		return head.data;
	}
	
	public void push(E e) {
		if(size == 0){
			head = new Node(e, head, head);
			tail = head;
		} else {
			Node<E> temp = new Node(e, tail, head);
			head.prev = temp;
			tail.next = temp;
			head = temp;
		}
		size++;
	}
	
	public E peek() {
		if(size == 0)
			throw new EmptyStackException();
		else {
			return head.data;
		}
	}
	
	public int size() {
		return size;
	}
	
	public String toString() {
		StringBuilder result = new StringBuilder();
		Node<E> temp = tail;
		for(int i = 0; i < size - 1; i++) {
			result.append(temp.data + ", ");
			temp = temp.prev;
		}
		result.append(head.data);
		return result.toString();
	}
}
