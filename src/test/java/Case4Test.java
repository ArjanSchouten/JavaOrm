import com.jordiarjan.exercise5.Entities.Advertisement;
import com.jordiarjan.exercise5.Entities.AdvertisementReaction;
import com.jordiarjan.exercise5.Entities.User;
import com.jordiarjan.exercise5.HibernateUtil;
import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by jordi_000 on 18-6-2015.
 */
public class Case4Test {
    User user1;
    User user2;
    Advertisement advertisement;
    List<AdvertisementReaction> reactions;

    @Before
    public void getUsers() {
        Random random = new Random();
        int id1 = random.nextInt(100000);
        int id2 = random.nextInt(100000);

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        user1 = new User();
        user1.setEmail(id1 + "@test.nl");
        user1.setFirstName("Testpersoon");
        user1.setLastName("1");
        user1.setPassword("test123");

        user2 = new User();
        user2.setEmail(id2 + "@test.nl");
        user2.setFirstName("Testpersoon");
        user2.setLastName("2");
        user2.setPassword("test123");

        session.save(user1);
        session.save(user2);
        session.getTransaction().commit();

    }

    @Test
    public void insertReactions() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        AdvertisementReaction reaction1 = new AdvertisementReaction();
        reaction1.setText("Ik vind het een beetje duur.");
        reaction1.setUser(user1);
        reaction1.setAdvertisement(advertisement);
        reaction1.setDate(new Date());

        AdvertisementReaction reaction2 = new AdvertisementReaction();
        reaction2.setText("Hoe is de kwaliteit?");
        reaction2.setUser(user2);
        reaction2.setAdvertisement(advertisement);
        reaction2.setDate(new Date());

        session.save(reaction1);
        session.save(reaction2);

        reactions = new ArrayList<>();
        reactions.add(reaction1);
        reactions.add(reaction2);

        advertisement.setReactions(reactions);
        session.save(advertisement);
        session.getTransaction().commit();

    }

    @Before
    public void getAdvertisement() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        advertisement = new Advertisement();
        advertisement.setName("Koop een MacBook");
        advertisement.setStartDate(new Date());
        advertisement.setStartPrice(1000);
        advertisement.setDescription("Gloedje nieuw en 2 x gebruikt");
        advertisement.setActive(true);
        advertisement.setReactions(new ArrayList<>());
        session.save(advertisement);
        session.getTransaction().commit();

    }
}
