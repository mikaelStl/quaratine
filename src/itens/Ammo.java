public class Ammo extends Item{
    public Ammo(String url) {
        super(url);
        this.value = 30;
    }
    @Override
    public void function(Player p) {
        p.getWeapon().addAmmo(value);
    }
}
