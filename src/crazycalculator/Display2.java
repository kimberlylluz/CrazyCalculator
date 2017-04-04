package crazycalculator;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Display2 extends JPanel{
	private Main main;
	public static JLabel display2Label;
	public static JTextField timeTField, readTField;
	public static JTextField[] stackTField, queueTField, arrayTField, llistTField;
	public static JButton[] stackButton, queueButton, arrayButton, llistButton;
	private JButton back, close, start;
	ImageIcon icon = new ImageIcon(getClass().getResource("display2bg.png"));
	
	public Display2(Main main){
		this.main = main;
		setLayout(null);
		
		display2Label = new JLabel(icon);
		display2Label.setLocation(0,0);
		display2Label.setSize(906,500);
		
		readTField = new JTextField();
		readTField.setLocation(539, 46);
		readTField.setSize(47, 19);
		readTField.setEditable(false);
		display2Label.add(readTField);
		
		stackTField = new JTextField[12];
		queueTField = new JTextField[12];
		arrayTField = new JTextField[12];
		llistTField = new JTextField[12]; 
		stackButton = new JButton[12];
		queueButton = new JButton[12];
		arrayButton = new JButton[12];
		llistButton = new JButton[12];
		
		for(int i=0; i<12; i++){
		    stackTField[i] = new JTextField();
		    stackTField[i].setEditable(false);
		    stackTField[i].setVisible(false);
			stackTField[i].setForeground(Color.WHITE);
			stackTField[i].setOpaque(false);
		    stackTField[i].setBounds(85, 114 + 20*i, 42, 20);
			stackTField[i].setHorizontalAlignment(JTextField.CENTER);
		    display2Label.add(stackTField[i]);
		}
		
		for(int i=0; i<12; i++){
			queueTField[i] = new JTextField();
			queueTField[i].setEditable(false);
			queueTField[i].setVisible(false);
			queueTField[i].setForeground(Color.WHITE);
			queueTField[i].setOpaque(false);
			queueTField[i].setBounds(316, 114 + 20*i, 42, 20);
			queueTField[i].setHorizontalAlignment(JTextField.CENTER);
		    display2Label.add(queueTField[i]);
		}
		
		for(int i=0; i<12; i++){
			arrayTField[i] = new JTextField();
			arrayTField[i].setEditable(false);
			arrayTField[i].setForeground(Color.WHITE);
			arrayTField[i].setOpaque(false);
			arrayTField[i].setBounds(548, 114 + 20*i, 42, 20);
			arrayTField[i].setHorizontalAlignment(JTextField.CENTER);
		    display2Label.add(arrayTField[i]);
		}
		
		for(int i=0; i<12; i++){
			llistTField[i] = new JTextField();
			llistTField[i].setEditable(false);
			llistTField[i].setVisible(false);
			llistTField[i].setForeground(Color.WHITE);
			llistTField[i].setOpaque(false);
			llistTField[i].setBounds(779, 114 + 20*i, 42, 20);
			llistTField[i].setHorizontalAlignment(JTextField.CENTER);
		    display2Label.add(llistTField[i]);
		}
		
		for(int i=0; i<12; i++){
		    stackButton[i] = new JButton(new ImageIcon(getClass().getResource("shadow.png")));
		    stackButton[i].setVisible(false);
		    stackButton[i].setBounds(71, 107 + 20*i, 68, 42);
		    display2Label.add(modifyButton(stackButton[i]));
		}
		
		for(int i=0; i<12; i++){
		    queueButton[i] = new JButton(new ImageIcon(getClass().getResource("shadow.png")));
		    queueButton[i].setVisible(false);
		    queueButton[i].setBounds(302, 107 + 20*i, 68, 42);
		    display2Label.add(modifyButton(queueButton[i]));
		}
		
		for(int i=0; i<12; i++){
		    arrayButton[i] = new JButton(new ImageIcon(getClass().getResource("shadow.png")));
		    arrayButton[i].setVisible(false);
		    arrayButton[i].setBounds(534, 107 + 20*i, 68, 42);
		    display2Label.add(modifyButton(arrayButton[i]));
		}
		
		for(int i=11; i>=0; i--){
		    llistButton[i] = new JButton(new ImageIcon(getClass().getResource("linkshadowR.png")));
		    llistButton[i].setVisible(false);
		    llistButton[i].setBounds(757, 106 + 20*i, 92, 60);
		    display2Label.add(modifyButton(llistButton[i]));
		}
		
		timeTField = new JTextField();
		timeTField.setLocation(662, 46);
		timeTField.setSize(147, 19);
		display2Label.add(timeTField);
		
		start = new JButton(new ImageIcon(getClass().getResource("start.png")));
        start.setRolloverIcon(new ImageIcon(getClass().getResource("starthover.png")));
		start.setLocation(828,37);
		start.setVisible(false);
		start.setSize(58, 32);
		display2Label.add(modifyButton(start));
		
		back = new JButton(new ImageIcon(getClass().getResource("back.png")));
        back.setRolloverIcon(new ImageIcon(getClass().getResource("backhover.png")));
		back.setLocation(41,362);
		back.setSize(46, 54);
		display2Label.add(modifyButton(back));
		
		close = new JButton(new ImageIcon(getClass().getResource("close.png")));
        close.setRolloverIcon(new ImageIcon(getClass().getResource("closehover.png")));
		close.setLocation(858,-10);
		close.setSize(56, 58);
		display2Label.add(modifyButton(close));
		
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
				Display1.commitArea.setText("");
				Display1.parseArea.setText("");
				CrazyCalculator.time = Integer.parseInt(timeTField.getText());
				Display1.timeTField.setText(timeTField.getText());
			}else if(event.getSource() == start){
				timeTField.setEditable(false);
				Display1.timeTField.setEditable(false);
				Input.display1.setVisible(true);
				Input.display2.setVisible(true);
				Input.postfixTField.setText("");
				Input.postfixTField.setVisible(false);
				Input.answerTField.setText("");
				Input.repeat.setVisible(false);
				Input.answerTField.setVisible(false);
				Input.inputLabel.setIcon(new ImageIcon(getClass().getResource("infix1bg.png")));
				display2Label.setIcon(new ImageIcon(getClass().getResource("display2bg.png")));
				Display1.display1Label.setIcon(new ImageIcon(getClass().getResource("display1bg.png")));
				
				CrazyCalculator calc = new CrazyCalculator(Input.string, Input.j);
				Thread thread = new Thread(calc);
				thread.start();
				start.setVisible(false);
			}else if(event.getSource() == close){
				System.exit(0);
			}
		}
	}
	

}