package CompanyUtils.PriceUtils;

import Order.Order;
import Order.FactoryCleanType.CleanType;

public class PriceCalculator {

    CleanType cleanTypeStrategy;

    public PriceCalculator() {
    }

    public void setStrategy(CleanType cleanTypeStrategy){
        this.cleanTypeStrategy = cleanTypeStrategy;
    }

    public float getFinalPrice(Order order){
        return cleanTypeStrategy.calculatePrice(order);
    }


    public CleanType getCleanTypeStrategy() {
        return cleanTypeStrategy;
    }

    public void setCleanTypeStrategy(CleanType cleanTypeStrategy) {
        this.cleanTypeStrategy = cleanTypeStrategy;
    }
}
