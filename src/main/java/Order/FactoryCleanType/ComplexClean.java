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

        float robotCost = order.getRobots().stream().map(x -> x.getCostPH()).reduce(0f,(ans,i)-> ans + i);

        sumatory += robotCost * horas * robotPlusValue;

        return sumatory;
    }

}
