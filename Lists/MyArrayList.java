import java.lang.Iterable;
import java.lang.StringBuilder;
import java.lang.ArrayIndexOutOfBoundsException;

public class MyArrayList<T>{

	private T[] items;
	private int size;
	private int capacity;
	private static final int DEFAULT_CAPACITY = 10;


	public MyArrayList() {
		this(DEFAULT_CAPACITY);
	}

	public MyArrayList( int size ) {

		clear(size);
	}


	private void clear( int size ) {
		this.size = 0;
		this.capacity = 0;
		ensureCapacity(size);
	}

	private void clear() {
		clear(DEFAULT_CAPACITY);
	}

	public int size() {
		return this.size;
	}
	public void trimToSize() {
		ensureCapacity(size);
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public T get(int index) {
		return this.items[index];
	}

	public void set(int index , T value) {
		if(index < 0 || index > size -1) {
			throw new ArrayIndexOutOfBoundsException(index);
		} else {
			items[index] = value;
		}
	}

	public boolean add(T value) {

		items[size++] = value;
		return true;
	}

	public boolean add(int index ,T value) {
		if (index < 0 ) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
		if( this.items.length == capacity ) {
			ensureCapacity(capacity * 2 + 1);
		}

		for(int i = size ; i > index ; i--) {
			items[i] = items[i-1];
		}

		items[index] = value;
		size++;
		return true;
	}


	public T remove(int index) {
		if(index < 0 || index > size -1) {
			throw new ArrayIndexOutOfBoundsException(index);
		} else {
		T val = items[index];
		for(int i = index ; i < size ; i++) {
			items[i] = items[i+1];
		}
		size--;
		return val;
	}
}


	public void ensureCapacity(int capacity) {

		if (  capacity < size ){
			return;
		}
		else if ( this.capacity == capacity ){
			return;
		}
		else {

			this.capacity = capacity;
			T[] oldItems = items;
			items = (T[]) new Object[capacity];

			for ( int i = 0; i < size ; i++ ) {
				items[i] = oldItems[i];
			}
		}

	}


	@Override
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		for (int i = 0 ; i < size ; i++ ){

			buffer.append(this.get(i));
			buffer.append(",");
		}

		return buffer.toString();
	}


	public static void main(String[] args) {
		MyArrayList<Integer> list = new MyArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(2,10);
		list.add(2,11);
		Integer item = list.remove(2);
		System.out.println(list);
	}

}