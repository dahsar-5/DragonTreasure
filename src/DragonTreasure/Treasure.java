
package DragonTreasure;


public class Treasure extends Item{
    private String description;
    private String name;

public Treasure(String name, String description) {
   super(name, description); // anropa Item-konstruktorn
        this.name = name;
        this.description = description;    
}
}
