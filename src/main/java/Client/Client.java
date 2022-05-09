package Client;

import CompanyUtils.Company;
import Order.*;
import Services.Service;

public class Client {
    private int dni;
    private Service service;
    private float debt;
    private Order requestedOrder;

    Client(int dni, Service service){
        this.dni=dni;
        this.service=service;
    };

    public Order requestOrder(Company company, CleanType cleanType, Location location, boolean wantsOrder) throws CouldNotCreateOrderException
    {
        try
        {
            return null;
        }
        catch (Exception CouldNotCreateOrderException)
        {
            throw new CouldNotCreateOrderException("No se pudo crear la orden");
        }

    }
}
