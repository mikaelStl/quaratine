class Weapon extends Entity{
    constructor(animations, pst = {}){
        super(animations);

        this.life.bar = 0;

        this.position = {
            x: pst.x,
            y: pst.y
        };
        this.mag = {
            standart: 30,
            total: 120
        }
        this.damage = 25;

        this.shots = [];
        this.shooting = false;
    }

    move(pst = {}, d){
        this.position = {
            x: pst.x+7,
            y: pst.y+7
        };
        this.direction = d;
    }

    //Método para atirar
    shoot(){
        if(this.mag.standart > 0){
            this.shots.push(new Shot((this.position.x + this.size.width), (this.position.y+5), this.direction, 
                                {standart: new Sprite('./img/shot.png', 1, 0),
                                 standartL: new Sprite('./img/shot-l.png', 1, 0),
                                }));
            this.mag.standart -= 1;
        }
    }
    //Método para recarregar
    reload(){
        if (this.mag.total > 0 && this.mag.standart != 30) {
            this.mag.standart += 30;
            this.mag.total -= 30;
            console.log(this.mag.total);
        }
    }
    //Método para adicionar mais munição no inventário
    addAmmo(ammo){
        this.mag.total += ammo;
        console.log(this.mag.total);
    }
}