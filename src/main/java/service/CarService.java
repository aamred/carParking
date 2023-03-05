package service;

import dao.CarDAO;
import entity.Car;
import bl.SessionUtil;
import org.hibernate.query.Query;
import org.hibernate.*;
import java.util.List;
import java.sql.SQLException;

/**
 *  Created by Anton Muzhytskyi 28/02/2023.
 */

public class CarService extends SessionUtil implements CarDAO {

    @Override
    public void add(Car car) throws SQLException {
        //open session
        openTransactionSession();

        Session session= getSession();
        session.save(car);

        //close session
        closeTransactionSession();
    }

    @Override
    public List<Car> getAll(Car car) throws SQLException {
        //open session
        openTransactionSession();

        String sql = "SELECT * FROM CAR";

        Session session = getSession();
        Query query = session.getNamedNativeQuery(sql).addEntity(Car.class);
        List<Car> carList = query.list();

        //close session
        closeTransactionSession();
        return null;
    }

    @Override
    public Car getById(Long id) throws SQLException {
        //open session
        openTransactionSession();

        String sql = "SELECT * FROM CAR ID = :id";

        Session session = getSession();
        Query query = session.getNamedNativeQuery(sql).addEntity(Car.class);
        query.setParameter("id", id);

        Car car = (Car) query.getSingleResult();

        //close session
        closeTransactionSession();
        return car;
    }

    @Override
    public void update(Car car) throws SQLException {
        //open session
        openTransactionSession();

        Session session= getSession();
        session.update(car);

        //close session
        closeTransactionSession();
    }

    @Override
    public void remove(Car car) throws SQLException {
        //open session
        openTransactionSession();

        Session session= getSession();
        session.delete(car);

        //close session
        closeTransactionSession();
    }
}
