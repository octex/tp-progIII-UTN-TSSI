package Services;

import CompanyUtils.AllocatorSystemExeptions.HasNoCreditsExeption;
import CompanyUtils.AllocatorSystemExeptions.ServiceNotIncludedExeption;
import Order.Order;
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

    public boolean validateService(Order order) throws ServiceNotIncludedExeption {
        if(order.doesWantOrder() && order.getClient().getService().getServiceName().equals("Economic")){
            throw new ServiceNotIncludedExeption("El cliente economico no puede pedir orden Exeption");}
        else
            return true;
    }

    public boolean validateClientCredits(Order order) throws HasNoCreditsExeption{
     if (order.getClient().getService().getCleaningQuantity() <= 0) {
        throw new HasNoCreditsExeption("El cliente Economico no tiene creditos para limpieza");
    }else{

        return true;
    }
    }
}