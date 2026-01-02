
package DragonTreasure;
    
    
    public class Door {
    private String direction;   // string för att skriva in N, S, V, Ö för att flytta spelaren 
    private Room leadsTo;       // vilket rum dörren leder till
    private boolean locked; //lås på dörren
    
    public Door(String direction, Room leadsTo, boolean locked) { //en konstruktor med parametrar
    this.direction = direction;   
    this.leadsTo = leadsTo;       
    this.locked = locked;         
    }

    public String getDirection() { //getter för direction
        return direction;
    }

    public Room getLeadsTo() { //getter för riktning/vart dörren leder
        return leadsTo;
    }
    
    public void setLocked(boolean locked) { //En setter med boolean för låset på dörren
    this.locked = locked;
    }           
    
    public boolean isLocked() { //Vad kallar man detta, en getter för att låsa eller låsa upp? Vad ör funktionaliteten?
    return locked;
}

    }

