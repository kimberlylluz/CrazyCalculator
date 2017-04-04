package crazycalculator;

import java.awt.*;
import javax.swing.*;

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
				Display2.stackTField[j].setText("" + link.getData());
			    Display2.stackTField[j].setVisible(true);
				Display2.stackButton[j].setVisible(true);
				Display2.queueButton[j].setVisible(true);
				Display2.arrayButton[j].setVisible(true);
				if(j%2 != 0)
					Display2.llistButton[j].setIcon(new ImageIcon(getClass().getResource("linkshadowL.png")));
				else
					Display2.llistButton[j].setIcon(new ImageIcon(getClass().getResource("linkshadowR.png")));
				Display2.llistButton[j].setVisible(true);
				Display2.queueTField[j].setText("" + link.getData());
				Display2.queueTField[j].setVisible(true);
				Display2.llistTField[j].setVisible(true);
				Display2.llistTField[j].setText("" + link.getData());
				Display2.arrayTField[j++].setText("" + link.getData());
				link = link.next;
			}
		}
		else if (i == 2) {
			while (link != null) {
				Display2.queueTField[j].setText("" + link.getData());
				Display2.queueTField[j].setVisible(true);
				Display2.queueButton[j].setVisible(true);
				Display2.arrayButton[j].setVisible(true);
				Display2.llistButton[j].setVisible(true);
				Display2.llistTField[j].setVisible(true);
				Display2.llistTField[j].setText("" + link.getData());
				Display2.arrayTField[j++].setText("" + link.getData());
				link = link.next;
			}
		}
		else if (i == 3) {
			while (link != null) {
				Display2.stackTField[j].setText("" + link.getData());
			    Display2.stackTField[j].setVisible(true);
				Display2.stackButton[j++].setVisible(true);
				link = link.next;
			}
		}
		
		clear(i, j);

		try {
			Thread.sleep(CrazyCalculator.time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
	
	public void clear(int i, int j) {
		if (i == 1) {
			int k;
			for (k = j; k < Display2.stackTField.length; k++) {
				Display2.stackTField[k].setText("");
				Display2.queueTField[k].setText("");
				Display2.arrayTField[k].setText("");
				Display2.stackButton[k].setVisible(false);
				Display2.queueButton[k].setVisible(false);
				Display2.arrayButton[k].setVisible(false);
				Display2.llistButton[k].setVisible(false);
				Display2.stackTField[k].setVisible(false);
				Display2.queueTField[k].setVisible(false);
				Display2.llistTField[k].setVisible(false);
				Display2.llistTField[k].setText("");
			}
		}
		else if (i == 2) {
			int k;
			for (k = j; k < Display2.stackTField.length; k++) {
				Display2.queueTField[k].setText("");
				Display2.queueTField[k].setVisible(false);
				Display2.queueButton[k].setVisible(false);
				Display2.arrayButton[k].setVisible(false);
				Display2.llistButton[k].setVisible(false);
				Display2.arrayTField[k].setText("");
				Display2.llistTField[k].setVisible(false);
				Display2.llistTField[k].setText("");
			}
		}
		else if (i == 3) {
			int k;
			for (k = j; k < Display2.stackTField.length; k++) {
				Display2.stackTField[k].setText("");
				Display2.stackButton[k].setVisible(false);
				Display2.stackTField[k].setVisible(false);
			}
		}
		
		try {
			Thread.sleep(CrazyCalculator.time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
	
}

