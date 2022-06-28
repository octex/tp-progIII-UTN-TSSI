package CompanyUtils;

import CompanyUtils.RobotAssignerExceptions.CouldNotAssignRobotException;
import Robots.Polisher;
import Robots.Robot;
import Order.Order;
import Robots.RobotRegister;
import Robots.RoomOrganizer;
import org.mockito.internal.matchers.Or;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.stream.Stream;


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

        try
        {
            robotsOrders.get(robotsOrders.indexOf(robotToAssing)).AddOrder(order);
        }
        catch (IndexOutOfBoundsException e)
        {
            RobotRegister newRobotRegister = new RobotRegister(robotToAssing);
            newRobotRegister.AddOrder(order);
            robotsOrders.add(newRobotRegister);
        }
    }


    private ArrayList<Robot> GetSuitableRobots(Order order, ArrayList<Robot> robots)
    {
        Stream<Robot> matchRobotsStream = robots.stream().filter(
                x -> x.doesSupportThisSurface(order.getSurface())
        );
        if (order.doesWantOrder())
        {
            matchRobotsStream = matchRobotsStream.filter(
                    x -> x instanceof RoomOrganizer
            );
        }
        if (order.doesWantPolish())
        {
            matchRobotsStream = matchRobotsStream.filter(
                    x -> x instanceof Polisher
            );
        }

        return new ArrayList<Robot>(matchRobotsStream.toList());
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
