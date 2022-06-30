package CompanyUtils;

import Client.Client;
import CompanyUtils.Employees.SpecialistAssigner;
import CompanyUtils.OrderVerifyerExceptions.*;
import CompanyUtils.PriceUtils.PriceCalculator;
import CompanyUtils.RobotAssignerExceptions.*;
import Order.Order;
import Robots.Robot;
import Robots.RobotRegister;
import Services.Exeptions.OverpassesDebtExeption;

import java.util.*;
import java.util.stream.Stream;

import static org.mockito.Mockito.mock;


public class Company {
    private ArrayList<Robot> robots;
    private ArrayList<Client> clients;
    private ArrayList<Order> orders;
    private RobotAssigner robotAssigner;
    private OrderVerifyer orderVerifyer;
    private SpecialistAssigner specialistAssigner;
    private ArrayList<RobotRegister> orderPerRobot;
    private CommunicationModuleReciver communicationModuleReciver;
    private PriceCalculator priceCalculator;
    private float robotAdjustmentFactor;
    private CompanyRegistry companyRegistry;
    private PaymentModule paymentModule;
    private RegistryPrinter registryPrinter;


    public Company(ArrayList<Robot> robots, ArrayList<Client> clients, ArrayList<Order> orders)
    {
        this.robotAssigner = new RobotAssigner();
        this.specialistAssigner = new SpecialistAssigner();
        this.orderVerifyer = new OrderVerifyer();
        this.robots = new ArrayList<>();
        this.orderPerRobot = new ArrayList<>();
        this.clients = new ArrayList<>();
        this.orders = new ArrayList<>();
        this.robots.addAll(robots);
        this.clients.addAll(clients);
        this.orders.addAll(orders);
        this.robotAdjustmentFactor = 1;
        this.companyRegistry = new CompanyRegistry();
        this.paymentModule = mock(PaymentModule.class);
        this.registryPrinter = new RegistryPrinter(companyRegistry);
    }

    public CommunicationModuleReciver getCommunicationModuleReciver(){
        return this.communicationModuleReciver;
    }

    public PriceCalculator getPriceCalculator(){
        return this.priceCalculator;
    }

    public void recieveOrder(Order order) throws Exception
    {
        try
        {
            orderVerifyer.verifyOrder(order);
            robotAssigner.AssignRobot(order, robots, orderPerRobot);
            paymentModule.checkClientsDebt(order.getClient());
        }
        catch (OverpassesDebtExeption e)
        {
            System.out.println("Error de pago.");
            printExceptionReasonAndThrowBack(e);
        }
        catch (CouldNotVerifyOrderException.ServiceNotIncludedExeption e)
        {
            System.out.println("Error verificando el servicio del cliente.");
            printExceptionReasonAndThrowBack(e);
        }
        catch (CouldNotVerifyOrderException.HasNoCreditsExeption e)
        {
            System.out.println("Error de creditos.");
            printExceptionReasonAndThrowBack(e);
        }
        catch (CouldNotAssignRobotException e)
        {
            System.out.println("No se pudo asignar el robot a la orden.");
            printExceptionReasonAndThrowBack(e);
        }
        catch (Exception e)
        {
            System.out.println("Error inesperado procesando el pedido.");
            e.printStackTrace();
            printExceptionReasonAndThrowBack(e);
        }
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

    public void setPriceCalculator(PriceCalculator priceCalculator) {
        this.priceCalculator = priceCalculator;
    }
    
    public float getRobotAdjustmentFactor() {
        return this.robotAdjustmentFactor;
    }

    public CompanyRegistry getCompanyRegistry() {
        return this.companyRegistry;
    }

    public void setCompanyRegistry(CompanyRegistry companyRegistry) {
        this.companyRegistry = companyRegistry;
    }

    public void increaseComplexRegistry(){
        companyRegistry.increaseNumberOfComplex();
    }

    public void increaseSimpleRegistry(){
        companyRegistry.increasNumberOfSimplex();
    }

    public void setRobotAdjustmentFactor(float robotAdjustmentFactor) {
        this.robotAdjustmentFactor = robotAdjustmentFactor;
    }

    private void printExceptionReasonAndThrowBack(Exception e) throws Exception
    {
        System.out.println("Detalle: ");
        System.out.println(e.toString());
        throw e;
    }

    public PaymentModule getPaymentModule() {
        return paymentModule;
    }

    public RegistryPrinter getRegistryPrinter() {
        return this.registryPrinter;
    }
}
