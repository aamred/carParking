package dao;

import entity.Car;
import java.sql.SQLException;
import java.util.List;

/**
 *  Created by Anton Muzhytskyi 28/02/2023.
 */

public interface CarDAO {
    //create
    void add (Car car) throws SQLException;
    //read
    List<Car> getAll(Car car) throws SQLException;
    Car getById(Long id) throws SQLException;
    //update
    void update (Car car) throws SQLException;
    //delete
    void remove (Car car) throws SQLException;
}
