package com.javawebtutor.dao;

import com.javawebtutor.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class UserDao {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("examplePU");

    public static void saveUser(User user) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
        System.out.println("User saved!");
        em.close();
    }

    public static void deleteUser(int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        User user = em.find(User.class, id);
        if (user != null) {
            em.remove(user);
        } else {
            System.out.println("User does not exit!");
            em.close();
            return;
        }
        em.getTransaction().commit();
        System.out.println("User deleted!");
        em.close();
    }

    public static void updateUser(User user) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(user);
        em.getTransaction().commit();
        System.out.println("User updated!");
        em.close();
    }

    public static List<User> getAllUsers() {
        EntityManager em = emf.createEntityManager();
        List<User> users = em.createQuery("SELECT u FROM User u", User.class).getResultList();
        em.close();
        return users;
    }

    public static List getAllDates() {
        EntityManager em = emf.createEntityManager();
        List list = em.createNativeQuery("SELECT to_char(CREATED_DATE, 'YYYY-MM-DD HH24:MI:SS') FROM User")
                .getResultList();
        em.close();
        return list;
    }
}
