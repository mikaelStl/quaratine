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
        this.magCapacity = 30;
        this.totalAmmo = 90;

        this.shots = [];
    }

    move(pst = {}){
        this.position = {
            x: pst.x+10,
            y: pst.y+10
        };
    }

    //Método para atirar
    shoot(p=Player()){
        if(this.mag.standart > 0){
            this.shots.add(new Shot(((p.getX() + p.getW())), (p.getY()+13), damage, p.getDirection()));
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
        this.totalAmmo += ammo;
        console.log(this.mag.total);
    }
}