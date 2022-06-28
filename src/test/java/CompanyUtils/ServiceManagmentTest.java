


package CompanyUtils;

import Client.Client;
import CompanyUtils.OrderVerifyerExceptions.CouldNotVerifyOrderException;
import Order.FactoryCleanType.SimpleClean;
import Order.Order;
import Robots.Surface;
import Services.Classic;
import Services.Economic;
import Services.Exeptions.OverpassesDebtExeption;
import Services.Platinum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class ServiceManagmentTest {




    protected OrderVerifyer orderVerifyer=new OrderVerifyer();

    public Client client = new Client(111, new Economic(), null);
    public Order order =new Order(client, new SimpleClean(),null,false, Surface.PISOS);


    ServiceManagement serviceManagment = ServiceManagement.getInstance();


    @BeforeEach
    void setUp() {
        client = new Client(111, new Economic(), null);

    }




    @Test
    void EconomicHasDebtFail()  {
        serviceManagment.setCostumerDebt((5));
        assertThrows(OverpassesDebtExeption.class , () -> {
            serviceManagment.debtSucceded(client.getService(), serviceManagment.getCostumerDebt());
        });
    }

    @Test
    void EconomicNoDebtOk()  {
        serviceManagment.setCostumerDebt((0));
        assertDoesNotThrow( () -> {
            serviceManagment.debtSucceded(client.getService(), serviceManagment.getCostumerDebt());
        });
    }


    @Test
    void ClassicHasDebtFail()  {
        client = new Client(111, new Classic(), null);
        serviceManagment.setCostumerDebt((2005));
        assertThrows(OverpassesDebtExeption.class , () -> {
            serviceManagment.debtSucceded(client.getService(), serviceManagment.getCostumerDebt());
        });
    }

    @Test
    void ClassicNoDebtOk()  {
        client = new Client(111, new Classic(), null);
        serviceManagment.setCostumerDebt((1000));
        assertDoesNotThrow( () -> {
            serviceManagment.debtSucceded(client.getService(), serviceManagment.getCostumerDebt());
        });
    }


    @Test
    void PlatinumHasDebtFail()  {
        Platinum platinum =new Platinum();

        client = new Client(111, platinum, null);
        serviceManagment.setCostumerDebt((3500));
        assertThrows(OverpassesDebtExeption.class , () -> {
            serviceManagment.debtSucceded(client.getService(), serviceManagment.getCostumerDebt());
        });
    }

    @Test
    void PlatinumNoDebtOk()  {
        Platinum platinum =new Platinum();

        client = new Client(111, platinum, null);
        serviceManagment.setCostumerDebt((1000));
        assertDoesNotThrow( () -> {
            serviceManagment.debtSucceded(client.getService(), serviceManagment.getCostumerDebt());
        });
    }


    @Test
    void getDebt() {
    }
}
