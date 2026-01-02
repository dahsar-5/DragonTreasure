
package DragonTreasure;


public class Treasure {
    private String description;
    private String name;

public Treasure(String name, String description) {
    this.name = name;
    this.description = description;    
}
}

//@override //Denna behövs nog inte då endgame har beskrivning för detta
// public void use(Player player) {
//        System.out.println("Du plockar upp " + getName() + " och blir rik!");
// }