import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class ToxicArea{
    private int x, y;
    private int acidDamage;
    private Image acidImg;

    public ToxicArea(int x, int y){
        this.x = x;
        this.y = y;
        this.acidDamage = 2;
    }
    
    public void hit(Player p){
        p.takeDamage(acidDamage);
    }
    
    public void setAcidImg(String url) {
        ImageIcon ref = new ImageIcon(getClass().getResource(url));
        this.acidImg = ref.getImage();
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
