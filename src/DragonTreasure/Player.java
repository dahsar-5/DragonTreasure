package DragonTreasure;

public class Player {
    
    private String name;  // spelarens namn

    // Konstruktor: körs när du skapar en ny spelare
    public Player(String name) {
        this.name = name;
    }

    // Getter: hämtar spelarens namn
    public String getName() {
        return name;
    }
    
}
