package Robots;


public class S031RTY extends Robot implements RoomOrganizer{

    public S031RTY(){
        this.surface = "N/A";
        this.canOrderRoom = true;
        this.canPolish = false;
        this.costPH = 2700;
    }

    @Override
    public void order(Integer surface) {

    }

    public String toString(){
        return "S031RTY";
    }
    
}