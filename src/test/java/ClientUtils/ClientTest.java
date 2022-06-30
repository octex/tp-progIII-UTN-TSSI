package ClientUtils;



import static org.junit.jupiter.api.Assertions.assertThrows;

import CompanyUtils.OrderVerifyerExceptions.CouldNotVerifyOrderException;
import Order.FactoryCleanType.SimpleClean;
import Robots.Surface;
import org.junit.jupiter.api.Test;

import Client.Client;
import CompanyUtils.Company;
import Order.Order;
import Services.Economic;


public class ClientTest {

        @Test
        void EconomicClientRequestsCleaningAndOrder(){
            var client = new Client(111, new Economic(), null);

            assertThrows(CouldNotVerifyOrderException.ServiceNotIncludedExeption.class, ()->{
                         client.sendOrder(new Company(), new Order(client, new SimpleClean(), null, true, Surface.PISOS));
            });
        }

}
