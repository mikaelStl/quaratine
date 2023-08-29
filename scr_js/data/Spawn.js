class Spawn {
    constructor(x, y, width, height, q){
        this.position = {
            x: x,
            y: y
        };
        this.size = {
            w: width,
            h: height
        };
        this.quant = q;
        this.hitbox = new HitBox(this.position, this.size);
    };

    draw(){
        c.fillStyle = 'rgba(255, 0, 0, 0.2)';
        c.fillRect(this.position.x, this.position.y, this.size.w, this.size.h);
    }

    #generateY(){
        const y = Math.round(this.position.y + (Math.random() * this.size.h));
        return y;
    }

    #generateX(){
        const x = Math.round(this.position.x + (Math.random() * this.size.w));
        return x;
    }

    spawnZombie(enemies = []){
        for (let i = 0; i < this.quant; i++) {
            enemies.push(new Zombie(this.#generateX(), this.#generateY(), {standart: new Sprite('./img/z-model.png', 1, 1)}, this.#generateItem()));
        }
    }

    #generateItem(){
        const rand = (Math.random() * 1);
        
        if (rand < 0.21) {
            return new Bandage({standart: new Sprite('./img/bandage.png', 1, 0)});
        } else if (rand >= 0.21 && rand < 0.34){
            return new Ammo({standart: new Sprite('./img/ammo.png', 1, 0)});
        } else {
            return null;
        }
    }

    spawnItem(z=Zombie()){
        if (z.item != null) {
            const i = z.item;
            i.position.x = Math.round((z.position.x + (z.size.width/2)));
            i.position.y = z.position.y + z.size.height;
            return i;
        } else {
            return null;
        }
    }
}