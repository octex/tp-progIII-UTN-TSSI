package CompanyUtils;

import Client.Client;
import Order.Order;
import Services.Economic;
import Services.Exeptions.OverpassesDebtExeption;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CustomerOrderTest {
    public Client client;
    public Company company = new Company();
    ServiceManagement serviceManagment = ServiceManagement.getInstance();
    public Order order = new Order();


    @BeforeEach
    void setUp() {
        client = new Client(111, new Economic(), null);

    }

    @Test
    void EconomicRequiresOrderingFail() throws CouldNotCreateOrderException {
        order.setWantsOrder(true);
        assertThrows(CouldNotCreateOrderException.class, ()->client.requestOrder(company,order));
    }


    @Test
    void EconomicNoDebtOk()  {
        serviceManagment.setCostumerDebt((0));
        assertDoesNotThrow( () -> {
            serviceManagment.debtSucceded(client.getService(), serviceManagment.getCostumerDebt());
        });
    }



}
