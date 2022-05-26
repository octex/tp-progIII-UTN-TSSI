package Services;

import Services.Exeptions.EconomicOverpassesDebtExeption;

public class Classic extends Service  {

    public Classic(){
        this.cleaningQuantity = -1;
        this.orderingQuantity = 3;
        this.orderValue = 0;
        this.maxDebt = 0;
    }


    public boolean overpassesDebtLimit(float clientDebt) throws EconomicOverpassesDebtExeption {
        if(clientDebt>2001){
            throw new EconomicOverpassesDebtExeption("El usuario clasico tiene deuda, por lo tanto no puede ordenar");
        }else {
            return true;
        }
    }

}