package com.managercours.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.managercours.entities.Courses;
import com.managercours.util.HibernateUtil;

public class CourseDAO implements DAO<Courses> {
    // Create
    public void persist(Courses course) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the course object
            session.save(course);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    //Read
    public Courses findById(int id) {
        Transaction transaction = null;
        Courses course = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an course object
            course = session.get(Courses.class, id);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return course;
    }

    // Update	
    public void update(Courses course) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the course object
            session.update(course);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }


    //Delete
    public void delete(int id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // Delete a course object
            Courses course = session.get(Courses.class, id);
            if (course != null) {
                session.delete(course);
            }

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    //List
    @SuppressWarnings("unchecked")
    public List < Courses > findAll() {
        Transaction transaction = null;
        List < Courses > listOfCourse = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an course object
            // getCurrentSession().createNativeQuery("Select * from courses", Course.class).getResultList();
            listOfCourse = session.createQuery("from Course").getResultList();
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return listOfCourse;
    }
}
