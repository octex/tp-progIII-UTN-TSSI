package Robots;

public class K311Y_a extends Robot implements Polisher,RoomOrganizer {

    public K311Y_a(){
        this.surface = "Pisos/Muebles";
        this.canOrderRoom = true;  //Ver si cambiar esto o abajo
        this.canPolish = true;
        this.costPH = 5000;
    }

    @Override
    public void polish(Integer surface) {

    }

    @Override
    public void order(Integer surface) {

    }

    public String toString(){
        return "K311Y-a";
    }
}