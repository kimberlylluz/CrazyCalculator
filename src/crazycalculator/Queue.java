package crazycalculator;

public class Queue{
	private int length;
	public LinkNode front, rear;
	public int capacity = 50;

	public Queue(){
		length = 0;
		front = rear = null;
	}
	
	public Queue(int capacity){
		this.capacity = capacity;
	}
	
	public void enqueue (Object data) throws Exception{
		LinkNode node = new LinkNode(data);
		if (isEmpty())
			front = node;
		else
			if (size() == capacity)
				throw new Exception("Stack is full.");
			else{
				rear.setNext (node);
			}
		rear = node;
		length++;
	}

	public Object dequeue() throws Exception{
		if (isEmpty())
			throw new Exception ("Stack is empty");
		Object result = front.getData();
		front = front.getNext();
		length--;
		if (isEmpty())
			rear = null;
		return result;
	}

	public Object first() throws Exception{
		if (isEmpty())
			throw new Exception("Stack is empty"); 
		return front.getData();
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
	
	public void display(int i) {
		LinkNode link = front;
		int j = 0;

		if (i == 1) {
			while (link != null) {
				Main.stackTField[j].setText("" + link.getData());
				Main.queueTField[j++].setText("" + link.getData());
				link = link.next;
			}
		}
		else if (i == 2) {
			while (link != null) {
				Main.queueTField[j++].setText("" + link.getData());
				link = link.next;
			}
		}
		else if (i == 3) {
			while (link != null) {
				Main.stackTField[j++].setText("" + link.getData());
				link = link.next;
			}
		}
		
		clear(i, j);

		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
	
	public void clear(int i, int j) {
		if (i == 1) {
			int k;
			for (k = j; k < Main.stackTField.length; k++) {
				Main.stackTField[k].setText("");
				Main.queueTField[k].setText("");
			}
		}
		else if (i == 2) {
			int k;
			for (k = j; k < Main.stackTField.length; k++) {
				Main.queueTField[k].setText("");
			}
		}
		else if (i == 3) {
			int k;
			for (k = j; k < Main.stackTField.length; k++) {
				Main.stackTField[k].setText("");
			}
		}
		
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
	
}

