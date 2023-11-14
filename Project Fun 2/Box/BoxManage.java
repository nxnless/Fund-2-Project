package Box;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;
import javax.imageio.ImageIO;
import java.awt.Graphics2D;

import Home.GPanel;



public class BoxManage {

    GPanel Pan;
    public Box[] box;
    public int MapBoxNumber[][];
 

    public BoxManage(GPanel Pan)
    {
        this.Pan = Pan;
        box = new Box[10];
        MapBoxNumber = new int[Pan.OScreenCol][Pan.OScreenRow];
        getBoxImage();
        LoadMap();
     
        
    }

    public void getBoxImage()
    {
        try {
            
            box[0] = new Box();
            box[0].BoxIm = ImageIO.read(getClass().getResourceAsStream("/Image/colisonbox.png"));
            box[0].BoxColli = true;
      
            box[1] = new Box();
            box[1].BoxIm= ImageIO.read(getClass().getResourceAsStream("/Image/box.png"));
            box[1].BoxColli = false;

            box[2] = new Box();
            box[2].BoxIm = ImageIO.read(getClass().getResourceAsStream("/Image/middle_block.png"));
            box[2].BoxColli = true;

            box[3] = new Box();
            box[3].BoxIm = ImageIO.read(getClass().getResourceAsStream("/Image/enemy_spot.png"));
            box[3].BoxColli = true;

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void LoadMap()
    {
        try{
            InputStream IPMap = getClass().getResourceAsStream("/Map/map.txt");
            BufferedReader BoxR = new BufferedReader(new InputStreamReader(IPMap));

            int col = 0;
            int row = 0;
        

            while(col < 17 && row < 12)
            {
                String line = BoxR.readLine();
                
                while(col< 17)
                {
                    String number[] = line.split(" ");

                    int num = Integer.parseInt(number[col]);

                    MapBoxNumber[col][row] = num;
                    col++;
                }
                if(col == 17)
                {
                    col = 0;
                    row++;
                    
                }if( MapBoxNumber[col][row] == 3)
                    {   
                      
                 
                    }

            }BoxR.close();

    }catch(Exception e){}

    }

    public void Draw(Graphics2D g2)
    {
        int col = 0;
        int row = 0;
        int x = 0;
        int y = 0;
        while(col <Pan.OScreenCol && row < Pan.OScreenRow)
        {
            int boxNum = MapBoxNumber[col][row];

            g2.drawImage(box[boxNum].BoxIm , x , y ,Pan.BoxSize,Pan.BoxSize,null);
        
            col++;
            x += Pan.BoxSize;

                if(col == Pan.OScreenCol)
                {
                    col = 0;
                    x = 0;
                    row ++;
                    y+= Pan.BoxSize;
                }
        }
    }
}
