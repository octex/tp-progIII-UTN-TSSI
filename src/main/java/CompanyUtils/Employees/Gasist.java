package CompanyUtils.Employees;

public class Gasist implements Specialist {

    float salary;
    String name;


    @Override
    public void repair() {
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
