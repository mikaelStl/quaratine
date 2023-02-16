import java.util.List;

public class Spawn {
    public void generateItem(List<Zombie> enemies){
        int quant = 8;

        for (int j = 0; j < quant; j++) {
            int rand = (int) (Math.random() * enemies.size());
            float rand2 =  (float) (Math.random() * 1);

            Zombie z = enemies.get(rand);
            if (rand2 < 0.5 && (z.getBandage() == null) ^ (z.getAmmo() != null)) {
                z.setBandage(new Bandage("imgs/bandage.png"));
            } else if (rand2 > 0.5 && (z.getBandage() != null) ^ (z.getAmmo() == null)){
                z.setAmmo(new Ammo("imgs/ammo.png"));
            }
        }
    }

    public Bandage spawnBandage(Zombie z){
        if (z.getBandage() != null) {
            Bandage b = z.getBandage();
            b.setX (z.getX() + (z.getW()/2));
            b.setY(z.getY()+ z.getH());
            return b;
        } else {
            return null;
        }
    }
    public Ammo spawnAmmo(Zombie z){
        if (z.getAmmo() != null) {
            Ammo a = z.getAmmo();
            a.setX (z.getX() + (z.getW()/2));
            a.setY(z.getY() + z.getH());
            return a;
        } else {
            return null;
        }
    }

    public void spawnZombie(List<Zombie> enemies){
        int quant = 1;

        for (int i = 0; i < quant; i++) {
            enemies.add(new Zombie(generateX(), generateY()));
        }
    }

    public int generateY(){
        float interval = (float) (Math.random() * 1);
        int y = 0;
        if (interval < 0.5) {
            y = (int) (Math.random() * -800);
        } else if (interval > 0.5){
            y = (int) (Math.random() * 800+640);
        }
        return y;
    }
    public int generateX(){
        int x = (int) (Math.random() * 3000 + (-2000));
        return x;
    }
}
