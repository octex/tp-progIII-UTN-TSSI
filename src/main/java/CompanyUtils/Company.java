package CompanyUtils;

import Client.Client;
import Order.Order;
import Robots.Robot;
import Robots.RobotRegister;

import java.util.*;


public class Company {
    private ArrayList<Robot> robots;
    private ArrayList<Client> clients;
    private ArrayList<Order> orders;
    private RobotAssigner robotAssigner;
    private ArrayList<RobotRegister> orderPerRobot;
    public Company() {

    }
    public Company(ArrayList<Robot> robots, ArrayList<Client> clients, ArrayList<Order> orders){
        this.robots.addAll(robots);
        this.clients.addAll(clients);
        this.orders.addAll(orders);
        this.robotAssigner = new RobotAssigner();
        this.orderPerRobot = new ArrayList();
    }

    public void tryToAssing(Order order){
        this.robotAssigner.AssignRobot(order);
    }
}
