package crazycalculator;

public class PseudoArray{
	public int length;
	public LinkNode front, rear;
	public int capacity = 12;

	public PseudoArray(){
		length = 0;
		front = rear = null;
	}
	
	public PseudoArray(int capacity){
		this.capacity = capacity;
	}

	public boolean isEmpty(){
		return (length == 0);
	}

	public int size(){
		return length;
	}

	public String toString(){
		String result = "";
		LinkNode current = front;
		while (current != null){
			result = result + current.toString() + "\n";
			current = current.getNext();
		}
		return result;
	}
}