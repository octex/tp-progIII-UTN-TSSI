package Robots.src.main.java.Order;

import Client.Location;

public class Order {
    
    private CleanType cleanType;
    private Location location;
    private boolean wantsOrder;

    public Order(CleanType cleanType, Location location, boolean wantsOrder){
        this.cleanType = cleanType;
        this.location = location;
        this.wantsOrder = wantsOrder;
    }

}
