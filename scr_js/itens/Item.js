class Item extends Entity {
    constructor(animations){
        super(animations);
        this.value;

        this.life.value = 0;
    }

    setPosition(x, y){
        this.position.x = x;
        this.position.x = y;
    }
}
