package CompanyUtils;

import Robots.Robot;
import Order.Order;
import Client.Client;


public class RobotAssigner
{

    public RobotAssigner()
    {

    }

    public void AssignRobot(Order order)
    {
        Robot robotToAssing;
        if(order.getClient().getService().getClass().getName().equals("Platinum"))
        {
            robotToAssing = GetRequiredRobotToPlatinumRobot(order);
        }
        else
        {
            robotToAssing = GetRequiredRobot(order);
        }
    }


    private Robot GetRequiredRobot(Order order)
    {
        return null;
    }

    private Robot GetRequiredRobotToPlatinumRobot(Order order)
    {
        return null;
    }
}
