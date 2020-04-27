package com.gridu.BEProgram.DAOs;

import com.gridu.BEProgram.entities.Dog;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "DogDAO")
public class DogDAOImpl implements DogDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Dog> allDogs() {
        Session session = sessionFactory.getCurrentSession();
        List<Dog> list = session.createQuery("from Dog").list();
        return list;
    }

    @Override
    public Dog add(Dog dog) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(dog);
        return dog;
    }

    @Override
    public Dog delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        Dog dog = (Dog)session.load(Dog.class,id);
        session.delete(dog);
        return dog;
    }

    @Override
    public Dog edit(Dog dog) {
        Session session = sessionFactory.getCurrentSession();
        session.update(dog);
        return dog;
    }

    @Override
    public Dog getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Dog.class, id);
    }
}
