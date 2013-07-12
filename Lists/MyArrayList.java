import java.lang.Iterable;
import java.lang.StringBuilder;
import java.lang.ArrayIndexOutOfBoundsException;
import java.util.Iterator;

public class MyArrayList<T> implements Iterable<T> {

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


	/**
	 * Clears the list and set its capacity to DEFAULT_CAPACITY
	 */

	private void clear( int size ) {
		this.size = 0;
		this.capacity = 0;
		ensureCapacity(size);
	}

	private void clear() {
		clear(DEFAULT_CAPACITY);
	}

	/**
	 * Returns the number of elements in this list
	 */

	public int size() {
		return this.size;
	}

	/**
	 * Set the capacity of the list to the current size ( no. of elements ).
	 * This method should be called once all the insertions are done to reclaim any
	 * extra memory that the array is taking up.
	 */

	public void trimToSize() {
		ensureCapacity(size);
	}

	

	/**
	 * Returns whether the list is empty or not.
	 */

	public boolean isEmpty() {
		return size == 0;
	}


	/**
	 * Gives the value of index.
	 */

	public T get(int index) {
		return this.items[index];
	}


	/**
	 * Sets the value of index.
	 */

	public void set(int index , T value) {
		if(index < 0 || index > size -1) {
			throw new ArrayIndexOutOfBoundsException(index);
		} else {
			items[index] = value;
		}
	}


	/**
	 * Add an item at the end of the list.
	 */

	public boolean add(T value) {

		items[size++] = value;
		return true;
	}


	/**
	 * Add an item at the specific index.
	 */

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


	/**
	 * Removes an item from the given index.
	 */

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



	/**
	 * This method ensures that the current capacity of the array should be
	 * atleast the value of capacity.User can call this method any time to expand the list.
	 * Note : List can't be shrinked with this method.
	 */

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

	public Iterator<T> iterator() {
		return new MyArrayListIterator();
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


	/**
	 * The iterator implementation to make it Iterable.
	 */
	private class MyArrayListIterator implements Iterator<T> {
		private int current = 0;
		
		public boolean hasNext() {
			return current < size;
		}

		public T next() {
			return items[current++];
		}

		public void remove() {
			MyArrayList.this.remove(--current);
		}

	}



	/**
	 * Main to test the implemented functionalities.
	 */
	public static void main(String[] args) {
		MyArrayList<Integer> list = new MyArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(2,10);
		list.add(2,11);
		Integer item = list.remove(2);
		//System.out.println(list);

		/** 
		* Iterable test of MyArrayList
		*/
		for (Integer i : list ) {
			System.out.println(i);
		}
	
	}

}