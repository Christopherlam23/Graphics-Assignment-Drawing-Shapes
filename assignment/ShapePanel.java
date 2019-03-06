package assignment;

import java.awt.Graphics;

import javax.swing.JPanel;

public class ShapePanel extends JPanel {
    Shape currentShape;
    public void setShape(Shape shape) {
    	currentShape = shape;
    }
    
    public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (currentShape != null)
			currentShape.draw(g);
    }
}