import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Container extends JFrame {
    public Container(){
        ImageIcon icone = new ImageIcon(getClass().getResource("imgs/icon.png"));
        add(new Game());
        setIconImage(icone.getImage());
        setTitle("Zombified");
        setSize(640, 640);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        this.setResizable(false);
        setVisible(true);
    }
}
