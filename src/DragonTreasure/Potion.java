
package DragonTreasure;


public class Potion extends Item { //potion är en subclass til item
    private int heal; 

    public Potion(String name, String description, int heal) {
        super(name, description); // anropa Item-konstruktorn
        this.heal = heal;
    }

   //@override
    public void use(Player player) {
        System.out.println("Du dricker " + getName() + " och återfår " + heal + " hälsa!");
        player.heal(heal); // Player har en heal-metod 
    }
}
