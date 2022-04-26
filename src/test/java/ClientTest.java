import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClientTest {
    Client cliente;
    Company empresa;
    CleanType cleanType;
    Location location;
    OrderPending orderPending;

    @BeforeEach
    void setUp() {
        cliente = new Client();
        empresa = new Company();
        cleanType = new CleanType();
        location = new Location();
    }

    @Test
    void requestOrder() {
        assertEquals(orderPending, cliente.requestOrder(empresa, cleanType, location));
    }
}