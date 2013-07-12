import java.util.Iterator;

public class MyLinkedList<T> implements Iterable<T> {
	

	private class Node<T> {
		public T data;
		public Node<T> previous;
		public Node<T> next;

		public Node(T data , Node<T> previous , Node<T> next) {
			this.data = data;
			this.previous = previous;
			this.next = next;
		}
	}


	private Node<T> start;
	private Node<T> end;
	private int size;

	public MyLinkedList() {
		this.size = 0;
		this.start = null;
		this.end = null;
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public T get(int index) {
		return traverse(index).data;
	}

	public T getFirst(){
		if(size > 0) {
			return traverse(0).data;
		}
		return null;
	}

	public T getLast(){
		if( size > 0 ){
		return traverse(size-1).data;
		}
		return null;
	}

	public Node<T> traverse(int index) {
		if( index < 0 || index > size ) {
			throw new IndexOutOfBoundsException();
		} else {
			Node<T> current = start;
			for (int i = 0 ; i < index ; i++ ) {
				current = current.next;
			}
			return current;
		}
	}

	public void addAtBeg(T value) {
		add(0,value);
	}

	public void addToEnd(T value) {
		add(size,value);
	}

	public void add(int index , T value) {

		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException();
		} else {
			Node<T> current = start;
			for (int i = 0; i < index -1 ; i++ ) {
				current = current.next;
			}

			if( index == 0 ) {
				if (start ==null){
					Node<T> newNode = new Node<>(value , null, null);
					start=end=newNode;	
					size++;
				} else {
					Node<T> newNode = new Node<>(value , null, start);
					start.previous = newNode;
					start = newNode;
					size++;
				}
			} else if ( index == size ) {
				Node<T> newNode = new Node<>(value , end, null);
				end.next = newNode;
				end = newNode;
				size++;
			}

			 else {
				
				Node<T> nextToCurrent = current.next;
				Node<T> newNode = new Node<>(value , current, current.next);
				current.next = newNode;
				nextToCurrent.previous = newNode;
				size++;
			}
		}
	}

	public void remove(int index) {
		Node<T> current = traverse(index - 1);
		Node<T> nextToNext = current.next.next;
		current.next = nextToNext;
		nextToNext = current;
		size--;
	}

	public void remove(Node<T> node){
		Node<T> prev = node.previous;
		Node<T> next = node.next;
		prev.next = next;
		next.previous = prev;
	}

	@Override
	public String toString(){
		StringBuilder buffer = new StringBuilder();
		Node<T> current = start;
		while(current != null) {
			buffer.append(current.data);
			buffer.append(" => ");
			current=current.next;
		}
		buffer.append("null");
		return buffer.toString();
	}

	public Iterator<T> iterator(){
		return new MyLinkedListIterator();
	}

	private class MyLinkedListIterator implements Iterator<T>{
		private int current;
		private Node<T> currentNode;

		MyLinkedListIterator(){
			currentNode = start;
		}
		
		public boolean hasNext(){
			return current < size;
		}

		public T next(){
			T data = currentNode.data;
			currentNode = currentNode.next;
			current++;
			return data;
		}

		public void remove(){
			Node<T> next = currentNode.next;
			MyLinkedList.this.remove(currentNode);
			current--;
			currentNode = next;
		}
	}

	public static void main(String[] args) {
		MyLinkedList<Integer> list = new MyLinkedList<>();
		list.addAtBeg(4);
		list.addAtBeg(3);
		list.addAtBeg(2);
		list.addAtBeg(1);
		list.addToEnd(5);
		list.add(0,0);
		list.add(2,10);
		//System.out.println(list);
		list.remove(2);
		//System.out.println(list);

		for (Integer data : list ) {
			System.out.println(data);
		}
	}


}