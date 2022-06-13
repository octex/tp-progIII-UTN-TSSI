package CompanyUtils;


import CompanyUtils.AllocatorSystemExeptions.HasNoCreditsExeption;
import CompanyUtils.AllocatorSystemExeptions.ServiceNotIncludedExeption;
import Order.*;
import Client.*;
import Order.FactoryCleanType.CleanType;
import Order.FactoryCleanType.SimpleClean;
import Services.Classic;
import Services.Economic;
import Services.Platinum;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderVerifyerTest {

    protected OrderVerifyer orderVerifyer=new OrderVerifyer();
    public Location location = new Location("Buenos aires","Olivos","Maipu 3500");;
    public Client client = new Client(111, new Economic(), null);

    public Order order =new Order(client, new SimpleClean(),location,false,"Piso");

    @BeforeEach
    void setUp() {

    }

    @Test
    void validateServiceEconomicSimpleWithCreditsOk() throws ServiceNotIncludedExeption {
        assertTrue( order.getClient().getService().validateService(order));
    }

    @Test
    void validateServiceEconomicSimpleWithoutCreditsFail() throws HasNoCreditsExeption {
        client.getService().setCleaningQuantity(0);
        assertFalse(order.getClient().getService().validateClientCredits(order));
    }


    @Test
    void validateServicePlatinumOK() throws HasNoCreditsExeption { //nunca va a tirar exepción.
        client.setService(new Platinum());

        order.setWantsOrder(true);
        order.setWantsPolish(true);
        client.getService().setCleaningQuantity(-1);
        client.getService().setOrderingQuantity(-1);
        assertTrue(order.getClient().getService().validateClientCredits(order));
    }


}