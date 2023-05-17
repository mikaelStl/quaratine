public class Toxic extends Zombie{
    private ToxicArea area;
    private boolean liberated;

    public Toxic(int x, int y) {
        super(x, y);
        setImg("imgs/toxic.png");
        this.lifeValue = 125;
        this.liberated = false;
        this.damage = 0;
        this.velocity = 2;
    }

    @Override
    public void attack(Player p){
        if (!liberated) {
            liberateArea();
            System.out.println("liberou");
        } else {
            area.hit(p);
        }
    }
    /* Métodos para a área tóxica */
    public void liberateArea(){
        this.area = new ToxicArea(getPsX(), getPsY());
        stop();
        this.liberated = true;
    }
    public ToxicArea getArea() {
        return area;
    }
    public boolean liberated() {
        return liberated;
    }
}
