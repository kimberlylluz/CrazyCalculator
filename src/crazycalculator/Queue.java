package crazycalculator;

public class Queue{
	public PseudoArray pseudoArray;

	public Queue(){
		pseudoArray = new PseudoArray();
	}
	public void enqueue (Object data) throws Exception{
		LinkNode node = new LinkNode(data);
		if (isEmpty())
			pseudoArray.front = node;
		else
			if (pseudoArray.size() == pseudoArray.capacity)
				throw new Exception("Stack is full.");
			else{
				pseudoArray.rear.setNext (node);
			}
		pseudoArray.rear = node;
		pseudoArray.length++;
	}

	public Object dequeue() throws Exception{
		if (isEmpty())
			throw new Exception ("Stack is empty");
		Object result = pseudoArray.front.getData();
		pseudoArray.front = pseudoArray.front.getNext();
		pseudoArray.length--;
		if (isEmpty())
			pseudoArray.rear = null;
		return result;
	}

	public Object first() throws Exception{
		if (isEmpty())
			throw new Exception("Stack is empty"); 
		return pseudoArray.front.getData();
	}

	public boolean isEmpty(){
		return pseudoArray.isEmpty();
	}

	public String toString(){
		return pseudoArray.toString();
	}
	
	public void display(int i) {
		LinkNode link = pseudoArray.front;
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

