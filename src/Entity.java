import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public abstract class Entity {
    protected Image img;
    protected Rectangle box;
    protected int x, y;
    protected int h, w;
    protected int dx, dy;
    protected int lifeValue;
    protected Rectangle lifeBar;
    protected int life_max;
    protected boolean dead;
    protected int velocity;
    protected int positionX;
    protected int positionY;
        
    public abstract void takeDamage(int damage);
    // Método para saber se o objeto tocou outro
    public static boolean touch(Entity ent1, Entity ent2){
        Rectangle ent1B = ent1.getBounds();
        Rectangle ent2B = ent2.getBounds();
        return ent1B.intersects(ent2B);
    }
    //Getter e Setter bara barra de vida
    public void setLifeBar(int width/*Tamanho atual da barra*/, int newLife/*vida após modificação*/) {
        int tamBar = (width * newLife)/life_max;
        this.lifeBar = new Rectangle(getX(), (getY()-9), tamBar, 3);
    }
    public Rectangle getLifeBar() {
        return lifeBar;
    }
    public int getBarWidth(){
        return (int) lifeBar.getWidth();
    }
    //Getter e Setter para imagem
    public Image getImg() {
        return img;
    }
    public void setImg(String url) {
        ImageIcon ref = new ImageIcon(getClass().getResource(url));
        this.img = ref.getImage();
    }
    //Definindo colisor
    public Rectangle getBounds(){
        return new Rectangle(x, y, w, h);
    }
    //Getter para dimensões
    public int getH(){
        return h;
    }
    public int getW(){
        return w;
    }
    //Getter para coordenadas
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    //Getter e Setter para posição em X
    public void setPositionX(int x, int width) {
        this.positionX = x + (width/2);
    }
    public int getPsX() {
        return positionX;
    }
    //Getter e Setter para posição em Y
    public void setPositionY(int y, int height) {
        this.positionY = y + (height/2);
    }
    public int getPsY() {
        return positionY;
    }
    public int getDx() {
        return dx;
    }
    public int getDy() {
        return dy;
    }
    //Getter e setter para vida
    public void setLife(int life) {
        this.lifeValue = life;
    }
    public int getLife() {
        return lifeValue;
    }
    //Getter e Setter para dead
    public void Dead(){
        this.dead = true;
        this.velocity = 0;
        this.box = null;
    }
    public boolean isDead() {
        return dead;
    }
}
