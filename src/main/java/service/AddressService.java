package service;

import dao.AddressDAO;
import entity.Address;
import bl.SessionUtil;
import org.hibernate.query.Query;
import org.hibernate.*;
import java.util.List;
import java.sql.SQLException;

/**
 *  Created by Anton Muzhytskyi 28/02/2023.
 */

public class AddressService extends SessionUtil implements AddressDAO {

    @Override
    public void add(Address address) throws SQLException {
        //open session
        openTransactionSession();

        Session session = getSession();
        session.save(address);

        //close session
        closeTransactionSession();
    }

    @Override
    public List<Address> getAll() throws SQLException {
        //open session
        openTransactionSession();

        String sql = "SELECT * FROM ADDRESS";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Address.class);
        List<Address> addressList = query.list();

        //close session
        closeTransactionSession();
        return addressList;
    }

    @Override
    public Address getById(Long id) throws SQLException {
        //open session
        openTransactionSession();

        String sql = "SELECT * FROM ADDRESS WHERE ID = :id";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Address.class);
        query.setParameter("id", id);
        Address address = (Address) query.getSingleResult();

        //close session
        closeTransactionSession();
        return address;
    }

    @Override
    public void update(Address address) throws SQLException {
        //open session
        openTransactionSession();

        Session session = getSession();
        session.update(address);

        //close session
        closeTransactionSession();
    }

    @Override
    public void remove(Address address) throws SQLException {
        //open session
        openTransactionSession();

        Session session = getSession();
        session.delete(address);

        //close session
        closeTransactionSession();
    }
}
