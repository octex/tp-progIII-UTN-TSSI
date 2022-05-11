package Services;

public abstract class Service {

    protected int cleaningQuantity;
    protected int orderingQuantity;
    protected float orderValue;
    protected float maxDebt;

    public float getMaxDebt(){
        return this.maxDebt;
    }

    public float getOrderingQuantity(){
        return this.orderingQuantity;
    }

    public float getCleaningQuantity(){
        return this.cleaningQuantity;
    }

    public float getOrderValue(){
        return this.orderValue;
    }

    public String GetServiceName()
    {
        return this.getClass().toString();
    }
}
