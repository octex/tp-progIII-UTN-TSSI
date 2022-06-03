package Services;

import Services.Exeptions.OverpassesDebtExeption;
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
}
