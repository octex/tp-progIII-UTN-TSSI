package CompanyUtils;

import Client.Client;
import CompanyUtils.AllocatorSystemExeptions.HasNoCreditsExeption;
import CompanyUtils.AllocatorSystemExeptions.ServiceNotIncludedExeption;
import CompanyUtils.OrderVerifyerExceptions.*;
import CompanyUtils.RobotAssignerExceptions.*;
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
    private CommunicationModuleReciver communicationModuleReciver;


    public Company() {

    }

    public Company(ArrayList<Robot> robots, ArrayList<Client> clients, ArrayList<Order> orders){
        this.robots.addAll(robots);
        this.clients.addAll(clients);
        this.orders.addAll(orders);
        this.robotAssigner = new RobotAssigner();
        this.orderPerRobot = new ArrayList();
    }

    public CommunicationModuleReciver getCommunicationModuleReciver(){
        return this.communicationModuleReciver;
    }

    public void tryToAssign(Order order){
        try{
            OrderVerifyer orderVerifyer = new OrderVerifyer();
            RobotAssigner robotAssigner = new RobotAssigner();

            orderVerifyer.verifyOrder(order);
            robotAssigner.AssignRobot(order, robots, orderPerRobot);
        }
        catch (ServiceNotIncludedExeption e){
            System.out.println("No se pudo verificar la orden.");
        }
        catch (HasNoCreditsExeption e){
            System.out.println("No se pudo asignar el robot a la orden.");
        }
        catch (Exception e){
            System.out.println("Hubo un error.");
        }
    }
}
