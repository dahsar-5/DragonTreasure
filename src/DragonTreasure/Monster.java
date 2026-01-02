
package DragonTreasure;


public class Monster {
   private String name;
   private int health;
   private int damage;
   private String description; //deklarerar alla variabler


//konstruktor med lämpliga parametrar
public Monster(String name, int health, int damage, String description){
    this.name = name;
    this.health = health;
    this.damage = damage;
    this.description = description;
}

public String getName(){
        return name;
}

public int getHealth(){
        return health;
}
public int getDamage(){
        return damage;
}

public String getDescription(){ //massa getters
    return description;
}

// Ny metod för att göra  skada
    public void takeDamage(int amount) {
        health -= amount; //healthPoints = healthPoints - amount
        if (health < 0) { //Om hälsan är mindte än noll
            health = 0; // så ska hälsa vara = 0, kontroll så hälsan inte blir minusvärden
        }
    }

    public boolean isAlive() { //Definerar att isAlive är så länge hälsa är över 0
        return health > 0;
    }
}