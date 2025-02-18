package com.javawebtutor;
import java.util.Date;

import com.javawebtutor.entity.User;
import com.javawebtutor.dao.UserDao;
import java.util.List;

import com.javawebtutor.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {

        //hibernate
//        ArrayList<User> users = new ArrayList<>();
//        users.add(new User("Fahad", "Vaulsys", new Date()));
//        try {
//            System.out.println("Timeout...");
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        users.add(new User("Ali", "Vaulsys", new Date()));
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

        User user1 = new User("Fahad", "Vaulsys", new Date());
        User user2 = new User("Ali", "Vaulsys", new Date());
        UserDao.saveUser(user1);
        UserDao.saveUser(user2);

        UserDao.deleteUser(3);
        user2.setUsername("Hamza");
        UserDao.updateUser(user2);

        List<User> results = UserDao.getAllUsers();
//        System.out.println();
//        results.forEach(u -> System.out.println(u.getUserId() + " - " + u.getUsername() + " - " + u.getCreatedBy() + " - " + u.getCreatedDate()));
        System.out.println();
        for (User user : results) {
            System.out.println(user.toString());
        }
    }
}