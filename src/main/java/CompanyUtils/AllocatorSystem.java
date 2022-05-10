package CompanyUtils;

import CompanyUtils.AllocatorSystemExeptions.HasNoCreditsExeption;
import CompanyUtils.AllocatorSystemExeptions.ServiceNotIncludedExeption;
import Robots.Robot;
import Order.Order;
import Client.Client;


public class AllocatorSystem
{
    private PaymentModule paymentModule;

    public AllocatorSystem(PaymentModule paymentModule)
    {
        this.paymentModule = paymentModule;
    }

    public void TryAllocate(Order order, Client client)
    {

    }

    private boolean validateService(Order order, Client client) throws ServiceNotIncludedExeption {
        if(order.doesWantOrder() && client.getService().getClass().getName().equals("Economic")){
            throw new ServiceNotIncludedExeption("El cliente economico no puede pedir orden Exeption");}
        else
            return true;
    }
    private boolean validateClientCredits(Order order, Client client) throws HasNoCreditsExeption {
        if(client.getService().getClass().getName().equals("Economic")){
            throw new HasNoCreditsExeption("El cliente economico no puede pedir orden Exeption");}
        else
            return true;
    }


    private Robot GetRequiredRobot(Order order)
    {
        return null;
    }

    private Robot GetRequiredToPlatinumRobot(Order order)
    {
        return null;
    }
}
