package com.jordiarjan.exercise5;

import com.jordiarjan.exercise5.Entities.User;
import org.hibernate.Session;

/**
 * Created by Arjan on 16/06/2015.
 */
public class App {

    public static void main(String args[]) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        User user = new User();
        user.setEmail("mail@arjan-schouten.nl");
        user.setFirstName("Arjan");
        user.setLastName("Schouten");
        session.save(user);

        session.getTransaction().commit();
    }
}
