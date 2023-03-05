package domain;

import bl.HibernateUtil;
import entity.Address;
import entity.Car;
import entity.Client;
import entity.Slot;
import org.hibernate.Session;
import java.util.Calendar;
import java.sql.Date;

/**
 *  Created by Anton Muzhytskyi 28/02/2023.
 */

public class Domain {
    public static void main(String[] args){

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        //address
        Address address = new Address();
        address.setCountry("Ukraine");
        address.setCity("Hostomel");
        address.setStreet("Velikih vuyok 56");
        address.setPostCode("qwe1234");

        //Client
        Client client= new Client();
        client.setTelephone("+380975420610");
        client.setFirstName("Volodimir");
        client.setLastName("Vili");

        Calendar birthday = Calendar.getInstance();
        birthday.set(1988, Calendar.MAY, 1);
        client.setBirthday(new Date(birthday.getTime().getTime()));
        client.setAddress(address);

        //slot
        Slot slot = new Slot();
        slot.setId(3l);

        Calendar rentStart = Calendar.getInstance();
        rentStart.set(2023, Calendar.MAY, 5);
        slot.setStartRent(new Date(rentStart.getTime().getTime()));

        Calendar rentEnd = Calendar.getInstance();
        rentEnd.set(2023, Calendar.MAY, 8);
        slot.setStartRent(new Date(rentStart.getTime().getTime()));
        slot.setRented(true);
        slot.setClient(client);

        //car
        Car car = new Car();
        car.setNumber("AP7479CP");
        car.setBrand("skoda");
        car.setModel("fabia");
        car.setColor("red");
        car.setSlot(slot);

        //Save all information
        session.save(address);
        session.save(client);
        session.save(slot);
        session.save(car);

        session.getTransaction().commit();
        HibernateUtil.shutdown();
    }
}
