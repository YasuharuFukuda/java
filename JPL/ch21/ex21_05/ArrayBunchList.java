package ch21.ex21_05;

import java.util.AbstractList;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class ArrayBunchList<E> extends AbstractList<E>{
	private final E[][] arrays;
	private final int size;

	public ArrayBunchList(E[][] arrays) {
		this.arrays = arrays;
		int s = 0;
		for(E[] array : arrays)
			s += array.length;
		size = s;
	}

	public int size() {
		return size;
	}

	public E get(int index) {
		int off = 0;
		for(int i = 0; i < arrays.length; i++) {
			if(index < off + arrays[i].length)
				return arrays[i][index - off];
			off += arrays[i].length;
		}
		throw new ArrayIndexOutOfBoundsException(index);
	}

	public E set(int index, E value){
		int off = 0;
		for(int i = 0; i < arrays.length; i++) {
			if(index < off + arrays[i].length) {
				E ret = arrays[i][index - off];
				arrays[i][index - off] = value;
				return ret;
			}
			off += arrays[i].length;
		}
		throw new ArrayIndexOutOfBoundsException(index);
	}

	private class ABLIterator implements ListIterator<E>{
		private int off;
		private int array;
		private int pos;
		private boolean flag = false;

		public ABLIterator() {
			off = 0;
			array = 0;
			pos = 0;
			for (array = 0; array < arrays.length; array++)
				if(arrays[array].length > 0)
					break;
		}

		public boolean hasNext() {
			return off + pos < size();
		}

		public E next() {
			if(!hasNext())
				throw new NoSuchElementException();
			E ret = arrays[array][pos++];
			while(pos >= arrays[array].length) {
				off += arrays[array++].length;
				pos = 0;
				if(array >= arrays.length)
					break;
			}
			flag = true;
			return ret;
		}

		public boolean hasPrevious() {
			return off + pos > 1;
		}

		public E previous() {
			if(!hasPrevious())
				throw new NoSuchElementException();
			E ret = arrays[array][pos--];
			while(pos > 0) {
				off -= arrays[array--].length;
				pos = 0;
				if(array <= arrays.length)
					break;
			}
			flag = true;
			return ret;
		}

		public int nextIndex() {
			if (hasNext())
				return off + pos;
			else
				return size();
		}

		public int previousIndex() {
			if (hasPrevious())
				return (off + pos - 1);
			else
				return 0;
		}

		public void remove() {
			throw new UnsupportedOperationException();

		}

		public void set(E e) {
			if (!flag)
				throw new IllegalStateException();
			arrays[array][pos] = e;
		}

		public void add(E e) {
			// TODO 自動生成されたメソッド・スタブ

		}
	}

}
