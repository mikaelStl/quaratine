// h = Number(), w = Number(), x = Number(), y = Number(),

class Entity{
    constructor (path = String(), frames = {max: 1, current: 0, elapsed: 0}){
        this.img;
        this.setImg(path);
        this.frames = {...frames, hold: fps};
        this.size = {
            height: this.img.height,
            width: this.img.width/this.frames.max
        }
        this.position = {
            x: 320-(this.size.width/2),
            y: 320-(this.size.height/2)
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

    animate(){
        this.frames.elapsed++;

        if (this.frames.elapsed % this.frames.hold === 0) {
            if (this.frames.current < (this.frames.max - 1)) {
                this.frames.current++;
            } else {
                this.frames.current = 0;
            }
        }
    }

    draw(screen){
        this.update();
        screen.drawImage(
            this.img,
            //image crop
            this.frames.current * this.size.width,
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
        this.animate();
        c.fillStyle = 'black';
        screen.fill();
        c.fillStyle = 'red';
        screen.fill();
    }

    move(key){
        this.moving = true;
        this.velocity = 4;
        switch (key.keyCode) {
            case keys.up: this.position.y -= this.velocity;
                break;
            case keys.down: this.position.y += this.velocity;
                break;
            case keys.right: this.position.x += this.velocity;
                break;
            case keys.left: this.position.x -= this.velocity;
                break;
        }
    }

    stop(){
        this.moving = false;
    }

    static touch(ent1 = Entity(), ent2 = Entity()){
        const ent1B = ent1.hitbox;
        const ent2B = ent2.hitbox;
        return ent1B.intersects(ent2B);
    }

    takeDamage(damage){
        damage = Number(damage);
        //todo
    }

    setLifeBar(width = Number(), newValue = Number()){
        const tamBar = (width * newValue)/this.life.max;
        this.life.bar = tamBar;
        c.beginPath();
        c.rect(this.position.x, this.position.y-8, tamBar, 3);
    }

    setImg(path){
        this.img = new Image();
        this.img.src = String(path);
    }

    getImg(){
        return this.img;
    }
}