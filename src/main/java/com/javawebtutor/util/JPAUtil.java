package com.javawebtutor.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
    private static final EntityManagerFactory emf = createEntityManagerFactory();

    private static EntityManagerFactory createEntityManagerFactory() {
        System.setProperty("db.url", ConfigUtil.getProperty("db.url"));
        System.setProperty("db.user", ConfigUtil.getProperty("db.user"));
        System.setProperty("db.password", ConfigUtil.getProperty("db.password"));

        return Persistence.createEntityManagerFactory("examplePU");
    }

    private JPAUtil() {} // Prevent instantiation

    public static EntityManagerFactory getEntityManagerFactory() {
        return emf;
    }

    public static void closeEntityManagerFactory() {
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }
}