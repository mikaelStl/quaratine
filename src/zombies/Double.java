import java.util.List;

public class Double extends Zombie{
    public Double(int x, int y) {
        super(x, y);
        setImg("imgs/double.png");
        this.damage = 7;
        this.lifeValue = 125;
    }
    
    public void divide(List<Zombie> zombies){
        if (lifeValue <= (lifeValue/2)) {
            zombies.add(new Zombie(getPsX(), getPsY()));
            zombies.add(new Zombie(getPsX(), getPsY()));
        }
    }
}
