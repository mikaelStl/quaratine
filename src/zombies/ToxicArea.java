import java.awt.Image;
import java.awt.geom.Ellipse2D;

import javax.swing.ImageIcon;

public class ToxicArea{
    private int x, y;
    private int acidDamage;
    private Image acidImg;

    public ToxicArea(int x, int y){
        setAcidImg("imgs/acidArea.png");
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
    public Ellipse2D getBounds(){
        return new Ellipse2D.Double(x, y, getImgWidth(), getImgHeight());
        // return new Rectangle(x, y, getImgWidth(), getImgHeight());
    }
    //Getter para posição
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
}
