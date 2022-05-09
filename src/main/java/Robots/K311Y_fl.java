package Robots;

public class K311Y_fl extends Robot {

    public K311Y_fl(){
        this.surface = "Pisos";
        this.canOrderRoom = false;
        this.canPolish = false;
        this.costPH = 1000;
    }

    public String toString(){
        return "K311Y-fl";
    }
    
}
