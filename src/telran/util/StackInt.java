package telran.util;

import java.util.NoSuchElementException;

public class StackInt {
	
	private int arr[];
	private int top;
	private int maxNumber;
	
	public StackInt(int size) {
		this.arr = new int[size];
		this.top = -1;
	}

	public int pop() {
		if (isEmpty()) {
			throw new NoSuchElementException("Stack is empty!");
		} else {
			int res = arr[top];
			arr[top] = 0;
			top--;
			return res;
		}
	}
	
	public void push(int number) {
		arr[++top] = number;
		if (number > maxNumber) {
			maxNumber = number;
		}
	}
	
	public boolean isEmpty() {
		return top == -1;
	}
	
	public int getMaxNumber() {
		if (isEmpty()) {
			throw new NoSuchElementException("Stack is empty!");
		} else {
			return maxNumber;
		}
	}
	
	public int[] toArray() {
		return arr;
	}

}
