package internet;

//
//Polygons.java
//Polygons
//
//Created by Wagner on Mon Feb 23 2004.
//Copyright (c) 2004 W.L.Truppel. All rights reserved.
//

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
A class for a program that draws polygons as the user clicks around.
@author Wagner Truppel
*/
public class Polygons
{
/**
	This is where execution of the program starts.
	@param args A list of strings.
 */
	public static void main (String[] args)
	{
	    JFrame frame = new JFrame("Polygons");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(new DrawingPanel());
	    frame.pack();
	    frame.setVisible(true);
	}
}

/**
This is another class in this program, responsible for
the panel where drawing will happen.
*/
class DrawingPanel extends JPanel
implements MouseListener, MouseMotionListener
{
/**
	This is how "constants" are defined in java.
 */
	private static final Dimension MIN_DIM = new Dimension(300, 300);
	private static final Dimension MAX_DIM = new Dimension(800, 800);
	private static final Dimension PREF_DIM = new Dimension(500, 500);
	
	private boolean polygonIsNowComplete = false;
	
	/**
		The 'dummy' point tracking the mouse.
	 */
	private final Point trackPoint = new Point();
	
	/**
		The list of points making up a polygon.
	 */
	private ArrayList points = new ArrayList();
	
	/**
		The only constructor needed for this class.
	 */
	DrawingPanel()
	{
		super();
		addMouseListener(this);
		addMouseMotionListener(this);
	}
	
	/**
		This is where all the drawing action happens.
	 */
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		int numPoints = points.size();
		if (numPoints == 0)
			return; // nothing to draw
		
		Point prevPoint = (Point) points.get(0);
		
		// draw polygon
		Iterator it = points.iterator();
		while (it.hasNext())
		{
			Point curPoint = (Point) it.next();
			draw(g, prevPoint, curPoint);			
			prevPoint = curPoint;
		}
		
		// now draw tracking line or complete the polygon
		if (polygonIsNowComplete)
			draw(g, prevPoint, (Point) points.get(0));
		else
			draw(g, prevPoint, trackPoint);	
	}
	
	/**
		This method is required by the MouseListener interface,
		and is the only one that we really care about.
	 */
	public void mouseClicked(MouseEvent evt)
	{
		int x = evt.getX();
		int y = evt.getY();
		
		switch (evt.getClickCount())
		{
			case 1: // single-click
				if (polygonIsNowComplete)
				{
					points.clear();
					polygonIsNowComplete = false;
				}
				points.add(new Point(x, y));
				repaint();
				break;
				
			case 2: // double-click
				polygonIsNowComplete = true;
				points.add(new Point(x, y));
				repaint();
				break;
				
			default: // ignore anything else
				break;
		}
	}
	
	
	/**
		This method is required by the MouseMotionListener interface,
		and is the only one that we really care about.
	 */
	public void mouseMoved(MouseEvent evt)
	{
		trackPoint.x = evt.getX();
		trackPoint.y = evt.getY();
		repaint();
	}
	
	/**
		Utility method used to draw points and lines.
	 */
	private void draw(Graphics g, Point p1, Point p2)
	{
		int x1 = p1.x;
		int y1 = p1.y;
			
		int x2 = p2.x;
		int y2 = p2.y;
		
		// draw the line first so that the points
		// appear on top of the line ends, not below
		g.setColor(Color.green.darker());
		g.drawLine(x1 + 3, y1 + 3, x2 + 3, y2 + 3);
		g.drawLine(x1 + 4, y1 + 4, x2 + 4, y2 + 4);
		g.drawLine(x1 + 5, y1 + 5, x2 + 5, y2 + 5);
		
		g.setColor(Color.red);
		g.fillOval(x1, y1, 8, 8);
		
		g.setColor(Color.blue);
		g.fillOval(x2, y2, 8, 8);
	}
	
	/**
		This method is used to draw this panel with the
		correct minimum size.
	 */
	public Dimension getMinimumSize()
	{ return MIN_DIM; }
	
	/**
		This method is used to draw this panel with the
		correct preferred size.
	 */
	public Dimension getPreferredSize()
	{ return PREF_DIM; }
	
	/**
		This method is required by the MouseMotionListener interface,
		but we don't really listen to this kind of event.
	 */
	public void mouseDragged(MouseEvent evt)
	{ /* do nothing */ }
	
	/**
		This method is required by the MouseListener interface,
		but we don't really listen to this kind of event.
	 */
	public void mousePressed(MouseEvent evt)
	{ /* do nothing */ }
	
	/**
		This method is required by the MouseListener interface,
		but we don't really listen to this kind of event.
	 */
	public void mouseReleased(MouseEvent evt)
	{ /* do nothing */ }
	
	/**
		This method is required by the MouseListener interface,
		but we don't really listen to this kind of event.
	 */
	public void mouseEntered(MouseEvent evt)
	{ /* do nothing */ }
	
	/**
		This method is required by the MouseListener interface,
		but we don't really listen to this kind of event.
	 */
	public void mouseExited(MouseEvent evt)
	{ /* do nothing */ }
}