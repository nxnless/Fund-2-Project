package Home;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

import Player.Player;
import Box.*;
import Enemy.Enemy;
import Enemy.EnemySummon;

public class GPanel extends JPanel implements Runnable{
    Rectangle a = new Rectangle(0,0,48,48);
    
    //Base Scale
    public final int BaseSize = 16;
    public final int ScaleUp = 3;
    public final int BoxSize = BaseSize*ScaleUp; //48

    //Window Size
    public final int OScreenCol = 17;
    public final int OScreenRow = 12;

    //Screen size
    public final int MaxScreenCol = OScreenCol*BoxSize;
    public final int MaxScreenRow = OScreenRow*BoxSize;

    //Random Summon Enemy in 6 point for left -> right top-> bot
    public EnemySummon[] enemyspot = new EnemySummon[6];
    
    /* 0 = Left top  x = 48*4 = 192 , y = 0
     * 1 = Mid top   x = 48 *8 = 384 , y = 0
     * 2 = Right top x = 48*12 = 576 , y = 0
     * 
     * 3 = Left bot  x = 48*4 = 192 , y = 528
     * 4 = Mid bot   x = 48 *8 = 384 , y = 528
     * 5 = Right bot x = 48*12 = 576 , y = 528
    */

    int FPS = 60;

    //Random Enemy Summon Point
    Random ran1 = new Random();
    Random ran2 = new Random();
    Random ran3 = new Random();


    //Input KeyHandler
    KeyHand KeyH = new KeyHand();

    //Input Player to Panel
    Player User = new Player(this,KeyH);

    //Input Map
    BoxManage BoxM = new BoxManage(this);

    //Input Check Collison
    public CollisonCheck ColliCheck = new CollisonCheck(this);

    //เรียก enemy
    Enemy enemy1 = new Enemy(this , 192 , 0);

    Enemy enemy2 = new Enemy(this , 384, 0);

    Enemy enemy3 = new Enemy(this , 576, 0);

    GPanel()
    {
   
        this.setDoubleBuffered(true); //Modify Frame 
        this.addKeyListener(KeyH);
        this.setFocusable(true);  //can input without enter
    }

    Thread gameThread;
    public void StertGameTread()
    {
        gameThread = new Thread(this);
        gameThread.start();
        
    }

    @Override
    public void run()
    {
        double DrawInterval = 1000000000/FPS;
        double nexdDrawnTime = System.nanoTime() + DrawInterval;

        while(gameThread != null)
        {
            update();

            repaint();

            try
            {
                double RemainTime = nexdDrawnTime - System.nanoTime();
                RemainTime = RemainTime/1000000;
                
                if(RemainTime < 0)
                {
                    RemainTime = 0;
                }
                Thread.sleep((long)RemainTime);
                
                nexdDrawnTime += DrawInterval;
            }catch(InterruptedException e)
            {  
                e.printStackTrace();
            }
        }
    }

    public void update()
    {
       
        User.update();  
        enemy1.update();
        enemy2.update();
        enemy3.update();
        intSectCheck();
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g); 
        
        Graphics2D g2 = (Graphics2D)g;

        String Rank ="";
        if(User.point < -300)
        {
            Rank = "นายเป็นขี้มากกว่าขี้อีกนะเนี้ย";
        }if(User.point < -200)
        {
            Rank = "โอ้ว อยู่ระดับขี้เองหรอ";
        }if(User.point < -100)
        {
            Rank = "ไม่นะกล้วยจะเปื้อนหมดแล้ว";
        }if(User.point < 0)
        {
            Rank = "ครั้งแรกหรอพ่อหนุ่ม";
        }if(User.point > 0 && User.point < 100)
        {
            Rank = "พยายามเข้าเกมไม่ยากขนาดนั้น";
        }if(User.point == 100)
        {
            Rank = "มีฝีมือนะเนี้ยเรา";
        }if(User.point == 200)
        {
            Rank = "ดุดันไม่เกรงใจใคร";
        }if(User.point == 300)
        {
            Rank = "โอ้วพระเจ้า นั่นเขาอยู่ระดับซุปเปอร์ข่าไก่เลยนะ";
        }




        BoxM.Draw(g2);
        enemy1.Draw(g2);
        enemy2.Draw(g2);
        enemy3.Draw(g2);
        User.Draw(g2);
        g2.setColor(Color.white);
        g2.fillRect(0, 0, 159, 20);
        g2.setColor(Color.BLACK);
        g2.drawString(Rank, 4, 15);

        g2.dispose();
       
    }
   
   public void intSectCheck()
   {

        int point1 = ran1.nextInt(6);
        int point2 = ran2.nextInt(6);
        int point3 = ran3.nextInt(6);

        enemyspot = new EnemySummon[6];
            /* 0 = Left top  x = 48*4 = 192 , y = 0
            * 1 = Mid top   x = 48 *8 = 384 , y = 0
            * 2 = Right top x = 48*12 = 576 , y = 0
            * 
            * 3 = Left bot  x = 48*4 = 192 , y = 528
            * 4 = Mid bot   x = 48 *8 = 384 , y = 528
            * 5 = Right bot x = 48*12 = 576 , y = 528
                */

        //Set จุดเกิด enemy
        enemyspot[0] = new EnemySummon();
        enemyspot[0].setSumXY(192, 0);
       
        enemyspot[1] = new EnemySummon();
        enemyspot[1].setSumXY(384, 0);

        enemyspot[2] = new EnemySummon();
        enemyspot[2].setSumXY(576, 0);

        enemyspot[3] = new EnemySummon();
        enemyspot[3].setSumXY(192, 528); 

        enemyspot[4] = new EnemySummon();
        enemyspot[4].setSumXY(384, 528);

        enemyspot[5] = new EnemySummon();
        enemyspot[5].setSumXY(576, 528);

        //when hit enemy random position
        if(User.Hitcheck.intersects(enemy1.getRec()) && User.isAttack == 1)
        {
            enemy1.setXandY(enemyspot[point1].ReX(), enemyspot[point1].ReY());
            enemy1.toBanana = false;
        }
        if(User.Hitcheck.intersects(enemy2.getRec()) && User.isAttack == 1)
        {
            enemy2.setXandY(enemyspot[point2].ReX(), enemyspot[point2].ReY());
            enemy2.toBanana = false;
        }if(User.Hitcheck.intersects(enemy3.getRec()) && User.isAttack == 1)
        {
            enemy3.setXandY(enemyspot[point3].ReX(), enemyspot[point3].ReY());
            enemy3.toBanana = false;
        }
        if(enemy1.toBanana == true)
        {
            User.point -= 0.25;
        }
   }





}
