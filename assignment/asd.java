package assignment;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class asd extends Frame{

	public static void main(String[] args)
	{
		Frame f = new asd();
		f.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent we)
			{
				System.exit(0);
			}
		});
		f.setVisible(true);
		f.setSize(1400	, 900);
	}
		public void paint(Graphics g)
		{
			Graphics2D ga = (Graphics2D)g;
			
			float rx = 600;
			float ry = 100;
			
			float Cx = 700;
			float Cy = 450;
			
			float x = 0;
			float y = ry;
			float rxx = rx*rx;
			float ryy = ry*ry;
			
			

			float Px = (2*rxx*y)-(2*rxx);
			float Py = (2*ryy*x) + (2*ryy);
			
			float Po = ryy - (rxx*ry) +((float)0.25*rxx);
			
			while(Px>=Py)
			{
				ga.drawLine((int)(Cx + x),(int)(Cy + y),(int)(Cx + x),(int)(Cy + y));
				ga.drawLine((int)(Cx + x),(int)(Cy - y),(int)(Cx + x),(int)(Cy - y));
				ga.drawLine((int)(Cx - x),(int)(Cy + y),(int)(Cx - x),(int)(Cy + y));
				ga.drawLine((int)(Cx - x),(int)(Cy - y),(int)(Cx - x),(int)(Cy - y));
				++x;
				if(Po<0)
				{
					Po =Po + Py + ryy;
					
				}
				else
				{
					Po =Po +Py - Px + ryy;
					y--;
				}
				
				Px = (2*rxx*y)-(2*rxx);
				Py = (2*ryy*x) + (2*ryy);
			}
			
			Po = (ryy *(float)( Math.pow(( x+0.5),2)   )) + (  rxx*(float)Math.pow((y-1), 2)   ) - (rxx*ryy);
			
			while(y>=0)
			{
				ga.drawLine((int)(Cx + x),(int)(Cy + y),(int)(Cx + x),(int)(Cy + y));
				ga.drawLine((int)(Cx + x),(int)(Cy - y),(int)(Cx + x),(int)(Cy - y));
				ga.drawLine((int)(Cx - x),(int)(Cy + y),(int)(Cx - x),(int)(Cy + y));
				ga.drawLine((int)(Cx - x),(int)(Cy - y),(int)(Cx - x),(int)(Cy - y));
				--y;
				if(Po > 0)
				{
					Po = Po -Px +rxx;
					
				}
				else
				{
					Po = Po + Py -Px +rxx;
					++x;
				}
				Px = (2*rxx*y)-(2*rxx);
				Py = (2*ryy*x) + (2*ryy);
			}
		}
}
