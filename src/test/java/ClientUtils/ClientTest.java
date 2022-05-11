package ClientUtils;

import static Order.CleanType.SIMPLE;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import Client.Client;
import CompanyUtils.Company;
import CompanyUtils.AllocatorSystemExeptions.ServiceNotIncludedExeption;
import Order.Order;
import Services.Economic;


public class ClientTest {

        @Test
        void EconomicClientRequestsCleaningAndOrder(){
            var client = new Client(111, new Economic(), null);

            assertThrows(ServiceNotIncludedExeption.class, ()->{
                         client.requestOrder(new Company(), new Order(client, SIMPLE, null, true, "a"));
            });
        }

}
