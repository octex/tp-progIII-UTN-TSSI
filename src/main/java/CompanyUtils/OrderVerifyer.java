package CompanyUtils;

import CompanyUtils.OrderVerifyerExceptions.CouldNotVerifyOrderException;
import Robots.Robot;
import Order.Order;
import Client.Client;


public class OrderVerifyer implements PaymentModule{

    public void verifyOrder(Order order) throws Exception{
        try
        {
            order.getClient().getService().validateClientCredits(order);
            order.getClient().getService().validateService(order);
        }
        catch (CouldNotVerifyOrderException.ServiceNotIncludedExeption | CouldNotVerifyOrderException.HasNoCreditsExeption e)
        {
            System.out.println(e.toString());
            throw e;
        }
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