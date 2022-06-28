package CompanyUtils;

import Client.Client;
import CompanyUtils.RobotAssignerExceptions.CouldNotAssignRobotException;
import Order.FactoryCleanType.SimpleClean;
import Robots.*;
import Services.Economic;
import Services.Service;
import Order.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Or;

import java.util.ArrayList;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class RobotAssignerTest {

    public RobotAssigner robotAssigner;
    public ArrayList<Robot> robots;
    public ArrayList<RobotRegister> robotOrders;
    public Client testClient;
    public Service testService;

    public Robot k311Y_fu;
    public Robot k311Ya;
    public Robot po11h;
    public Robot so31rty;

    @BeforeEach
    void setUp()
    {
        robotAssigner = new RobotAssigner();
        robots = new ArrayList<>();
        robotOrders = new ArrayList<>();
        testClient = new Client(43085477, testService, null);
        testService = new Economic();
        LinkedList<Order> testOrders = new LinkedList<>();
        Order economicOrder = new Order(testClient, new SimpleClean(),
                null, true, Surface.PISOS);
        for (int i = 0; i < 3; i++)
        {
            testOrders.add(economicOrder);
        }

        k311Y_fu = new K311Y_fu();
        k311Ya = new K311Ya();
        po11h = new P011H();
        so31rty = new S031RTY();

        robots.add(k311Y_fu);
        robots.add(k311Ya);
        robots.add(po11h);
        robots.add(so31rty);

        RobotRegister so31rtyOrders = new RobotRegister(so31rty);
        RobotRegister k311yfuOrders = new RobotRegister(k311Y_fu);

        for (int i = 0; i < 3; i++)
        {
            so31rtyOrders.AddOrder(economicOrder);
            k311yfuOrders.AddOrder(economicOrder);
        }

        robotOrders.add(so31rtyOrders);
        robotOrders.add(k311yfuOrders);
    }

    private RobotRegister GetRobotRegistry(Robot robot)
    {
        for (RobotRegister robotOrder : robotOrders)
        {
            if (robotOrder.GetRobot().equals(robot))
            {
                return robotOrder;
            }
        }
        return null;
    }

    @Test
    void AssignRobotForEconomicService()
    {
        Service economicService = new Economic();
        Client economicClient = new Client(43085477, economicService, null);
        Order economicOrder = new Order(economicClient, new SimpleClean(),
                null, false, Surface.PISOS);
        economicOrder.setWantsPolish(false);
        assertDoesNotThrow(() -> robotAssigner.AssignRobot(economicOrder, robots, robotOrders));
        assertNotNull(GetRobotRegistry(po11h));
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