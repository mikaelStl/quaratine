import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.Timer;

import java.util.List;
import java.util.ArrayList;

public class Game extends JPanel implements ActionListener{
    private Image background;
    private Image dead;
    private Player player;
    private Timer timer;
    private List<Zombie> enemies;
    private List<Item> items;
    private List<Shot> shots;

    public Game(){
        setFocusable(true);
        setDoubleBuffered(true);

        ImageIcon ref = new ImageIcon(getClass().getResource("imgs/background.png"));
        background = ref.getImage();

        player = new Player();

        enemies = new ArrayList<Zombie>();
        items = new ArrayList<Item>();
        shots = player.getWeapon().getShots();
    
        Spawn.spawnZombie(enemies);
        Spawn.generateItem(enemies);

        addKeyListener(new Keyboard());

        timer = new Timer(20, this);
        timer.start();
    }
    //Método para imprimir objetos na tela
    public void paint(Graphics g){
        Graphics2D graphics = (Graphics2D) g;
        graphics.drawImage(background, 0, 0, null);

        if (player.isDead() == false) {
            //Desenhando itens
            for (Item item : items) {
                if (item != null) {
                    graphics.drawImage(item.getImg(), item.getX(), item.getY(), this);
                }
            }
            //Desenhando Zumbis
            for (Zombie z : enemies) {
                graphics.drawImage(z.getImg(), z.getX(), z.getY(), this);
                    graphics.setColor(new Color(225, 0, 0));
                        graphics.fill(z.getLifeBar());
                        graphics.draw(z.getLifeBar());
                    graphics.setColor(new Color(0, 0, 0));
                        graphics.fillRect(z.getX(), z.getY(), 2, 2);
                        graphics.fillRect(z.getDx(), z.getDy(), 2, 2);
                if (z instanceof Toxic) {
                    Toxic t = (Toxic) z;
                    if (t.liberated()) {
                        graphics.drawImage(t.getArea().getAcidImg(), t.getPsX(), t.getPsY(), this);
                    }
                }
            }
            //Desenhando Player
            graphics.drawImage(player.getImg(), player.getX(), player.getY(), this);
            graphics.setColor(new Color(225, 0, 0));
                graphics.fill(player.getLifeBar());
                graphics.draw(player.getLifeBar());
            graphics.setColor(new Color(0, 0, 0));
                graphics.draw(player.getBounds());

            //Desenhando Tiros
            for (Shot s : shots) {
                graphics.drawImage(s.getImg(), s.getX(), s.getY(), this);
            }
        } else {
            ImageIcon ref = new ImageIcon(getClass().getResource("imgs/dead.png"));
            dead = ref.getImage();
            graphics.drawImage(dead, 0, 0, null);
        }
        g.dispose();
    }
    //Método para atualizar o jogo em tempo real
    @Override
    public void actionPerformed(ActionEvent e){
        int cont = 1;

        player.move();
        player.setLifeBar(player.getW(), player.getLife());

        for (int o = 0; o < shots.size(); o++) {
            Shot s = shots.get(o);
            s.shot();
            if (s.getX() > 640 || s.getX() < 0) {
                shots.remove(o);
            }
        }

        for (Zombie z : enemies) {
            if (!z.isDead()) {
                if (!Entity.touch(z, player)) {
                    z.setLifeBar(z.getW(), z.getLife());

                    while (cont < enemies.size()) {
                        Zombie zombie = enemies.get(cont);
                        if (Entity.touch(zombie, z) && zombie instanceof Zombie) {
                            zombie.walk(zombie, player);
                        }
                        cont++;
                    }
                }
            }
        }

        // while (cont != enemies.size()) {
        //     Zombie z = enemies.get(cont);
        //     Zombie tempZ = enemies.get(aux);
        //     z.setLifeBar(z.getW(), z.getLife());
        //     if (z.isDead() == false) {
        //         if (!Entity.touch(player, z)) {
        //             touchIn(player, z);
        //             z.walk(player);
        //             z.walkZ(tempZ);
        //             // z.walkY(player);
        //             // z.attack(player);
        //         } else if (Entity.touch(z, tempZ)){
        //             touchIn(z, tempZ);
        //         }
        //     }
        //     aux = cont;
        //     cont++;
        // }

        checkColision();
        repaint();
    }
    // Colisor entre zumbis
    
    //Metódo para checar colisão
    public void checkColision(){
        Rectangle shotBox;
        // Rectangle itemBox;

        for (int m = 0; m < shots.size(); m++) {
            Shot shot = shots.get(m);
            shotBox = shot.getBounds();
            for (int s = 0; s < enemies.size(); s++) {
                Zombie zombie = enemies.get(s);
                if (shotBox.intersects(zombie.getBounds())) {
                    shot.hitZombie(zombie);
                    if (zombie.getLife() <= 0) {
                        if (zombie.getItem() != null) {
                            items.add(Spawn.spawnItem(zombie));
                        }
                        enemies.remove(zombie);
                    }
                    shots.remove(shot);
                }
            }
        }

        for (int f = 0; f < items.size(); f++) {
            Item item = items.get(f);
            if (item != null) {
                item.getBounds();
                if (Entity.touch(player, item)) {
                    player.addItem(item);
                    items.remove(f);
                }
            }
        }
    }
    //Classe para receber as teclas do teclado
    public class Keyboard extends KeyAdapter{
        public int getKey(KeyEvent key){
            int keyCode = key.getKeyCode();
            return keyCode;
        }

        @Override
        public void keyPressed(KeyEvent e) {
            player.walk(getKey(e));
        }

        @Override
        public void keyReleased(KeyEvent e) {
            player.stop(getKey(e));
            player.interact(getKey(e));
        }
    }
}