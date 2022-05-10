import java.beans.Transient;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.Assertions.*;

import Services.Economic;


public class test {

    @Test
    void economicLimpiezaOrdenamiento(){
        var client = new Client(111, new Economic(), null);

        assertThrows(CouldNotCreateOrderException.class,
            ()->{
                client.requestOrder(new Company(), new Order(SIMPLE, null, true, "a"));
            });

    }
    
}
