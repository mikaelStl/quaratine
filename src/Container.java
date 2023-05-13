import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Container extends JFrame {
    public Container(){
        Image icone = Toolkit.getDefaultToolkit().getImage(getClass().getResource("imgs/icon.png"));
        add(new Game());
        setIconImage(icone);
        setTitle("Zombified");
        setSize(640, 640);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        this.setResizable(false);
        setVisible(true);
    }
}
