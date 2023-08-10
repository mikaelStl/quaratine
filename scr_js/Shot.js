class Shot extends Entity{
    constructor(x=Number(), y=Number(), direction=Number(),animations={}){
        super(animations);
        
        this.damage = 25;
        this.direction = direction;

        const VELOCITY = 10;
    }
    /*1: DIREITA*/
    /*0: ESQUERDA*/
    shot(){
        if (this.direction === 1) {
            this.x += VELOCITY;
        } else if (this.direction === 0) {
            this.x -= VELOCITY;
        }
    }
    
    hit(z=Zombie()){
        if (getBounds().intersects(z.getBounds())) {
            z.takeDamage(damage);
        }
    }
}
