package Services;

import Services.Exeptions.OverpassesDebtExeption;

public abstract class Service{

    protected int cleaningQuantity;
    protected int orderingQuantity;
    protected float orderValue;
    protected float maxDebt;
     public abstract boolean overpassesDebtLimit(float clientDebt) throws OverpassesDebtExeption;
    public void setMaxDebt(float maxDebt) {
        this.maxDebt = maxDebt;
    }

    public float getMensualFee() {
        return mensualFee;
    }

    public void setMensualFee(float mensualFee) {
        this.mensualFee = mensualFee;
    }

    protected float mensualFee;



    public float getOrderingQuantity(){
        return this.orderingQuantity;
    }

    public float getCleaningQuantity(){
        return this.cleaningQuantity;
    }

    public float getOrderValue(){
        return this.orderValue;
    }

    public String getServiceName()
    {
        return this.getClass().getName().replace("Services.", "");
    }

    public void setCleaningQuantity(int cleaningQuantity) {
        this.cleaningQuantity = cleaningQuantity;
    }

    public void setOrderingQuantity(int orderingQuantity) {
        this.orderingQuantity = orderingQuantity;
    }

    public void setOrderValue(float orderValue) {
        this.orderValue = orderValue;
    }


}
