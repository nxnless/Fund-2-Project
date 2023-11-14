package Home;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class KeyHand implements KeyListener{

    public boolean UpPress,DownPress,LeftPress,RightPress;
    public boolean SpacePress = false;
    @Override
    public void keyTyped(KeyEvent e) {
       
    }

    @Override
    public void keyPressed(KeyEvent e) {

        int code = e.getKeyCode();

        if(code == KeyEvent.VK_W){
            UpPress = true;
        }if(code == KeyEvent.VK_S){
            DownPress = true;
        }if(code == KeyEvent.VK_A){
            LeftPress = true;
        }if(code == KeyEvent.VK_D){
            RightPress = true;
        }if(code == KeyEvent.VK_SPACE) // Attack
        {
            SpacePress = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        if(code == KeyEvent.VK_W){
            UpPress = false;
        }if(code == KeyEvent.VK_S){
            DownPress = false;
        }if(code == KeyEvent.VK_A){
            LeftPress = false;
        }if(code == KeyEvent.VK_D){
            RightPress = false;
        }if(code == KeyEvent.VK_SPACE) //Attack
        {
            SpacePress = false;
        }
    }

}
