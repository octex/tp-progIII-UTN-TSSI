package Order.FactoryCleanType;

import Order.Order;

public class SimpleClean implements CleanType{
    @Override

    public float calculatePrice(Order order){


        float sumatory;
        order.getRobots().stream().forEach(y -> sumatory += y.getCostPH());

        sumatory += (order.getSpecialist().getSalary() / 160) * order.getReparacion().getComplexity();

        sumatory += order.getReparacion().getCost();

        return sumatory;
    }
}
