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
		display(2);
	}
	
	public void enqueue1 (Object data) throws Exception{
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
		display(1);
	}

	public Object dequeue() throws Exception{
		if (isEmpty())
			throw new Exception ("Stack is empty");
		Object result = pseudoArray.front.getData();
		pseudoArray.front = pseudoArray.front.getNext();
		pseudoArray.length--;
		if (isEmpty())
			pseudoArray.rear = null;
		display(2);
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
			    Main.stackTField[j].setVisible(true);
				Main.queueTField[j].setText("" + link.getData());
				Main.queueTField[j++].setVisible(true);
				link = link.next;
			}
		}
		else if (i == 2) {
			while (link != null) {
				Main.queueTField[j].setText("" + link.getData());
				Main.queueTField[j++].setVisible(true);
				link = link.next;
			}
		}
		else if (i == 3) {
			while (link != null) {
				Main.stackTField[j].setText("" + link.getData());
			    Main.stackTField[j++].setVisible(true);
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
				Main.stackTField[k].setVisible(false);
				Main.queueTField[k].setVisible(false);
			}
		}
		else if (i == 2) {
			int k;
			for (k = j; k < Main.stackTField.length; k++) {
				Main.queueTField[k].setText("");
				Main.queueTField[k].setVisible(false);
			}
		}
		else if (i == 3) {
			int k;
			for (k = j; k < Main.stackTField.length; k++) {
				Main.stackTField[k].setText("");
				Main.stackTField[k].setVisible(false);
			}
		}
		
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
	
}

