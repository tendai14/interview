package models;

import com.skyrock.interview.models.Users;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
public class UsersModelTest {
    @InjectMocks
    Users users;

    private static  Long  id = 1L;

    private static  String title = "Mr";

    private static  String firstName = "Adrian";

    private static  String surname = "Mutize";

    private static  String dob = "14/05/1995";

    private static  String jobTitle = "Developer";


    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        users.setId(1L);
        users.setFirstName("Adrian");
        users.setSurname("Mutize");
        users.setDob("14/05/1995");
        users.setTitle("Mr");
        users.setJobTitle("Developer");
        users.setCreatedAt(new Date());
    }

    @Test
    public void testId(){
        Assert.assertEquals(id, users.getId());
    }

    @Test
    public void testFirstName(){
        Assert.assertEquals(firstName, users.getFirstName());
    }

    @Test
    public void testSurname(){
        Assert.assertEquals(surname, users.getSurname());
    }

    @Test
    public void testTitle(){
        Assert.assertEquals(title, users.getTitle());
    }

    @Test
    public void testJobTitle(){
        Assert.assertEquals(jobTitle, users.getJobTitle());
    }

    @Test
    public void testDob(){
        Assert.assertEquals(dob, users.getDob());
    }








}
