import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Timer;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Player extends Entity implements ActionListener{
    private int mvX, mvY;
    private Weapon weapon;
    private int direction;
    private List<Item> inventory;

    private Timer timer;

    //Construtor
    public Player(){
        setImg("imgs/modelR.png");
        this.h = getImg().getHeight(null);
        this.w = getImg().getWidth(null);
        this.lifeValue = 100;
        this.LIFE_MAX = lifeValue;
        this.x = 320-h;
        this.y = 320-w;
        this.dead = false;
        setPositionX(x, w);
        setPositionY(y, h);
        setDirection(1);

        this.inventory = new ArrayList<Item>();

        weapon = new Weapon();
        
        setLifeBar(getW(), this.lifeValue);

        timer = new Timer(12, this);
        timer.start();
    }
    @Override
    public void actionPerformed(ActionEvent e){
        setPositionX(x, w);
        setPositionY(y, h);
    }
    //Métodos para se mover
    public void move(){
            x += mvX;
            y += mvY;
    }
    public void walk(int keyCode){
        switch (keyCode) {
            case KeyEvent.VK_UP: mvY = -4;
                break;
            case KeyEvent.VK_DOWN: mvY = 4;
                break;
            case KeyEvent.VK_RIGHT: mvX = 4;
                                    setImg("imgs/modelR.png");
                                    setDirection(1);   
                break;
            case KeyEvent.VK_LEFT: mvX = -4;
                                   setImg("imgs/modelL.png");
                                   setDirection(0);  
                break;
        }
    }
    public void stop(int keyCode){
        switch (keyCode) {
            case KeyEvent.VK_UP: mvY = 0;
                break;
            case KeyEvent.VK_DOWN: mvY = 0;
                break;
            case KeyEvent.VK_RIGHT: mvX = 0;
                break;
            case KeyEvent.VK_LEFT: mvX = 0;
                break;
        }
    }
    //Interações
    public void interact(int keyCode){
        switch (keyCode) {
            case KeyEvent.VK_A: weapon.shoot(getPlayer());
                break;
            case KeyEvent.VK_R: weapon.reload();
                break;
            case KeyEvent.VK_F: useBandage();
        }
    }
    // Adicionar item ao inventario
    public void addItem(Item i){
        this.inventory.add(i);
    }
    //Usar bandagem
    public void useBandage(){
        if (inventory.size() > 0) {
            int cont = 0;
            Item b = inventory.get(cont);
            if (lifeValue < LIFE_MAX) {
                b.function(getPlayer());
                this.inventory.remove(cont);
                cont++;
            } else{
                System.out.println("VIDA CHEIA");
            }
        } else {
            System.out.println("NÃO POSSUI BANDAGENS");
        }
    }
    //Método para baixar vida
    @Override
    public void takeDamage(int damage){
        this.lifeValue -= damage;
        setLifeBar(getBarWidth(), this.lifeValue);
        if (lifeValue <= 0) {
            setDead();
        }
    }
    //Retorna o objeto
    public Player getPlayer(){
        return this;
    }
    //Getter para objeto Weapon
    public Weapon getWeapon(){
        return weapon;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }
    public int getDirection() {
        return direction;
    }
}
