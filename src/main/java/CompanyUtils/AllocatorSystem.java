package CompanyUtils;

import CompanyUtils.AllocatorSystemExeptions.HasNoCreditsExeption;
import CompanyUtils.AllocatorSystemExeptions.ServiceNotIncludedExeption;
import Robots.Robot;
import Order.Order;
import Client.Client;


public class AllocatorSystem
{
    private PaymentModule paymentModule;

    public AllocatorSystem(){
        this.paymentModule = null;
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
        switch (client.getService().getClass().getName()) {
            case "Platinum":
                return true;
            case "Classic":
                if (order.doesWantOrder() && client.getService().getOrderingQuantity() <= 0) {
                    throw new HasNoCreditsExeption("El cliente clasico no tiene creditos");
                } else {
                    return true;
                }
            case "Economic":
                if (client.getService().getCleaningQuantity() <= 0) {
                    throw new HasNoCreditsExeption("El cliente Economico no tiene creditos para limpieza");
                }else{
                    return true;
                }
        }


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
