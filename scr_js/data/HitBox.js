class HitBox{
    constructor(x, y, width, height){
        this.position = {
            x: x,
            y: y
        };
        this.size = {
            width: width,
            height: height
        };
    }

    update(x, y){
        this.position.x = x;
        this.position.y = y;
    }

    intersects(box = HitBox()) {
        return (
            this.position.x < box.position.x + box.size.width &&
            this.position.x + this.size.width > box.position.x &&
            this.position.y < box.position.y + box.size.height &&
            this.position.y + this.size.height > box.position.y
        );
    }

    draw(){
        c.fillStyle = 'rgba(255, 0, 0, 0.2)';
        c.fillRect(this.position.x, this.position.y, this.size.width, this.size.height);
    }
}