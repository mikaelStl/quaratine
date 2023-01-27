public class Bandage extends Item{
    public Bandage(String url) {
        super(url);
        this.value = 30;
    }
    public void function(Player p) {
        p.setLife((p.getLife() + value));
    }
}
