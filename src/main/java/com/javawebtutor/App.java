package com.javawebtutor;
import java.util.Date;

import com.javawebtutor.entity.User;
import com.javawebtutor.dao.UserDao;
import java.util.ArrayList;
import java.util.List;

import com.javawebtutor.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class App {
    public static void main(String[] args) {

        //hibernate
//        ArrayList<User> users = new ArrayList<>();
//        users.add(new User(1, "Fahad", "Vaulsys", new Date()));
//        try {
//            System.out.println("Timeout...");
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        users.add(new User(2, "Ali", "Vaulsys", new Date()));
//        Transaction transaction = null;
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        transaction = session.beginTransaction();
//        for ( User user: users ) {
//            session.save(user);
//        }
//        transaction.commit();
//
//        List<User> result = session.createQuery("from example", User.class).list();
//        result.forEach(u -> System.out.println(u.getUsername()));

        User user1 = new User(1, "Fahad", "Vaulsys", new Date());
        User user2 = new User(2, "Ali", "Vaulsys", new Date());
        UserDao.saveUser(user1);
        System.out.println("User 1 saved.");
        UserDao.saveUser(user2);
        System.out.println("User 2 saved.");
        List<User> results = UserDao.getAllUsers();
        System.out.println();
        results.forEach(u -> System.out.println(u.getUserId() + " - " + u.getUsername() + " - " + u.getCreatedBy() + " - " + u.getCreatedDate()));
        System.out.println();
        for (User user : results) {
            System.out.println(user.toString());
        }
    }
}