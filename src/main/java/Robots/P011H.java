package Robots;


public class P011H extends Robot implements Polisher{

    public P011H(){
        this.surface = "Pisos";
        this.canOrderRoom = false;
        this.canPolish = true;
        this.costPH = 1500;
    }

    @Override
    public void polish(Integer surface) {

    }

    public String toString(){
        return "P011H";
    }
    
}