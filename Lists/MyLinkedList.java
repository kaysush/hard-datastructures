public class MyLinkedList<T> {
	

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

	public static void main(String[] args) {
		MyLinkedList<Integer> list = new MyLinkedList<>();
		//list.add(0,4);
		//list.add(0,3);
		//list.add(0,2);
		//list.add(0,1);
		//list.add(4,5);
		//list.add(0,0);
		list.addAtBeg(4);
		list.addAtBeg(3);
		list.addAtBeg(2);
		list.addAtBeg(1);
		list.addToEnd(5);
		list.add(0,0);
		list.add(2,10);
		System.out.println(list);
	}


}