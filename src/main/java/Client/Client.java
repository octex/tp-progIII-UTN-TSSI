package Client;

import CompanyUtils.Company;
import Order.*;

public class Client {
    private int dni;
    private float debt;
    private Services.Service service;
    private Order requestedOrder;

    public Order requestOrder(Company company, CleanType cleanType, Location location, boolean wantsOrder) throws CouldNotCreateOrderException{
        try{
            Order order = new Order(cleanType, location, wantsOrder);
            order = company.createOrderPending(CleanType cleanType, Location location); // Metodo sin definir
            return order;
        }
        catch (Exception CouldNotCreateOrderException){
            throw new CouldNotCreateOrderException("No se pudo crear la orden");
        }

    }
}
