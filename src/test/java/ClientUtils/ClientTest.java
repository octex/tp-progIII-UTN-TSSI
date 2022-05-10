package ClientUtils;

import java.beans.Transient;

import CompanyUtils.AllocatorSystemExeptions.ServiceNotIncludedExeption;
import Client.Client;
import CompanyUtils.Company;
import Order.CleanType;
import Order.Order;
import Order.CleanType;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import Services.Economic;

public class ClientTest {

        @Test
        void economicLimpiezaOrdenamiento(){
            var client = new Client(111, new Economic(), null);

            assertThrows(ServiceNotIncludedExeption.class, ()->{
                         client.requestOrder(new Company(), new Order(client, SIMPLE, null, true, "a"));
            });
        }

}
