// import Entity from './Entity';

class Player extends Entity{
    /**
     * 
     * @param {object} animations - Objeto que deve conter todas as animações do objeto 
     * @param {string} standart - animação padrão do objeto
     */
    constructor(animations, standart){
        super(animations, standart);
        this.position = {
            x: Math.round(320-(this.size.width/2)),
            y: Math.round(320-(this.size.height/2))
        }
        this.weapon;
        this.inventory = [];
        this.dead = false;
    }
    
    move(key){
        this.moving = true;
        this.velocity = 4;
        switch (key) {
            case keys.up: this.position.y -= this.velocity;
                break;
            case keys.down: this.position.y += this.velocity;
                            // this.invert();
                break;
            case keys.right: this.position.x += this.velocity;
                            //  this.invert();
                break;
            case keys.left: this.position.x -= this.velocity;
                break;
        }
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
    // addItem(i){
    //     this.inventory.add(i);
    // }

    //Usar bandagem
    // useBandage(){
    //     if (inventory.size() > 0) {
    //         const cont = 0;
    //         const b = inventory.get(cont);
    //         if (lifeValue < life_max) {
    //             b.function(getPlayer());
    //             this.inventory.remove(cont);
    //             cont++;
    //         } else{
    //             System.out.println("VIDA CHEIA");
    //         }
    //     } else {
    //         System.out.println("NÃO POSSUI BANDAGENS");
    //     }
    // }

    //Método para baixar vida
    takeDamage(damage){
        this.lifeValue -= damage;
        setLifeBar(getBarWidth(), this.lifeValue);
        if (lifeValue <= 0) {
            Dead();
        }
    }
}
