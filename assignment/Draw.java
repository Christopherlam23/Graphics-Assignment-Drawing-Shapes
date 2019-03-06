package assignment;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.*;
import java.awt.*;

public class Draw extends JFrame implements MouseListener{
	
	public static Point previousPoint;
	public static Point nextPoint;
	
	public static Point firstPointEllipse;
	public static Point secondPointEllipse;
	public static Point thirdPointEllipse;
	
	public static int x=(int)java.awt.Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	public static int y=(int)java.awt.Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	
	public static int width_buttonPanel=230;
	public static int centerx=(x-width_buttonPanel)/2;
	public static int centery=y/2;
	
	public static int gridInterval=50;
	public static boolean flag_scale=true;
	
	public static double arrX[]=new double[2000];
	public static double arrY[]=new double[2000];
	public static double[] interval_line;
	public static ArrayList<Point[]> list_line=new ArrayList<>();
	
	public static double[] pk=new double[500];
	public static double[] xk=new double[500];
	public static double[] yk=new double[500];
	public static double[] interval_circle;
	public static int circle_pos_x;
	public static int circle_pos_y;
	
	public static double[] interval_ellipse;
	public static int ellipse_pos_x;
	public static int ellipse_pos_y;
	public static ArrayList<Double> listX;
	public static ArrayList<Double> listY;
	public static ArrayList<Point> list_ellipse=new ArrayList<>();
	
	public static double[] polygonX;
	public static double[] polygonY;
	public static double[] interval_polygon;
	public static int polygon_pos_x;
	public static int polygon_pos_y;
	
	private int [] xAxis_polygon=new int[50];		//the x coor that are clicked	
	private int [] yAxis_polygon=new int[50];		//the y coor that are clicked 
	private int nPoints_polygon = 0;
	private boolean DRAW_Polygon=false;
	private int index_polygon=0;
	
	JRadioButton btn_solid=new JRadioButton("Solid");
	JRadioButton btn_dotted=new JRadioButton("Dotted");
	JRadioButton btn_dashed=new JRadioButton("Dashed");
	JTextField jtf_thickness = new JTextField("1");
	public static int flag_shapeProperties;
	public static int flag_shapeThickness;
	
	public static int flag_mouse_shape;
	
	public static ArrayList<Integer> listX_line;
	public static ArrayList<Integer> listY_line;
	
	
	JButton apply_btn=new JButton("Apply");
	JButton clear_btn=new JButton("Clear Graph");
	
	JRadioButton mouse_line_rbtn=new JRadioButton("Line");
	JRadioButton mouse_circle_rbtn=new JRadioButton("Circle");
	JRadioButton mouse_ellipse_rbtn=new JRadioButton("Ellipse");
	JRadioButton mouse_polygon_rbtn=new JRadioButton("Polygon");
	
	JRadioButton line_rbtn=new JRadioButton("Draw Line");
	JRadioButton circle_rbtn=new JRadioButton("Draw Circle");
	JRadioButton ellipse_rbtn=new JRadioButton("Draw Ellipse");
	JRadioButton polygon_rbtn=new JRadioButton("Draw Polygon");
	
	JRadioButton polygon_regular_rbtn=new JRadioButton("Regular");
	JRadioButton polygon_irregular_rbtn=new JRadioButton("Irregular");
	JButton polygon_irregular_okbtn=new JButton("Apply");
	
	JRadioButton line_DDA=new JRadioButton("DDA");
	JRadioButton line_BLA=new JRadioButton("BLA");
	
	JTextField line_x1 = new JTextField();
	JTextField line_x2 = new JTextField();
	JTextField line_y1 = new JTextField();
	JTextField line_y2 = new JTextField();
	
	JTextField circle_x = new JTextField();
	JTextField circle_y = new JTextField();
	JTextField circle_r = new JTextField();
	
	JTextField ellipse_x = new JTextField();
	JTextField ellipse_y = new JTextField();
	JTextField ellipse_r1 = new JTextField();
	JTextField ellipse_r2 = new JTextField();
	

	JTextField polygon_num_sides1 = new JTextField();
	JTextField polygon_r = new JTextField();
	JTextField polygon_x = new JTextField();
	JTextField polygon_y = new JTextField();

	JTextField polygon_num_sides2 = new JTextField();
	
	ShapePanel shapePanel=new ShapePanel();
	
	JLabel label;
	
	public Draw(){
		
		label = new JLabel("", JLabel.CENTER);
		shapePanel.addMouseListener(this);
		shapePanel.add(label);
		JPanel buttonPanel=new JPanel();
		buttonPanel.setBackground(Color.white);
		
		JPanel shapePropertiesPanel=new JPanel();
		shapePropertiesPanel.setPreferredSize(new Dimension(width_buttonPanel,80));
		shapePropertiesPanel.setBackground(Color.CYAN);
		shapePropertiesPanel.setLayout(new GridLayout(4,2));
		shapePropertiesPanel.add(new JLabel("Line Properties"));
		shapePropertiesPanel.add(new JLabel(""));
		shapePropertiesPanel.add(btn_solid);
		btn_solid.setOpaque(false);
		shapePropertiesPanel.add(btn_dotted);
		btn_dotted.setOpaque(false);
		shapePropertiesPanel.add(btn_dashed);
		btn_dashed.setOpaque(false);
		shapePropertiesPanel.add(new JLabel(""));
		shapePropertiesPanel.add(new JLabel("Thickness"));
		shapePropertiesPanel.add(jtf_thickness);
		
		
		
		
		JPanel linePanel=new JPanel();
		linePanel.setBackground(Color.GRAY);
		linePanel.setPreferredSize(new Dimension(width_buttonPanel,110));
		linePanel.setLayout(new GridLayout(6,2,2,2));
		linePanel.add(line_rbtn);
		line_rbtn.setOpaque(false);
		linePanel.add(new JLabel(""));
		linePanel.add(line_DDA);
		line_DDA.setOpaque(false);
		linePanel.add(line_BLA);
		line_BLA.setOpaque(false);
		linePanel.add(new JLabel("x1",SwingConstants.CENTER));
		linePanel.add(line_x1);
		linePanel.add(new JLabel("y1",SwingConstants.CENTER));
		linePanel.add(line_y1);
		linePanel.add(new JLabel("x2",SwingConstants.CENTER));
		linePanel.add(line_x2);
		linePanel.add(new JLabel("y2",SwingConstants.CENTER));
		linePanel.add(line_y2);
		
		
		JPanel circlePanel=new JPanel();
		circlePanel.setBackground(Color.lightGray);
		circlePanel.setPreferredSize(new Dimension(width_buttonPanel,80));
		circlePanel.setLayout(new GridLayout(4,2,5,5));
		circlePanel.add(circle_rbtn);
		circle_rbtn.setOpaque(false);
		circlePanel.add(new JLabel(""));
		circlePanel.add(new JLabel("x",SwingConstants.CENTER));
		circlePanel.add(circle_x);
		circlePanel.add(new JLabel("y",SwingConstants.CENTER));
		circlePanel.add(circle_y);
		circlePanel.add(new JLabel("r",SwingConstants.CENTER));
		circlePanel.add(circle_r);
		
		JPanel ellipsePanel=new JPanel();
		ellipsePanel.setBackground(Color.GRAY);
		ellipsePanel.setPreferredSize(new Dimension(width_buttonPanel,90));
		ellipsePanel.setLayout(new GridLayout(5,2,2,2));
		ellipsePanel.add(ellipse_rbtn);
		ellipse_rbtn.setOpaque(false);
		ellipsePanel.add(new JLabel(""));
		ellipsePanel.add(new JLabel("x",SwingConstants.CENTER));
		ellipsePanel.add(ellipse_x);
		ellipsePanel.add(new JLabel("y",SwingConstants.CENTER));
		ellipsePanel.add(ellipse_y);
		ellipsePanel.add(new JLabel("r1",SwingConstants.CENTER));
		ellipsePanel.add(ellipse_r1);
		ellipsePanel.add(new JLabel("r2",SwingConstants.CENTER));
		ellipsePanel.add(ellipse_r2);
		
		JPanel polygonPanel_full=new JPanel();
		polygonPanel_full.setPreferredSize(new Dimension(width_buttonPanel,190));
		
		
		JPanel polygonPanel1=new JPanel();
		JPanel polygonPanel2=new JPanel();
		
		polygonPanel1.setBackground(Color.lightGray);
		polygonPanel1.setPreferredSize(new Dimension(width_buttonPanel,100));
		polygonPanel1.setLayout(new GridLayout(5,2,2,2));
		polygonPanel1.add(polygon_regular_rbtn);
		polygon_regular_rbtn.setOpaque(false);
		polygonPanel1.add(new JLabel(""));
		polygonPanel1.add(new JLabel("Num Sides",SwingConstants.CENTER));
		polygonPanel1.add(polygon_num_sides1);
		polygonPanel1.add(new JLabel("r",SwingConstants.CENTER));
		polygonPanel1.add(polygon_r);
		polygonPanel1.add(new JLabel("x",SwingConstants.CENTER));
		polygonPanel1.add(polygon_x);
		polygonPanel1.add(new JLabel("y",SwingConstants.CENTER));
		polygonPanel1.add(polygon_y);
		
		
		polygonPanel2.setBackground(Color.lightGray);
		polygonPanel2.setPreferredSize(new Dimension(width_buttonPanel,40));
		polygonPanel2.setLayout(new GridLayout(2,3));
		polygonPanel2.add(polygon_irregular_rbtn);
		polygon_irregular_rbtn.setOpaque(false);
		polygonPanel2.add(new JLabel(""));
		polygonPanel2.add(new JLabel(""));
		polygonPanel2.add(new JLabel("Num Sides",SwingConstants.CENTER));
		polygonPanel2.add(polygon_num_sides2);
		polygonPanel2.add(polygon_irregular_okbtn);
		
		
		polygonPanel_full.setBackground(Color.lightGray);
		polygonPanel_full.setLayout(new FlowLayout(FlowLayout.LEFT));
		polygonPanel_full.add(polygon_rbtn);
		polygon_rbtn.setOpaque(false);
		polygonPanel_full.add(polygonPanel1);
		polygonPanel_full.add(polygonPanel2);
		
		JPanel mousePanel=new JPanel();
		mousePanel.setBackground(Color.GREEN);
		mousePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		mousePanel.setLayout(new GridLayout(2,2));
		mousePanel.setPreferredSize(new Dimension(width_buttonPanel,40));
		mousePanel.add(mouse_line_rbtn);
		mouse_line_rbtn.setOpaque(false);
		mousePanel.add(mouse_circle_rbtn);
		mouse_circle_rbtn.setOpaque(false);
		mousePanel.add(mouse_ellipse_rbtn);
		mouse_ellipse_rbtn.setOpaque(false);
		mousePanel.add(mouse_polygon_rbtn);
		mouse_polygon_rbtn.setOpaque(false);
		
		
		
		
		
		ButtonGroup shapePropertiesButton=new ButtonGroup();
		shapePropertiesButton.add(btn_solid);
		shapePropertiesButton.add(btn_dotted);
		shapePropertiesButton.add(btn_dashed);
		btn_solid.setSelected(true);
		
		ButtonGroup line_properties=new ButtonGroup();
		line_properties.add(line_DDA);
		line_properties.add(line_BLA);
		line_DDA.setSelected(true);
		
		ButtonGroup keyboard_shapeButton=new ButtonGroup();
		keyboard_shapeButton.add(line_rbtn);
		keyboard_shapeButton.add(circle_rbtn);
		keyboard_shapeButton.add(ellipse_rbtn);
		keyboard_shapeButton.add(polygon_rbtn);
		line_rbtn.setSelected(true);

		ButtonGroup keyboard_shapeButton_polygon=new ButtonGroup();
		keyboard_shapeButton_polygon.add(polygon_regular_rbtn);
		keyboard_shapeButton_polygon.add(polygon_irregular_rbtn);
		polygon_regular_rbtn.setSelected(true);
		
		ButtonGroup mouse_shapeButton=new ButtonGroup();
		mouse_shapeButton.add(mouse_line_rbtn);
		mouse_shapeButton.add(mouse_circle_rbtn);
		mouse_shapeButton.add(mouse_ellipse_rbtn);
		mouse_shapeButton.add(mouse_polygon_rbtn);
		mouse_line_rbtn.setSelected(true);
		
		buttonPanel.add(shapePropertiesPanel);
		buttonPanel.add(linePanel);
		buttonPanel.add(circlePanel);
		buttonPanel.add(ellipsePanel);
		buttonPanel.add(polygonPanel_full);
		buttonPanel.setPreferredSize(new Dimension(width_buttonPanel,y));
		buttonPanel.add(mousePanel);
		buttonPanel.add(apply_btn);
		buttonPanel.add(clear_btn);
		
		
		shapePanel.setPreferredSize(java.awt.Toolkit.getDefaultToolkit().getScreenSize());
		getContentPane().add(buttonPanel, BorderLayout.EAST);
		getContentPane().add(shapePanel, BorderLayout.CENTER);
		pack();
		setVisible(true);
		
		ActionListener listener=new ActionListener(){
			public void actionPerformed(ActionEvent event){
				Shape drawShape = null;
				
				
					if(event.getSource()!=clear_btn){
						
					
						if(line_rbtn.isSelected()){
							flag_shapeThickness=Integer.parseInt(jtf_thickness.getText());
							
							if(btn_solid.isSelected()){
								flag_shapeProperties=1;
							}
							else if(btn_dotted.isSelected()){
								flag_shapeProperties=2;
							}
							else if(btn_dashed.isSelected()){
								flag_shapeProperties=3;
							}
							
							
							
							int original_startx=Integer.parseInt(line_x1.getText());
							int original_starty=Integer.parseInt(line_y1.getText());
							int original_endx=Integer.parseInt(line_x2.getText());
							int original_endy=Integer.parseInt(line_y2.getText());
							
							
								double startx=original_startx;
								double starty=original_starty;
								double endx=original_endx;
								double endy=original_endy;
								
								double x1=Math.abs(startx);
								double y1=Math.abs(endx);
								double x2=Math.abs(starty);
								double y2=Math.abs(endy);
								
								double biggestValue=Math.max(x1, Math.max(y1, Math.max(x2, y2)));
								double biggestValue_new = 0;
								
								
							
								double percentage=.40;
								if(biggestValue<y*percentage){
									double differenceTimes=(y*percentage)/biggestValue;
									biggestValue_new=biggestValue*differenceTimes;
									
									startx=startx*differenceTimes;
									starty=starty*differenceTimes;
									endx=endx*differenceTimes;
									endy=endy*differenceTimes;
									
								}
								else if(biggestValue>y*percentage){
									double numberTimesBigger=1;
									
									while((biggestValue/numberTimesBigger)>y*percentage){
										numberTimesBigger+=0.1;
									}
									biggestValue_new=biggestValue/numberTimesBigger;
									
									startx=startx/numberTimesBigger;
									starty=starty/numberTimesBigger;
									endx=endx/numberTimesBigger;
									endy=endy/numberTimesBigger;
								}
								
							//start - finding out how many grid space and scale
								double numGrid=biggestValue_new/gridInterval;
								interval_line=new double[(int)numGrid+2];
								
								double scale=biggestValue/numGrid;
								interval_line[0]=0;
								for(int i=1;i<interval_line.length;i++){
									interval_line[i]=scale*i;
								}					
							//end - finding out how many grid space and scale
								
								
							if(line_DDA.isSelected()){	
								
								//initialise array to zero
								arrX=new double[2000];
								arrY=new double[2000];
									
								int dx=(int)(endx-startx);
								int dy=(int)(endy-starty);
								
								double steps;
							
								if(dy>dx)
									steps=dy;
								else
									steps=dx;
								
								double xincr=dx/steps;
								double yincr=dy/steps;
								
								int n = 0;
								if(xincr==1)
									n=(int)(endx-startx)+1;
								
								else if(yincr==1)
									n=(int)(endy-starty)+1;
								
								arrX[0]=startx;
								arrY[0]=starty;
									
								for(int i=1;i<n;i++){
									arrX[i]=arrX[i-1]+xincr;
									arrY[i]=arrY[i-1]+yincr;
								}							
							}
							
							else if(line_BLA.isSelected()){
								//initialise array to zero
								arrX=new double[2000];
								arrY=new double[2000];
									
								int dx=(int)(endx-startx);
								int dy=(int)(endy-starty);
								
								if((dy/dx)<1.0){
									
									int deltaX=(int)(endx-startx);
									int deltaY=(int)(endy-starty);
									
									int two_deltaY=deltaY*2;
									int two_deltaY_minus_two_deltaX=(2*deltaY)-(2*deltaX);
									
									int looptimes=(int)(deltaX)-1;
									
									int[] arrPK=new int[looptimes+1];
									
									arrPK[0]=(int)(two_deltaY-deltaX);
									arrX[0]=startx;
									arrY[0]=starty;
									
									for(int i=1;i<=looptimes;i++){
										if(arrPK[i-1]<0){
											arrX[i]=arrX[i-1]+1;
											arrY[i]=arrY[i-1];
											arrPK[i]=arrPK[i-1]+two_deltaY;
										}
										else{
											arrX[i]=arrX[i-1]+1;
											arrY[i]=arrY[i-1]+1;
											arrPK[i]=arrPK[i-1]+two_deltaY_minus_two_deltaX;
										}
									}	
								}// if dy/dx<1
								
								else{
									int deltaX=(int)(endx-startx);
									int deltaY=(int)(endy-starty);
									
									int two_deltaX=deltaX*2;
									int two_deltaX_minus_two_deltaY=(2*deltaX)-(2*deltaY);
									
									int looptimes=(int)(deltaY)-1;
									
									int[] arrPK=new int[looptimes+1];
									
									arrPK[0]=(int)(two_deltaX-deltaY);
									arrX[0]=startx;
									arrY[0]=starty;
									
									for(int i=1;i<=looptimes;i++){
										if(arrPK[i-1]<0){
											arrX[i]=arrX[i-1];
											arrY[i]=arrY[i-1]+1;
											arrPK[i]=arrPK[i-1]+two_deltaX;
										}
										else{
											arrX[i]=arrX[i-1]+1;
											arrY[i]=arrY[i-1]+1;
											arrPK[i]=arrPK[i-1]+two_deltaX_minus_two_deltaY;
										}
									}	
								}
							}
							
							drawShape=new Line();
							flag_scale=false;
							
							
						}//end line for loop
						
						else if(circle_rbtn.isSelected()){
							
							flag_shapeThickness=Integer.parseInt(jtf_thickness.getText());
							
							if(btn_solid.isSelected()){
								flag_shapeProperties=1;
							}
							else if(btn_dotted.isSelected()){
								flag_shapeProperties=2;
							}
							else if(btn_dashed.isSelected()){
								flag_shapeProperties=3;
							}
							
							
							int radiusInt=Integer.parseInt(circle_r.getText());
							int positionXInt=Integer.parseInt(circle_x.getText());
							int positionYInt=Integer.parseInt(circle_y.getText());
							
							int greater=(int)((Math.max(Math.abs(positionXInt), Math.abs(positionYInt)))/1.2);
							
							
							int originalRadius=radiusInt;
							
							double radius=originalRadius;
							
							double percentage=.40;
							if((radius+greater)<y*percentage){
								double differenceTimes=(y*percentage)/(radius+greater);
								radius=radius*differenceTimes;
								positionXInt=(int)(positionXInt*differenceTimes);
								positionYInt=(int)(positionYInt*differenceTimes);
							}
							else if((radius+greater)>y*percentage){
								double numberTimesBigger=1;
								
								while(((radius+greater)/numberTimesBigger)>y*percentage){
									numberTimesBigger+=0.1;
								}
								radius=radius/numberTimesBigger;
								positionXInt=(int)(positionXInt/numberTimesBigger);
								positionYInt=(int)(positionYInt/numberTimesBigger);
							}
							
							circle_pos_x=positionXInt;
							circle_pos_y=positionYInt;
							
						//start - finding out how many grid space and scale
							double numGrid=radius/gridInterval;
							interval_circle=new double[(int)numGrid+12];
							
							double scale=originalRadius/numGrid;
							interval_circle[0]=0;
							for(int i=1;i<interval_circle.length;i++){
								interval_circle[i]=scale*i;
							}					
						//end - finding out how many grid space and scale
							
							xk=new double[500];
							yk=new double[500];
							pk=new double[500];
							
							xk[0]=0;
							yk[0]=radius;
							pk[0]=1-radius;
							
							int i=0;
							
							while(xk[i]<yk[i]){
								if(pk[i]<0){
									xk[i+1]=xk[i]+1;
									yk[i+1]=yk[i];
									pk[i+1]=pk[i]+2*(xk[i+1])+1;
								}
								else{
									xk[i+1]=xk[i]+1;
									yk[i+1]=yk[i]-1;
									pk[i+1]=pk[i]+2*(xk[i+1])+1-2*(yk[i+1]);
								}
								i++;
							}
							
							drawShape=new Circle();
							flag_scale=false;
						}//end circle for loop
						
						
						
						else if(ellipse_rbtn.isSelected()){
							
							flag_shapeThickness=Integer.parseInt(jtf_thickness.getText());
							
							if(btn_solid.isSelected()){
								flag_shapeProperties=1;
							}
							else if(btn_dotted.isSelected()){
								flag_shapeProperties=2;
							}
							else if(btn_dashed.isSelected()){
								flag_shapeProperties=3;
							}
							
							
							int rX=Integer.parseInt(ellipse_r1.getText());
							int rY=Integer.parseInt(ellipse_r2.getText());
							int positionXIntEllipse=Integer.parseInt(ellipse_x.getText());
							int positionYIntEllipse=Integer.parseInt(ellipse_y.getText());
							
							int greater=(Math.max(Math.abs(positionXIntEllipse), Math.abs(positionYIntEllipse)));
							
							int originalRadiusX=rX;
							
							double radius_rX=originalRadiusX;
							double radius_rY=rY;
							
							double percentage=.40;
							
							if(radius_rX>radius_rY){
								if((radius_rX+greater)<y*percentage){
									double differenceTimes=(y*percentage)/(radius_rX+greater);
									radius_rX=radius_rX*(int)(differenceTimes);
									radius_rY=radius_rY*(int)(differenceTimes);
									positionXIntEllipse=positionXIntEllipse*(int)differenceTimes;
									positionYIntEllipse=positionYIntEllipse*(int)differenceTimes;
								}
								else if((radius_rX+greater)>y*percentage){
									double numberTimesBigger=1;
									
									while(((radius_rX+greater)/numberTimesBigger)>y*percentage){
										numberTimesBigger+=0.1;
									}
									radius_rX=radius_rX/numberTimesBigger;
									radius_rY=radius_rY/numberTimesBigger;
									positionXIntEllipse=(int)(positionXIntEllipse/numberTimesBigger);
									positionYIntEllipse=(int)(positionYIntEllipse/numberTimesBigger);
								}
							}
							
							else{
								if((radius_rY+greater)<y*percentage){
									double differenceTimes=(y*percentage)/(radius_rY+greater);
									radius_rX=radius_rX*(int)(differenceTimes);
									radius_rY=radius_rY*(int)(differenceTimes);
									positionXIntEllipse=positionXIntEllipse*(int)differenceTimes;
									positionYIntEllipse=positionYIntEllipse*(int)differenceTimes;
								}
								else if((radius_rY+greater)>y*percentage){
									double numberTimesBigger=1;
									
									while(((radius_rY+greater)/numberTimesBigger)>y*percentage){
										numberTimesBigger+=0.1;
									}
									radius_rX=radius_rX/numberTimesBigger;
									radius_rY=radius_rY/numberTimesBigger;
									positionXIntEllipse=(int)(positionXIntEllipse/numberTimesBigger);
									positionYIntEllipse=(int)(positionYIntEllipse/numberTimesBigger);
								}
							}
							
							ellipse_pos_x=positionXIntEllipse;
							ellipse_pos_y=positionYIntEllipse;
							
							
						//start - finding out how many grid space and scale
							double numGrid=radius_rX/gridInterval;
							interval_ellipse=new double[(int)numGrid+12];
							
							double scale=originalRadiusX/numGrid;
							interval_ellipse[0]=0;
							for(int i=1;i<interval_ellipse.length;i++){
								interval_ellipse[i]=scale*i;
							}					
						//end - finding out how many grid space and scale
							
							
							
							//initialise to zero
							listX = new ArrayList<Double>();
							listY = new ArrayList<Double>();

							
							double rx=radius_rX;
							double ry=radius_rY;
							
							double rxx=rx*rx;
							double ryy=ry*ry;

							
							double x=0;
							double y=ry;
							
							//ellipseX[i]=x;
							//ellipseY[i]=y;
							
							listX.add(x);
							listY.add(y);
							
							double Py=(2*ryy*x)+(2*ryy);
							double Px=(2*rxx*y)-(2*rxx);
							
							double Po=ryy-(rxx*ry)+(0.25*rxx);
							
							while(Py<Px){
								x++;
								if(Po<0){
									Po=Po+Py+ryy;
								}
								else{
									y--;
									Po=Po+Py-Px+ryy;
								}
								Py=(2*ryy*x)+(2*ryy);
								Px=(2*rxx*y)-(2*rxx);
								listX.add(x);
								listY.add(y);
							}
							
							Po=(ryy*(Math.pow((x+0.5),2)))+(rxx*(Math.pow((y-1),2)))-(rxx*ryy);
							
							while(y>0){
								y--;
								if(Po>0){
									Po=Po-Px+rxx;
								}
								else{
									x++;
									Po=Po+Py-Px+rxx;
								}
								Py=(2*ryy*x)+(2*ryy);
								Px=(2*rxx*y)-(2*rxx);
								listX.add(x);
								listY.add(y);
							}			
				
							drawShape=new Ellipse();
							flag_scale=false;
						}
						
						else if(polygon_rbtn.isSelected()){
							
							flag_shapeThickness=Integer.parseInt(jtf_thickness.getText());
							
							if(btn_solid.isSelected()){
								flag_shapeProperties=1;
							}
							else if(btn_dotted.isSelected()){
								flag_shapeProperties=2;
							}
							else if(btn_dashed.isSelected()){
								flag_shapeProperties=3;
							}
							
							
							if(polygon_regular_rbtn.isSelected()){
								int numSides=Integer.parseInt(polygon_num_sides1.getText());
								int r=Integer.parseInt(polygon_r.getText());
								int position_x=Integer.parseInt(polygon_x.getText());
								int position_y=Integer.parseInt(polygon_y.getText());
								
								int greater=(Math.max(Math.abs(position_x), Math.abs(position_y)));
								
								int originalRadius=r;
								
								double radius=originalRadius;
								
								double percentage=.40;
								if((radius+greater)<y*percentage){
									double differenceTimes=(y*percentage)/(radius+greater);
									radius=radius*differenceTimes;
									position_x=(int)(position_x*differenceTimes);
									position_y=(int)(position_y*differenceTimes);
								}
								else if((radius+greater)>y*percentage){
									double numberTimesBigger=1;
									
									while(((radius+greater)/numberTimesBigger)>y*percentage){
										numberTimesBigger+=0.1;
									}
									radius=radius/numberTimesBigger;
									position_x=(int)(position_x/numberTimesBigger);
									position_y=(int)(position_y/numberTimesBigger);
								}
								
								polygon_pos_x=(int)(position_x);
								polygon_pos_y=(int)(position_y);
								
								
							//start - finding out how many grid space and scale
								double numGrid=radius/gridInterval;
								interval_polygon=new double[(int)numGrid+12];
								
								double scale=originalRadius/numGrid;
								interval_polygon[0]=0;
								for(int i=1;i<interval_polygon.length;i++){
									interval_polygon[i]=scale*i;
								}					
							//end - finding out how many grid space and scale
								
								
								
								
								polygonX=new double[numSides+1];
								polygonY=new double[numSides+1];
								
								double theta=2*Math.PI/numSides;
								
								for(int i=0;i<numSides;i++){
									polygonX[i]=radius*Math.cos(theta*i);
									polygonY[i]=radius*Math.sin(theta*i);
								}
								
								polygonX[numSides]=radius*Math.cos(0);
								polygonY[numSides]=radius*Math.sin(0);
								
							}//regular polygon
							
							else if(polygon_irregular_rbtn.isSelected()){
								int numSides=Integer.parseInt(polygon_num_sides2.getText());
								
								polygonX=new double[numSides+1];
								polygonY=new double[numSides+1];
								
								if(event.getSource()==polygon_irregular_okbtn){
									
									//input each coordinate into array
										for(int i=0;i<numSides;i++){

											String radius_string_x=JOptionPane.showInputDialog("Enter x coordinate");
											int radius_int_x=Integer.parseInt(radius_string_x);
											
											String radius_string_y=JOptionPane.showInputDialog("Enter y coordinate");
											int radius_int_y=Integer.parseInt(radius_string_y);
											
											if(i==0){
												polygonX[numSides]=radius_int_x;
												polygonY[numSides]=radius_int_y;
											}//if
											
											polygonX[i]=radius_int_x;
											polygonY[i]=radius_int_y;
										}//for
									
										
									//start - finding out how many grid space and scale
										double numGrid=centerx/gridInterval;
										interval_polygon=new double[(int)numGrid+2];
										
										interval_polygon[0]=0;
										for(int i=1;i<interval_polygon.length;i++){
											interval_polygon[i]=gridInterval*i;
										}					
									//end - finding out how many grid space and scale
								
								}
							
								
							}//irregular polygon
								
							drawShape=new Polygon();
							flag_scale=false;
						}//end polygon for loop
						
						
					shapePanel.setShape(drawShape);
					repaint();
					}
					
					else{ ///////////////////////////////when clear button is not clicked .////////////////////////////////////////////////
						shapePanel.setShape(null);
						repaint();
						flag_scale=true;
						

						list_ellipse=new ArrayList<>();
						xAxis_polygon=new int[50];		//the x coor that are clicked	
						yAxis_polygon=new int[50];		//the y coor that are clicked 
						nPoints_polygon = 0;

					}
				}
	
		};
		
		apply_btn.addActionListener(listener);
		polygon_irregular_okbtn.addActionListener(listener);
		clear_btn.addActionListener(listener);

	}	
	
	@Override
	public void mousePressed(MouseEvent e){
		
		if(btn_solid.isSelected()){
			flag_shapeProperties=1;
		}
		else if(btn_dotted.isSelected()){
			flag_shapeProperties=2;
		}
		else if(btn_dashed.isSelected()){
			flag_shapeProperties=3;
		}
		
		if(mouse_line_rbtn.isSelected()){
			label.setText("///Click and Drag to Draw Line///Double Click to clear///");
			previousPoint = e.getPoint();
		}
		
		if(mouse_circle_rbtn.isSelected()){
			label.setText("///Click and Drag to Draw Circle///Double Click to clear///");
			previousPoint = e.getPoint();
		}
	}
	
	public void mouseReleased(MouseEvent e){
		
		int thickness=flag_shapeThickness;
		
		if(btn_solid.isSelected()){
			flag_shapeProperties=1;
		}
		else if(btn_dotted.isSelected()){
			flag_shapeProperties=2;
		}
		else if(btn_dashed.isSelected()){
			flag_shapeProperties=3;
		}
		
		
		
		
		if(mouse_line_rbtn.isSelected()){
			nextPoint=e.getPoint();
			g2 = getGraphics();
			Graphics2D gc = (Graphics2D)g2;
			gc.translate(8, 30);
			
			if(flag_shapeProperties==1){
				Stroke solid = new BasicStroke(thickness, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0);
				
				gc.setColor(Color.red);
				gc.drawOval(previousPoint.x-2, previousPoint.y-3, 6, 6);
				gc.fillOval(nextPoint.x-2, nextPoint.y-3, 6, 6);
				gc.setColor(Color.black);
				
				gc.setStroke(solid);
				gc.drawLine(previousPoint.x, previousPoint.y, nextPoint.x, nextPoint.y);
			}
			
			if(flag_shapeProperties==2){
				Stroke dotted = new BasicStroke(thickness, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{5,5}, 0);
				
				gc.setColor(Color.red);
				gc.drawOval(previousPoint.x-2, previousPoint.y-3, 6, 6);
				gc.fillOval(nextPoint.x-2, nextPoint.y-3, 6, 6);
				gc.setColor(Color.black);
				
				gc.setStroke(dotted);
				gc.drawLine(previousPoint.x, previousPoint.y, nextPoint.x, nextPoint.y);
			}
			
			if(flag_shapeProperties==3){
				Stroke dashed = new BasicStroke(thickness, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[] {6,4,10,4}, 0);
				
				gc.setColor(Color.red);
				gc.drawOval(previousPoint.x-2, previousPoint.y-3, 6, 6);
				gc.fillOval(nextPoint.x-2, nextPoint.y-3, 6, 6);
				gc.setColor(Color.black);
				
				gc.setStroke(dashed);
				gc.drawLine(previousPoint.x, previousPoint.y, nextPoint.x, nextPoint.y);
			}

		}
		
		if(mouse_circle_rbtn.isSelected()){
			nextPoint=e.getPoint();
			g2 = getGraphics();
			Graphics2D gc = (Graphics2D)g2;
			gc.translate(8, 30);
			
			int x1=previousPoint.x;
			int y1=previousPoint.y;
			int x2=nextPoint.x;
			int y2=nextPoint.y;
			
			int diffx=Math.abs(Math.abs(x1)-Math.abs(x2));
			int diffy=Math.abs(Math.abs(y1)-Math.abs(y2));
			
			double circleRadius=Math.sqrt(Math.pow(diffx, 2)+Math.pow(diffy, 2));
			int circleHyp=(int)(circleRadius*Math.cos(Math.PI/8)*1.08);
			
			if(flag_shapeProperties==1){
				
				gc.setColor(Color.blue);
				gc.fillOval(previousPoint.x-2, previousPoint.y-2, 4, 4);
				gc.setColor(Color.black);
				Stroke solid = new BasicStroke(thickness, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL, 0);
				gc.setStroke(solid);
				gc.drawOval(x1-circleHyp,y1-circleHyp,2*circleHyp,2*circleHyp);
			}
			
			if(flag_shapeProperties==2){
				Stroke dotted = new BasicStroke(thickness, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL, 0, new float[]{5,5}, 0);
				gc.setStroke(dotted);
				gc.drawOval(x1-circleHyp,y1-circleHyp,2*circleHyp,2*circleHyp);
			}
			
			if(flag_shapeProperties==3){
				Stroke dashed = new BasicStroke(thickness, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL, 0, new float[] {6,3,10,3}, 0);
				gc.setStroke(dashed);
				gc.drawOval(x1-circleHyp,y1-circleHyp,2*circleHyp,2*circleHyp);
			}
			
			
			
		}
	}
	
	public void mouseEntered(MouseEvent e){}
	
	public void mouseExited(MouseEvent e){}
	
	Graphics g2;
	
	@Override
	public void mouseClicked(MouseEvent e){
		
		flag_scale=true;
		
		if(btn_solid.isSelected()){
			flag_shapeProperties=1;
		}
		else if(btn_dotted.isSelected()){
			flag_shapeProperties=2;
		}
		else if(btn_dashed.isSelected()){
			flag_shapeProperties=3;
		}
		
		
		

		if(mouse_line_rbtn.isSelected()){
			if(e.getButton() == MouseEvent.BUTTON1){	
				if(e.getClickCount()==2){
				shapePanel.removeAll();
				repaint();
				}
			}
		}
		
		
		if(mouse_ellipse_rbtn.isSelected()){
			label.setText("1st click=CENTER coordinate // 2nd click=R1 coordinate // 3rd click=R2 coordinate // Double Click to CLEAR ALL");
			flag_mouse_shape=3;
			if(e.getButton() == MouseEvent.BUTTON1){
				if(e.getClickCount()==1){
					list_ellipse.add(e.getPoint());

					if(list_ellipse.size()%3==0){
						repaint();
					}
				}
				
				if(e.getClickCount()==2){
				list_ellipse=new ArrayList<>();
				repaint();
				}
			}
		}
		
		if(mouse_polygon_rbtn.isSelected()){
			label.setText("Left Click: Add Point   ///  Double Left Click: Draw Shape  ///  Right Click: Remove Point  ///  Scroll Click: Clear Screen");
			flag_mouse_shape=4;
			if(e.getButton() == MouseEvent.BUTTON1){		//checks if left click was pressed
				if(DRAW_Polygon==false){
					if(e.getClickCount()==2){
						xAxis_polygon[nPoints_polygon] = xAxis_polygon[0];			
						//set the last index in the array back to where
						//the first point started to complete the polygon
						yAxis_polygon[nPoints_polygon] = yAxis_polygon[0];

						DRAW_Polygon = true;
					}
					else{
					nPoints_polygon++;
					xAxis_polygon[index_polygon] = e.getX();			//stores the x coors into the array
					yAxis_polygon[index_polygon] = e.getY();			//stores the y coors into the a separate array
					index_polygon++;
					}
				}
			}
			
			else if(e.getButton() == MouseEvent.BUTTON3){
				if(nPoints_polygon>0){
					nPoints_polygon--;
					index_polygon--;
				}				
			}
			
			else if(e.getButton() == MouseEvent.BUTTON2){
				xAxis_polygon=new int[50];			
				//set the last index in the array back to where
				//the first point started to complete the polygon
				yAxis_polygon=new int[50];
				index_polygon=0;
				nPoints_polygon=0;
				DRAW_Polygon = false;
			}
			repaint();
		}
		
		if(mouse_circle_rbtn.isSelected()){
			if(e.getButton() == MouseEvent.BUTTON1){	
				if(e.getClickCount()==2){
				shapePanel.removeAll();
				repaint();
				}
			}
		}		
	}

	
	public void paint(Graphics g){///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		super.paint(g);
		
		int x=centerx*2;
		int y=centery*2;
		
		int centerx2=(int)(centerx*1.01);
		int centery2=(int)(centery*1.06);
		
		Color lightgrey=new Color(196,196,196);
		int n=gridInterval;
		
		
//start - drawing the graph grid lines/////////////////////////////////////////////////////////////////////////////////////////////////	
		g.setColor(Color.red);
		g.drawLine(centerx2, 0, centerx2, y);
		g.drawLine(0, centery2, x, centery2);
			
		g.setColor(lightgrey);
			
		int p=1;
		while((p*n)<centerx || (p*n)<centery){
			g.drawLine(centerx2-(p*n), 0, centerx2-(p*n), y);
			g.drawLine(centerx2+(p*n), 0, centerx2+(p*n), y);
			
			g.drawLine(0, centery2-(p*n), x, centery2-(p*n));
			g.drawLine(0, centery2+(p*n), x, centery2+(p*n));
			p++;
		}
//end - drawing the graph grid lines////////////////////////////////////////////////////////////////////////////////////////////////////
		
		
		
		
///////////////////////drawing interval for mouse events////////////////////////////////////////////////////////////////////////////////
		if(flag_scale){
			g.setColor(Color.blue);
			g.translate(8, 30);
			
			g.drawString("0", centerx, centery+15);	//zero coordinate
			
			int q=1;
			while((q*n)<centerx || (q*n)<centery){
				int interval=q*n;
				
				g.drawString(""+interval, centerx+(q*n), centery+15);  //positive x
				g.drawString(""+interval, centerx-30, centery+(q*n));  //negative y
				
				g.drawString("-"+interval, centerx-(q*n), centery+15);	//negative x
				g.drawString("-"+interval, centerx-30, centery-(q*n));  //positive y
				q++;
			}
		}
///////////////////////drawing interval for mouse events////////////////////////////////////////////////////////////////////////////////		

		
		
/////////////////////////////////////////////////////////////ellipse/////////////////////////////////////////////////////////////////////////////////
		if(flag_mouse_shape==3){
			g.setColor(Color.black);
			//g.translate(8, 30);
			
			Graphics2D gc=(Graphics2D)g;
			int thickness=flag_shapeThickness;
			
			if(flag_shapeProperties==1){
				Stroke solid = new BasicStroke(thickness, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL, 0);
				
				for(int i=0;i<list_ellipse.size();i+=3){
					Point center=list_ellipse.get(i);
					Point radius1=list_ellipse.get(i+1);
					Point radius2=list_ellipse.get(i+2);
					
					int height=(int)(Math.abs(center.getY()-radius1.getY())*1.01);
					int width=(int)(Math.abs(center.getX()-radius2.getX())*1.01);
					
					int startPointX=(int)center.getX()-width;
					int startPointY=(int)center.getY()-height;
					
					gc.setColor(Color.blue);
					gc.fillOval(center.x-2, center.y-2, 4, 4);
					gc.setColor(Color.black);
					
					gc.setStroke(solid);
					gc.drawOval(startPointX, startPointY, 2*width, 2*height);
					

				}
			}
			
			if(flag_shapeProperties==2){
				Stroke dotted = new BasicStroke(thickness, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL, 0, new float[]{5,5}, 0);
				
				
				for(int i=0;i<list_ellipse.size();i+=3){
					Point center=list_ellipse.get(i);
					Point radius1=list_ellipse.get(i+1);
					Point radius2=list_ellipse.get(i+2);
					
					int height=(int)(Math.abs(center.getY()-radius1.getY())*1.01);
					int width=(int)(Math.abs(center.getX()-radius2.getX())*1.01);
					
					int startPointX=(int)center.getX()-width;
					int startPointY=(int)center.getY()-height;
					
					gc.setColor(Color.blue);
					gc.fillOval(center.x-2, center.y-2, 4, 4);
					gc.setColor(Color.black);
					
					gc.setStroke(dotted);
					gc.drawOval(startPointX, startPointY, 2*width, 2*height);
					

				}
			}
			
			if(flag_shapeProperties==3){
				Stroke dashed = new BasicStroke(thickness, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL, 0, new float[] {6,3,10,3}, 0);
				
				for(int i=0;i<list_ellipse.size();i+=3){
					Point center=list_ellipse.get(i);
					Point radius1=list_ellipse.get(i+1);
					Point radius2=list_ellipse.get(i+2);
					
					int height=(int)(Math.abs(center.getY()-radius1.getY())*1.01);
					int width=(int)(Math.abs(center.getX()-radius2.getX())*1.01);
					
					int startPointX=(int)center.getX()-width;
					int startPointY=(int)center.getY()-height;
					
					gc.setColor(Color.blue);
					gc.fillOval(center.x-2, center.y-2, 4, 4);
					gc.setColor(Color.black);
					
					gc.setStroke(dashed);
					gc.drawOval(startPointX, startPointY, 2*width, 2*height);
					

				}
			}
		}
///////////////////////////////////////////////////////////ellipse/////////////////////////////////////////////////////////////////////////////////////////////////////
		
		
		
		
////////////////////////POLYGON//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
		if(flag_mouse_shape==4){
			
			Graphics2D gc=(Graphics2D)g;
			int thickness=flag_shapeThickness;
			
			gc.setColor(Color.black);
			//gc.translate(8, 30);
			
			if(flag_shapeProperties==1){
				Stroke solid = new BasicStroke(thickness, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL, 0);
				gc.setStroke(solid);
				gc.drawPolyline(xAxis_polygon, yAxis_polygon, nPoints_polygon);	
			}
			
			if(flag_shapeProperties==2){
				Stroke dotted = new BasicStroke(thickness, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL, 0, new float[]{5,5}, 0);
				gc.setStroke(dotted);
				gc.drawPolyline(xAxis_polygon, yAxis_polygon, nPoints_polygon);	
			}
			
			if(flag_shapeProperties==3){
				Stroke dashed = new BasicStroke(thickness, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL, 0, new float[] {6,3,10,3}, 0);
				gc.setStroke(dashed);
				gc.drawPolyline(xAxis_polygon, yAxis_polygon, nPoints_polygon);	
			}
			
			
			
			if(DRAW_Polygon == true)	//checks if the right click was pressed
			{
				gc.setColor(Color.blue);
				
				if(flag_shapeProperties==1){
					Stroke solid = new BasicStroke(thickness, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL, 0);
					gc.setStroke(solid);
					gc.drawPolygon(xAxis_polygon, yAxis_polygon, nPoints_polygon);	
				}
				
				if(flag_shapeProperties==2){
					Stroke dotted = new BasicStroke(thickness, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL, 0, new float[]{5,5}, 0);
					gc.setStroke(dotted);
					gc.drawPolygon(xAxis_polygon, yAxis_polygon, nPoints_polygon);
				}
				
				if(flag_shapeProperties==3){
					Stroke dashed = new BasicStroke(thickness, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL, 0, new float[] {6,3,10,3}, 0);
					gc.setStroke(dashed);
					gc.drawPolygon(xAxis_polygon, yAxis_polygon, nPoints_polygon);	
				}
			}
			
		}
////////////////////////POLYGON//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
	}
	
	
	
	public static void main(String[] args){
		new Draw();
	}
}