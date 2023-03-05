package dao;

import entity.Slot;
import java.sql.SQLException;
import java.util.List;

/**
 *  Created by Anton Muzhytskyi 28/02/2023.
 */

public interface SlotDAO {
    //create
    void add (Slot slot) throws SQLException;
    //read
    List<Slot> getAll(Slot slot) throws SQLException;
    Slot getById(Long id) throws SQLException;
    //update
    void update (Slot slot) throws SQLException;
    //delete
    void remove (Slot slot) throws SQLException;
}
