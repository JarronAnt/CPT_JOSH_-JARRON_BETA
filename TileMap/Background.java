package TileMap;

import java.awt.*;
import java.awt.image.*;
import javax.imageio.ImageIO;
import main.GamePanel;

public class Background 
{
	private BufferedImage image;
	private double x;
	private double y;
	private double dx;
	private double dy;
	
	private double moveScale;
	
	//constructer 
	public Background (String str, double _ms)
	{
		//try catch for reading in the background
		try
		{
			
			image = ImageIO.read(getClass().getResourceAsStream(str));
			moveScale = _ms;
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	public void setPosition(double x, double y)
	{
		this.x = (x*moveScale) % GamePanel.SCREEN_WIDTH;
		this.y = (y*moveScale) % GamePanel.SCREEN_HEIGHT;
		
	}
	
	public void setVector (double dx, double dy)
	{
		 this.dx = dx;
         this.dy = dy;
	}
	
	 public void update() {
         x += (dx*moveScale) % GamePanel.SCREEN_WIDTH;
         y += (dy*moveScale) % GamePanel.SCREEN_HEIGHT;
 }
 
 public void draw(Graphics2D g) 
 {
         
         g.drawImage(image, (int)x, (int)y, null);
         
         if(x < 0) 
         {
                 g.drawImage(
                         image,
                         (int)x + GamePanel.SCREEN_WIDTH,
                         (int)y,
                         null
                 );
         }
         if(x > 0) 
         {
                 g.drawImage(image, (int)x - GamePanel.SCREEN_WIDTH,(int)y,null);
         }
 }
 
}
