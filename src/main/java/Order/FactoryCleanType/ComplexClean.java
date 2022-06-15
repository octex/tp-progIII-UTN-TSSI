package Order.FactoryCleanType;

import Order.Order;
import Robots.Robot;

public class ComplexClean implements CleanType{

    public void ComplexClean(float robotPlusValue){
        this.robotPlusValue = robotPlusValue;
    }

    private float robotPlusValue;

    public float calculatePrice(Order order){
        

        int horas = 3; //random

        float sumatory=0f;

        sumatory += (order.getSpecialist().getSalary() / 160) * order.getReparacion().getComplexity();
        
        sumatory += order.getReparacion().getCost();

        float robotCost = order.getRobots().stream().map(x -> x.getCostPH()).reduce(0f,(ans,i)-> ans + i);//forEach(y -> sumatory += (y.getCostPH() * horas * robotPlusValue));

        sumatory += robotCost * horas * robotPlusValue;

        return sumatory;
    }

}
