package Stacks;

import Lists.MyLinkedList;

public class LinkedListStack<T> {
	private MyLinkedList<T> stack;

	public LinkedListStack(){
		this.stack = new MyLinkedList<>();
	}

	public void push(T value){
		stack.addToEnd(value);
	}

	public T pop() {
		return stack.removeFromEnd();
	}

	public String toString(){
		return stack.toString();
	}
	public static void main(String[] args){
		ArrayStack<Integer> stack = new ArrayStack<>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		System.out.println(stack);
		int value = stack.pop();
		System.out.println(stack);
	}
}