
package DragonTreasure;

public class Key extends Item {  //Nyckel är en subklass til item
    private boolean usable; 

    public Key(String name, String description, boolean usable) { 
        super(name, description); 
        this.usable = usable;
    }

   // Getter för att kolla om nyckeln är användbar
    public boolean isUsable() { 
        return usable;
    }

    //Setter för att ändra om nyckeln är användbar eller inte
    public void setUsable(boolean usable) { 
        this.usable = usable;
    }

   @Override
public void use(Player player) { //Metod: när spelaren har en nyckel som är användbar och använder den
    if (usable) {
        System.out.println("Du kan nu använda " + getName() + "n för att låsa upp en dörr.");
        player.giveKey();   
        usable = false;    
    }
}

}
