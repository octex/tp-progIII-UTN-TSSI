package ClientUtils;

import static org.junit.jupiter.api.Assertions.*;

import Client.Client;
import CompanyUtils.Company;
import Order.FactoryCleanType.CleanTypeSelector;
import Order.FactoryCleanType.SimpleClean;
import Services.Economic;
import Services.Service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Order.Order;

class EconomicTest {
    Client client;
    Service economic =new Economic();
    Order order =new Order();
    Company company= new Company();

    @BeforeEach
    void setUp() {
        client =new Client(5,economic,null);

    }



    @Test
    void economicOrderPolishCleaning() throws CouldNotCreateOrderException, {

        client.requestOrder(company,order);
        assertNotThrows(economic.req(Company));
    }

    @Test
    void economicOrderSimple(){
        this.economic= new ServiceEconomic();
        this.requestOrder = new RequestOrder(false,false);
        this.clienteEconomic = new ClienteEconomic(21001,false,economic ,requestOrder);
        assertDoesNotThrow(clienteEconomic.requireOrder(Company));
    }

    @Test
    void economicOrderCleaning{
        this.economic= new ServiceEconomic();
        this.requestOrder = new RequestOrder(true,false);
        this.clienteEconomic = new ClienteEconomic(21001,false,economic ,requestOrder);
        assertDoesNotThrow(clienteEconomic.requireOrder(Company));

    }

    @Test
    void economicDefaulter {
        this.economic= new ServiceEconomic();
        this.requestOrder = new RequestOrder(false,false);
        this.clienteEconomic = new ClienteEconomic(21001,true,economic ,requestOrder);
        assertDoesNotThrow(clienteEconomic.requireOrder(Company));


    }
}