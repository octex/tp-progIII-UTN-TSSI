package CompanyUtils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RobotAssignerTest {

    public RobotAssigner robotAssigner;
    public PaymentModuleMock mock;
    @BeforeEach
    void setUp()
    {
        robotAssigner = new RobotAssigner();
        mock = new PaymentModuleMock();
    }

    @Test
    void AssignRobotForEconomicService()
    {

    }

    @Test
    void AssignRobotForClassicService()
    {

    }

    @Test
    void AssignRobotForPlatinumClient()
    {

    }

    @Test
    void AssignRobotForEconomicServiceWithDebt()
    {

    }

    @Test
    void AssignRobotForClassicServiceWithDebt()
    {

    }

    @Test
    void AssignRobotForClassicServiceWithExcededDebt()
    {

    }

    @Test
    void AssignRobotForPlatinumServiceWithExcededDebt()
    {

    }
}