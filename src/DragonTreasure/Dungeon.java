
package DragonTreasure;

import java.util.ArrayList;
import java.util.Scanner;

public class Dungeon {
    private Room currentRoom;
    private ArrayList<Room> rooms; // ArrayList för alla rum
    private Player player; 
    private Room skattkista; //Deklarerar rummet som sedan är med i endGame
    private Monster dragon;

    public Dungeon(Player player) { //konstruktor 
        this.player = player; 
        rooms = new ArrayList<>();

        // Skapa monster
         dragon = new Monster("Drake", 15, 2, "En enorm drake dyker upp och står framför och vaktar skatten!");
         Monster ork = new Monster("Ork", 5, 1, "En riktigt ful ork kommer fram ur mörkret, med blod runt hela munnen");
        
        // skapa objekt/instanser av items 
         Potion potion = new Potion("Hälsodryck", "En magisk dryck som återställer hälsa.", 5);
         Key key = new Key ("Nyckel", "En stor tung gammal nyckel.", true);
         Weapon sword = new Weapon ("Svärd", "Svärdet är gammalt, glansigt och tungt", 4);
    
        
        // Skapa rummen med tillhörande beskrivning
        Room grotta = new Room("Du är inne i grottan och du ser den kollapsade ingången bakom dig. "
            + "Rummet är upplyst av några ljus som sitter på ett bord framför dig.");
        grotta.addItem(key);

        Room dödKropp = new Room("Du ser en död kropp på golvet", ork);
        Room bergrum = new Room("Du kommer in i ett rymligt bergrum med en ljusstrimma sipprandes genom en spricka i den östra väggen.");
        bergrum.addItem(sword);
        
        Room fackla = new Room("Du ser en brinnande fackla i rummets ena hörn.");
        fackla.addItem(potion);

                                                                                                          //Tagit bort rum ut
        Room fuktig = new Room("Du kommer in i ett fuktigt rum med vatten sipprandes längs den västra väggen. "
            + "Du ser en låst dörr i öster [Ö].");
        
         skattkista = new Room("Du ser en skattkista full med guld.", dragon);
         skattkista.setEndRoom(true);                                                                    //JUSTERAT
    
        // Lägg alla rum i ArrayList
        rooms.add(grotta);
        rooms.add(dödKropp);
        rooms.add(bergrum);
        rooms.add(fackla);                                                                              //Tagit bort rum ut
        rooms.add(fuktig);
        rooms.add(skattkista);

        // Koppla ihop dörrarna
        grotta.addDoor(new Door("N", dödKropp, false));
        grotta.addDoor(new Door("S", bergrum, false));

        dödKropp.addDoor(new Door("Ö", fackla, false));
        dödKropp.addDoor(new Door("S", grotta, false));

        fackla.addDoor(new Door("V", dödKropp, false));                                      //tagit bort koppling till ut rum
        fackla.addDoor(new Door("S", fuktig, false));

        bergrum.addDoor(new Door("N", grotta, false));
        bergrum.addDoor(new Door("Ö", fuktig, false));

        fuktig.addDoor(new Door("N", fackla, false));
        fuktig.addDoor(new Door("V", bergrum, false));
        fuktig.addDoor(new Door("Ö", skattkista, true)); 
                                                                                      // tagit bort all navigering ut ur skattrum
                                                                                      // JUSTERAT tagit bort ut rum

        // Spelet startar i grottan
        currentRoom = grotta;
    }

public void enterRoom(Room room, Scanner input) { //metod för när man går in i ett rum

    // Monsterattack direkt när man går in, går att ha efter rumsbeskrivning 
    //men eftersom det sker av sig själv i detta spelet känns det naturligt att ha beskrivningen efter?
   
   if (room.getMonster() != null && room.getMonster().isAlive()) { //Monstret är inte null (finns i rummet) & lever
    System.out.println(room.getMonster().getDescription());  // monsterbeskrivning skrivs ut
    room.doBattle(player, room.getMonster()); //Strid, anropar konstruktor?
}
   
   if (room.isEndRoom() && room.getMonster() != null && !room.getMonster().isAlive()) {                     //Tillagt 87-90
    endGame();
    return;
}

    // Om spelaren dog i striden, avbryt
    if (!player.isAlive()) {
        return;
    }

    // Rumbeskrivning kommer efter monstret attackerar 
    System.out.println(room.getDescription());

    // Kollar om det finns Items och kör metoder för detta
    if (!room.getItems().isEmpty()) {
        System.out.println("Du ser följande föremål:");

        for (Item item : new ArrayList<>(room.getItems())) {
            System.out.println("- " + item.getName() + ": " + item.getDescription());
            System.out.println("Vill du plocka upp detta föremål? (ja/nej)");

            String choice = input.nextLine();

            if (choice.equalsIgnoreCase("ja")) {
                player.addToInventory(item);  // lägg i ryggsäcken
                item.use(player);             // använd item 
                room.removeItem(item);         // ta bort från rummet
            } else {
                System.out.println("Du lämnar " + item.getName() + " kvar.");
            }
        }
    }

    // Visa dörrar (om spelaren lever OM det inte är slutrum)                                 //JUSTERAT 120-123
        if (!room.isEndRoom()) {
            room.showDoors();
        }
    }

 public void playGame() { //Metod för att spela spelet
    Scanner input = new Scanner(System.in); //Läser in från spelaren
    String direction = ""; //En tom sträng
    String command = ""; // En tom sträng för olika kommandon

    // Visa första rummet som är grottan
    enterRoom(currentRoom, input);

  while (player.isAlive()) { //medan spelaren lever
        System.out.println("Skriv 'Ryggsäck' för att se vad som är i din ryggsäck, eller 'quit' för att avsluta:");  
       command = input.nextLine(); //Hämtar sträng från spelaren som är ett kommando
       
        
        if (command.equalsIgnoreCase("ryggsäck")) { 
            player.showInventory(); 
        continue; //Gör att man kommer tillbaka till while 
        } 
        
     
       if (command.equalsIgnoreCase("quit")) { 
    System.out.println("Spelet avslutas..."); 
    break; 
         } 
        
       direction = command; //Om command inte är något av det ovanför är det en direction
       
        // Flytta spelaren
        currentRoom = currentRoom.move(direction, player); //använder move metod, anropar konstruktor & metod?

                                                                                                        // JUSTERAT  141-150
            if (currentRoom.isEndRoom() && !dragon.isAlive()) {
                endGame();
                return;
            }

            if (player.isAlive()) {
                enterRoom(currentRoom, input);
            }
        }
    }

public void endGame() { //metod för att avsluta spelet 
    System.out.println(player.getName() + " du lämnar grottan med skatten. Grattis, du vann!");
    System.exit(0); } //inbyggt java-kommando 
}
