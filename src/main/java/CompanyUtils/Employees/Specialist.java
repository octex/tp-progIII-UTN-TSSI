package CompanyUtils.Employees;

import Order.Order;
import Order.Repairs.Repair;

public interface Specialist {

    public float getSalary();
    public void repair();
    public boolean canHandle(Repair repair);

}
