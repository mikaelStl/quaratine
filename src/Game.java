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
    private List<Zombie> zombies;
    private List<Ammo> ammo;
    private List<Bandage> bandages;
    private Spawn spawn;

    public Game(){
        setFocusable(true);
        setDoubleBuffered(true);

        ImageIcon ref = new ImageIcon(getClass().getResource("imgs/background.png"));
        background = ref.getImage();

        player = new Player();

        zombies = new ArrayList<Zombie>();
        ammo = new ArrayList<Ammo>();
        bandages = new ArrayList<Bandage>();
        
        spawn = new Spawn();
        spawn.spawnZombie(zombies);
        spawn.generateItem(zombies);

        addKeyListener(new Keyboard());

        timer = new Timer(20, this);
        timer.start();
    }
    //Método para imprimir objetos na tela
    public void paint(Graphics g){
        Graphics2D graphics = (Graphics2D) g;
        graphics.drawImage(background, 0, 0, null);

        if (player.isDead() == false) {
            for (int q = 0; q < bandages.size(); q++){
                Bandage bandage = bandages.get(q);
                if (bandage != null) {
                    graphics.drawImage(bandage.getItemImg(), bandage.getX(), bandage.getY(), this);
                }
            }
            for (int u = 0; u < ammo.size(); u++){
                Ammo am = ammo.get(u);
                if (am != null) {
                    graphics.drawImage(am.getItemImg(), am.getX(), am.getY(), this);
                }
            }

            for (int j = 0; j < zombies.size(); j++) {
                Zombie z = zombies.get(j);
                graphics.drawImage(z.getImg(), z.getX(), z.getY(), this);
                    graphics.setColor(new Color(225, 0, 0));
                        graphics.fill(z.getLifeBar());
                        graphics.draw(z.getLifeBar());
                    graphics.setColor(Color.black);
                        graphics.draw(z.getBounds());
            }
        
            List<Shot> shots = player.getWeapon().getShots();
            for (int p = 0; p < shots.size(); p++) {
                Shot s = shots.get(p);
                graphics.drawImage(s.getImg(), s.getX(), s.getY(), this);
            }
        
            graphics.drawImage(player.getImg(), player.getX(), player.getY(), this);
            graphics.setColor(new Color(225, 0, 0));
                graphics.fill(player.getLifeBar());
                graphics.draw(player.getLifeBar());
        } else {
            ImageIcon ref = new ImageIcon(getClass().getResource("imgs/dead.png"));
            dead = ref.getImage();
            graphics.drawImage(dead, 0, 0, null);
        }
        g.dispose();
    }
    //Método para imprimir objetos na tela
    @Override
    public void actionPerformed(ActionEvent e){
        int cont = 0;
        int aux = 0;

        player.move();
        player.setLifeBar(player.getW(), player.getLife());

        List<Shot> shots = player.getWeapon().getShots();
        for (int o = 0; o < shots.size(); o++) {
            Shot s = shots.get(o);
            s.shot();
            if (s.getX() > 640 || s.getX() < 0) {
                shots.remove(o);
            }
        }

        while (cont != zombies.size()) {
            Zombie z = zombies.get(cont);
            Zombie tempZ = zombies.get(aux);
            z.setLifeBar(z.getW(), z.getLife());
            if (z.isDead() == false) {
                if (!touch(player.getBounds(), z.getBounds())) {
                    z.walkX(player, tempZ);
                    z.walkY(player, tempZ);
                }
                z.setPlayer(player);   
            }
            aux = cont;
            cont++;
        }

        checkColision();
        repaint();
    }
    //Metódo para Checar colição
    public void checkColision(){
        Rectangle playerBox = player.getBounds();
        Rectangle zombieBox;
        Rectangle shotBox;
        Rectangle itemBox;

        List<Shot> shots = player.getWeapon().getShots();
        for (int m = 0; m < shots.size(); m++) {
            Shot shot = shots.get(m);
            shotBox = shot.getBounds();
            for (int s = 0; s < zombies.size(); s++) {
                Zombie zombie = zombies.get(s);
                if (zombie.isDead() == false) {
                    zombieBox = zombie.getBounds();
                    if (shotBox.intersects(zombieBox)) {
                        shot.hitZombie(zombie);
                        if (zombie.getLife() <= 0) {
                            if (zombie.getBandage() != null) {
                                bandages.add(spawn.spawnBandage(zombie));
                            } else if(zombie.getAmmo() != null){
                                ammo.add(spawn.spawnAmmo(zombie));
                            }
                            zombies.remove(s);
                            zombieBox = null;
                            System.out.println(zombieBox);
                        }
                        shots.remove(m);
                    }
                }
            }
        }

        for (int f = 0; f < bandages.size(); f++) {
            Bandage b = bandages.get(f);
            if (b != null) {
                itemBox = b.getBounds();
                if (touch(playerBox, itemBox)) {
                    player.addItem(b);
                    bandages.remove(f);
                }
            }
        }
        for (int w = 0; w < ammo.size(); w++) {
            Ammo a = ammo.get(w);
            if (a != null) {
                itemBox = a.getBounds();
                if (touch(playerBox, itemBox)) {
                    a.function(player);
                    ammo.remove(w);
                }
            }
        }

    }
    public boolean touch(Rectangle objBounds1, Rectangle objBounds2){
        return objBounds2.intersects(objBounds1);
    }
    //Metódo para desenhar munição
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