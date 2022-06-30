package CompanyUtils;

import Client.Client;
import Order.Order;
import Services.Economic;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CompanyRegistryTest {
    public Client client;
    public Company company = new Company();
     Order order = new Order();


    @BeforeEach
    void setUp() {
        client = new Client(111, new Economic(), null);
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

    @Test
    void isUserInDatabaseFail() {

        ClientOrders clientOrdersSeek = new ClientOrders();
        ClientOrders clientOrders=new ClientOrders(client,null);
        clientOrdersSeek= company.findClient(order);
        assertNull(clientOrdersSeek);
    }

    @Test
    void databaseLoadedOtherUser() {

        Client client2 =new Client(5,new Economic(),null);
        ClientOrders clientOrdersSeek = new ClientOrders();
        ClientOrders clientOrders=new ClientOrders(client,null);
        clientOrdersSeek= company.findClient(order);
        assertNull(clientOrdersSeek);
    }




}
