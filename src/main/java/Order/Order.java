package Order;

import Client.Client;
import Client.Location;
import CompanyUtils.Employees.Specialist;
import Order.FactoryCleanType.CleanData;
import Order.FactoryCleanType.CleanType;
import Order.Repairs.Repair;
import Robots.Robot;
import Robots.RobotRegister;
import Robots.Surface;

import java.util.ArrayList;

public class Order {

    private CleanType cleanType;
    private Location location;
    private boolean wantsPolish;
    private boolean wantsOrder;
    private Surface surface;
    private Client client;
    private ArrayList<Robot> robots;
    private ArrayList<Specialist> specialistsAssigned;
    private Specialist specialist;
    private ArrayList<Repair> repairNeeded;
    private CleanData cleanData;
    private float orderPrice;

    public Order() {

    }
    public void setSpecialist(Specialist specialist) {
        this.specialist = specialist;
    }


    public Order(Client client, CleanType cleanType, Location location, boolean wantsOrder, Surface surface){
        this.client = client;
        this.cleanType = cleanType;
        this.location = location;
        this.wantsOrder = wantsOrder;
        this.surface=surface;
        this.robots = new ArrayList<>();
        this.specialistsAssigned =new ArrayList<>();
    }
    public void setCleanData(CleanData cleanData) {
        this.cleanData = cleanData;
    }

    public CleanData getCleanData() {
        return cleanData;
    }

    public boolean doesWantPolish() {
        return wantsPolish;
    }

    public void setWantPolish(boolean wantsPolish) {
        this.wantsPolish = wantsPolish;
    }

    public CleanType getCleanType() {
        return cleanType;
    }

    public Location getLocation() {
        return location;
    }

    public boolean doesWantOrder() {
        return this.wantsOrder;
    }

    public void setWantsOrder(boolean wantsOrder) {
        this.wantsOrder = wantsOrder;
    }

    public Surface getSurface() {
        return surface;
    }

    public void setSurface(Surface surface) {
        this.surface = surface;
    }

    public Client getClient() {
        return client;
    }

    public float getOrderPrice() {
        return orderPrice;
    }
    public void setOrderPrice(float price) {
        this.orderPrice = price;
    }
    public void addOrderPrice(float price) {
        this.orderPrice += price;
    }
    

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setWantsPolish(boolean wantsPolish) {
        this.wantsPolish = wantsPolish;
    }

    public void setClient(Client client) {
        this.client = client;
    }


    public ArrayList<Robot> getRobots() { return robots; }

    public void addRobot(Robot robot) { robots.add(robot); }

    public ArrayList<Specialist> getSpecialistsAssigned() {
        return specialistsAssigned;
    }

    public void setSpecialistsAssigned(ArrayList<Specialist> specialistsAssigned) {
        this.specialistsAssigned = specialistsAssigned;
    }

    public ArrayList<Repair> getRepairsNeeded() {
        return repairNeeded;
    }

    public void assignSpecialist(Specialist specialist){
        this.specialistsAssigned.add(specialist);
    }
    public void setRepairsNeeded(ArrayList<Repair> repairNeeded) {
        this.repairNeeded = repairNeeded;
    }
}
