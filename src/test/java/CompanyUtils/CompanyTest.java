package CompanyUtils;

import Client.Location;
import Services.Classic;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Order.*;
import Client.*;
import Services.*;
import CompanyUtils.Company;
//import org.mockito.internal.matchers.Or;

import java.util.Collection;

import static Order.CleanType.SIMPLE;
import static org.junit.jupiter.api.Assertions.*;

class CompanyTest {
    Company company;

    @BeforeEach
    void setUp() {
        company = new Company();
    }

    @Test
    void tryToAssignRobotToClassicThrowCouldNotVerifyOrderException() {
        CleanType cleanType =  CleanType.SIMPLE;
        Location location = new Location("Buenos Aires", "Olivos", "Maipu");
        Service service = new Classic();
        Client client = new Client(111111111, service, (Collection) location);
        Order order = new Order(client, cleanType, location, true, "madera");

        assertThrows(CouldNotCreateOrderException.class , () -> {
            company.tryToAssign(order);
        });
    }

    @Test
    void tryToAssignRobotToEconomicThrowCouldNotVerifyOrderException() {
        CleanType cleanType =  CleanType.SIMPLE;
        Location location = new Location("Buenos Aires", "Olivos", "Maipu");
        Service service = new Economic();
        Client client = new Client(111111111, service, (Collection) location);
        Order order = new Order(client, cleanType, location, true, "madera");

        assertThrows(CouldNotCreateOrderException.class , () -> {
            company.tryToAssign(order);
        });
    }

    @Test
    void tryToAssignRobotToEconomicDontThrowCouldNotVerifyOrderException() {
        CleanType cleanType =  CleanType.SIMPLE;
        Location location = new Location("Buenos Aires", "Olivos", "Maipu");
        Service service = new Economic();
        Client client = new Client(111111111, service, (Collection) location);
        Order order = new Order(client, cleanType, location, true, "madera");

        assertThrows(CouldNotCreateOrderException.class , () -> {
            company.tryToAssign(order);
        });
    }


}