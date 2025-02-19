package com.javawebtutor.dao;

import com.javawebtutor.entity.Course;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class CourseDao {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("examplePU");

    public static void saveCourse(Course course) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(course);
        em.getTransaction().commit();
        System.out.println("Course saved!");
        em.close();
    }

    public static void deleteCourse(int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Course course = em.find(Course.class, id);
        if (course!= null) {
            em.remove(course);
        } else {
            System.out.println("Course does not exit!");
            em.close();
            return;
        }
        em.getTransaction().commit();
        System.out.println("Course deleted!");
        em.close();
    }

    public static void updateCourse(Course course) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(course);
        em.getTransaction().commit();
        System.out.println("Course updated!");
        em.close();
    }

    public static List<Course> getAllCourses() {
        EntityManager em = emf.createEntityManager();
        List<Course> instructors = em.createQuery("SELECT u FROM Course u", Course.class).getResultList();
        em.close();
        return instructors;
    }
}
