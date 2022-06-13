package Order.FactoryCleanType;

import Order.Order;

public class SimpleClean implements CleanType{
    @Override

    public Float calculatePrice(Order order){

        float sumatory = 0;

        order.getRobots().stream().forEach(y -> sumatory += y.getCostPH());

        sumatory += (order.getEmpleado().getSalary / 160) * order.getReparation().complexity;

        sumatory += order.getReparation().cost;

        return sumatory;
    }
