package CompanyUtils;

import Client.Location;
import CompanyUtils.OrderVerifyerExceptions.CouldNotVerifyOrderException;
import Order.FactoryCleanType.CleanType;
import Order.FactoryCleanType.SimpleClean;
import Robots.*;
import Services.Classic;
import Services.Exeptions.ClassicOverpassesDebtExeption;
import Services.Exeptions.EconomicOverpassesDebtExeption;
import Services.Exeptions.OverpassesDebtExeption;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Order.*;
import Client.*;
import Services.*;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class CompanyTest
{
    Company company;
    PaymentModule paymentModule;

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
        paymentModule = company.getPaymentModule();
        Mockito.reset(paymentModule);
    }

    @Test
    void tryToSendOrderFromClassicWithDebt() throws OverpassesDebtExeption {
        CleanType cleanType = new SimpleClean();
        Location location = new Location("Buenos Aires", "Olivos", "Maipu");
        Service service = new Classic();
        Client client = new Client(111111111, service, Collections.singleton(location));
        Order order = new Order(client, cleanType, location, true, Surface.PISOS);

        Mockito.doThrow(new ClassicOverpassesDebtExeption("El cliente con servicio Classic supero la mora de $2000"))
                .when(paymentModule).checkClientsDebt(client);

        assertThrows(ClassicOverpassesDebtExeption.class , () -> {
            client.sendOrder(company, order);
        });
    }

    @Test
    void tryToSendOrderFromEconomicThrowCouldNotVerifyOrderException() {
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
    void tryToSendOrderFromToEconomicSuccess() {
        CleanType cleanType =  new SimpleClean();
        Location location = new Location("Buenos Aires", "Olivos", "Maipu");
        Service service = new Economic();
        Client client = new Client(111111111, service, Collections.singleton(location));
        Order order = new Order(client, cleanType, location, false, Surface.PISOS);

        assertDoesNotThrow(() -> client.sendOrder(company, order));
    }

    @Test
    void tryToSendOrderFromPlatinumClientSuccess()
    {
        CleanType cleanType =  new SimpleClean();
        Location location = new Location("Buenos Aires", "Olivos", "Maipu");
        Service service = new Platinum();
        Client client = new Client(111111111, service, Collections.singleton(location));
        Order order = new Order(client, cleanType, location, false, Surface.PISOS);

        assertDoesNotThrow(() -> client.sendOrder(company, order));
    }

    @Test
    void tryToSendOrderFromEconomicClientWithDebt() throws OverpassesDebtExeption
    {
        CleanType cleanType = new SimpleClean();
        Location location = new Location("Buenos Aires", "Olivos", "Maipu");
        Service service = new Economic();
        Client client = new Client(111111111, service, Collections.singleton(location));
        Order order = new Order(client, cleanType, location, false, Surface.PISOS);

        Mockito.doThrow(new EconomicOverpassesDebtExeption("El cliente con servicio Economic se encuentra moroso."))
                .when(paymentModule).checkClientsDebt(client);

        assertThrows(EconomicOverpassesDebtExeption.class , () -> {
            client.sendOrder(company, order);
        });
    }

    @Test
    void tryToSendOrderFromEconomicClientWithNoCleaningCredits()
    {
        CleanType cleanType = new SimpleClean();
        Location location = new Location("Buenos Aires", "Olivos", "Maipu");
        Service service = new Economic();
        Client client = new Client(111111111, service, Collections.singleton(location));
        Order order = new Order(client, cleanType, location, false, Surface.PISOS);
        assertDoesNotThrow(() -> client.sendOrder(company, order));
        assertDoesNotThrow(() -> client.sendOrder(company, order));
        assertDoesNotThrow(() -> client.sendOrder(company, order));
        assertThrows(CouldNotVerifyOrderException.HasNoCreditsExeption.class , () -> {
            client.sendOrder(company, order);
        });
    }

    @Test
    void tryToSendOrderFromClassicClientWithNoOrderingCredits()
    {
        CleanType cleanType = new SimpleClean();
        Location location = new Location("Buenos Aires", "Olivos", "Maipu");
        Service service = new Classic();
        Client client = new Client(111111111, service, Collections.singleton(location));
        Order order = new Order(client, cleanType, location, true, Surface.PISOS);
        assertDoesNotThrow(() -> client.sendOrder(company, order));
        assertDoesNotThrow(() -> client.sendOrder(company, order));
        assertDoesNotThrow(() -> client.sendOrder(company, order));
        assertThrows(CouldNotVerifyOrderException.HasNoCreditsExeption.class , () -> {
            client.sendOrder(company, order);
        });
    }

    @Test
    void tryToSendOrderWithElectricalRepairOk()
    {

    }

    @Test
    void tryToSendOrderWithGasRepairOk()
    {

    }

    @Test
    void tryToSendOrderWithElectricalRepairWithNoEmployeesAvailable()
    {

    }

    @Test
    void tryToSendOrderWithGasRepairWithNoEmployeesAvailable()
    {

    }

    @Test
    void tryToSendOrderExpectsASimpleClean()
    {

    }

    @Test
    void tryToSendOrderExpectsAComplexClean()
    {

    }
}