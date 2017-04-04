package crazycalculator;

import java.awt.*;
import javax.swing.*; 

public class Main extends JFrame{
	private static Main instance;
	public final Instruction instructionPanel;
	public final Input inputPanel;
	public final Display1 display1Panel;
	public final Display2 display2Panel;
	private final JPanel jpanel;
	private final CardLayout layout;
	
	public Main(){
		setUndecorated(true);
        setLayout(null);
        setSize(906, 500);
        setLocationRelativeTo(null);
        setResizable(false);
		
		instructionPanel = new Instruction(this);
		instructionPanel.setFocusable(false);
		instructionPanel.setOpaque(false);
		
		inputPanel = new Input(this);
		inputPanel.setFocusable(false);
		inputPanel.setOpaque(false);
		
		display1Panel = new Display1(this);
		display1Panel.setFocusable(false);
		display1Panel.setOpaque(false);

		display2Panel = new Display2(this);
		display2Panel.setFocusable(false);
		display2Panel.setOpaque(false);
		
		layout = new CardLayout();
		
		jpanel = new JPanel();
        jpanel.setLocation(0,0);
		jpanel.setSize(906,500);
		jpanel.setLayout(layout);
		
		jpanel.add(instructionPanel, "Instruction");
		jpanel.add(inputPanel, "Input");
		jpanel.add(display1Panel, "Display1");
		jpanel.add(display2Panel, "Display2");
		add(jpanel);
		
		setVisible(true);
	}
	
	public static Main getInstance(){
        if(instance == null)
            instance = new Main();
        return instance; 
    }

    public void switchCard(String string){
		layout.show(jpanel, string);
    }
	
	public static void main(String[] args){
		Main main = new Main();
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main.setSize(906, 500);
		main.setResizable(false);
		main.setLocationRelativeTo(null);
		main.setContentPane(main.instructionPanel.bg);
		main.setVisible(true);
		main.setLayout(null);
	}
}