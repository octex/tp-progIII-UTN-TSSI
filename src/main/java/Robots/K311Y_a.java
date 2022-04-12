package Robots;

public class K311Y_a extends Robot {

    public K311Y_a(){
        this.surface = "Pisos/Muebles";
        this.canOrderRoom = true;
        this.canPolish = true;
        this.costPH = 5000;
    }

    public String toString(){
        return "K311Y-a";
    }
    
}