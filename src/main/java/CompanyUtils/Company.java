package CompanyUtils;

import Client.Client;
import Order.Order;
import Robots.Robot;

import java.lang.reflect.Array;
import java.util.*;


public class Company {
    private ArrayList<Robot> robots;
    private ArrayList<Client> clients;
    private ArrayList<Order> orders;
    private AllocatorSystem allocatorSystem;
    private LinkedList<RobotRegister> orderPerRobot;

    public Company(ArrayList<Robot> robots, ArrayList<Client> clients, ArrayList<Order> orders){
        this.robots.addAll(robots);
        this.clients.addAll(clients);
        this.orders.addAll(orders);
        this.allocatorSystem = new AllocatorSystem();
        this.orderPerRobot = new LinkedList();
    }

    public void tryToAssing(Order order){
        this.allocatorSystem.TryAllocate(order);
    }
}
