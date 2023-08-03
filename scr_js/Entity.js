// h = Number(), w = Number(), x = Number(), y = Number(),

class Entity{
    constructor (path = String(), frames = {max: 1, current: 0, elapsed: 0}){
        this.img;
        this.setImg(path);
        this.frames = {...frames, hold: 12};
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
        // this.hitbox;
        // this.lifeValue;
        // this.lifeBar;
        // this.lifeMax;
        // this.dead;
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
        screen.drawImage(
            this.img,
            //image crop
            this.frames.current * this.size.width,
            0,
            this.size.width/this.frames.max,
            this.size.height,
            //original image
            this.position.x,
            this.position.y,
            this.size.width/2,
            this.size.height,
        );
        this.animate();
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

    takeDamage(damage){
        damage = Number(damage);
    }

    setImg(path){
        this.img = new Image();
        this.img.src = String(path);
    }

    getImg(){
        return this.img;
    }
}