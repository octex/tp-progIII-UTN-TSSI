package ClientUtils;



import static org.junit.jupiter.api.Assertions.assertThrows;

import Order.FactoryCleanType.CleanType;
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
                         client.requestOrder(new Company(), new Order(client, CleanType.SIMPLE, null, true, "a"));
            });
        }

}
