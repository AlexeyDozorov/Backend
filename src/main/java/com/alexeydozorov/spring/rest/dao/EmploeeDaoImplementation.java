package com.alexeydozorov.spring.rest.dao;

import com.alexeydozorov.spring.rest.entity.Emploee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class EmploeeDaoImplementation implements EmploeeDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Emploee> getAllEmployees() {
        Session session = sessionFactory.getCurrentSession();
        List<Emploee> allEmp = session.createQuery("FROM Emploee", Emploee.class).getResultList();
        return allEmp;
    }

    @Override
    public void saveEmloee(Emploee emploee) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(emploee);
    }

    @Override
    public Emploee getEmploee(int id) {
        Session session = sessionFactory.getCurrentSession();
        Emploee emploee = session.get(Emploee.class, id);
        return emploee;
    }

    @Override
    public void deleteEmploee(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Emploee> query = session.createQuery("DELETE FROM Emploee WHERE id =:emloeeId");
        query.setParameter("emloeeId", id);
        query.executeUpdate();
    }
}
