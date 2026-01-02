package DragonTreasure;

import java.util.Scanner;


public class DragonTreasure {

    public static void main(String[] args) {
       Scanner input = new Scanner(System.in);
       int playerHealth = 10;   // startvärde för hälsopoäng
       int playerDamage = 1;    // startvärde för skada
       int playerHeal = 1 ; //Deklarera variabel för att läka
    
     //Fråga efter spelarens namn
      System.out.println("Välkommen till Dragon Treasure Skriv ditt namn och tryck [Enter] för att starta ett nytt spel...");
      String playerName = input.nextLine();

      // Skapa en Player med det namnet, hälsopoäng,  skadopoäng, läkning
      Player player = new Player(playerName, playerHealth, playerDamage, playerHeal);


     // Skriv ut en hälsning och spelets startbeskrivning, samt spelarens stats
        System.out.println("Välkommen, " + player.getName() + " till din skattjakt. Akta dig för draken!");
        System.out.println("Du står utanför en grotta. Det luktar svavel från öppningen");
        System.out.println(player.getName() + " du startar med  " + player.getHealth() + " hälsopoäng och gör " 
    + player.getDamage() + " i skada. Äventyret börjar nu... " +
    "När du går in i grottan kollapsar ingången bakom dig");



       Dungeon dungeon = new Dungeon(player);   // skapa spelvärlden med spelaren
       dungeon.playGame();                // starta spelet
    }
}
