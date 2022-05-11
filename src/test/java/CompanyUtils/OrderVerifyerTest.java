package CompanyUtils;


import CompanyUtils.AllocatorSystemExeptions.HasNoCreditsExeption;
import CompanyUtils.AllocatorSystemExeptions.ServiceNotIncludedExeption;
import Order.*;
import Client.*;
import Services.Economic;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

import static Order.CleanType.SIMPLE;
import static org.junit.jupiter.api.Assertions.*;

class OrderVerifyerTest {

    protected OrderVerifyer orderVerifyer=new OrderVerifyer();
    public Location location = new Location("Buenos aires","Olivos","Maipu 3500");;
    public Client client = new Client(111, new Economic(), null);
    public Order order =new Order(client,SIMPLE,location,false,"Piso");

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void validateServiceEconomicSimpleWithCreditsOk() throws ServiceNotIncludedExeption {
        assertTrue(orderVerifyer.validateService(order));
    }

    @Test
    void validateServiceEconomicSimpleWithoutCreditsFail() throws HasNoCreditsExeption {
        assertFalse(orderVerifyer.validateClientCredits(order));
    }
    

    @Test
    void getDebt() {
    }
}