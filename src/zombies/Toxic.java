public class Toxic extends Zombie {
    private final int VELOCITY = 2;

    private ToxicArea area;
    private boolean liberated;

    public Toxic(int x, int y) {
        super(x, y);
        setImg("imgs/ztoxic.png");
        this.lifeValue = 125;
        this.liberated = false;
    }

    @Override
    public void attack(Player p){
        liberateArea();
        if (liberated) {
            
        }
    }
    /* Métodos para a área tóxica */
    public void liberateArea(){
        this.area = new ToxicArea(getPsX(), getPsY());
        this.liberated = true;
    }
}
