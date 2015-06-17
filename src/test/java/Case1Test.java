import com.jordiarjan.exercise5.Entities.Advertisement;
import com.jordiarjan.exercise5.Entities.Category;
import com.jordiarjan.exercise5.Entities.User;
import com.jordiarjan.exercise5.HibernateUtil;
import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;

import javax.validation.*;
import java.util.Date;
import java.util.Set;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by Arjan on 17/06/2015.
 */
public class Case1Test {

    private Category category;

    @Before
    public void setCategory()
    {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Category category = new Category();
        category.setName("myCategory");
        session.save(category);
        session.getTransaction().commit();
    }

    @Test
    public void insertUserAndAdvertisement()
    {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        User user = createUser();
        Advertisement advertisement = createAdvertisement(user);
        session.save(user);
        session.save(advertisement);
        session.getTransaction().commit();
    }

    private Advertisement createAdvertisement(User user) {
        Advertisement advertisement = new Advertisement();
        advertisement.setActive(true);
        advertisement.setCategory(category);
        advertisement.setDescription("my description");
        advertisement.setName("my name");
        advertisement.setSellingUser(user);
        advertisement.setStartDate(new Date());
        advertisement.setStartPrice(10);
        return advertisement;
    }

    public User createUser()
    {
        User user = new User();
        user.setEmail("mail@arjan-schouten.nl");
        user.setFirstName("Arjan");
        user.setLastName("Schouten");
        return user;
    }

    @Test
    public void emailValidation()
    {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        User user = new User();
        user.setEmail("arjan-schouten");
        user.setFirstName("Arjan");
        user.setLastName("Schouten");
        Set<ConstraintViolation<User>> constraintViolations = validator.validate( user );

        assertEquals( 1, constraintViolations.size() );
    }
}
