package Player;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.io.IOException;

import javax.imageio.ImageIO;


import Home.GPanel;
import Home.KeyHand;


public class Player extends Entity{
    GPanel Pan;
    KeyHand KeyH;
    PlayerIm[] PImage;
    
    public double point = 0;

    public int isAttack = 0;
    public Rectangle Hitcheck ;

    public Player(GPanel Pan , KeyHand KeyH)
    {
        this.Pan = Pan;
        this.KeyH = KeyH;
        PImage = new PlayerIm[2];
        SolidPlayer = new Rectangle(PlayerX+14,PlayerY+14,20,20);

        setDefaultValue();
        getPlayerImage();

    }

    public void setDefaultValue()
    {
        //PlayerX = Pan.BoxSize*8; เดี่ยวมาคำนวณ
        //PlayerY = Pan.BoxSize*16;
        PlayerX = 48*8;
        PlayerY = 48*4;
        Speed = 6;
    }

    public void getPlayerImage()
    {
        try {
            
            PImage[0] = new PlayerIm();
            PImage[0].PlayerIm =  ImageIO.read(getClass().getResourceAsStream("/Image/player.png"));

            PImage[1] = new PlayerIm();
            PImage[1].PlayerIm =  ImageIO.read(getClass().getResourceAsStream("/Image/Is_Attack.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update()
    {
    
        if(isAttack ==0)
        {
            point += 0.05f;
        }
        if(KeyH.UpPress == true)
        {
            Direction = 1; //Up
        }
        
        if(KeyH.DownPress == true)
        {
            Direction = 2; //Down
        }
        
        if(KeyH.LeftPress== true)
        {
            Direction = 3; //left
        }
        
        if(KeyH.RightPress == true)
        {   
            Direction = 4; //Right
            
        }if(KeyH.SpacePress == true)
        {   
            Direction = 5;
        }

        OnCollison = false; //เช็คว่าPlayer เดินไปได้ไหม จาก entity ของ palyer
        
        Pan.ColliCheck.CheckBox(this);  //เช็ค บล็อคที่เดินไปสามารถเดินผ่านได้ไหมจาก Box,Map และ player

        // ถ้า OnCollison === false Player ขยับได้
        if(OnCollison == false)
        {
            switch(Direction)
            {
                case 1: // Up
                PlayerY -= Speed;
                Direction = 0;
                break;

                case 2: // Down
                PlayerY += Speed;
                Direction = 0;
                break;

                case 3: //Left
                PlayerX -= Speed;
                Direction = 0;
                break;

                case 4: //Right
                PlayerX += Speed;
                Direction = 0;
                break;

                case 5:
                isAttack = 1;
                Direction = 6;
                break;  

                case 6:
                isAttack = 0;
                Direction = 0;
                break;
            }
        }
        Hitcheck = new Rectangle(PlayerX,PlayerY,48,48);
    }

    public void Draw (Graphics2D g2)
    {
        int n = (int)point;
        g2.drawImage(PImage[isAttack].PlayerIm, PlayerX, PlayerY,Pan.BoxSize,Pan.BoxSize,null);
        g2.setColor(Color.white);
        g2.fillRect(48, 48, 70, 20);
        g2.setColor(Color.black);
        g2.drawString(" Score "+n, 48, 60);
        
        
    }


}
