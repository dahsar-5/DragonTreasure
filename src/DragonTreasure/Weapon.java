
package DragonTreasure;

public class Weapon extends Item {
    private int damageMultiplier; //Vapen kan öka spelarens skada med damageMultiplier

    public Weapon(String name, String description, int damageMultiplier) {
        super(name, description); 
        this.damageMultiplier = damageMultiplier;
    }

    @Override
    public void use(Player player) { //Metod för att öka spelarens skada med vapnet
        int newDamage = player.getDamage() * damageMultiplier;
        player.setDamage(newDamage);
        System.out.println("Du lyfter upp " + getName() + "! Din skada är nu " + newDamage + ".");
    }
}
