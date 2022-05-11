
import Services.Economic;
import CompanyUtils.AllocatorSystemExeptions.ServiceNotIncludedExeption;
import Client.Client;
import CompanyUtils.Company;
import Order.Order;
import org.junit.jupiter.api.Test;
import static Order.CleanType.SIMPLE;
import static org.junit.jupiter.api.Assertions.*;


public class ClientTest {

        @Test
        void economicLimpiezaOrdenamiento(){
            var client = new Client(111, new Economic(), null);

            assertThrows(ServiceNotIncludedExeption.class, ()->{
                         client.requestOrder(new Company(), new Order(client, SIMPLE, null, true, "a"));
            });
        }

}
