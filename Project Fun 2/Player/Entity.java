package Player;

import java.awt.Rectangle;

public class Entity {
    public int PlayerX,PlayerY;
    public int Speed;
  
    public int Direction;
    
    public Rectangle SolidPlayer;       //เป็นคลาสที่เอาไว้สร้าง สี่เหลี่ยมซึ่งสามารถเช็คการชนของ Rectangle ก้อนอื่นได้ ซึ่งถ้าชนกันจะมีค่าเป็น true
    public boolean OnCollison = false; //ไว้เช็คว่า Player ชนกัยวัตถุรึเปล่า
}
