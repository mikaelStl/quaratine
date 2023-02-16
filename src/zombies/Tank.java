public class Tank extends Zombie {
    private int protection;

    public Tank(int x, int y) {
        super(x, y);
        this.protection = 60;
        this.damage = 20;
        this.lifeValue = 140;
    }
    
    // @Override
    public void takeDamage(int damage){
        if (this.protection <= 0) {
            this.lifeValue -= damage;
        } else{
            this.protection -= damage;
        }
    }
}
