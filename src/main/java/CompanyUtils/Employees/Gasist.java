package CompanyUtils.Employees;

import Order.Order;
import Order.Repairs.Repair;

import java.util.Objects;

public class Gasist implements Specialist {

    float salary;
    String name;

    public Gasist(float salary, String name) {
        this.salary = salary;
        this.name = name;
    }


    @Override
    public void repair() {
    }
    public boolean canHandle(Repair repair) {
        return Objects.equals(repair.getType(), "Gas");
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
