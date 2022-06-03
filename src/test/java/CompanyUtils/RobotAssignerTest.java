package CompanyUtils;

import Client.Client;
import Services.Economic;
import Services.Service;
import Order.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Or;

import static org.junit.jupiter.api.Assertions.*;

class RobotAssignerTest {

    public RobotAssigner robotAssigner;

    @BeforeEach
    void setUp()
    {
        robotAssigner = new RobotAssigner();
    }

    @Test
    void AssignRobotForEconomicService()
    {
        Service economicService = new Economic();
        Client economicClient = new Client(43085477, economicService, null);
        Order economicOrder = new Order(economicClient, CleanType.SIMPLE,
                null, true, "Pisos");

    }

    @Test
    void AssignRobotForClassicService()
    {

    }

    @Test
    void AssignRobotForPlatinumClient()
    {

    }
}