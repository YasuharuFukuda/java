package ch21.ex21_07;

import java.util.ArrayList;

public class Stack<E> {
	private ArrayList<E> list;

	public boolean empty() {
		return list.size() == 0;
	}

	public E peek(){
		return list.get(list.size() - 1);
	}

	public E pop() {
		E item = list.get(list.size() - 1);
		list.remove(list.size() - 1);
		return item;
	}

	public E push(E item) {
		list.add(item);
		return item;
	}

	public int search(Object o){
		int count = 1;
		for (E e : list) {
			if (e.equals(o))
				return count;
			count++;
		}
		return -1;

	}


}
