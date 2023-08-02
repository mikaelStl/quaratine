import java.awt.Rectangle;

import java.util.Timer;
import java.util.TimerTask;


public class Zombie extends Entity{    
    private Item item;
    protected int damage;
    protected int interval;
    protected Timer timer;
    protected TimerTask action;

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
        this.dx = x + w;
        this.dy = y + h;
        this.dead = false;

        this.item = null;

        this.timer = new Timer();
        this.interval = 800;

        setLifeBar(getW(), getLife());
    }

    // Método para se mover em reação ao Player
    public void walkX(Player p){
        setPositionX(x, w);
        int playerPosition = p.getPsX();
    
        if ((playerPosition > getPsX())) {
            x += velocity;
            dx += velocity;
        }else if ((playerPosition < getPsX())) {
            x -= velocity;
            dx -= velocity;
        } else if (playerPosition == this.positionX){
            y += 0;
            dy += 0;
        }
    }
    public void walkY(Player p){
        setPositionY(y, h);
        int playerPosition = p.getPsY();
        
        if ((playerPosition > getPsY())) {
            y += velocity;
            dy += velocity;
        } else if ((playerPosition < getPsY())) {
            y -= velocity;
            dy -= velocity;
        } else if (playerPosition == this.positionY){
            x += 0;
            dx += 0;
        }
    }
    // Método para parar
    public void stop() {
        this.velocity = 0;
    }
    //Andar caso tocou em zumbi
    public void walk(Zombie z, Player p){
        if (z.getDx() > this.getX() && z.getDx() < this.getDx()){
            walkY(p);
        } else if (z.getDy() > this.getY() && z.getDy() < this.getDy()){
            walkX(p);
        }
    }
    // Método para baixar vida
    @Override
    public void takeDamage(int damage){
        if (this.lifeValue > 0) {
            this.lifeValue -= damage;
            setLifeBar(getBarWidth(), this.lifeValue);
        } else if (lifeValue <= 0) {
            Dead();
        }
    }
    //Método para atacar
    public void attack(Player p){
        action = new TimerTask() {
            public void run() {
                if (Entity.touch(p, getZ())) {
                    p.takeDamage(damage);
                } else {
                    cancel();
                }
            }
        };
        timer.scheduleAtFixedRate(action, 0, interval);
    }
    public Zombie getZ() {
        return this;
    }
    //Metodos especiais para o objeto item
    public Item getItem() {
        return item;
    }
    public void setItem(Item i) {
        this.item = i;
    }
}
