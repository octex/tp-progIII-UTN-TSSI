package Order.FactoryCleanType;


import Order.Order;

public interface CleanType {
        Float calculatePrice(Order order);

    class ComplexClean implements CleanType {
        @Override
        public Float calculatePrice(Order order) {
            return null;
        }
    }
}

