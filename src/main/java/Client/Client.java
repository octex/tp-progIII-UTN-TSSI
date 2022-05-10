package Client;

import java.util.ArrayList;
import java.util.Collection;

import Client.Services.Economic;
import CompanyUtils.Company;
import Order.*;
import Client.Services.Service;


public class Client {
    private int dni;
    private Service service;
    private Collection locations = new ArrayList<Location>();


    public Client(int dni, Economic service, Collection locations){
        this.dni=dni;
        this.service=service;
        this.locations = locations;
    };

    public void requestOrder(Company company, Order order) throws CouldNotCreateOrderException
    {
        try
        {
            company.tryToAssing(order);
        }
        catch (Exception CouldNotCreateOrderException)
        {
            throw new CouldNotCreateOrderException("No se pudo crear la orden");
        }

    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }
}
