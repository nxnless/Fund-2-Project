package Home;
import javax.swing.JFrame;

public class Display {
    public static void main(String[] args) {
        
        GPanel P = new GPanel();

        JFrame frame = new JFrame("The Monkey Defense");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(P);
        frame.setSize(830,612);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        P.StertGameTread();

        
    }
}
