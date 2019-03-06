package assignment;

import java.awt.Color;
import java.awt.Graphics;

public class Line extends Shape{

	public void draw(Graphics g){
		
		int n=Draw.gridInterval;
		int centerx=Draw.centerx;
		int centery=Draw.centery;
		
		
		//start - drawing the scale on screen///////////////////////////////////////////////////////////////////
		if(!Draw.flag_scale){ 
			g.setColor(Color.blue);
			g.drawString(""+(int)Draw.interval_line[0], Draw.centerx, Draw.centery+15);	//zero coordinate
			
			for(int i=1;i<Draw.interval_line.length;i++){
				int x=(int)Draw.interval_line[i];
				
				g.drawString(""+x, centerx+(i*n), centery+15);  //positive x
				g.drawString(""+x, centerx-30, centery+(i*n));  //positive y
				
				g.drawString("-"+x, centerx-(i*n), centery+15);	//negative x
				g.drawString("-"+x, centerx-30, centery-(i*n));  //negative y
				
				g.setColor(Color.red);
				g.drawLine(centerx+(i*n), centery-4, centerx+(i*n), centery+4);	//positive x
				g.drawLine(centerx-(i*n), centery-4, centerx-(i*n), centery+4);	//positive x
				g.drawLine(centerx-4, centery-(i*n), centerx+4, centery-(i*n));	//positive y
				g.drawLine(centerx-4, centery+(i*n), centerx+4, centery+(i*n));	//negative y
				g.setColor(Color.blue);
				
			}
		}
		//end - drawing the scale on screen///////////////////////////////////////////////////////////////////
		
		g.setColor(Color.black);
		
		int thickness=Draw.flag_shapeThickness;
		
		//start - drawing the circle
		if(Draw.flag_shapeProperties==1){
			for(int i=0;i<Draw.arrX.length;i++){
				int x=(int)Draw.arrX[i];
				int y=(int)Draw.arrY[i];
				
				for(int j=0;j<thickness;j++){
					g.drawLine(x+centerx, y+centery+j, x+centerx, y+centery+j);
				}
			}
		}
		else if(Draw.flag_shapeProperties==2){
			for(int i=0;i<Draw.arrX.length;i+=2){
				int x=(int)Draw.arrX[i];
				int y=(int)Draw.arrY[i];
				
				for(int j=0;j<thickness;j++){
					g.drawLine(x+centerx, y+centery+j, x+centerx, y+centery+j);
				}
			}
		}
		else if(Draw.flag_shapeProperties==3){
			for(int i=0;i<Draw.arrX.length;i++){
				
				if(i%10==0)
					i+=2;
				else if(i%5==0)
					i+=4;
				
				int x=(int)Draw.arrX[i];
				int y=(int)Draw.arrY[i];
				
				for(int j=0;j<thickness;j++){
					g.drawLine(x+centerx, y+centery+j, x+centerx, y+centery+j);
				}	
			}
		}
		
		
			
		
		
		
		
		//end - drawing the circle	
	
	}
}
