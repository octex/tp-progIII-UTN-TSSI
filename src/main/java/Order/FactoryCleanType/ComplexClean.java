package Order.FactoryCleanType;

import Order.Order;

public class ComplexClean implements CleanType{

    public void ComplexClean(float robotPlusValue){
        this.robotPlusValue = robotPlusValue;
    }

    private float robotPlusValue;

    public float calculatePrice(Order order){
        

        int horas = 3; //random

        float sumatory=0f;
        order.getRobots().stream().forEach(y -> sumatory += (y.getCostPH() * horas * robotPlusValue));

        sumatory += (order.getSpecialist().getSalary() / 160) * order.getReparacion().getComplexity();

        sumatory += order.getReparacion().getCost();

        return sumatory;
    }

}
