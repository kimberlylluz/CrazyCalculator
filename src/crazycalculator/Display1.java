package crazycalculator;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Display1 extends JPanel{
	private Main main;
	public static JLabel display1Label;
	public static JTextArea parseArea, commitArea;
	public static JTextField timeTField;
	private JButton back, close, start;
	ImageIcon icon = new ImageIcon(getClass().getResource("display1bg.png"));
	
	public Display1(Main main){
		this.main = main;
		setLayout(null);
		
		display1Label = new JLabel(icon);
		display1Label.setLocation(0,0);
		display1Label.setSize(906,500);
		
		timeTField = new JTextField();
		timeTField.setLocation(662, 46);
		timeTField.setSize(147, 19);
		display1Label.add(timeTField);
		
		start = new JButton(new ImageIcon(getClass().getResource("start.png")));
        start.setRolloverIcon(new ImageIcon(getClass().getResource("starthover.png")));
		start.setLocation(828,37);
		start.setVisible(false);
		start.setSize(58, 32);
		display1Label.add(modifyButton(start));
		
		back = new JButton(new ImageIcon(getClass().getResource("back.png")));
        back.setRolloverIcon(new ImageIcon(getClass().getResource("backhover.png")));
		back.setLocation(41,362);
		back.setSize(46, 54);
		display1Label.add(modifyButton(back));
		
		close = new JButton(new ImageIcon(getClass().getResource("close.png")));
        close.setRolloverIcon(new ImageIcon(getClass().getResource("closehover.png")));
		close.setLocation(858,-10);
		close.setSize(56, 58);
		display1Label.add(modifyButton(close));
		
		parseArea = new JTextArea();
		parseArea.setBounds(30,124,404,220);
		parseArea.setEditable(false);
		JScrollPane scroll = new JScrollPane(parseArea);
		scroll.setLocation(30,124);
		scroll.setVisible(true);
		scroll.setSize(404,220);
		display1Label.add(scroll);
		
		commitArea = new JTextArea();
		commitArea.setBounds(471,124,403,220);
		commitArea.setEditable(false);
		JScrollPane scroll1 = new JScrollPane(commitArea);
		scroll1.setLocation(471,124);
		scroll1.setVisible(true);
		scroll1.setSize(404,220);
		display1Label.add(scroll1);
		
		Handler handler = new Handler();
		start.addActionListener(handler);
		back.addActionListener(handler);
		close.addActionListener(handler);
		timeTField.addActionListener(handler);
	}
	
	private JButton modifyButton (JButton button){
		button.setOpaque(false);
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		button.setFocusable(false);
		return button;
	}
	
	private class Handler implements ActionListener{
		public void actionPerformed(ActionEvent event){
			if(event.getSource() == back){
				main.switchCard("Input");
				main.setContentPane(main.inputPanel.inputLabel);
			}else if(event.getSource() == timeTField){
				start.setVisible(true);
				commitArea.setText("");
				parseArea.setText("");
				CrazyCalculator.time = Integer.parseInt(timeTField.getText());
				Display2.timeTField.setText(timeTField.getText());
			}else if(event.getSource() == start){
				timeTField.setEditable(false);
				Display2.timeTField.setEditable(false);
				Input.display1.setVisible(true);
				Input.display2.setVisible(true);
				Input.postfixTField.setText("");
				Input.postfixTField.setVisible(false);
				Input.answerTField.setText("");
				Input.repeat.setVisible(false);
				Input.answerTField.setVisible(false);
				Input.inputLabel.setIcon(new ImageIcon(getClass().getResource("infix1bg.png")));
				display1Label.setIcon(new ImageIcon(getClass().getResource("display1bg.png")));
				Display2.display2Label.setIcon(new ImageIcon(getClass().getResource("display2bg.png")));
				
				CrazyCalculator calc = new CrazyCalculator(Input.string, Input.j);
				Thread thread = new Thread(calc);
				thread.start();
				start.setVisible(false);
			}else if(event.getSource() == close){
				System.exit(0);
			}
		}
	}
	
	public static void displayParsed(String messageToDisplay){
		SwingUtilities.invokeLater(
			new Runnable(){
				public void run(){
					parseArea.append(messageToDisplay + "\n");
				}
			}
		);
	}
	
	public static void displayCommitted(String messageToDisplay){
		SwingUtilities.invokeLater(
			new Runnable(){
				public void run(){
					commitArea.append(messageToDisplay + "\n");
				}
			}
		);
	}
}