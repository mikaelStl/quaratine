public class Toxic extends Zombie {
    private final int VELOCITY = 2;

    // private AcidArea area;
    // private boolean liberated;

    public Toxic(int x, int y) {
        super(x, y);
        setImg("imgs/ztoxic.png");
        this.lifeValue = 125;
        // this.liberated = false;
    }

    // @Override
    /* public void attack(Player p){
        liberateAcid();
        if (p.getBounds().intersects(area.getBounds())) {
            p.takeDamage(area);
        }
    } */
    /* Métodos para a área tóxica */
    public ToxicArea liberateArea(){
        return new ToxicArea(getPsX(), getPsY());
    }
    /* public AcidArea getArea() {
        return area;
    } */
    /* Método para saber se o zumbi liberou ou não o ácido */
    /* public boolean isLiberated() {
        return liberated;
    } */
}
