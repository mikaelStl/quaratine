class Spawn {
    constructor();
    generateItem(enemies = []){
        const quant = 8;

        for (let j = 0; j < quant; j++) {
            const rand = (int) (Math.random() * enemies.size());
            const rand2 =  (float) (Math.random() * 1);

            const z = enemies[rand];
            if (rand2 < 0.5 && (z.getItem() == null)) {
                z.setItem(new Bandage("imgs/bandage.png"));
            } else if (rand2 > 0.5 && (z.getItem() == null)){
                z.setItem(new Ammo("imgs/ammo.png"));
            }
        }
    }

    static spawnItem(z){
        if (z.getItem() != null) {
            Item i = z.getItem();
            i.setX(z.getX() + (z.getW()/2));
            i.setY(z.getY()+ z.getH());
            return i;
        } else {
            return null;
        }
    }

    static spawnZombie(enemies = []){
        const quant = 12;

        for (let i = 0; i < quant; i++) {
            enemies.push(new Zombie(generateX(), generateY()));
        }
    }

    static generateY(){
        float interval = (float) (Math.random() * 1);
        int y = 0;
        if (interval < 0.5) {
            y = (int) (Math.random() * -800);
        } else if (interval > 0.5){
            y = (int) (Math.random() * 800+640);
        }
        return y;
    }
    generateX(){
        return Math.random() * 3000 + (-2000);
    }
}