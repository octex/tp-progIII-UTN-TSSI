package Client.Services;

public abstract class Service {

    protected int cleaningQuantity;
    protected int orderingQuantity;
    protected float serviceValue;
    protected float maxDebt;

    Service(int cleaningQuantity, int orderingQuantity, float serviceValue, float maxDebt){
        this.cleaningQuantity=cleaningQuantity;
        this.orderingQuantity=orderingQuantity;
        this.serviceValue=serviceValue;
        this.maxDebt=maxDebt;
    }
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
        return this.serviceValue;
    }
    
}
