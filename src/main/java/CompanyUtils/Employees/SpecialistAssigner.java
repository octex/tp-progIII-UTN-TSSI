package CompanyUtils.Employees;

import Order.Order;
import Order.Repairs.Repair;

public class SpecialistAssigner {

   void iterateOrder(Order order){
           order.getRepairsNeeded().forEach(repair ->
                   {
                       try {
                           order.getSpecialistsAssigned().add(getSpecialist(repair));
                       } catch (noHayEspecialistaExepcion e) {
                           e.printStackTrace();
                       }
                   }
           );
       }
   Specialist getSpecialist(Repair repair) throws noHayEspecialistaExepcion{
       Specialist specialistToAssign= SpecialistRegister.getSpecialists().stream().findFirst().filter(specialist -> specialist.canHandle(repair)).orElse(null);
       if(specialistToAssign ==null) {
           throw new noHayEspecialistaExepcion("No hay especialistas del tipo" + repair.getType());
       }else{
           return  specialistToAssign;
       }
   }

}
