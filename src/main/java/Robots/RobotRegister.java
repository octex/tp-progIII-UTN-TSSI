package Robots;

import Order.Order;

import java.util.LinkedList;

public class RobotRegister {
    private Robot robot;
    private LinkedList<Order> orders;

    public RobotRegister(Robot robot, LinkedList<Order> orders){
        this.robot = robot;
        this.orders.addAll(orders);
    }
}
