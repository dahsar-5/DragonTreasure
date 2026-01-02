
package DragonTreasure;

public class Weapon extends Item {
    private int damageMultiplier;

    public Weapon(String name, String description, int damageMultiplier) {
        super(name, description);
        this.damageMultiplier = damageMultiplier;
    }

    @Override
    public void use(Player player) {
        int newDamage = player.getDamage() * damageMultiplier;
        player.setDamage(newDamage);
        System.out.println("Du lyfter upp " + getName() + "! Din skada är nu" + newDamage + ".");
    }
}
