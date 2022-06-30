package CompanyUtils.Employees;

import Order.Order;
import Order.Repairs.Repair;

public class SpecialistAssigner
{
    private final SpecialistRegister specialistRegister;

    public SpecialistAssigner()
    {
        specialistRegister = SpecialistRegister.getInstance();
    }

    public void iterateOrder(Order order) throws NoHayEspecialistaExepcion {

        order.getRepairsNeeded().forEach(repair ->
                {
                    try {
                        order.assignSpecialist(getRequiredSpecialist(repair));

                    } catch (NoHayEspecialistaExepcion e) {
                        System.out.println(e.getMessage());
                    }
                }
        );

        if (order.getRepairsNeeded().size() != order.getSpecialistsAssigned().size()) {
            throw new NoHayEspecialistaExepcion("Falta un especialista");
        }
    }
    public Specialist getRequiredSpecialist(Repair repair) throws NoHayEspecialistaExepcion
    {
        Specialist specialistToAssign = specialistRegister.getSpecialists().stream().filter(specialist -> specialist.canHandle(repair)).findFirst().orElse(null);
        if(specialistToAssign == null)
        {
            throw new NoHayEspecialistaExepcion("No hay especialistas del tipo" + repair.getType());
        }
        else
        {
            return  specialistToAssign;
        }
    }

}
