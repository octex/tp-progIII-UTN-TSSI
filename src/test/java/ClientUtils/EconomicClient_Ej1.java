import java.beans.Transient;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import Services.Economic;


class ClientTest {

    @Test
    void economicLimpiezaOrdenamiento(){
        var client = new Client(111, new Economic(), null);

        assertThrows(CouldNotCreateOrderException.class,
            ()->{
                client.requestOrder(new Company(), new Order(SIMPLE, null, true, "a"));
            });

    }
    
}
