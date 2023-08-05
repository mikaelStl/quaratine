// import Entity from './Entity';

class Zombie extends Entity{
    //Construtor
    constructor(x=Number(), y=Number(),animations={}){
        super(animations);
        
        this.position = {
            x: x,
            y: y
        }
        this.damage = 5;
        this.velocity = 1;
        this.dead = false;

        // this.item = null;

        this.interval = 800;
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

        if (this.hitbox.intersects(p.hitbox)) {
            this.velocity += 0;
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

        if (this.hitbox.intersects(p.hitbox)) {
            this.velocity = 0;
        }
    }
    // Método para baixar vida
    takeDamage(damage){
        if (this.lifeValue > 0) {
            this.lifeValue -= damage;
            setLifeBar(getBarWidth(), this.lifeValue);
        } else if (lifeValue <= 0) {
            this.dead=true;
        }
    }
    //Método para atacar
    attack(p = Player()){
        setInterval(()=>{
            if (Entity.touch(p, getZ())) {
                p.takeDamage(damage);
            }
        }, this.interval)
    }
}
