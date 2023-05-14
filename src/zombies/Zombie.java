import javax.swing.Timer;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Zombie extends Entity implements ActionListener {    
    private Item item;
    protected int damage;
    protected Player p;
    protected int velocity;

    protected Timer timer;

    //Construtor
    public Zombie(int x, int y){
        setImg("imgs/z-model.png");
        this.h = getImg().getHeight(null);
        this.w = getImg().getWidth(null);
        this.lifeValue = 100;
        this.life_max = lifeValue;
        this.damage = 5;
        this.velocity = 1;
        this.y = y;
        this.x = x;
        this.dead = false;

        this.item = null;

        setLifeBar(getW(), getLife());
    
        timer = new Timer(800, this);
        timer.start();
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if (p.getBounds().intersects(getBounds())) {
            attack(p);
        }
    }
    // Método para se mover
    public void walkX(Player p){
        setPositionX(x, w);
        int playerPosition = p.getPsX();
        
        if (playerPosition > getPsX()) {
            x += velocity;
        }else if ((playerPosition < getPsX())) {
            x -= velocity;
        } else if (playerPosition == this.positionX){
            y += 0;
        }
    }
    public void walkY(Player p){
        setPositionY(y, h);
        int playerPosition = p.getPsY();
        
        if (playerPosition > getPsY()) {
            y += velocity;
        } else if (playerPosition < getPsY()) {
             y -= velocity;
        } else if (playerPosition == getPsY()){
            x += 0;
        }
    }

    // public void walkX(Player p, Zombie z){
    //     setPositionX(x, w);
    //     int playerPosition = p.getPsX();
    //     boolean touchZombie = z.getBounds().intersects(getBounds());
        
    //     if (!touchZombie && checkZColisionX(z)) {
    //         if ((playerPosition > getPsX())) {
    //             x += velocity;
    //         }else if ((playerPosition < getPsX())) {
    //            x -= velocity;
    //         } else if (playerPosition == this.positionX){
    //             stop();
    //         }
    //     }
    // }
    // public void walkY(Player p, Zombie z){
    //     setPositionY(y, h);
    //     int playerPosition = p.getPsY();
    //     boolean touchZombie = z.getBounds().intersects(getBounds());
        
    //     if (!touchZombie && checkZColisionY(z)) {
    //         if (playerPosition > getPsY()) {
    //             y += velocity;
    //         } else if (playerPosition < getPsY()) {
    //             y -= velocity;
    //         } else if (playerPosition == getPsY()){
    //             stop();
    //         }
    //     }
    // }
    public void stop() {
        this.velocity = 0;
    }
    /*Método para baixar vida*/
    @Override
    public void takeDamage(int damage){
        if (this.lifeValue > 0) {
            this.lifeValue -= damage;
            setLifeBar(getBarWidth(), this.lifeValue);
        } else if (lifeValue <= 0) {
            setDead();
        }
    }
    //Método para atacar
    public void attack(Player p){
        p.takeDamage(damage);
    }

    public boolean checkZColisionX(Zombie z){
        int zPosition = z.getPsX();
        return ((zPosition > this.positionX) ^ (zPosition < this.positionX));
    }
    public boolean checkZColisionY(Zombie z){
        int zPosition = z.getPsY();
        return ((zPosition > this.positionY) ^ (zPosition < this.positionY));
    }
    //Metodos especiais para o objeto item
    public Item getItem() {
        return item;
    }
    public void setItem(Item i) {
        this.item = i;
    }
    /* MUDAR ISSO */
    public void setPlayer(Player p) {
        this.p = p;
    }
}
