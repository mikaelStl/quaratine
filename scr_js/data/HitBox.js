class HitBox{
    constructor(position = {}, size = {}){
        this.position = {...position};
        this.size = {...size};
    }

    update(position){
        this.position = {...position};
    }

    intersects(box = HitBox()) {
        return (
            this.position.x < box.position.x + box.size.width &&
            this.position.x + this.size.width > box.position.x &&
            this.position.y < box.position.y + box.size.height &&
            this.position.y + this.size.height > box.position.y
        );
    }

    draw(screen){
        screen.strokeStyle = 'black';
        screen.lineWidth = 1;
        screen.strokeRect(this.position.x, this.position.y, this.size.width, this.size.height);
    }
}