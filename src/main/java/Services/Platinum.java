package Services;

import CompanyUtils.AllocatorSystemExeptions.HasNoCreditsExeption;
import CompanyUtils.AllocatorSystemExeptions.ServiceNotIncludedExeption;
import Order.Order;

import Services.Exeptions.PlatinumOverpassesDebtExeption;

public class Platinum extends Service {

    public Platinum(){
        this.cleaningQuantity = -1;
        this.orderingQuantity = -1;
        this.orderValue = 0;
        this.mensualFee=3000;
        this.maxDebt = mensualFee;
    }




    @Override
    public boolean overpassesDebtLimit(float clientDebt) throws PlatinumOverpassesDebtExeption {
        if(clientDebt>maxDebt){
            throw new PlatinumOverpassesDebtExeption("Platino tiene deuda");
        }
        return true;

    }
    public boolean validateService(Order order) throws ServiceNotIncludedExeption {
        return true;
}

    @Override
    public boolean validateClientCredits(Order order) throws HasNoCreditsExeption {

            return true;

    }
}
