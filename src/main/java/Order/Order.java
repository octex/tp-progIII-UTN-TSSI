package Order;

import Client.Location;
import Order.CleanType;

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
