package internet;

/**
*Name:		Paul T Pham
*Section:	001
*Program:	Lab 11
*Date:		11/8/12
*Description: Lab 11 Draw Polygon applet

/** 
* In this lab, we will be doing an applet that will allow the user to draw their own polygon and allow
* them to select which color the polygon will be. If they do not select a color it will fill the polygon
* with the default black. Once the polygon is drawn then the user can not draw another polygon until 
* they reset the applet.
* 
* @author Paul Pham 
* @version 1.0 11/8/2012 
* 
*/

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.*;
import java.util.Arrays;
import javax.swing.*;

public class DrawPolygon extends JApplet implements ActionListener, MouseListener {
	
	private JButton pickColorButton;				//the choose color button
	private JButton resetButton;					//clears the previous polygon
	private JPanel topPanel;						//top panel for the two buttons
	private JPanel bottomPanel;						//button panel where the shape is drawn
	private FlowLayout layout;						//the type of layout the panels will have						
	private Color colorChoice;						//the color the user picks
	private int [] xAxis;							//the x coor that are clicked	
	private int [] yAxis;							//the y coor that are clicked 
	private int nPoints = 0;						//number of total of points entered
	private int index = 0;							//the index of the x and y coor
	private int minPoints = 3;						//need more than 3 points to be a polygon
	private boolean DRAW;							//true or false 
	private static final int  MAXSIZE = 1000;		//max number of points
	
	@Override
	public void init()
	{
		layout = new FlowLayout();						//assign layout to a FlowLayout
		setLayout(layout);								//set the layout
		layout.setAlignment(FlowLayout.LEFT);			//set the buttons to the left of the panel
		
		DRAW = false;									//set to false as default
		colorChoice = Color.BLACK;						//set to default
		xAxis = new int[MAXSIZE];						//an array that stores the x coor
		yAxis = new int[MAXSIZE];						//am array that stpres the y coor
		
		topPanel = new JPanel();						//creates top panel
		bottomPanel = new JPanel();						//creats bottom panel
		
		pickColorButton = new JButton("Color Picker");	//creates the pick color button
		pickColorButton.addActionListener(this);		//adds the action listener
		add(pickColorButton);							//adds the button to the applet
		
		resetButton = new JButton("Reset"); 			//creates the reset button
		resetButton.addActionListener(this);			//adds the action listener to the button
		add(resetButton);								//adds the button to the applet
		
		topPanel.add(pickColorButton);					//adds the pick color buttons to the top panel
		topPanel.add(resetButton);						//adds the reset button to the bottom panel			
		
		add(topPanel);									//add the top panel to the applet
		add(bottomPanel);								//add the bottom panel to the applet
		
		addMouseListener(this);							//enables the mouse listener
	}
	
	@Override
	public void paint(Graphics g)
	{
		super.paint(g);
		
		g.setColor(Color.BLACK);
		
		g.drawRect(5, 40, getWidth() - 10, getHeight() - (topPanel.getHeight()+10));//creates a border
		
		g.setColor(colorChoice);					//sets to color to the color or the users choice
		
		g.drawPolyline(xAxis, yAxis, nPoints);		//draws the lines where the user clicks
		
		if(DRAW == true)							//checks if the right click was pressed
		{
			g.drawPolygon(xAxis, yAxis, nPoints);	
		}
		
	}
	
	public void actionPerformed(ActionEvent e)		//handles the buttons
	{
		if(e.getSource() == pickColorButton)		//checks if the pick color buttons is clicked
		{
			colorChoice = JColorChooser.showDialog(this, "Choose Color", colorChoice);
		}
		
		if(e.getSource() == resetButton)			//checks if the reset buttons is clicked
		{
			//clears the panel
			Arrays.fill(xAxis, 0);					//fills array with zeros
			Arrays.fill(yAxis, 0);
			
			nPoints = 0;							//sets the number of points to 0
			index = 0;								//resets the index
			
			DRAW = false;							//draw now is set to false  again
			colorChoice = Color.BLACK;				//color choice is also reset to default
		}
		
		repaint();
	}

	@Override
	public void mouseClicked(MouseEvent e) 			//handles the mouse
	{
		if(DRAW == false)								//checks if the right click was already press		
		{
			if(e.getButton() == MouseEvent.BUTTON1)		//checks if left click was pressed
			{
				if(e.getY() > (topPanel.getHeight()+10))	//doesnt allow user to click outside the 
															//rectangle
				{
					nPoints++;
					xAxis[index] = e.getX();			//stores the x coors into the array
					yAxis[index] = e.getY();			//stores the y coors into the a separate array
					index++;							//increment the index by 1	
				}
			}
			
			//checks to see if the right click is pressed and makes sure there are 3 or more
			//points because a polygon has 3 more sides
			if(e.getButton() == MouseEvent.BUTTON3 && nPoints >= minPoints)		
			{
				xAxis[nPoints] = xAxis[0];			//set the last index in the array back to where
													//the first point started to complete the polygon
				yAxis[nPoints] = yAxis[0];
				
				DRAW = true;

			}
		}
		
		repaint();
	}

	@Override
	public void mousePressed(MouseEvent e) 
	{
		if(DRAW == false)								//checks if the right click was already press		
		{
			if(e.getButton() == MouseEvent.BUTTON1)		//checks if left click was pressed
			{
				if(e.getY() > (topPanel.getHeight()+10))	//doesnt allow user to click outside the 
															//rectangle
				{
					nPoints++;
					xAxis[index] = e.getX();			//stores the x coors into the array
					yAxis[index] = e.getY();			//stores the y coors into the a separate array
					index++;							//increment the index by 1	
				}
			}
			
			//checks to see if the right click is pressed and makes sure there are 3 or more
			//points because a polygon has 3 more sides
			if(e.getButton() == MouseEvent.BUTTON3 && nPoints >= minPoints)		
			{
				xAxis[nPoints] = xAxis[0];			//set the last index in the array back to where
													//the first point started to complete the polygon
				yAxis[nPoints] = yAxis[0];
				
				DRAW = true;

			}
		}
		
		repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) 
	{
		// TODO Auto-generated method stub
		
	}

}