package Client;

import Service.*;
import Order.Order;

public class Client {
    private int dni;
    private float debt;
    private Service service;
    private Order requestedOrder;


    public Order requestOrder(Company company, CleanType cleanType, Location location) throws CouldNotCreateOrderException{
        try{
            OrderPending order = new OrderPending();
            order = company.createOrderPending(CleanType cleanType, Location location);
            return order;
        }
        catch (Exception CouldNotCreateOrderException){
            throw new CouldNotCreateOrderException();
        }

    }
}
