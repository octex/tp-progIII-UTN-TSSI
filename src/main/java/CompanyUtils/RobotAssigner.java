package CompanyUtils;

import Robots.Robot;
import Order.Order;
import Client.Client;
import Robots.RobotRegister;

import java.util.ArrayList;
import java.util.Comparator;


public class RobotAssigner
{

    public RobotAssigner()
    {

    }

    public void AssignRobot(Order order, ArrayList<Robot> robots, ArrayList<RobotRegister> robotsOrders)
    {
        Robot robotToAssing;
        if(order.getClient().getService().getServiceName().equals("Platinum"))
        {
            robotToAssing = GetRequiredRobotToPlatinumRobot(robots, robotsOrders);
        }
        else
        {
            robotToAssing = GetCheapestRobot(robots);
        }
    }


    private Robot GetCheapestRobot(ArrayList<Robot> robots)
    {
        return robots.stream()
                .min(Comparator.comparingDouble(Robot::getCostPH))
                .get();
    }

    private Robot GetRequiredRobotToPlatinumRobot(ArrayList<Robot> robots, ArrayList<RobotRegister> robotsOrders)
    {
        return robotsOrders.stream()
                .min(Comparator.comparingInt(RobotRegister::GetAmountOfOrders))
                .get().GetRobot();
    }
}
