package com.managercours.services;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.managercours.dao.DAO;
import com.managercours.entities.User;
import com.managercours.util.HibernateUtil;

public class UserDaoImpl implements DAO<User> {
    // Create
    public void persist(User user) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the user object
            session.save(user);
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
    public User findById(int id) {
        Transaction transaction = null;
        User user = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            user = session.get(User.class, id);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return user;
    }

    // Update	
    public void update(User user) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the user object
            session.update(user);
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
            // Delete a user object
            User user = session.get(User.class, id);
            if (user != null) {
                session.delete(user);
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
    public List < User > findAll() {
        Transaction transaction = null;
        List < User > listOfUser = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            // getCurrentSession().createNativeQuery("Select * from users", User.class).getResultList();
            listOfUser = session.createQuery("from User").getResultList();
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return listOfUser;
    }

    //SignIn
    public User signIn(User user) {
        Transaction transaction = null;
        User admin = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            String email = user.getEmail();
            String password = user.getPassword();
            admin = (User) session.createQuery("FROM User U WHERE U.email = :email AND role = 'admin'").setParameter("email", email).uniqueResult();
            if (!(admin != null && admin.getPassword().equals(password))) {
              admin = null;
            }
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return admin;
    }

}
