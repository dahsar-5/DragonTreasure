
package DragonTreasure;
    
    public class Door {
    private String direction;   // N, S, V, Ö
    private Room leadsTo;       // vilket rum dörren leder till
    private boolean locked; //lås på dörren
    
    public Door(String direction, Room leadsTo, boolean locked) {
    this.direction = direction;   
    this.leadsTo = leadsTo;       
    this.locked = locked;         
    }

    public String getDirection() {
        return direction;
    }

    public Room getLeadsTo() {
        return leadsTo;
    }
    
    public void setLocked(boolean locked) {
    this.locked = locked;
    }           
    
    public boolean isLocked() {
    return locked;
}

    }

