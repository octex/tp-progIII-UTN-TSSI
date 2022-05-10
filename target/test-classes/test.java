import Client.Client;
import Services.Economic;
import org.testng.annotations.Test;

import static org.testng.Assert.*;


public class economicOrdenamiento {

    @Test
    void economicLimpiezaOrdenamiento(){
        var client = new Client(111, new Economic(), null);

        assertThrows(CouldNotCreateOrderException.class,
            ()->{
                client.requestOrder(new Company(), new Order(SIMPLE, null, true, "a"));
            });

    }
    
}
