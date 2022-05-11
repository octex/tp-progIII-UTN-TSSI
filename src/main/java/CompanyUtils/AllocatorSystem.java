package CompanyUtils;

import CompanyUtils.AllocatorSystemExeptions.HasNoCreditsExeption;
import CompanyUtils.AllocatorSystemExeptions.ServiceNotIncludedExeption;
import Robots.Robot;
import Order.Order;
import Client.Client;


public class AllocatorSystem implements PaymentModule{

    public void TryAllocate(Order order){
        try
        {
            validateClientCredits(order);
            validateService(order);
        }
        catch (ServiceNotIncludedExeption | HasNoCreditsExeption e)
        {
            System.out.println(e.toString());
        }
    }

    private boolean validateService(Order order) throws ServiceNotIncludedExeption {
        if(order.doesWantOrder() && order.getClient().getService().getClass().getName().equals("Economic")){
            throw new ServiceNotIncludedExeption("El cliente economico no puede pedir orden Exeption");}
        else
            return true;
    }
    private boolean validateClientCredits(Order order) throws HasNoCreditsExeption {
        switch (order.getClient().getService().getClass().getName()) {
            case "Platinum":
                return true;
            case "Classic":
                if (order.doesWantOrder() && order.getClient().getService().getOrderingQuantity() <= 0) {
                    throw new HasNoCreditsExeption("El cliente clasico no tiene creditos");
                } else {
                    return true;
                }
            case "Economic":
                if (order.getClient().getService().getCleaningQuantity() <= 0) {
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


    @Override
    public float getDebt(Client client) {
        return 0;
    }
}
