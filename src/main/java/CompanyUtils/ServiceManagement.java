package CompanyUtils;



import Services.Exeptions.OverpassesDebtExeption;
import Services.Service;
import org.junit.jupiter.api.function.Executable;


public final class ServiceManagement {
    private static ServiceManagement serviceInstance;

    public int getCostumerDebt() {
        return costumerDebt;
    }

    public void setCostumerDebt(int costumerDebt) {
        this.costumerDebt = costumerDebt;
    }

    int costumerDebt;
    private ServiceManagement(){

    }

    public static ServiceManagement getInstance() {
        if(serviceInstance == null) {
            serviceInstance = new ServiceManagement();
        }

        return serviceInstance;
    }

    int seekDebt(int customerDebt){
        return customerDebt;
    }

    public Executable debtSucceded(Service servicioCliente, int customerDebt ) throws OverpassesDebtExeption{
        try {
            servicioCliente.overpassesDebtLimit(seekDebt(customerDebt));

        }
        catch (OverpassesDebtExeption e) {
            System.out.println(e.getMessage());
            throw new OverpassesDebtExeption("Error en el modulo de pagos");
        }

        return null;
    }

}
