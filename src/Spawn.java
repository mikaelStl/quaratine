import java.util.List;

public class Spawn {
    public void generateItem(List<Zombie> enemies){
        int quant = 8;

        for (int j = 0; j < quant; j++) {
            int rand = (int) (Math.random() * enemies.size());
            float rand2 =  (float) (Math.random() * 1);

            Zombie z = enemies.get(rand);
            if (rand2 < 0.5 && (z.getItem() == null)) {
                z.setItem(new Bandage("imgs/bandage.png"));
            } else if (rand2 > 0.5 && (z.getItem() == null)){
                z.setItem(new Ammo("imgs/ammo.png"));
            }
        }
    }

    public Item spawnItem(Zombie z){
        if (z.getItem() != null) {
            Item i = z.getItem();
            i.setX(z.getX() + (z.getW()/2));
            i.setY(z.getY()+ z.getH());
            return i;
        } else {
            return null;
        }
    }

    public void spawnToxicArea(List<ToxicArea> toxic){

    }

    public void spawnZombie(List<Zombie> enemies){
        int quant = 12;

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
