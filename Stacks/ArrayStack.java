package Stacks;

import Lists.MyArrayList;

public class ArrayStack<T> {
	private MyArrayList<T> stack;
	private int top;

	public ArrayStack() {
		this.stack = new MyArrayList<>();
		top = 0;
	}

	public void push(T value){
		stack.add(top++,value);
	}

	public T pop(){
		T value = stack.remove(--top);
		return value;
	}

	@Override
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