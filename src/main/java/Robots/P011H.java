package Robots.src.main.java.Robots;

public class P011H extends Robot {

    public P011H(){
        this.surface = "Pisos";
        this.canOrderRoom = false;
        this.canPolish = true;
        this.costPH = 1500;
    }

    public String toString(){
        return "P011H";
    }
    
}