package Order.FactoryCleanType;

import Order.Order;

public class ComplexClean implements CleanType{

    public void ComplexClean(float robotPlusValue){
        this.robotPlusValue = robotPlusValue;
    }

    private float robotPlusValue;

    public float calculatePrice(Order order){

        float sumatory = 0;

        int horas = 3; //random

        order.getRobots().stream().forEach(y -> sumatory += (y.getCostPH() * horas * robotPlusValue));

        sumatory += (order.getEmpleado().getSalary() / 160) * order.getReparacion().getComplexity();

        sumatory += order.getReparacion().getCost();

        return sumatory;
    }

}
