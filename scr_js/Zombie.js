class Zombie extends Entity{
    //Construtor
    constructor(x = Number(), y = Number(),path, frames = {max: 1, current: 0, elapsed: 0}){
        super(path, frames)
        
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
        const playerPosition = p.getPsX();
    
        if ((playerPosition > getPsX())) {
            x += velocity;
            dx += velocity;
        }else if ((playerPosition < getPsX())) {
            x -= velocity;
            dx -= velocity;
        } else if (playerPosition == this.positionX){
            y += 0;
            dy += 0;
        }
    }
    walkY(p = Player()){
        const playerPosition = p.getPsY();
        
        if ((playerPosition > getPsY())) {
            y += velocity;
            dy += velocity;
        } else if ((playerPosition < getPsY())) {
            y -= velocity;
            dy -= velocity;
        } else if (playerPosition == this.positionY){
            x += 0;
            dx += 0;
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
