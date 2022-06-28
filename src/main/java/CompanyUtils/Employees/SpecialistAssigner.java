package CompanyUtils.Employees;

import Order.Order;
import Order.Repairs.Repair;

public class SpecialistAssigner {

   public void iterateOrder(Order order){
           order.getRepairsNeeded().forEach(repair ->
                   {
                       try {
                           order.assignSpecialist(getRequiredSpecialist(repair));
                       } catch (NoHayEspecialistaExepcion e) {
                           e.printStackTrace();

                       }
                   }
           );
       }
       public Specialist getRequiredSpecialist(Repair repair) throws NoHayEspecialistaExepcion {

       Specialist specialistToAssign= SpecialistRegister.getSpecialists().stream().filter(specialist -> specialist.canHandle(repair)).findFirst().orElse(null);
       if(specialistToAssign ==null) {
           throw new NoHayEspecialistaExepcion("No hay especialistas del tipo" + repair.getType());
       }else{
           return  specialistToAssign;
       }
   }

}