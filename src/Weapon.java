import java.util.List;
import java.util.ArrayList;

public class Weapon{
    private int magCapacity;
    private int totalAmmo;
    private int damage;
    private List<Shot> shots;

    public Weapon(){
        this.damage = 25;
        this.magCapacity = 30;
        this.totalAmmo = 90;

        shots = new ArrayList<Shot>();
    }
    //Método para atirar
    public void shoot(Player p){
        if(magCapacity > 0){
            this.shots.add(new Shot(((p.getX() + p.getW())), (p.getY()+13), damage, p.getDirection()));
            this.magCapacity -= 1;
        }
    }
    //Método para recarregar
    public void reload(){
        if (totalAmmo > 0) {
            setMagCapacity(30);
            this.totalAmmo -= 30;
            System.out.println(this.totalAmmo);
        }
    }
    //Método para adicionar mais munição no inventário
    public void addAmmo(int ammo){
        this.totalAmmo += ammo;
        System.out.println(this.totalAmmo);
    }
    //Getter para tiros
    public void setMagCapacity(int magCapacity) {
        this.magCapacity = magCapacity;
    }
    //Setter para tiros
    public List<Shot> getShots(){
        return shots;
    }
    //Getter para objeto Weapon
    public Weapon getWeapon(){
        return this;
    }
    public int getTotalAmmo() {
        return totalAmmo;
    }
}