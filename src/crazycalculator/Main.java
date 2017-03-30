package crazycalculator;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main extends JFrame implements ActionListener{
	private JTextField input;
	public static JTextField output, result;
	private JLabel infixLabel, postfixLabel, answerLabel, queueLabel, stackLabel;
	public static JLabel parse, evaluate;
	public static JTextField[] stackTField, queueTField;
	Font font = new Font("Century Gothic", Font.BOLD, 12);

	public Main() {
		setLayout(null);
		setBackground(Color.WHITE);
		
		infixLabel = new JLabel("INPUT:");
		infixLabel.setBounds(90, 20, 50, 25);
		infixLabel.setFont(font);
		add(infixLabel);
		
		input = new JTextField(50);
		input.setBounds(170, 20, 200, 25);
		input.setFont(font);
		add(input);
		
		stackTField = new JTextField[10];
		queueTField = new JTextField[10];
		
		input.addKeyListener(new KeyAdapter(){
			public void keyTyped(KeyEvent e){
				char ch = e.getKeyChar();
				if(!isNumber(ch)  && !isOperator(ch) )
					e.consume();
			}
		});
		
		for(int i=0; i<10; i++){
		    stackTField[i] = new JTextField();
		    stackTField[i].setEditable(false);
		    stackTField[i].setVisible(false);
		    stackTField[i].setFont(font);
		    stackTField[i].setBounds(170, 180 + 25*i, 50, 25);
		    add(stackTField[i]);
		}
		
		stackLabel = new JLabel(" STACK");
		stackLabel.setBounds(170, 160, 50, 25);
		stackLabel.setFont(font);
		add(stackLabel);
		
		parse = new JLabel("");
		parse.setFont(font);
		parse.setBounds(225, 45, 150, 25);
		add(parse);
		
		evaluate = new JLabel();
		evaluate.setFont(font);
		evaluate.setBounds(225, 95, 70, 25);
		add(evaluate);
		
		for(int i=0; i<10; i++){
			queueTField[i] = new JTextField();
			queueTField[i].setEditable(false);
			queueTField[i].setVisible(false);
			queueTField[i].setBounds(270, 180 + 25*i, 50, 25);
			queueTField[i].setFont(font);
		    add(queueTField[i]);
		}
		
		queueLabel = new JLabel(" QUEUE");
		queueLabel.setFont(font);
		queueLabel.setBounds(270, 160, 70, 25);
		add(queueLabel);
		
		postfixLabel = new JLabel("POSTFIX:");
		postfixLabel.setFont(font);
		postfixLabel.setBounds(90, 70, 80, 25);
		add(postfixLabel);
		
		output = new JTextField(10);
		output.setFont(font);
		output.setBounds(170, 70, 200, 25);
		output.setEditable(false);
		add(output);
		
		answerLabel =  new JLabel("ANSWER:");
		answerLabel.setFont(font);
		answerLabel.setBounds(90, 120 , 80 , 25);
		add(answerLabel);
		
		result = new JTextField(10);
		result.setFont(font);
		result.setBounds(170, 120, 200, 25);
		result.setEditable(false);
		add(result);
		input.addActionListener(this);
	}
	
	public boolean isNumber(char ch){
		return ch >= '0' && ch <= '9';
	}
	
	public boolean isOperator(char ch){
		return ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^' || ch == ' '|| ch == '(' || ch== ')' || ch == '.' ;
	}
	
	public static void main(String[] args) {
		   Main main = new Main();
		   main.setSize(500,500);
		   main.setVisible(true);
		   main.setResizable(false);
		   main.setLocationRelativeTo(null);
		   main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	}

	public void actionPerformed(ActionEvent e) {
		CrazyCalculator calc = new CrazyCalculator(input.getText());
	    Thread thread = new Thread(calc);
	    thread.start();
	}
}

