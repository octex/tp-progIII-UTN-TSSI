package CompanyUtils;

import Client.Client;
import Order.FactoryCleanType.ComplexClean;
import Order.FactoryCleanType.SimpleClean;
import Robots.*;
import Services.Classic;
import Services.Economic;
import Services.Service;
import Order.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class RobotAssignerTest {

    public RobotAssigner robotAssigner;
    public ArrayList<Robot> robots;
    public ArrayList<RobotRegister> robotOrders;
    public Client testClient;
    public Service testService;

    public Robot k311Yfu;
    public Robot k311Ya;
    public Robot po11h;
    public Robot so31rty;
    public Robot k311yfl;

    @BeforeEach
    void setUp()
    {
        robotAssigner = new RobotAssigner();
        robots = new ArrayList<>();
        robotOrders = new ArrayList<>();
        testClient = new Client(43085477, testService, null);
        testService = new Economic();
        Order testOrder = new Order(testClient, new SimpleClean(),
                null, true, Surface.PISOS);

        k311Yfu = new K311Y_fu();
        k311Ya = new K311Ya();
        po11h = new P011H();
        so31rty = new S031RTY();
        k311yfl = new K311Y_fl();

        robots.add(k311Yfu);
        robots.add(k311Ya);
        robots.add(po11h);
        robots.add(so31rty);
        robots.add(k311yfl);

        RobotRegister so31rtyOrders = new RobotRegister(so31rty);
        RobotRegister k311YfuOrders = new RobotRegister(k311Yfu);
        RobotRegister k311YaOrders = new RobotRegister(k311Ya);

        for (int i = 0; i < 3; i++)
        {
            so31rtyOrders.AddOrder(testOrder);
        }

        for (int i = 0; i < 5; i++)
        {
            k311YaOrders.AddOrder(testOrder);
        }

        for(int i = 0; i < 10; i++)
        {
            k311YfuOrders.AddOrder(testOrder);
        }

        robotOrders.add(so31rtyOrders);
        robotOrders.add(k311YfuOrders);
        robotOrders.add(k311YaOrders);
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
        Client economicClient = new Client(11111111, economicService, null);
        Order economicOrder = new Order(economicClient, new SimpleClean(),
                null, false, Surface.PISOS);
        economicOrder.setWantsPolish(false);
        assertDoesNotThrow(() -> robotAssigner.AssignRobot(economicOrder, robots, robotOrders));
        assertNotNull(GetRobotRegistry(k311yfl));
    }

    @Test

    void AssignRobotForClassicService()
    {
        Service classicService = new Classic();
        Client classicClient = new Client(222222222, classicService, null);
        Order economicOrder = new Order(classicClient, new ComplexClean(),
                null, false, Surface.MUEBLES);
    }

    @Test
    void AssignRobotForPlatinumClient()
    {

    }
}