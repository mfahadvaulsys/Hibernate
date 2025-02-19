package com.javawebtutor.dao;

import com.javawebtutor.entity.Instructor;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class InstructorDao {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("examplePU");

    public static void saveInstructor(Instructor instructor) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(instructor);
        em.getTransaction().commit();
        System.out.println("Instructor saved!");
        em.close();
    }

    public static void deleteInstructor(int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Instructor instructor = em.find(Instructor.class, id);
        if (instructor != null) {
            em.remove(instructor);
        } else {
            System.out.println("Instructor does not exit!");
            em.close();
            return;
        }
        em.getTransaction().commit();
        System.out.println("Instructor deleted!");
        em.close();
    }

    public static void updateInstructor(Instructor instructor) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(instructor);
        em.getTransaction().commit();
        System.out.println("Instructor updated!");
        em.close();
    }

    public static Instructor getInstructorById(int id) {
        EntityManager em = emf.createEntityManager();
        Instructor instructor = em.find(Instructor.class, id);
        em.close();
        return instructor;
    }

    public static List<Instructor> getAllInstructors() {
        EntityManager em = emf.createEntityManager();
        List<Instructor> instructors = em.createQuery("SELECT u FROM Instructor u", Instructor.class).getResultList();
        em.close();
        return instructors;
    }
}
