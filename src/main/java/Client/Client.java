package Client;
import Service.*;

public class Client {
    private int dni;
    private Service service;
    private float debt;

    public Client(){
    }

    public OrderPending requestOrder(Company company, CleanType cleanType, Location location) throws CouldNotCreateOrderException{
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
