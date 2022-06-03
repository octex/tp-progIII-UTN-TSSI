package Robots;

public abstract class Robot {

    protected String surface;

    protected float costPH;

    public Robot(String surface,float costPH){
        this.surface=surface;
        this.costPH=costPH;
    }



    public String getSurface(){
        return surface;
    }
    public float getCostPH(){
        return costPH;
    }


}
