import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public abstract class Item {
    private Image itemImg;
    private int x, y;
    private int h, w;
    protected int value;
    
    public Item(String url){
        setImg(url);
        this.h = getItemImg().getHeight(null);
        this.w = getItemImg().getWidth(null);
    }
    //Definindo colisor
    public Rectangle getBounds(){
        return new Rectangle(x, y, w, h);
    }
    //Getter e Setter para imagem
    public void setImg(String url){
        ImageIcon ref = new ImageIcon(getClass().getResource(url));
        this.itemImg = ref.getImage();
    }
    public Image getItemImg(){
        return itemImg;
    }
    //Getter e Setter para posição
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public int getY() {
        return y;
    }
}
