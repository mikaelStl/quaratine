import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class AcidArea {
    private int x, y;
    private int acidDamage;
    private Rectangle acidArea;
    private Image acidImg;

    public AcidArea(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void setAcidImg(String url) {
        ImageIcon ref = new ImageIcon(getClass().getResource(url));
        this.acidImg = ref.getImage();
        this.acidDamage = 2;
    }
    public Image getAcidImg() {
        return acidImg;
    }
    //Variaveis para area toxica
    public int getImgHeight(){
        return acidImg.getHeight(null);
    }
    public int getImgWidth(){
        return acidImg.getWidth(null);
    }
    //Definindo colisor
    public Rectangle getBounds(){
        return new Rectangle(x, y, getImgWidth(), getImgHeight());
    }
    //Getter para posição
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
}
