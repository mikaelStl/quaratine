class Spawn {
    constructor(){};
    // generateItem(enemies = []){
    //     const quant = 8;

    //     for (let j = 0; j < quant; j++) {
    //         const rand = (Math.round(Math.random()) * enemies.size());
    //         const rand2 =  (Math.random() * 1);

    //         const z = enemies[rand];
    //         if (rand2 < 0.5 && (z.getItem() == null)) {
    //             z.setItem(new Bandage("imgs/bandage.png"));
    //         } else if (rand2 > 0.5 && (z.getItem() == null)){
    //             z.setItem(new Ammo("imgs/ammo.png"));
    //         }
    //     }
    // }

    //todo
    // static spawnItem(z){
    //     if (z.getItem() != null) {
    //         Item i = z.getItem();
    //         i.setX(z.getX() + (z.getW()/2));
    //         i.setY(z.getY()+ z.getH());
    //         return i;
    //     } else {
    //         return null;
    //     }
    // }

    static generateY(){
        const interval = Math.random() * 1;
        let y = 0;
        if (interval < 0.5) {
            y = Math.round(Math.random() * -800);
        } else if (interval > 0.5){
            y = Math.round(Math.random() * 800+640);
        }
        return y;
    }

    static generateX(){
        const x = Math.random() * 3000 + (-2000);
        return x;
    }

    static spawnZombie(enemies = []){
        const quant = 12;

        for (let i = 0; i < quant; i++) {
            enemies.push(new Zombie(this.generateX(), this.generateY(),'./img/z-model.png',frames = {max: 1, current: 0, elapsed: 0}));
        }
    }
}