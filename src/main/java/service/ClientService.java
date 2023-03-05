package service;

import bl.SessionUtil;
import dao.ClientDAO;
import entity.Client;
import org.hibernate.query.Query;
import org.hibernate.*;
import java.util.List;
import java.sql.SQLException;

/**
 *  Created by Anton Muzhytskyi 28/02/2023.
 */

public class ClientService extends SessionUtil implements ClientDAO {

    @Override
    public void add(Client client) throws SQLException {
        //open session
        openTransactionSession();

        Session session= getSession();
        session.save(client);

        //close session
        closeTransactionSession();
    }

    @Override
    public List<Client> getAll() throws SQLException {
        //open session
        openTransactionSession();

        String sql = "SELECT * FROM CLIENT";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Client.class);
        List<Client> clientList = query.list();

        //close session
        closeTransactionSession();
        return clientList;
    }

    @Override
    public Client getById(Long id) throws SQLException {
        //open session
        openTransactionSession();

        String sql = "SELECT * FROM CLIENT WHERE ID =:id";
        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Client.class);
        query.setParameter("id",id);
        Client client =(Client) query.getSingleResult();

        //close session
        closeTransactionSession();
        return client;
    }

    @Override
    public void update(Client client) throws SQLException {
        //open session
        openTransactionSession();

        Session session= getSession();
        session.update(client);

        //close session
        closeTransactionSession();
    }

    @Override
    public void remove(Client client) throws SQLException {
        //open session
        openTransactionSession();

        Session session= getSession();
        session.remove(client);
        //close session
        closeTransactionSession();
    }
}
