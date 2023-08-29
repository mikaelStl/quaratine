class Ammo extends Item{
    constructor(animations){
        super(animations);
        this.value = 30;
    }
    add(p=Player()) {
        p.weapon.addAmmo(this.value);
    }
}
