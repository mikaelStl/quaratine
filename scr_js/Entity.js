// h = Number(), w = Number()

class Entity{
    constructor (x = Number(), y = Number(), path = String()){
        this.img;
        this.setImg(path);
        // this.box;
        this.position = {
            x: Number(x),
            y: Number(y)
        }
        this.size = {
            height: this.img.height,
            width: this.img.width
        }
        this.velocity;
        this. moving = false;
        // this.lifeValue;
        // this.lifeBar;
        // this.lifeMax;
        // this.dead;
    }

    draw(screen){
        this.img.onload = () => {
            screen.drawImage(this.img, this.position.x, this.position.y);
        };
        // screen.fillStyle = 'red';
        // screen.fillRect(this.position.x, this.position.y, this.size.width, this.size.height);
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