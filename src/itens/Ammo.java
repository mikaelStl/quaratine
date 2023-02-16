public class Ammo extends Item implements ItemFunction{
    public Ammo(String url) {
        super(url);
        this.value = 30;
    }

    public void function(Player p) {
        p.getWeapon().addAmmo(value);
    }
}
