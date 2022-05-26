package Robots;

public abstract class Robot {

    protected String surface;
    private CommunicationModuleEmisor communicationModule;
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

    public void sendMessage(){
        this.communicationModule.readyMessage(this);
    }


}
