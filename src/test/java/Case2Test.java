import com.jordiarjan.exercise5.Entities.*;
import com.jordiarjan.exercise5.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.sql.JoinType;
import org.junit.Before;
import org.junit.Test;

import javax.el.Expression;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Arjan on 17/06/2015.
 */
public class Case2Test {

    private Category category;
    private Advertisement advertisement;
    private List<User> users = new ArrayList<>();

    @Before
    public void insertAdvertisement()
    {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        category = new Category();
        category.setName("This is a category");
        advertisement = new Advertisement();
        advertisement.setActive(true);
        advertisement.setCategory(category);
        advertisement.setDescription("Desc");
        advertisement.setName("name");
        for(int i =0; i  < 20; i++){
            User user = new User();
            user.setEmail("mail@arjan-schouten.nl" + i);
            user.setFirstName("bar" + i);
            user.setLastName("lastname" + i);
            session.save(user);
            users.add(user);
        }
        session.save(category);
        session.save(advertisement);
        session.getTransaction().commit();
    }

    @Test
    public void addOffers()
    {
        for(int i = 0; i < 20; i ++){
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            Offer offer = new Offer();
            offer.setAdvertisement(advertisement);
            Integer price = (Integer)session.createQuery("SELECT max(price) from Offer where advertisement_id=?").setLong(0, advertisement.getId()).uniqueResult();
            if(price == null)
                offer.setPrice(10);
            else
                offer.setPrice(price + 2);
            offer.setUser(users.get(i % users.size()));
            session.save(offer);
            session.getTransaction().commit();
        }
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        DetachedCriteria criteria = DetachedCriteria.forClass(Offer.class).setProjection(Projections.max("price"));
        Offer offer = (Offer)session.createCriteria(Offer.class).setFetchMode("user", FetchMode.JOIN).add(Property.forName("price").eq(criteria)).list().get(0);
        CreditCard paymentData = new CreditCard();
        paymentData.setNumber(01205654);
        paymentData.setOwnerName("Arjan");
        paymentData.setBankName("ING");
        paymentData.setUser(offer.getUser());
        session.save(paymentData);
        offer.getUser().addPaymentData(paymentData);
        session.save(offer);
        session.getTransaction().commit();
    }
}
