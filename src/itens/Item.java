import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public abstract class Item extends Entity {
    protected int value;
    
    public Item(String url){
        setImg(url);
        this.h = getImg().getHeight(null);
        this.w = getImg().getWidth(null);
    }
    //funcionalidade do item
    public abstract void function(Player p);
    //Definindo colisor
    public Rectangle getBounds(){
        return new Rectangle(x, y, w, h);
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
