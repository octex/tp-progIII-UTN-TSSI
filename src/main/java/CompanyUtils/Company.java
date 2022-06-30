package CompanyUtils;

import Client.Client;
import CompanyUtils.Employees.Specialist;
import CompanyUtils.Employees.SpecialistRegister;
import CompanyUtils.OrderVerifyerExceptions.*;
import CompanyUtils.PriceUtils.PriceCalculator;
import CompanyUtils.RobotAssignerExceptions.*;
import Order.Order;
import Robots.Robot;
import Robots.RobotRegister;
import org.mockito.internal.matchers.Or;

import java.util.*;
import java.util.stream.Stream;


public class Company {
    private ArrayList<Robot> robots;
    private ArrayList<Client> clients;
    private ArrayList<Order> orders;
    private RobotAssigner robotAssigner;
    private OrderVerifyer orderVerifyer;
    private ArrayList<RobotRegister> orderPerRobot;
    private CommunicationModuleReciver communicationModuleReciver;
    private PriceCalculator priceCalculator;
    private float robotAdjustmentFactor;

    public CompanyRegistry getCompanyRegistry() {
        return companyRegistry;
    }

    public void setCompanyRegistry(CompanyRegistry companyRegistry) {
        this.companyRegistry = companyRegistry;
    }

    private CompanyRegistry companyRegistry;

    public Company() {
        this.robotAssigner = new RobotAssigner();
        this.orderVerifyer = new OrderVerifyer();
        this.robots = new ArrayList<>();
        this.orderPerRobot = new ArrayList<>();
        this.clients = new ArrayList<>();
        this.orders = new ArrayList<>();
        this.companyRegistry= new CompanyRegistry();
    }


    public void increaseComplexRegistry(){
        companyRegistry.increaseNumberOfComplex();
    }


    public void increaseSimpleRegistry(){
        companyRegistry.increasNumberOfSimplex();
    }


    public Company(ArrayList<Robot> robots, ArrayList<Client> clients, ArrayList<Order> orders){
        this.robotAssigner = new RobotAssigner();
        this.orderVerifyer = new OrderVerifyer();
        this.robots = new ArrayList<>();
        this.orderPerRobot = new ArrayList<>();
        this.clients = new ArrayList<>();
        this.orders = new ArrayList<>();
        this.robots.addAll(robots);
        this.clients.addAll(clients);
        this.orders.addAll(orders);
        this.robotAdjustmentFactor = 1;
        companyRegistry= new CompanyRegistry();
    }

    public CommunicationModuleReciver getCommunicationModuleReciver(){
        return this.communicationModuleReciver;
    }

    public PriceCalculator getPriceCalculator(){
        return this.priceCalculator;
    }

    public void recieveOrder(Order order){
        try
        {
            orderVerifyer.verifyOrder(order);
            robotAssigner.AssignRobot(order, robots, orderPerRobot);
        }

        catch (CouldNotVerifyOrderException.ServiceNotIncludedExeption e){
            System.out.println("No se pudo verificar la orden.");
        }
        catch (CouldNotVerifyOrderException.HasNoCreditsExeption e){
            System.out.println("No se pudo asignar el robot a la orden.");
        } catch (CouldNotAssignRobotException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

<<<<<<< Updated upstream
=======
    public int getSimpleOrdersContator() {
        return simpleOrdersContator;
    }

    public void createOrUpdateClient(Order order){
        ClientOrders clientRegister =findClient(order);

        if((clientRegister!=null)){
            clientRegister.getClientOrders().add(order);
        }
        else{
            ArrayList<Order> firstClientOrder = new ArrayList<Order>();
            firstClientOrder.add(order);
            getCompanyRegistry().getClientsAgenda().add(new ClientOrders(order.getClient(),firstClientOrder));
        }
    };

    public ClientOrders findClient(Order order){
        Stream<ClientOrders> a= companyRegistry.getClientsAgenda().stream().filter(
                (clientOrders -> order.getClient().getDni() == clientOrders.client.getDni()));
        return a.findFirst().orElse(null);
    }
    
    public int getComplexOrdersContator() {
        return complexOrdersContator;
    }


>>>>>>> Stashed changes
    public void setPriceCalculator(PriceCalculator priceCalculator) {
        this.priceCalculator = priceCalculator;
    }
    
    public float getRobotAdjustmentFactor() {
        return this.robotAdjustmentFactor;
    }

    public CompanyRegistry getCompanyRegistry() {
        return this.companyRegistry;
    }
    public void setRobotAdjustmentFactor(float robotAdjustmentFactor) {
        this.robotAdjustmentFactor = robotAdjustmentFactor;
    }
}
