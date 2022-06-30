package CompanyUtils;

import Client.Client;
import Client.CouldNotCreateOrderException;
import Order.Order;
import Services.Economic;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerOrderTest {
    public Client client;
    public Company company = new Company();
    public Order order = new Order();




    @BeforeEach
    void setUp() {
        client = new Client(1, new Economic(), null);
        Order order = new Order();
        order.setClient(client);
    }

    @Test
    void isUserInDatabaseOk() {

        ClientOrders clientOrdersSeek = new ClientOrders();
        ClientOrders clientOrders=new ClientOrders(client,null);
        company.getCompanyRegistry().getClientsAgenda().add(clientOrders);
        clientOrdersSeek= company.findClient(order);
        assertNotNull(clientOrdersSeek);
    }





}
