package assignment;

import java.awt.Color;
import java.awt.Graphics;

public class Circle extends Shape{
	public void draw(Graphics g){
		
		int n=Draw.gridInterval;
		int centerx=Draw.centerx;
		int centery=Draw.centery;
		
		
		//start - drawing the scale on screen
		if(!Draw.flag_scale){ 
			g.setColor(Color.blue);
			g.drawString(""+(int)Draw.interval_circle[0], Draw.centerx, Draw.centery+15);	//zero coordinate
			
	
	
			for(int i=1;i<Draw.interval_circle.length;i++){
				int x=(int)Draw.interval_circle[i];
				
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
		//end - drawing the scale on screen
		
		g.setColor(Color.black);
		g.translate(Draw.circle_pos_x,Draw.circle_pos_y);
		
		int thickness=Draw.flag_shapeThickness;
		
		//start - drawing the circle
		if(Draw.flag_shapeProperties==1){	
			for(int i=0;i<Draw.pk.length;i++){
				for(int j=0;j<thickness;j++){
					
					int x=(int)Draw.xk[i]+j;
					int y=(int)Draw.yk[i]+j;
				
					g.drawLine(x+centerx, y+centery, x+centerx, y+centery);
					g.drawLine(y+centerx, x+centery, y+centerx, x+centery);
					
					g.drawLine(x+centerx, -y+centery, x+centerx, -y+centery);
					g.drawLine(-y+centerx, x+centery, -y+centerx, x+centery);
					
					g.drawLine(-x+centerx, y+centery, -x+centerx, y+centery);
					g.drawLine(y+centerx, -x+centery, y+centerx, -x+centery);
					
					g.drawLine(-x+centerx, -y+centery, -x+centerx, -y+centery);
					g.drawLine(-y+centerx, -x+centery, -y+centerx, -x+centery);
			
				}
			}
		}
		
		else if(Draw.flag_shapeProperties==2){	
			for(int i=0;i<Draw.pk.length;i+=2){
				
				for(int j=0;j<thickness;j++){
					
					int x=(int)Draw.xk[i]+j;
					int y=(int)Draw.yk[i]+j;
				
					g.drawLine(x+centerx, y+centery, x+centerx, y+centery);
					g.drawLine(y+centerx, x+centery, y+centerx, x+centery);
					
					g.drawLine(x+centerx, -y+centery, x+centerx, -y+centery);
					g.drawLine(-y+centerx, x+centery, -y+centerx, x+centery);
					
					g.drawLine(-x+centerx, y+centery, -x+centerx, y+centery);
					g.drawLine(y+centerx, -x+centery, y+centerx, -x+centery);
					
					g.drawLine(-x+centerx, -y+centery, -x+centerx, -y+centery);
					g.drawLine(-y+centerx, -x+centery, -y+centerx, -x+centery);
			
				}
			}
		}
		
		else if(Draw.flag_shapeProperties==3){	
			for(int i=0;i<Draw.pk.length;i++){
				
				if(i%10==0)
					i+=2;
				else if(i%5==0)
					i+=4;
				
				
				
				for(int j=0;j<thickness;j++){
					
					int x=(int)Draw.xk[i]+j;
					int y=(int)Draw.yk[i]+j;
				
					g.drawLine(x+centerx, y+centery, x+centerx, y+centery);
					g.drawLine(y+centerx, x+centery, y+centerx, x+centery);
					
					g.drawLine(x+centerx, -y+centery, x+centerx, -y+centery);
					g.drawLine(-y+centerx, x+centery, -y+centerx, x+centery);
					
					g.drawLine(-x+centerx, y+centery, -x+centerx, y+centery);
					g.drawLine(y+centerx, -x+centery, y+centerx, -x+centery);
					
					g.drawLine(-x+centerx, -y+centery, -x+centerx, -y+centery);
					g.drawLine(-y+centerx, -x+centery, -y+centerx, -x+centery);
			
				}
			}
		}
		//end - drawing the circle	
	
		/*Color lightgrey=new Color(196,196,196);
			
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
		}
		//end - drawing the graph grid lines
		Draw.flag=true;*/
	}
}