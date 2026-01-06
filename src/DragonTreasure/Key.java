
package DragonTreasure;

public class Key extends Item {  //Nyckel är en subklass til item
    private boolean usable; 

    public Key(String name, String description, boolean usable) { 
        super(name, description); 
        this.usable = usable;
    }

    public boolean isUsable() { 
        return usable;
    }

    public void setUsable(boolean usable) { 
        this.usable = usable;
    }

   @Override
public void use(Player player) {
    if (usable) {
        System.out.println("Du kan nu använda " + getName() + "n för att låsa upp en dörr.");
        player.giveKey();   
        usable = false;    
    }
}

}
