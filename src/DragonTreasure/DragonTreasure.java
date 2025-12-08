package DragonTreasure;

import java.util.Scanner;

        
public class DragonTreasure {
    public static void main(String[] args) {
       Scanner input = new Scanner(System.in);
       
       //Fråga efter spelarens namn
       System.out.println("Välkommen till Dragon Treasure Skriv ditt namn och tryck [Enter] för att starta ett nytt spel...");
        String playerName = input.nextLine();

        // Skapa en Player med det namnet
        Player player = new Player(playerName);
       
       // Skriv ut en hälsning och spelets startbeskrivning
        System.out.println("Välkommen, " + player.getName() + "! Äventyret börjar nu... " + 
                "Du står framför en grotta och väljer att gå in i denna. När du går in i grottan kollapsar ingången bakom dig. "      
            + "Rummet är upplyst av några ljus som sitter på ett bord framför dig.");


       Dungeon dungeon = new Dungeon();   // skapa spelvärlden
       dungeon.playGame();                // starta spelet
    }
}