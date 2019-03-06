package internet;

import java.awt.*;
import javax.swing.*;

public class GUI extends JFrame{
	
     public GUI(){
	     FlowLayout flo = new FlowLayout();
	     Container pane = getContentPane();
	     
	     JButton button = new JButton("CLICK ME");
	     JLabel label = new JLabel("Dont Click Him!");
	    
	     setTitle("My First GUI");
	     setVisible(true);
	     setSize(500,500);
	     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     pane.setLayout(flo);
	     pane.add(button);
	     pane.add(label);
     }
     
     public void paintComponent(Graphics g){
    	 Graphics2D ga=(Graphics2D)g;
    	 ga.setColor(Color.black);
    	 ga.drawLine(20, 20, 60, 60);
     }
     
	public static void main(String args[]){
	    GUI gu = new GUI ();
	}
}