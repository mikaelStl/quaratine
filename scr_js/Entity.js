// h = Number(), w = Number(), x = Number(), y = Number(),

class Entity{
    constructor(animations = {standart: null}){
        this.animations = animations;
        this.img;
        this.setImg('standart');
        this.size = {
            width: Math.round(this.img.width/this.animations.standart.frames),
            height: this.img.height
        };
        this.position = {
            x: 0,
            y: 0
        }
        this.velocity;
        this.moving = false;
        this.hitbox = new HitBox(this.position, this.size);
        this.life = {
            bar: this.size.width,
            value: 100,
            max: 100
        };
        this.dead;
    }

    update(){
        this.hitbox.update(this.position);
        this.setLifeBar(this.life.bar, this.life.value);
    }

    draw(screen, path){
        this.setImg(path);
        if (!this.img) return;

        this.update();
        screen.drawImage(
            this.img,
            //image crop
            this.animations[path].current * this.size.width,
            0,
            this.size.width,
            this.size.height,
            //original image
            this.position.x,
            this.position.y,
            this.size.width,
            this.size.height
        );
        this.hitbox.draw(screen);
        this.animations[path].animate();
        screen.fillStyle = 'black';
        screen.fill();
        screen.fillStyle = 'red';
        screen.fill();
    }

    invert(){
        //to-do
    }

    static touch(ent1 = Entity(), ent2 = Entity()){
        const ent1B = ent1.hitbox;
        const ent2B = ent2.hitbox;
        return ent1B.intersects(ent2B);
    }

    takeDamage(damage){
        //to-do
    }

    setLifeBar(width = Number(), newValue = Number()){
        const tamBar = (width * newValue)/this.life.max;
        this.life.bar = tamBar;
        c.beginPath();
        c.rect(this.position.x, this.position.y-8, tamBar, 3);
    }

    setImg(path){
        this.img = new Image();
        this.img.src = this.animations[path].src;
    }
}

// export default Entity;