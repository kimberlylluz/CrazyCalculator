package crazycalculator;

import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CrazyCalculator extends Thread{
	String postfix, infixString, postfixString;
	String[] string;
	Stack stack;
	int size, j;
	public static int time;
	
	public CrazyCalculator(String[] string, int j){
		stack = new Stack();
		this.j = j;
		this.string = string;
	}
	
	public void run(){
		int count = 0;
			try{
				Input.postfixTField.setVisible(true);
				for(int i = 0; i < j + 1; i++){String temp = "";
					for(int j = 0; j < i + 1; j++){
						temp += string[j] + " ";
					}					
					String str = string[i];
						
					if (str.equals("(")){
						stack.push(str);
					}else if (str.equals(")")) {		
						while (!stack.isEmpty()) {
							String k = (String) stack.pop();
							if (k.equals("(")){
								break;
							}
							else
							   postfix += k + " ";
						}
					}else if(str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/") || str.equals("^")){
						if (str.equals("+") || str.equals("-"))
							pushOperator(str, 1);
						else if (str.equals("*") || str.equals("/"))
							pushOperator(str, 2);
						else if (str.equals("^"))
							pushOperator(str, 3);
					}
					else{
						postfix += str + " ";
					}
					
					char[] ch = postfix.toCharArray();
					StringBuilder strBuilder = new StringBuilder();
					for (int l = 4; l < ch.length; l++) {
						   strBuilder.append(ch[l]);
					}
					postfixString = strBuilder.toString();
					Thread.sleep(time);
					Display1.displayParsed(temp);
					if(count != 0){
						Display1.displayCommitted(postfixString);
					}
					System.out.println(postfixString);
					Input.postfixTField.setText(postfixString);
					count++;
				}
				
				while (!stack.isEmpty()) {
					postfix += stack.pop() + " ";
					char[] ch1 = postfix.toCharArray();
					StringBuilder strBuilder = new StringBuilder();
					for (int i = 4; i < ch1.length; i++) {
						   strBuilder.append(ch1[i]);
					}
					postfixString = strBuilder.toString();
					Display1.displayCommitted(postfixString);
					System.out.println(postfixString);
					Input.postfixTField.setText(postfixString);
				}
				
				char[] ch2 = postfix.toCharArray();
				StringBuilder strBuilder = new StringBuilder();
				for (int i = 4; i < ch2.length; i++) {
					   strBuilder.append(ch2[i]);
				}
				postfixString = strBuilder.toString();
				
				System.out.println(postfixString);
				Input.postfixTField.setText(postfixString);
				Thread.sleep(time);
				Input.inputLabel.setIcon(new ImageIcon(getClass().getResource("postfix1bg.png")));
				Display1.display1Label.setIcon(new ImageIcon(getClass().getResource("display1postfix.png")));
				Display2.display2Label.setIcon(new ImageIcon(getClass().getResource("postfixbg.png")));
				Input.answerTField.setVisible(true);
				getResult();
			        
			}catch(Exception ex){
				ex.printStackTrace();
			}		
	}
	
	public static boolean isNumeric(String str){  
		try  
		{  
			double d = Double.parseDouble(str);  
		}catch(NumberFormatException nfe){  
			return false;  
		}  
		return true;  
	}
	
	public boolean isOperator(String ch){
		return ch.equals("+") || ch.equals("-") || ch.equals("*") || ch.equals("/")|| ch.equals("^") ||  ch.equals("(") || ch.equals(")");
	}

	public void pushOperator(String opThis, int precedence) throws InterruptedException{
		try{
			if (stack.isEmpty()) {
				stack.push(opThis);
			}else{
				while (!stack.isEmpty()) {
					int prec = 0;
					String opTop = (String) stack.pop();
		
					if(opTop.equals("+") || opTop.equals("-"))
						prec = 1;
					else if(opTop.equals("*") || opTop.equals("/"))
						prec = 2;
					else if(opTop.equals("^"))
						prec = 3;
					if(opTop.equals("(")) {
						stack.push(opTop);
						break;
					}else if (prec < precedence) {
						stack.push(opTop);
						break;
					}else if(prec >= precedence ){
						postfix += opTop + " ";
						break;
					}
				}
				stack.push(opThis);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public void  getResult() throws InterruptedException {
		int j = 0;
		String[] array = new String[postfixString.length()];
		String temp = "";
		
		Display1.parseArea.setText("");
		Display1.commitArea.setText("");
		
		for (int i = 0; i < postfixString.length(); i++)
			array[i] = "";
		for (int i = 0; i < postfixString.length()-1; i++){
			if (postfixString.charAt(i) == ' ')
				j++;
			else
				array[j] += postfixString.charAt(i);
		}

		for (int i = 0; i < j + 1; i++) {
			for(int k = i; k < i + 1; k++){
				temp += array[k] + " ";
			}					
			
	       	Display1.displayParsed(temp);
			String num = "";
			String num1 = "";
			double ans = 0;
			String ch = array[i];
            
			try{
	            if(ch.equals("+") || ch.equals("-") || ch.equals("*") || ch.equals("/") || ch.equals("^")) {
	            	num += stack.pop();
					num1 += stack.pop();
				
					double n1 = Double.parseDouble(num);
					double n2 = Double.parseDouble(num1);
				
				
					if (ch.equals("+")) {
						ans = n1 + n2;
						stack.push(ans);
			     	} else if (ch.equals("-")) {
						ans = n2 - n1;
						stack.push(ans);
					} else if (ch.equals("*")) {
						ans = n1 * n2;
						stack.push(ans);
					} else if (ch.equals("/")) {
						ans = n2 / n1;
						stack.push(ans);
					} else if (ch.equals("^")) {
						ans = Math.pow(n2, n1);
						stack.push(ans);
					} else {
						ans = 0;
						stack.push(ans);
					}
								
	             }else{
	            	 stack.push(ch);
		         }	
			}catch(Exception ex){
				ex.printStackTrace();
			}
			
		}
		try{
			Display1.display1Label.setIcon(new ImageIcon(getClass().getResource("display1answer.png")));
			Display2.display2Label.setIcon(new ImageIcon(getClass().getResource("display2answer.png")));
			Input.inputLabel.setIcon(new ImageIcon(getClass().getResource("answer1bg.png")));
			Input.answerTField.setText(""+stack.pop());
			Input.repeat.setVisible(true);				
			Display1.timeTField.setEditable(true);
			Display2.timeTField.setEditable(true);
			Display1.timeTField.setText("");
			Display2.timeTField.setText("");
			Thread.sleep(time);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

}

