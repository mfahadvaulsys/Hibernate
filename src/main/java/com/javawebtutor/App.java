package com.javawebtutor;
import java.util.Date;


import com.javawebtutor.entity.Instructor;
import com.javawebtutor.entity.Course;
import com.javawebtutor.dao.InstructorDao;
import com.javawebtutor.dao.CourseDao;
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

//        Instructor i1 = new Instructor("Muhammad", "Fahad", "mfahadd960@gmail.com", new Date());
//        InstructorDao.saveInstructor(i1);

//        try {
//            System.out.println("Timeout...");
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        Instructor i2 = new Instructor("ABC", "XYZ", "ABC@XYZ.com", new Date());
//        InstructorDao.saveInstructor(i2);

//        List<Instructor> r1 = InstructorDao.getAllInstructors();
//        System.out.println();
//
//        for (Instructor i : r1) {
//            System.out.println(i.toString());
//        }

        Instructor i1 = InstructorDao.getInstructorById(1);

        System.out.println(i1);

        Course tempCourse1 = new Course("Air Guitar - The Ultimate Guide");
        tempCourse1.setInstructor(i1);
        CourseDao.saveCourse(tempCourse1);

        Course tempCourse2 = new Course("The Pinball Masterclass");
        tempCourse2.setInstructor(i1);
        CourseDao.saveCourse(tempCourse2);

        List<Course> r2 = CourseDao.getAllCourses();
        System.out.println();

        for (Course i : r2) {
            System.out.println(i.toString());
        }
    }
}