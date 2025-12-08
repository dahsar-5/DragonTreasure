package DragonTreasure;

import java.util.ArrayList;

public class Room {
    private String description;
    private ArrayList<Door> doors = new ArrayList<>();

    public Room(String description) {
        this.description = description;
    }

    public void addDoor(Door door) {
        doors.add(door);
    }

    // Getter för rummets beskrivning
    public String getDescription() {
        return description;
    }

    // Metod för att visa dörrar
    public void showDoors() {
        System.out.println("Välj dörr och gå vidare till nästa rum. Dörrar finns åt:");
        for (Door d : doors) {
            System.out.println("- " + d.getDirection());
        }
    }

    public Room move(String direction) {
        for (Door d : doors) {
            if (d.getDirection().equalsIgnoreCase(direction)) {
                if (d.isLocked()) {
                    // Specialfall: skattkistan
                    if (d.getLeadsTo().getDescription().toLowerCase().contains("skattkista")) {
                        System.out.println("Du har ingen nyckel som passar. Du kikar genom nyckelhålet och ser en skattkista full med guld.");
                    } else {
                        System.out.println("Dörren är låst! Du behöver en nyckel.");
                    }
                    this.showDoors();
                    return this;
                }
                // Om dörren inte är låst → byt rum
                Room next = d.getLeadsTo();
                System.out.println(next.getDescription()); // skriv ut beskrivning
                next.showDoors();                          // och dörrar
                return next;
            }
        }
        System.out.println("Ingen dörr åt det hållet!");
        this.showDoors();
        return this;
    }
}
