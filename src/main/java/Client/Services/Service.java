package Client.Services;

public abstract class Service {


    protected float serviceValue;
    protected float maxDebt;
    protected int orderingPerMonth;
    protected int cleaningPerMonth;
    Service(float serviceValue, float maxDebt){

        this.serviceValue=serviceValue;
        this.maxDebt=maxDebt;
    }
    public float getMaxDebt(){
        return this.maxDebt;
    }



    public float getOrderValue(){
        return this.serviceValue;
    }

    public float getServiceValue() {
        return serviceValue;
    }

    public void setServiceValue(float serviceValue) {
        this.serviceValue = serviceValue;
    }

    public void setMaxDebt(float maxDebt) {
        this.maxDebt = maxDebt;
    }

    public int getOrderingPerMonth() {
        return orderingPerMonth;
    }

    public void setOrderingPerMonth(int orderingPerMonth) {
        this.orderingPerMonth = orderingPerMonth;
    }

    public int getCleaningPerMonth() {
        return cleaningPerMonth;
    }

    public void setCleaningPerMonth(int cleaningPerMonth) {
        this.cleaningPerMonth = cleaningPerMonth;
    }
}
