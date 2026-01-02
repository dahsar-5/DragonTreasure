
package DragonTreasure;

public class Key extends Item { //Detta är en subklass til item, då använder man extend
    private boolean usable; //Boolean för nyckel, deklarerar datayp och variabel

    public Key(String name, String description, boolean usable) { 
        super(name, description); //super används för att anropa items konstruktor?
        this.usable = usable;
    }

    public boolean isUsable() { //Är detta som en getter? Hur funkar is här?
        return usable;
    }

    public void setUsable(boolean usable) { //en setter för usable av nyckeln, om den går att använda?
        this.usable = usable;
    }

   @Override
public void use(Player player) {
    if (usable) {
        System.out.println("Du plockar upp nyckeln " + getName() + ".");
        player.giveKey();   //varför används give här??
        usable = false;     // Vad betyder detta?
    }
}

}
