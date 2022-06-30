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
import java.util.stream.Stream;


public class RobotAssigner
{

    public RobotAssigner()
    {

    }

    public void AssignRobot(Order order, ArrayList<Robot> robots, ArrayList<RobotRegister> robotsOrders) throws CouldNotAssignRobotException
    {
        ArrayList<Robot> suitableRobots;

        if(order.getClient().getService().getServiceName().equals("Platinum"))
        {
            suitableRobots = GetSuitableRobotsForPlatinum(order, robots, robotsOrders);
        }
        else
        {
            suitableRobots = GetSuitableRobots(order, robots);
        }

        if (suitableRobots.size() == 0)
        {
            throw new CouldNotAssignRobotException("No hay robots disponibles para el pedido solicitado");
        }

        for(Robot robot : suitableRobots)
        {
            order.addRobot(robot);
            try
            {
                robotsOrders.get(GetRobotRegistry(robot, robotsOrders)).AddOrder(order);
            }
            catch (IndexOutOfBoundsException e)
            {
                RobotRegister newRobotRegister = new RobotRegister(robot);
                newRobotRegister.AddOrder(order);
                robotsOrders.add(newRobotRegister);
            }
        }
    }

    private int GetRobotRegistry(Robot robot, ArrayList<RobotRegister> robotOrders)
    {
        for (RobotRegister robotOrder : robotOrders)
        {
            if (robotOrder.GetRobot().equals(robot))
            {
                return robotOrders.indexOf(robotOrder);
            }
        }
        return -1;
    }

    private ArrayList<Robot> GetSuitableRobotsForPlatinum(Order order, ArrayList<Robot> robots, ArrayList<RobotRegister> robotsOrders)
    {
        ArrayList<Robot> suitableRobots = new ArrayList<>(robots.stream().filter(
                x -> x.doesSupportThisSurface(order.getSurface())
        ).toList());
        ArrayList<RobotRegister> suitableRobotsWithOrders = new ArrayList<>();

        if (order.doesWantOrder())
        {
            suitableRobots = new ArrayList<>(
                    suitableRobots.stream().filter(
                            x -> x instanceof RoomOrganizer
                    ).toList()
            );
        }
        if (order.doesWantPolish())
        {
            suitableRobots = new ArrayList<>(
                    suitableRobots.stream().filter(
                            x -> x instanceof Polisher
                    ).toList()
            );
        }

        for (Robot robot: suitableRobots)
        {
            int index = GetRobotRegistry(robot, robotsOrders);
            if (index == -1)
            {
                suitableRobots.clear();
                suitableRobots.add(robot);
                return suitableRobots;
            }
            else
            {
                suitableRobotsWithOrders.add(robotsOrders.get(index));
            }
        }
        return suitableRobots;
    }

    private ArrayList<Robot> GetSuitableRobots(Order order, ArrayList<Robot> robots)
    {
        ArrayList<Robot> matchRobots = new ArrayList<>();

        Robot matchRobotForSurface = robots.stream().filter(
                x -> x.doesSupportThisSurface(order.getSurface())
        ).min(Comparator.comparingDouble(Robot::getCostPH)).get();

        matchRobots.add(matchRobotForSurface);

        Robot matchRobotForOrder;
        Robot matchRobotForPolish;

        if (order.doesWantOrder() && !(matchRobotForSurface instanceof RoomOrganizer))
        {
            matchRobotForOrder = robots.stream().filter(
                    x -> x instanceof RoomOrganizer
            ).min(Comparator.comparingDouble(Robot::getCostPH)).get();
            matchRobots.add(matchRobotForOrder);
        }
        if (order.doesWantPolish() && !(matchRobotForSurface instanceof Polisher))
        {
            matchRobotForPolish = robots.stream().filter(
                    x -> x instanceof Polisher
            ).min(Comparator.comparingDouble(Robot::getCostPH)).get();
            matchRobots.add(matchRobotForPolish);
        }

        return matchRobots;
    }
}
