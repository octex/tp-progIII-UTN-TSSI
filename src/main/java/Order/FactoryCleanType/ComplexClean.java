package Order.FactoryCleanType;

public class ComplexClean implements CleanType{

    public float calculatePrice(Order order){

        float sumatory = 0;

        order.getRobots().stream().forEach(y -> sumatory += y.getCostPH());

        sumatory += (order.getEmpleado().getSalary / 160) * order.getReparation().complexity;

        sumatory += order.getReparation().cost;

        return sumatory;
    }
    
}
