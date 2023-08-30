// import Entity from './Entity';

class Zombie extends Entity{
    //Construtor
    constructor(x=Number(), y=Number(),animations={}, item){
        super(animations);
        
        this.position = {
            x: x,
            y: y
        }
        this.damage = 5;
        this.velocity = 1;
        this.dead = false;

        this.item = item;

        this.interval = 800;

        this.area = new HitBox((this.position.x-this.size.width/2), (this.position.y-this.size.height/2), (this.size.width*2), (this.size.height*2));

        this.find = false
    }

    follow(p = Player()){
        if (this.find) {
            this.walkX(p);
            this.walkY(p);
        } else if (p.hitbox.intersects(this.area)) {
            this.find = true;
        }

        this.area.update((this.position.x-this.size.width/2), (this.position.y-this.size.height/2));
    }

    // Método para se mover em reação ao Player
    walkX(p = Player()){
        const playerPosition = p.position.x;
    
        if ((playerPosition > this.position.x)) {
            this.position.x += this.velocity;
        }else if ((playerPosition < this.position.x)) {
            this.position.x -= this.velocity;
        } else if (playerPosition == this.position.x){
            this.position.y += 0;
        }
    }
    walkY(p = Player()){
        const playerPosition = p.position.y;
        
        if ((playerPosition > this.position.y)) {
            this.position.y += this.velocity;
        } else if ((playerPosition < this.position.y)) {
            this.position.y -= this.velocity;
        } else if (playerPosition == this.position.y){
            this.position.x += 0;
        }
    }
    //Método para atacar
    attack(p = Player()){
        setInterval(()=>{
            if (Entity.touch(p, this)) {
                p.take_damage(damage);
            }
        }, this.interval)
    }
}
