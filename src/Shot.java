import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.Rectangle;

public class Shot {
    private Image img;
    private int x, y;
    private int w, h;
    private int damage;
    private int direction;

    private final int VELOCITY = 10;

    public Shot(int x, int y, int d, int direction){
        ImageIcon ref = new ImageIcon(getClass().getResource("imgs/shot.png"));
        setImg(ref);
        this.w = getImg().getHeight(null);
        this.h = getImg().getWidth(null);
        this.x = x;
        this.y = y;
        this.damage = d;
        this.direction = direction;
    }
    /*1: DIREITA*/
    /*0: ESQUERDA*/
    public void shot(){
        if (getDirection() == 1) {
            this.x += VELOCITY;
        } else if (getDirection() == 0) {
            this.x -= VELOCITY;
        }
    }
    
    public void hitZombie(Zombie z){
        if (getBounds().intersects(z.getBounds())) {
            z.takeDamage(damage);
        }
    }
    //Área de colisão
    public Rectangle getBounds(){
        return new Rectangle(x, y, w, h);
    }
    //Getter e Setter para imagem
    public Image getImg() {
        return img;
    }
    public void setImg(ImageIcon ref) {
        this.img = ref.getImage();
    }
    //Getter para x e y
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    //Getter para direção
    public int getDirection() {
        return direction;
    }
}
