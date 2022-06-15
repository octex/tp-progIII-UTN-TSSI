package Order.FactoryCleanType;

import Order.Order;

public class SimpleClean implements CleanType{
    @Override

    public float calculatePrice(Order order){

        float sumatory = 0;

        order.getRobots().stream().forEach(y -> sumatory += y.getCostPH());

        sumatory += (order.getEmpleado().getSalary() / 160) * order.getReparacion().complexity();

        sumatory += order.getReparacion().cost();

        return sumatory;
    }
}
