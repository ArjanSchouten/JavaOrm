import com.jordiarjan.exercise5.Entities.Advertisement;
import com.jordiarjan.exercise5.Entities.Category;
import com.jordiarjan.exercise5.HibernateUtil;
import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;

import java.time.ZonedDateTime;
import java.util.Date;

/**
 * Created by jordi_000 on 17-6-2015.
 */
public class Case3Test {
    public Advertisement advertisement;
    public Category category;


    @Before
    public void setCategory()
    {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        category = new Category();
        category.setName("Mazda");

        Category parentCategory = new Category();
        parentCategory.setName("Auto");

        category.setParent(parentCategory);

        session.save(parentCategory);
        session.save(category);
        session.getTransaction().commit();
    }

    @Test
    public void setAdvertisement()
    {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        advertisement = new Advertisement();
        advertisement.setActive(true);
        advertisement.setCategory(category);
        advertisement.setName("Cool car for sale");
        advertisement.setDescription("Best looking car ever! Just buy it");
        advertisement.setStartPrice(10000);
        advertisement.setStartDate(new Date());
        session.save(advertisement);
        session.getTransaction().commit();
    }
}
