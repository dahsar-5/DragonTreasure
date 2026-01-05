package DragonTreasure;

import java.util.ArrayList;

public class Room {
    private String description; 
    private ArrayList<Door> doors = new ArrayList<>(); //Array list för doors 
    private Monster monster; //Deklarerar monster
    private ArrayList<Item> items = new ArrayList<>(); // En array list för item
    private boolean endRoom = false;                                                      //JUSTERAT  11-19

    public boolean isEndRoom() {
           return endRoom;
    }

    public void setEndRoom(boolean endRoom) {
          this.endRoom = endRoom;
    }


    public Room(String description) { //Konstruktor för room om monster inte finns
        this.description = description;
        this.monster = null;
    }

    // Extra konstruktor för rum med monster 
    public Room(String description, Monster monster) {
        this.description = description;
        this.monster = monster;
    }

    // Lägg till ett item i rummet
    public void addItem(Item item) { //lägger til items 
        items.add(item);
    }

    // Hämta alla items i rummet
    public ArrayList<Item> getItems() { //getter för array item
        return items;
    }

    // Ta bort ett item (när spelaren plockar upp det)
    public void removeItem(Item item) {
        items.remove(item);
    }
    public void addDoor(Door door) { //Lägga til en dörr
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

    // Metod för att visa dörrar
    public void showDoors() {
        System.out.println("Välj dörr och gå vidare till nästa rum. Dörrar finns åt:");
        for (Door d : doors) { //En enhanced for loop
            System.out.println("- " + d.getDirection()); //Skriver ut - och hämtar direction från door klassen?
        }
    }

    public Room move(String direction, Player player) { //här är metoden för move 

    // Leta efter dörren i den valda riktningen
    for (Door d : doors) { //är Door d ett sätt att förkorta Door till bara d, eller varför skriver man så?
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

    //Om ingen dörr hittades, hur funkar denna kodbiten? Hur vet den att ingen dörr hittas?
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
