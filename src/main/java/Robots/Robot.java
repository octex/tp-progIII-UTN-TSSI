package Robots;
public abstract class Robot {
    public Robot(){

    }

    protected String surface;
    protected boolean canOrderRoom;
    protected boolean canPolish;
    protected float costPH;

    public String getSurface(){
        return surface;
    }
    public boolean getcanOrderRoom(){
        return canOrderRoom;
    }
    public boolean getCanPolish(){
        return canPolish;
    }
    public float getCostPH(){
        return costPH;
    }
}
