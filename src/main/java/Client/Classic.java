package Client;

import Order.*;

public abstract class Classic extends Client {

    public void Client(){
    }

    public Order requestOrder(CompanyUtils.Company company, CleanType cleanType, Location location) throws CouldNotCreateOrderException{
        try{
            Order order = new Order();
            order = company.createOrderPending(CleanType cleanType, Location location);
            return order;
        }
        catch (Exception CouldNotCreateOrderException){
            throw new CouldNotCreateOrderException();
        }

    }
}
