import javax.swing.JFrame;

public class Container extends JFrame {
    public Container(){
        add(new Game());
        setTitle("Zombified");
        setSize(640, 640);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        this.setResizable(false);
        setVisible(true);
    }
}
