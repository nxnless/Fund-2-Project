package Enemy;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import Home.GPanel;


public class Enemy 
{
    GPanel Pan;
    private BufferedImage EnIm;
    private int StartX,StartY;
    private int x,y;
    private int SpeedEn = 1;

    public boolean toBanana = false;

    private Rectangle EnRectangle ;


    public Enemy(GPanel Pan,int x , int y)
    {
        StartX = x;
        this.y = y;
        this.x = x;
        StartY = y;
        getEnemyImage();
        
    }

    public int getY()
    {
        return y;
    }

    public int getStartY()
    {
        return StartY;
    }

    public void setY(int y)
    {
        this.y = y;
    }
    
    public Rectangle getRec()
    {
        return EnRectangle;
    }

    public void setXandY(int x , int y)
    {
        StartX = x;
        this.y = y;
        this.x = x;
        StartY = y;
    }

    public void update()
    {
        if(toBanana == false)
        {
             x = StartX;
     
            if(StartY == 0){
            y+= SpeedEn;
         
            }
            if(StartY == 48*11){
                y -=SpeedEn;
            } 

            if(y ==4*48 || y == 48*7 )
            {
                toBanana = true;
            }
            if(y == StartY)
            {
            }
        }
       

       
    
        EnRectangle = new Rectangle(x,y,48,50);

    }

    public void getEnemyImage()
    {
        try {
            EnIm = ImageIO.read(getClass().getResourceAsStream("/Image/enemy.png"));
        } catch (Exception e) {
       
        }
    }

    public void Draw(Graphics2D g2)
    {
       // g2.fillRect(x, y, 20, 20);
        g2.drawImage(EnIm, x,y,48,48,null);

     
    }


}