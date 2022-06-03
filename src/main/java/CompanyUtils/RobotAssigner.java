package CompanyUtils;

import CompanyUtils.RobotAssignerExceptions.CouldNotAssignRobotException;
import Robots.Polisher;
import Robots.Robot;
import Order.Order;
import Robots.RobotRegister;
import Robots.RoomOrganizer;

import java.util.ArrayList;
import java.util.Comparator;


public class RobotAssigner
{

    public RobotAssigner()
    {

    }

    public void AssignRobot(Order order, ArrayList<Robot> robots, ArrayList<RobotRegister> robotsOrders) throws CouldNotAssignRobotException
    {
        Robot robotToAssing;
        ArrayList<Robot> suitableRobots = GetSuitableRobots(order, robots);
        if (suitableRobots.size() == 0)
        {
            throw new CouldNotAssignRobotException("No hay robots disponibles para el pedido solicitado");
        }
        if(order.getClient().getService().getServiceName().equals("Platinum"))
        {
            robotToAssing = GetRequiredRobotToPlatinumRobot(suitableRobots, robotsOrders);
        }
        else
        {
            robotToAssing = GetCheapestRobot(suitableRobots);
        }
        robotsOrders.get(robotsOrders.indexOf(robotToAssing)).AddOrder(order);
    }


    private ArrayList<Robot> GetSuitableRobots(Order order, ArrayList<Robot> robots)
    {
        ArrayList<Robot> matchRobots = new ArrayList<Robot>();

        for(Robot robot : robots)
        {
            boolean matches = order.getSurface().equals(robot.getSurface()) &&
                    order.doesWantOrder() && robot instanceof RoomOrganizer &&
                    order.doesWantPolish() && robot instanceof Polisher;
            if(matches)
            {
                matchRobots.add(robot);
            }
        }
        return matchRobots;
    }

    private Robot GetCheapestRobot(ArrayList<Robot> robots)
    {
        return robots.stream()
                .min(Comparator.comparingDouble(Robot::getCostPH))
                .get();
    }

    private Robot GetRequiredRobotToPlatinumRobot(ArrayList<Robot> suitableRobots, ArrayList<RobotRegister> robotsOrders)
    {
        ArrayList<RobotRegister> suitableRobotsWithOrders = new ArrayList<RobotRegister>();
        for(Robot robot : suitableRobots)
        {
            suitableRobotsWithOrders.add(robotsOrders.get(robotsOrders.indexOf(robot)));
        }
        return suitableRobotsWithOrders.stream()
                .min(Comparator.comparingInt(RobotRegister::GetAmountOfOrders))
                .get().GetRobot();
    }
}
