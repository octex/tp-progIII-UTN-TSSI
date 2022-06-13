package CompanyUtils.PriceUtils;

import Order.Order;
import Order.FactoryCleanType.CleanType;

public class PriceCalculator {

    CleanType cleanTypeStrategy;

    public void setStrategy(CleanType cleanTypeStrategy){
        this.cleanTypeStrategy = cleanTypeStrategy;
    }

    public float getFinalPrice(Order order){
        return cleanTypeStrategy.calculatePrice(order);
    }
    

}
