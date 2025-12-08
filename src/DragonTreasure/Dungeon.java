
package DragonTreasure;

import java.util.ArrayList;
import java.util.Scanner;

public class Dungeon {
    private Room currentRoom;
    private ArrayList<Room> rooms; // ArrayList för alla rum

    public Dungeon() {
        rooms = new ArrayList<>();

        // Skapa rummen med tillhörande beskrivning
        Room grotta = new Room("Nu är du tillbaka i grottan igen och du ser den kollapsade ingången bredvid dig. "
            + "Rummet är upplyst av några ljus som sitter på ett bord framför dig.");

        Room dödKropp = new Room("Du ser en död kropp på golvet.");
        Room bergrum = new Room("Du kommer in i ett rymligt bergrum med en ljusstrimma sipprandes genom en spricka i den östra väggen.");
        Room fackla = new Room("Du ser en brinnande fackla i rummets ena hörn och känner en motbjudande stank.");
        Room ut = new Room("UTGÅNG: Du lämnar grottan med livet i behåll. Grattis, du förlorade inte!");
        Room fuktig = new Room("Du kommer in i ett fuktigt rum med vatten sipprandes längs den västra väggen. "
            + "Du ser en låst dörr i öster [Ö].");
        Room skattkista = new Room("Du ser en skattkista full med guld.");

        // Lägg alla rum i ArrayList
        rooms.add(grotta);
        rooms.add(dödKropp);
        rooms.add(bergrum);
        rooms.add(fackla);
        rooms.add(ut);
        rooms.add(fuktig);
        rooms.add(skattkista);

        // Koppla ihop dörrarna
        grotta.addDoor(new Door("N", dödKropp, false));
        grotta.addDoor(new Door("S", bergrum, false));

        dödKropp.addDoor(new Door("Ö", fackla, false));
        dödKropp.addDoor(new Door("S", grotta, false));

        fackla.addDoor(new Door("V", dödKropp, false));
        fackla.addDoor(new Door("Ö", ut, false));
        fackla.addDoor(new Door("S", fuktig, false));

        bergrum.addDoor(new Door("N", grotta, false));
        bergrum.addDoor(new Door("Ö", fuktig, false));

        fuktig.addDoor(new Door("N", fackla, false));
        fuktig.addDoor(new Door("V", bergrum, false));
        fuktig.addDoor(new Door("Ö", skattkista, true));

        skattkista.addDoor(new Door("V", bergrum, false));
        skattkista.addDoor(new Door("N", fackla, false));

        ut.addDoor(new Door("V", fackla, false));

        // Spelet startar i grottan
        currentRoom = grotta;
    }

    public void playGame() {
        Scanner input = new Scanner(System.in);
        String direction = "";

        // Vid start: visa bara dörrarna (starttexten skrevs redan i main)
        currentRoom.showDoors();

        while (!direction.equalsIgnoreCase("quit")) {
            System.out.println("Skriv 'quit' för att avsluta:");
            direction = input.nextLine();
            currentRoom = currentRoom.move(direction);
        }
    }
}
