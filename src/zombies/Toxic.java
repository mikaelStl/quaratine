public class Toxic extends Zombie {
    private AcidArea area;
    private boolean liberated;

    public Toxic(int x, int y) {
        super(x, y);
        setImg("imgs/ztoxic.png");
        this.lifeValue = 125;
        this.liberated = false;
    }

    @Override
    public void attack(Player p){
        liberateAcid();
        if (p.getBounds().intersects(area.getBounds())) {
            p.takeDamage(damage);
        }
    }
    /* Métodos para a área tóxica */
    public void liberateAcid(){
        area = new AcidArea(getPsX(), getPsY());
        this.liberated = true;
    }
    public AcidArea getArea() {
        return area;
    }
    /* Método para saber se o zumbi liberou ou não o ácido */
    public boolean isLiberated() {
        return liberated;
    }
}
