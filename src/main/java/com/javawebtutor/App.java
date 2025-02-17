package com.javawebtutor;
import java.util.ArrayList;
import java.util.Date;

import com.javawebtutor.entities.User;
import com.javawebtutor.dao.UserDao;
import com.javawebtutor.utils.HibernateUtil;
import org.hibernate.Session;
import java.util.List;

public class App {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        ArrayList<User> users = new ArrayList<User>();
        users.add(new User(1, "Fahad", "Vaulsys", new Date()));
        try {
            System.out.println("Timeout...");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        users.add(new User(2, "Ali", "Vaulsys", new Date()));

        for ( User user: users ) {
            session.save(user);
        }

        session.getTransaction().commit();

        List<User> results = UserDao.getAllUsers();
        results.forEach(u -> System.out.println(u.getUserId() + " - " + u.getUsername() + " - " + u.getCreatedBy() + " - " + u.getCreatedDate()));
    }
}