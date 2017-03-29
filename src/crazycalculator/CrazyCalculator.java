package crazycalculator;

import java.util.*;

public class CrazyCalculator extends Thread{
	String postfix, infixString, postfixString;
	String[] string;
	Stack stack;
	int size;
	
	public CrazyCalculator(String input){
		infixString = input;
		size = input.length();
		stack = new Stack();
		string = new String[size];
	}
	
	public void run(){
		boolean run = true;
		int j = 0;
			
		for(int i = 0; i < infixString.length(); i++)
			string[i] = "";

		
		for(int k = 0; k < infixString.length(); k++){
			if (infixString.charAt(k) == ' ')
				j++;
			else
				string[j] += infixString.charAt(k);
		}
		
		for(int i = 0; i < j + 1; i++){
			if(!isNumeric(string[i]) && !isOperator(string[i]) || string[i].isEmpty()){
				Main.parse.setText("Wrong input!");
				run = false;
				try {
					//System.out.println("Not runnable");
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				break;
			}
		}
		   
		
		if(run == true){
			try{
				for(int i = 0; i < j + 1; i++){
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
					Main.result.setText("");
					Main.parse.setText("Parsing.");
					Thread.sleep(500);
					Main.parse.setText("Parsing..");
					Thread.sleep(500);
					Main.parse.setText("Parsing...");
					Thread.sleep(500);
					
					char[] ch = postfix.toCharArray();
					StringBuilder strBuilder = new StringBuilder();
					for (int l = 4; l < ch.length; l++) {
						   strBuilder.append(ch[l]);
					}
					postfixString = strBuilder.toString();
					Main.output.setText(postfixString);
				}
				
				while (!stack.isEmpty()) {
					postfix += stack.pop() + " ";
					char[] ch1 = postfix.toCharArray();
					StringBuilder strBuilder = new StringBuilder();
					for (int i = 4; i < ch1.length; i++) {
						   strBuilder.append(ch1[i]);
					}
					postfixString = strBuilder.toString();
					Main.output.setText(postfixString);
				}
				
				char[] ch2 = postfix.toCharArray();
				StringBuilder strBuilder = new StringBuilder();
				for (int i = 4; i < ch2.length; i++) {
					   strBuilder.append(ch2[i]);
				}
				postfixString = strBuilder.toString();
				
				Main.output.setText(postfixString);
				Thread.sleep(500);
				Main.parse.setText(" ");
				
				getResult();
			        
			}catch(Exception ex){
				ex.printStackTrace();
			}
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
					}else if (prec <= precedence) {
						stack.push(opTop);
						break;
					}else {
						postfixString += opTop + " ";
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
		String array[] = new String[postfixString.length()];
		
		for (int i = 0; i < postfixString.length(); i++)
			array[i] = "";
		for (int i = 0; i < postfixString.length()-1; i++){
			if (postfixString.charAt(i) == ' ')
				j++;
			else
				array[j] += postfixString.charAt(i);
		}

		for (int i = 0; i < j + 1; i++) {
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
			Main.evaluate.setText("Evaluating.");
			Thread.sleep(500);
			Main.evaluate.setText("Evaluating..");
			Thread.sleep(500);
			Main.evaluate.setText("Evaluating...");
			Thread.sleep(500);
		}
		try{
			Main.result.setText(""+stack.pop());
			Thread.sleep(500);
			Main.evaluate.setText("");
			Thread.sleep(500);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

}

