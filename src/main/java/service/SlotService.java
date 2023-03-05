package service;

import dao.SlotDAO;
import entity.Slot;
import bl.SessionUtil;
import org.hibernate.query.Query;
import org.hibernate.*;
import java.util.List;
import java.sql.SQLException;

/**
 *  Created by Anton Muzhytskyi 28/02/2023.
 */

public class SlotService extends SessionUtil implements SlotDAO {

    @Override
    public void add(Slot slot) throws SQLException {
        //open session
        openTransactionSession();

        Session session = getSession();
        session.save(slot);

        //close session
        closeTransactionSession();
    }

    @Override
    public List<Slot> getAll(Slot slot) throws SQLException {
        //open session
        openTransactionSession();

        String sql = "SELECT * FROM SLOT";

        Session session =getSession();
        Query query = session.createNativeQuery(sql).addEntity(Slot.class);
        List<Slot> slotList= query.list();

        //close session
        closeTransactionSession();
        return slotList;
    }

    @Override
    public Slot getById(Long id) throws SQLException {
        //open session
        openTransactionSession();

        String sql = "SELECT * FROM SLOT WHERE ID = :id";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Slot.class);
        query.setParameter("id", id);

        Slot slot = (Slot) query.getSingleResult();
        //close session
        closeTransactionSession();
        return slot;
    }

    @Override
    public void update(Slot slot) throws SQLException {
        //open session
        openTransactionSession();

        Session session = getSession();
        session.update(slot);

        //close session
        closeTransactionSession();
    }

    @Override
    public void remove(Slot slot) throws SQLException {
        //open session
        openTransactionSession();

        Session session = getSession();
        session.remove(slot);

        //close session
        closeTransactionSession();
    }
}
