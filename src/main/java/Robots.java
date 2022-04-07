public abstract class Robots {
    public Robots(){

    }

    private String surface;
    private boolean canOrder;
    private boolean canPolish;
    private float costPH;

    public String getSurface(){
        return surface;
    }
    public boolean getCanOrder(){
        return canOrder;
    }
    public boolean getCanPolish(){
        return canPolish;
    }
    public float getCostPH(){
        return costPH;
    }
}
