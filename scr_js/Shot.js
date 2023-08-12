class Shot extends Entity{
    constructor(x=Number(), y=Number(), direction=Number(),animations={}){
        super(animations);

        this.life.bar = 0;

        this.position = {
            x: x,
            y: y
        };
        
        this.damage = 25;
        this.direction = direction;

        this.VELOCITY = 10;
    }
    /*1: DIREITA*/
    /*0: ESQUERDA*/
    move(){
        if (this.direction === 1) {
            this.position.x += this.VELOCITY;
        } else if (this.direction === 0) {
            this.position.x -= this.VELOCITY;
        }
    }
    
    hit(z=Zombie()){
        if (getBounds().intersects(z.getBounds())) {
            z.takeDamage(damage);
        }
    }
}
