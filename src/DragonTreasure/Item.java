
package DragonTreasure;


public class Item {
    private String name;        // Namnet på föremålet
    private String description; // Beskrivning av föremålet

    public Item(String name, String description) { //konstruktor som tar in namn och beskrivning
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
    
    public void use(Player player) {
        System.out.println("Du använder " + name + ".");}
}

