package com.javawebtutor.dao;

import com.javawebtutor.entities.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class UserDao {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("examplePU");

    public static List<User> getAllUsers() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<User> query = em.createQuery("SELECT b FROM Example b", User.class);
        List<User> users = query.getResultList();
        em.close();
        return users;
    }
}
