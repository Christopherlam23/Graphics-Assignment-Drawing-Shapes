package assignment;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;

public class Polygon extends Shape{

	public void draw(Graphics g){
	
		int n=Draw.gridInterval;
		int centerx=Draw.centerx;
		int centery=Draw.centery;
		
		
		//start - drawing the scale on screen/////////////////////////////////////////////////////////////////////////////////////////////////
		if(!Draw.flag_scale){ 
			g.setColor(Color.blue);	
			g.drawString(""+(int)Draw.interval_polygon[0], Draw.centerx, Draw.centery+15);	//zero coordinate

			for(int i=1;i<Draw.interval_polygon.length;i++){
				int x=(int)Draw.interval_polygon[i];
					
				g.drawString(""+x, centerx+(i*n), centery+15);  //positive x
				g.drawString(""+x, centerx-30, centery+(i*n));  //negative y
				
				g.drawString("-"+x, centerx-(i*n), centery+15);	//negative x					
				g.drawString("-"+x, centerx-30, centery-(i*n));  //positive y
				
				g.setColor(Color.red);
				g.drawLine(centerx+(i*n), centery-4, centerx+(i*n), centery+4);	//positive x
				g.drawLine(centerx-(i*n), centery-4, centerx-(i*n), centery+4);	//positive x
				g.drawLine(centerx-4, centery-(i*n), centerx+4, centery-(i*n));	//positive y					
				g.drawLine(centerx-4, centery+(i*n), centerx+4, centery+(i*n));	//negative y
				g.setColor(Color.blue);
					
			}
		}
		//end - drawing the scale on screen/////////////////////////////////////////////////////////////////////////////////////////////////
				

		
		g.setColor(Color.black);
		g.translate(Draw.polygon_pos_x, Draw.polygon_pos_y);
		
		int thickness=Draw.flag_shapeThickness;
		
		//start - drawing the polygon
		if(Draw.flag_shapeProperties==1){
			
			Stroke solid = new BasicStroke(thickness, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL, 0);
			Graphics2D g2 = (Graphics2D)g;
			
			for(int i=0;i<Draw.polygonX.length-1;i++){
				/*for(int j=0;j<thickness;j++){
					
					int x1=(int)Draw.polygonX[i];
					int y1=(int)Draw.polygonY[i]+j;
					
					int x2=(int)Draw.polygonX[i+1];
					int y2=(int)Draw.polygonY[i+1]+j;
					
					g2.setStroke(solid);
					g2.drawLine(x1+centerx,y1+centery,x2+centerx,y2+centery);
				}*/
				
				int x1=(int)Draw.polygonX[i];
				int y1=(int)Draw.polygonY[i];
				
				int x2=(int)Draw.polygonX[i+1];
				int y2=(int)Draw.polygonY[i+1];
				
				g2.setStroke(solid);
				g2.drawLine(x1+centerx,y1+centery,x2+centerx,y2+centery);
			}
		}
		
		else if(Draw.flag_shapeProperties==2){
			//Stroke dotted = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{5,5}, 0);
			
			Stroke dotted = new BasicStroke(thickness, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL, 0, new float[]{5,5}, 0);
			Graphics2D g2 = (Graphics2D)g;
			for(int i=0;i<Draw.polygonX.length-1;i++){
				
				/*1*/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
				/*for(int j=0;j<thickness;j++){
					
					int x1=(int)Draw.polygonX[i];
					int y1=(int)Draw.polygonY[i]+j;
					
					int x2=(int)Draw.polygonX[i+1];
					int y2=(int)Draw.polygonY[i+1]+j;
					
					g2.setStroke(dotted);
					g2.drawLine(x1+centerx,y1+centery,x2+centerx,y2+centery);
				}*/
				///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
				
					
					int x1=(int)Draw.polygonX[i];
					int y1=(int)Draw.polygonY[i];
					
					int x2=(int)Draw.polygonX[i+1];
					int y2=(int)Draw.polygonY[i+1];
					
					g2.setStroke(dotted);
					g2.drawLine(x1+centerx,y1+centery,x2+centerx,y2+centery);
				
			}
		}
		
		else if(Draw.flag_shapeProperties==3){
			/*1*/
			//Stroke dashed = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[] {6,4,10,4}, 0);
			
			/*2*/
			Stroke dashed = new BasicStroke(thickness, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL, 0, new float[] {6,4,10,4}, 0);
			
			
			Graphics2D g2 = (Graphics2D)g;
			for(int i=0;i<Draw.polygonX.length-1;i++){
				
				/*1*/////////////////////////////////////////////////////////////////////////////////////////////
				/*for(int j=0;j<thickness;j++){
					
					int x1=(int)Draw.polygonX[i];
					int y1=(int)Draw.polygonY[i]+j;
					
					int x2=(int)Draw.polygonX[i+1];
					int y2=(int)Draw.polygonY[i+1]+j;
					
					g2.setStroke(dashed);
					g2.drawLine(x1+centerx,y1+centery,x2+centerx,y2+centery);
				}*/
				////////////////////////////////////////////////////////////////////////////////////////////////////
				
				/*2*////////////////////////////////////////////////////////////////////////////////////////////////
				int x1=(int)Draw.polygonX[i];
				int y1=(int)Draw.polygonY[i];
				
				int x2=(int)Draw.polygonX[i+1];
				int y2=(int)Draw.polygonY[i+1];
				
				g2.setStroke(dashed);
				g2.drawLine(x1+centerx,y1+centery,x2+centerx,y2+centery);
				/////////////////////////////////////////////////////////////////////////////////////////////////////
			}
		}
		//end - drawing the polygon
		
		
		
		
		
		
		
	/*	Color lightgrey=new Color(196,196,196);
		
		//start - drawing the graph grid lines
			
		int x=Draw.x;
		int y=Draw.y;
				
		g.setColor(Color.red);
		g.drawLine(centerx, 0, centerx, y);
		g.drawLine(0, centery, x, centery);	
		g.setColor(lightgrey);
			
		int p=1;
		while((p*n)<centerx || (p*n)<centery){
			g.drawLine(centerx-(p*n), 0, centerx-(p*n), y);
			g.drawLine(centerx+(p*n), 0, centerx+(p*n), y);
			
			g.drawLine(0, centery-(p*n), x, centery-(p*n));
			g.drawLine(0, centery+(p*n), x, centery+(p*n));
			p++;
		}*/
		//end - drawing the graph grid lines
		
		
		//Draw.flag=true;
	}
}
