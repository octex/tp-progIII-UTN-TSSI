package CompanyUtils;

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

    private Robot GetRequiredRobot(Order order)
    {
        return null;
    }

    private Robot GetRequiredToPlatinumRobot(Order order)
    {
        return null;
    }
}
