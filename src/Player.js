// import Entity from './Entity';

class Player extends Entity{
    constructor(animations={}){
        super(animations);

        this.position = {
            x: Math.round((WIDTH/2)-(this.size.width/2)),
            y: Math.round((HEIGHT/2)-(this.size.height/2))
        };

        this.weapon = new Weapon(
                        {standart: new Sprite('./img/weapon.png', 2, 48),
                         standartL: new Sprite('./img/weapon-l.png', 2, 48),
                         shoot: new Sprite('./img/shooting.png', 6, 2),
                         shootL: new Sprite('./img/shooting-l.png', 6, 2)
                        },
                        {x: this.position.x+7, y: this.position.y+7}
                    );

        this.inventory = [];
        this.dead = false;
        
        this.velocity = 4;
    }
    
    move(key){
        this.moving = true;
        switch (key) {
            case keys.up: this.position.y -= this.velocity;
                break;
            case keys.down: this.position.y += this.velocity;
                break;
            case keys.right: this.position.x += this.velocity;
                             this.direction = false;
                break;
            case keys.left: this.position.x -= this.velocity;
                            this.direction = true;
                break;
        }
        this.weapon.move(this.position, this.direction);
    }

    stop(){
        this.moving = false;
    }

    //Interações
    // interact(key){
    //     switch (key) {
    //         case KeyEvent.VK_A: weapon.shoot(getPlayer());
    //             break;
    //         case KeyEvent.VK_R: weapon.reload();
    //             break;
    //         case KeyEvent.VK_F: useBandage();
    //     }
    // }
    
    // Adicionar item ao inventario
    catch(i=Item()){
        this.inventory.push(i);
    }

    // heal(){
    //     for (const item of this.inventory) {
    //         if (typeof item === Bandage()) {
                
    //         }
    //     }
    // }
}
