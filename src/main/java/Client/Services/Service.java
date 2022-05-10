package Client.Services;

public abstract class Service {


    protected float serviceValue;
    protected float maxDebt;

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
    
}
