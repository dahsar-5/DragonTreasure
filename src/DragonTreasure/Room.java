package DragonTreasure;

import java.util.ArrayList;

public class Room {
    private String description; 
    private ArrayList<Door> doors = new ArrayList<>(); //Array list för doors 
    private Monster monster; //Deklarerar monster
    private ArrayList<Item> items = new ArrayList<>(); // En array list för item
    private boolean endRoom = false;    //Boolean för att markera om man är i endRoom                                                  

    //Konstruktor för room om monster inte finns
    public Room(String description) { 
        this.description = description;
        this.monster = null;
    }

    // Extra konstruktor för rum med monster 
    public Room(String description, Monster monster) {
        this.description = description;
        this.monster = monster;
    }

    // Lägg till ett item i rummet
    public void addItem(Item item) { 
        items.add(item);
    }

    // Hämta alla items i rummet
    public ArrayList<Item> getItems() { 
        return items;
    }

    // Ta bort ett item (när spelaren plockar upp det)
    public void removeItem(Item item) {
        items.remove(item);
    }
    //Lägga til en dörr
    public void addDoor(Door door) {
        doors.add(door);
    }

    // Getter för rummets beskrivning
    public String getDescription() {
        return description;
    }

    // Getter för monster
    public Monster getMonster() {
        return monster;
    }
        public boolean isEndRoom() {
           return endRoom;
    }

    public void setEndRoom(boolean endRoom) {
          this.endRoom = endRoom;
    }

    // Metod för att visa dörrar
    public void showDoors() {
        System.out.println("Välj dörr och gå vidare till nästa rum. Dörrar finns åt:");
        for (Door d : doors) { //En enhanced for loop
            System.out.println("- " + d.getDirection()); //Skriver ut - och hämtar direction från door klassen?
        }
    }
     //här är metoden för move
    public Room move(String direction, Player player) { 

    // Leta efter dörren i den valda riktningen
    for (Door d : doors) { 
        if (d.getDirection().equalsIgnoreCase(direction)) {

            // om dörren är låst
            if (d.isLocked()) {
                if (player.hasKey()) { //och spelaren har en nyckel så 
                    System.out.println("Du använder nyckeln och låser upp dörren!");
                    d.setLocked(false); //sätter man dörren från true til false
                } else {
                    System.out.println("Dörren är låst! Du behöver en nyckel.");
                    return this; // Om man inte har nyckel och dörren är låst stannar man i rummet, när använder man this egentligen? 
                }
            }
            // Flytta till nästa rum 
            return d.getLeadsTo();
        }
    }

    //Om ingen dörr hittades
    System.out.println("Ingen dörr åt det hållet!");
    return this;
}
   

    // Stridsmetod mot ett monster
    public void doBattle(Player player, Monster monster) {
        System.out.println(monster.getName() + "n attackerar dig!");

        while (player.getHealth() > 0 && monster.getHealth() > 0) { //medan spelaren har över 0 i hälsopoäng och monster har över 0
            player.takeDamage(monster.getDamage()); //monster skada spelaren 
            System.out.println(monster.getName() + " gör " + monster.getDamage() + 
                               " skada.");

            monster.takeDamage(player.getDamage()); //spelaren gör skada på monstret
            System.out.println("Du attackerar " + monster.getName() + "n" + " och gör " +
                               player.getDamage() + " skada.");
           }

        if (player.getHealth() <= 0) { //om spelarens hälsa är lika med eller mindre än noll
            System.out.println("Du blev besegrad av " + monster.getName() +"n" + "..." + "Du har " + player.getHealth() + " hälsopoäng kvar");
        } else {
            System.out.println("Du besegrade " + monster.getName() + " Du har " + player.getHealth() + " hälsopoäng kvar!");
        }
    }
}
