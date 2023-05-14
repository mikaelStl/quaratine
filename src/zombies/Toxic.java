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
        liberateArea();
        // if (liberated) {
        //     area.hit(p);
        // }
        System.out.println("liberou");
    }
    /* Métodos para a área tóxica */
    public void liberateArea(){
        this.area = new ToxicArea(getPsX(), getPsY());
        setImg("");
        stop();
        this.liberated = true;
    }
}
