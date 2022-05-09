package Robots;

public class K311Y_fu extends Robot  implements Polisher{

    public K311Y_fu(){
        this.surface = "Muebles";
        this.canOrderRoom = false;
        this.canPolish = true;
        this.costPH = 500;
    }

    @Override
    public void polish(Integer surface) {

    }

    public String toString(){
        return "K311Y-fu";
    }
    
}