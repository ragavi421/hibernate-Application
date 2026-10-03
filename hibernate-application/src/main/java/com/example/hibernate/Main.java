package com.example.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {

    public static void main(String[] args) {

        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            // Create and insert a Student object
            transaction = session.beginTransaction();

            Student student = new Student(
                    "Ragavi",
                    "ragavi@example.com",
                    "Artificial Intelligence and Data Science"
            );

            session.save(student);
            transaction.commit();

            System.out.println("Student inserted successfully.");
            System.out.println("Inserted record: " + student);

            // Update the same record
            transaction = session.beginTransaction();

            student.setCourse("Artificial Intelligence & Data Science");
            session.update(student);

            transaction.commit();

            System.out.println("Student updated successfully.");
            System.out.println("Updated record: " + student);

        } catch (Exception e) {
            if (transaction != null && transaction.getStatus().canRollback()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            HibernateUtil.shutdown();
        }
    }
}
