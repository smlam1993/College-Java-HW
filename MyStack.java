import java.lang.IndexOutOfBoundsException;
import java.util.EmptyStackException;
import java.lang.StringBuilder;

interface MyDeque<E> {
	void pop();
	void push(E e);
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
	
	Node<E> getNext() {
		return next;
	}
}

public class MyStack<E> implements MyDeque<E>{

	Node<Integer> node;
	private Node<E> head;
	private Node<E> tail;
	private int size = 0;
	
	public void pop() {
		if(size == 0)
			throw new IndexOutOfBoundsException();
		else {
			tail = head.next;
			(head.next).prev = tail;
			Node<E> temp = head.next;
			head = null;
			temp = head;
		}
		size--;
	}
	
	public void push(E e) {
		Node<E> temp;
		if(size == 0){
			head = new Node(e, head, head);
			tail = head;
		} else {
			temp = new Node(e, head.prev, head);
			head.next = temp;
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
		Node<E> temp = head;
		while(temp.getNext() != tail) {
			result.append(temp.data + ", ");
			temp.getNext();
		}
		result.append(tail.data);
		return result.toString();
	}
}
