package CompanyUtils;

import Client.Client;
import CompanyUtils.AllocatorSystemExeptions.HasNoCreditsExeption;
import CompanyUtils.AllocatorSystemExeptions.ServiceNotIncludedExeption;
import CompanyUtils.OrderVerifyerExceptions.*;
import CompanyUtils.PriceUtils.PriceCalculator;
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
    private PriceCalculator priceCalculator;
    private int simpleOrdersContator;
    private int complexOrdersContator;


    public Company() {

    }

    public Company(ArrayList<Robot> robots, ArrayList<Client> clients, ArrayList<Order> orders){
        this.robots.addAll(robots);
        this.clients.addAll(clients);
        this.orders.addAll(orders);
        this.robotAssigner = new RobotAssigner();
        this.orderPerRobot = new ArrayList();
        this.simpleOrdersContator = 0;
        this.complexOrdersContator = 0;
    }

    public CommunicationModuleReciver getCommunicationModuleReciver(){
        return this.communicationModuleReciver;
    }

    public PriceCalculator getPriceCalculator(){
        return this.priceCalculator;
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

    public int getSimpleOrdersContator() {
        return simpleOrdersContator;
    }
    public void increaseSimpleOrdersContator() {
        simpleOrdersContator += 1;
    }
    
    public int getComplexOrdersContator() {
        return complexOrdersContator;
    }
    public void increaseComplexOrdersContator() {
        complexOrdersContator += 1;
    }

    public void setPriceCalculator(PriceCalculator priceCalculator) {
        this.priceCalculator = priceCalculator;
    }
}
