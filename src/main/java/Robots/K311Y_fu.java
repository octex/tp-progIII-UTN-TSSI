package Robots.src.main.java.Robots;

public class K311Y_fu extends Robot {

    public K311Y_fu(){
        this.surface = "Muebles";
        this.canOrderRoom = false;
        this.canPolish = true;
        this.costPH = 500;
    }

    public String toString(){
        return "K311Y-fu";
    }
    
}