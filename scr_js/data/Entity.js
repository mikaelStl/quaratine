// h = Number(), w = Number(), x = Number(), y = Number(),

class Entity{
    /**
     * 
     * @param {object} animations - Objeto que deve conter todas as animações da Entidade
     */
    constructor(animations = {standart: null}){
        this.animations = animations;
        this.img;
        this.size;
        this.setImg('standart');
        this.position = {
            x: 0,
            y: 0
        };
        this.velocity;
        this.moving = false;
        this.hitbox = new HitBox(this.position, this.size);
        this.life = {
            bar: this.size.width,
            value: 100,
            max: 100
        };
        this.dead;

        this.direction = false; //false: to right; true: to left
    }

    update(){
        this.hitbox.update(this.position);
        this.setLifeBar(this.life.bar, this.life.value);
    }

    draw(ctx, path){
        if (!this.img) return;

        this.setImg(path);
        this.update();

        //logic to draw invert or normal image
        if (this.direction) {
            ctx.save();
            ctx.scale(-1, 1);
            ctx.drawImage(
                this.img,
                //image crop
                this.animations[path].current * this.size.width,
                0,
                this.size.width,
                this.size.height,
                //original image
                -this.position.x - this.size.width,
                this.position.y,
                this.size.width,
                this.size.height
            );
            ctx.restore();
        } else {
            ctx.drawImage(
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
        }
        this.hitbox.draw(ctx);
        this.animations[path].animate();
        ctx.fillStyle = 'red';
        ctx.fill();
    }

    static touch(ent1 = Entity(), ent2 = Entity()){
        const ent1B = ent1.hitbox;
        const ent2B = ent2.hitbox;
        return ent1B.intersects(ent2B);
    }

    take_damage(damage){
        //to-do
    }

    setLifeBar(width = Number(), newValue = Number()){
        const tamBar = (width * newValue)/this.life.max;
        this.life.bar = tamBar;
        c.beginPath();
        c.rect(this.position.x, this.position.y-6, tamBar, 3);
    }

    setImg(path){
        this.img = new Image();
        this.img.src = this.animations[path].src;

        this.size = {
            width: Math.round(this.img.width/this.animations[path].frames),
            height: this.img.height
        };
    }
}

// export default Entity;