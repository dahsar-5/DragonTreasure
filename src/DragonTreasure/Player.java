package DragonTreasure;

public class Player {
    private String name;   // Instansvariabel: lagrar spelarens namn
    private int health;    // Instansvariabel: lagrar spelarens hälsopoäng
    private int damage;    // Instansvaraiabel: lagrar spelarens skada
    private int heal;      //Instansvaraiabel: lagrar spelarens läkning
    
    // Konstruktor: används när man skapar en ny Player
    public Player(String name, int health, int damage, int heal) {
        this.name = name;      // "this.name" syftar på klassens variabel, "name" är parametern
        this.health = health;  
        this.damage = damage; 
        this.heal = heal;      //att läka
    }

    // Getter: hämtar spelarens namn
    public String getName() {
        return name;
    }
    
    //metod för att läka spelaren med en potion
    public void heal(int amount) {
    health += amount; // samma som health = health + amount 
    System.out.println(name + "s hälsa är nu " + health); 
}

     //Getter: hämtar hälsopoängen
    public int getHealth() {
        return health;
    }
    // Setter: ändrar hälsopoängen
    public void setHealth(int health) {
        this.health = health;
    }
   
    
    // Getter: hämtar nuvarande damage?? Behövs den?
    public int getDamage() {
        return damage;
    }
    
    //Getter: ändrar/setter nuvarande damage, t.ex. ökar denna när spelaren hämtar upp vapen
    public void setDamage(int damage) {
        this.damage = damage;
    }
    
    
    // Ny metod för att spelaren ska göra skada på olika monster
    public void takeDamage(int amount) {
        health -= amount;
        if (health < 0) {
            health = 0;
        }
    }

    public boolean isAlive() {
        return health > 0;
    }
    
    private boolean hasKey = false; 

public void giveKey() { 
    hasKey = true;
}

public boolean hasKey() { 
    return hasKey;
}

}
