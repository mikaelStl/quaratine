class Bandage extends Item{
    constructor(animations) {
        super(animations);
        this.value = 30;
    }
    cure(p=Player()) {
        p.life.value += 30;
    }
}
