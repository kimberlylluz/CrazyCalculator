package crazycalculator;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Instruction extends JPanel{
	public JLabel bg;
	private Main main;
	private JButton next, close;
	ImageIcon icon = new ImageIcon(getClass().getResource("menu.png"));
	
	public Instruction(Main main){
		this.main = main;
		setLayout(null);
		
		bg = new JLabel(icon);
		bg.setLocation(0,0);
		bg.setSize(906,500);
		
		next = new JButton(new ImageIcon(getClass().getResource("next.png")));
        next.setRolloverIcon(new ImageIcon(getClass().getResource("nexthover.png")));
		next.setLocation(756,303);
		next.setSize(46,54);
		bg.add(modifyButton(next));
		
		close = new JButton(new ImageIcon(getClass().getResource("close.png")));
        close.setRolloverIcon(new ImageIcon(getClass().getResource("closehover.png")));
		close.setLocation(858,-10);
		close.setSize(56,58);
		bg.add(modifyButton(close));
		
		Handler handler = new Handler();
		next.addActionListener(handler);
		close.addActionListener(handler);
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
			if(event.getSource() == next){
				main.switchCard("Input");
				main.setContentPane(main.inputPanel.inputLabel);
			}else if(event.getSource() == close){
				System.exit(0);
			}
		}
	}
}