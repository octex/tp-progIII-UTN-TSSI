
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



    class EconomicTest {



        @BeforeEach
        void setUp() {
            Cliente clienteEconomic;
            Service economic;
            RequestOrder requestOrder;
            Company company;
        }

        @Test
            void economicOrderPolishCleaning throws NoCumpleExeption{
                this.economic= new ServiceEconomic();
                this.requestOrder = new RequestOrder(true,true);
                this.clienteEconomic = new ClienteEconomic(21001,,false,economic ,requestOrder);
                assertNotThrows(clienteEconomic.requireOrder(Company));
            }

            @Test
                void economicOrderSimple{
                    this.economic= new ServiceEconomic();
                    this.requestOrder = new RequestOrder(false,false);
                    this.clienteEconomic = new ClienteEconomic(21001,false,economic ,requestOrder);
                    assertDoesNotThrow(clienteEconomic.requireOrder(Company));
                }

                @Test
                    void economicOrderCleaning{
                        this.economic= new ServiceEconomic();
                        this.requestOrder = new RequestOrder(true,false);
                        this.clienteEconomic = new ClienteEconomic(21001,false,economic ,requestOrder);
                        assertDoesNotThrow(clienteEconomic.requireOrder(Company));

                }

                    @Test
                    void economicDefaulter {
                        this.economic= new ServiceEconomic();
                        this.requestOrder = new RequestOrder(false,false);
                        this.clienteEconomic = new ClienteEconomic(21001,true,economic ,requestOrder);
                        assertDoesNotThrow(clienteEconomic.requireOrder(Company));


        }
    }


