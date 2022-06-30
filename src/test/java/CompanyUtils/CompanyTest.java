package CompanyUtils;

import Client.Location;
import CompanyUtils.OrderVerifyerExceptions.CouldNotVerifyOrderException;
import Order.FactoryCleanType.CleanType;
import Order.FactoryCleanType.SimpleClean;
import Robots.*;
import Services.Classic;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Order.*;
import Client.*;
import Services.*;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class CompanyTest
{
    Company company;

    @BeforeEach
    void setUp()
    {
        ArrayList<Robot> robots = new ArrayList<>();
        Robot k311Yfu;
        Robot k311Ya;
        Robot po11h;
        Robot so31rty;
        Robot k311yfl;

        k311Yfu = new K311Y_fu();
        k311Ya = new K311Ya();
        po11h = new P011H();
        so31rty = new S031RTY();
        k311yfl = new K311Y_fl();

        robots.add(k311Yfu);
        robots.add(k311Ya);
        robots.add(po11h);
        robots.add(so31rty);
        robots.add(k311yfl);

        company = new Company(robots, new ArrayList<>(), new ArrayList<>());
    }

    @Test
    void tryToAssignRobotToClassicThrowCouldNotVerifyOrderException() {
        CleanType cleanType = new SimpleClean();
        Location location = new Location("Buenos Aires", "Olivos", "Maipu");
        Service service = new Classic();
        Client client = new Client(111111111, service, Collections.singleton(location));
        Order order = new Order(client, cleanType, location, true, Surface.PISOS);

        assertThrows(CouldNotVerifyOrderException.class , () -> {
            client.sendOrder(company, order);
        });
    }

    @Test
    void tryToAssignRobotToEconomicThrowCouldNotVerifyOrderException() {
        CleanType cleanType = new SimpleClean();
        Location location = new Location("Buenos Aires", "Olivos", "Maipu 233");
        Service service = new Economic();
        Client client = new Client(111111111, service, Collections.singleton(location));
        Order order = new Order(client, cleanType, location, true, Surface.PISOS);

        assertThrows(CouldNotVerifyOrderException.ServiceNotIncludedExeption.class , () -> {
            client.sendOrder(company, order);
        });
    }

    @Test
    void tryToAssignRobotToEconomicDontThrowCouldNotVerifyOrderException() {
        CleanType cleanType =  new SimpleClean();
        Location location = new Location("Buenos Aires", "Olivos", "Maipu");
        Service service = new Economic();
        Client client = new Client(111111111, service, Collections.singleton(location));
        Order order = new Order(client, cleanType, location, true, Surface.PISOS);

        assertThrows(CouldNotVerifyOrderException.class , () -> {
            client.sendOrder(company, order);
        });
    }
}