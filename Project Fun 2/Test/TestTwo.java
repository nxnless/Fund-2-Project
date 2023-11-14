package Test;

import java.awt.Rectangle;

public class TestTwo {
    public static void main(String[] args) {
        Rectangle a = new Rectangle();
        a.setSize(20, 20);
        Rectangle b = new Rectangle(0,0,100,20);
        int i = 0;
        while(true)
        {
            a.setLocation(0,i);
            if(a.intersects(b))
            {
                System.out.println(a.getLocation());
            }
            i++;
        }
}
    }
   

