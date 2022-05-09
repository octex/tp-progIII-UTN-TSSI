package Client;

import Order.*;
import CompanyUtils.Company;


public abstract class Classic extends Client {

    public void Client(){
    }

    public Order requestOrder(Company company, CleanType cleanType, Location location, boolean wantsOrder) throws CouldNotCreateOrderException{
        try{
            Order order = new Order(cleanType, location, wantsOrder);
            order = company.createOrderPending(CleanType cleanType, Location location);
            return order;
        }
        catch (Exception CouldNotCreateOrderException){
            throw new CouldNotCreateOrderException("No se pudo crear la orden");
        }

    }
}
