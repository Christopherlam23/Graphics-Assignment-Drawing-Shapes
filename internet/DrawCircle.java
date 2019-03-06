package internet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DrawCircle extends JFrame implements MouseListener { 

  private int x=50;   // leftmost pixel in circle has this x-coordinate
  private int y=50;   // topmost  pixel in circle has this y-coordinate

  public DrawCircle() {
    setSize(800,800);
    setLocation(100,100);
    addMouseListener(this); 
    setVisible(true);
  }

  // paint is called automatically when program begins, when window is
  //   refreshed and  when repaint() is invoked 
  public void paint(Graphics g) {
    g.setColor(Color.yellow);
    g.fillOval(x,y,100,100);

}

  // The next 4 methods must be defined, but you won't use them.
  public void mouseReleased(MouseEvent e ) { }
  public void mouseEntered(MouseEvent e)   { }
  public void mouseExited(MouseEvent e)    { }
  public void mousePressed(MouseEvent e)   { }

  public void mouseClicked(MouseEvent e) { 
    x = e.getX();   // x-coordinate of the mouse click
    y = e.getY();   // y-coordinate of the mouse click
    repaint();    //calls paint()
  }

  public static void main(String argv[]) {
    DrawCircle c = new DrawCircle();
  }
}