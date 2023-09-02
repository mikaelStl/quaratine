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

        this.velocity = 12;
    }
    /*1: DIREITA*/
    /*0: ESQUERDA*/
    move(){
        if (!this.direction) {
            this.position.x += this.velocity;
        } else {
            this.position.x -= this.velocity;
        }
    }
    
    hit(z=Zombie()){
        z.take_damage(this.damage);
    }
}
