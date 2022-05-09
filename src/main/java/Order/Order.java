package Order;

import Client.Location;

public class Order {
    
    private CleanType cleanType;
    private Location location;
    private boolean wantsOrder;
    private String surface;
    public Order(CleanType cleanType, Location location, boolean wantsOrder, String surface){
        this.cleanType = cleanType;
        this.location = location;
        this.wantsOrder = wantsOrder;
        this.surface=surface;
    }

}
