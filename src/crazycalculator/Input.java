package crazycalculator;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Input extends JPanel{
	private Main main;
	String infixString;
	public static JButton inputButton;
	public static JTextField input, inputTField, postfixTField, answerTField;
	public static int j = 0;
	public static JLabel inputLabel;
	public static String[] string;
	ImageIcon icon = new ImageIcon(getClass().getResource("inputbg.png"));
	public static JButton next, next1, repeat, close, parsing, tryAgain, display1, display2;
	
	public Input(Main main){
		this.main = main;
		setLayout(null);
		
		inputLabel = new JLabel(icon);
		inputLabel.setLocation(0,0);
		inputLabel.setSize(906,500);
		
		input = new JTextField();
		input.setLocation(456,240);
		input.setSize(315,37);
		input.setOpaque(false);
		input.setForeground(Color.WHITE);
		inputLabel.add(input);
		
		input.addKeyListener(new KeyAdapter(){
			public void keyTyped(KeyEvent e){
				char ch = e.getKeyChar();
				if(!isNumber(ch)  && !isOperator(ch) )
					e.consume();
			}
		});
		
		inputTField = new JTextField();
		inputTField.setVisible(false);
		inputTField.setEditable(false);
		inputTField.setLocation(512, 151);
		inputTField.setSize(286,27);
		inputTField.setOpaque(false);
		inputTField.setForeground(Color.WHITE);
		inputLabel.add(inputTField);
		
		postfixTField = new JTextField();
		postfixTField.setVisible(false);
		postfixTField.setEditable(false);
		postfixTField.setLocation(512,209);
		postfixTField.setSize(286,27);
		postfixTField.setOpaque(false);
		postfixTField.setForeground(Color.WHITE);
		inputLabel.add(postfixTField);
		
		answerTField = new JTextField();
		answerTField.setVisible(false);
		answerTField.setEditable(false);
		answerTField.setLocation(512,268);
		answerTField.setSize(286,27);
		answerTField.setOpaque(false);
		answerTField.setForeground(Color.WHITE);
		inputLabel.add(answerTField);
		
		inputButton =  new JButton(new ImageIcon(getClass().getResource("inputtextfield1.png")));
        inputButton.setRolloverIcon(new ImageIcon(getClass().getResource("inputtextfield.png")));
		inputButton.setLocation(443,226);
		inputButton.setSize(346, 64);
		inputLabel.add(modifyButton(inputButton)); 
		
		repeat = new JButton(new ImageIcon(getClass().getResource("repeat.png")));
        repeat.setRolloverIcon(new ImageIcon(getClass().getResource("repeathover.png")));
		repeat.setLocation(756,319);
		repeat.setSize(42, 42);
		repeat.setVisible(false);
		inputLabel.add(modifyButton(repeat));
		
		next = new JButton(new ImageIcon(getClass().getResource("start1.png")));
        next.setRolloverIcon(new ImageIcon(getClass().getResource("start1hover.png")));
		next.setLocation(703,311);
		next.setSize(98,42);
		next.setVisible(false);
		inputLabel.add(modifyButton(next));
		
		next1 = new JButton(new ImageIcon(getClass().getResource("next.png")));
        next1.setRolloverIcon(new ImageIcon(getClass().getResource("nexthover.png")));
		next1.setLocation(756,303);
		next1.setSize(46, 54);
		next1.setVisible(true);
		inputLabel.add(modifyButton(next1));
		
		display2 = new JButton(new ImageIcon(getClass().getResource("display2.png")));
        display2.setRolloverIcon(new ImageIcon(getClass().getResource("display2hover.png")));
		display2.setLocation(83, 110);
		display2.setSize(228, 254);
		display2.setVisible(false);
		inputLabel.add(modifyButton(display2));
		
		display1 = new JButton(new ImageIcon(getClass().getResource("display1.png")));
        display1.setRolloverIcon(new ImageIcon(getClass().getResource("display1hover.png")));
		display1.setLocation(225, 130);
		display1.setSize(200, 214);
		display1.setVisible(false);
		inputLabel.add(modifyButton(display1));
		
		close = new JButton(new ImageIcon(getClass().getResource("close.png")));
        close.setRolloverIcon(new ImageIcon(getClass().getResource("closehover.png")));
		close.setLocation(858,-10);
		close.setSize(56, 58);
		inputLabel.add(modifyButton(close));
		
		tryAgain = new JButton(new ImageIcon(getClass().getResource("tryagain.png")));
		tryAgain.setVisible(false);
		tryAgain.setLocation(615,315);
		tryAgain.setSize(86, 34);
		inputLabel.add(modifyButton(tryAgain));
		
		Handler handler = new Handler();
		next1.addActionListener(handler);
		next.addActionListener(handler);
		close.addActionListener(handler);
		display1.addActionListener(handler);
		display2.addActionListener(handler);
		repeat.addActionListener(handler);
	}
	
	private JButton modifyButton(JButton button){
		button.setOpaque(false);
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		button.setFocusable(false);
		return button;
	}
	
	private class Handler implements ActionListener{
		public void actionPerformed(ActionEvent event){
			if(event.getSource() == next1){
				tryAgain.setVisible(false);
				infixString = new String(input.getText());
				System.out.println(infixString);
				infixError();
			}
			
			if(event.getSource() == next){
				next1.setVisible(false);
				inputTField.setText(infixString);
				inputTField.setVisible(true);
				input.setVisible(false);
				inputButton.setVisible(false);
				inputLabel.setIcon(new ImageIcon(getClass().getResource("infix1bg.png")));
				display1.setVisible(true);
				display2.setVisible(true);
				next.setVisible(false);
			}else if(event.getSource() == close){
				System.exit(0);
			}
			
			if(event.getSource() == display2){
				main.switchCard("Display2");
				main.setContentPane(main.display2Panel.display2Label);
			}else if(event.getSource() == display1){
				main.switchCard("Display1");
				main.setContentPane(main.display1Panel.display1Label);
			}
			
			if(event.getSource() == repeat){
				Display1.timeTField.setEditable(true);
				display1.setVisible(true);
				display2.setVisible(true);
				Display1.parseArea.setText("");
				Display1.commitArea.setText("");
				postfixTField.setText("");
				postfixTField.setVisible(false);
				answerTField.setText("");
				answerTField.setVisible(false);
				inputLabel.setIcon(new ImageIcon(getClass().getResource("infix1bg.png")));
				Display1.display1Label.setIcon(new ImageIcon(getClass().getResource("display1bg.png")));
				Display2.display2Label.setIcon(new ImageIcon(getClass().getResource("display2bg.png")));
				repeat.setVisible(false);
			}
		}
	}
	
	public void infixError(){
		boolean run = true;
		next1.setVisible(false);
		
		string = new String[infixString.length()];	
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
				run = false;
				try{
					Thread.sleep(100);
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
				break;
			}
		}
		   
		if(run == true){
			next.setVisible(true);
			input.setEditable(false);
		}else if(run == false){
			tryAgain.setVisible(true);
			next1.setVisible(true);
			clearInput();
		}
	}
	
	public void clearInput(){
		infixString = new String("");
		input.setText("");
	}
	
	public boolean isNumeric(String str){  
		try{  
			double d = Double.parseDouble(str);  
		}catch(NumberFormatException nfe){  
			return false;  
		}  
		return true;  
	}
	
	public boolean isOperator(String ch){
		return ch.equals("+") || ch.equals("-") || ch.equals("*") || ch.equals("/")|| ch.equals("^") ||  ch.equals("(") || ch.equals(")");
	}
	
		public boolean isNumber(char ch){
		return ch >= '0' && ch <= '9';
	}
	
	public boolean isOperator(char ch){
		return ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^' || ch == ' '|| ch == '(' || ch== ')' || ch == '.' ;
	}
}