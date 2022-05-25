package Services;

import Services.Exeptions.EconomicOverpassesDebtExeption;

public class Economic extends Service  {

    public Economic(){
            this.cleaningQuantity = 3;
            this.orderingQuantity = 3;
            this.orderValue = 0;


    }


    @Override
    public boolean overpassesDebtLimit(float clientDebt) throws EconomicOverpassesDebtExeption {
        if(clientDebt>0){
            throw new EconomicOverpassesDebtExeption("Cliente economico se paso");
        }else{
            return true;
        }
    }
}