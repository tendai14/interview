package dtos;

import com.skyrock.interview.dtos.UsersDto;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
public class UsersDtoTest {

    @InjectMocks
    UsersDto usersDto;

    private static final Long  id = 1L;

    private static final String title = "Mr";

    private static final String firstName = "Adrian";

    private static final String surname = "Mutize";

    private static final String dob = "14/05/1995";

    private static final String jobTitle = "Developer";


    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        usersDto.setId(1L);
        usersDto.setFirstName("Adrian");
        usersDto.setSurname("Mutize");
        usersDto.setDob("14/05/1995");
        usersDto.setTitle("Mr");
        usersDto.setJobTitle("Developer");
        usersDto.setCreatedAt(new Date());
    }

    @Test
    public void testId(){
        Assert.assertEquals(id, usersDto.getId());
    }

    @Test
    public void testFirstName(){
        Assert.assertEquals(firstName, usersDto.getFirstName());
    }

    @Test
    public void testSurname(){
        Assert.assertEquals(surname, usersDto.getSurname());
    }

    @Test
    public void testTitle(){
        Assert.assertEquals(title, usersDto.getTitle());
    }

    @Test
    public void testJobTitle(){
        Assert.assertEquals(jobTitle, usersDto.getJobTitle());
    }

    @Test
    public void testDob(){
        Assert.assertEquals(dob, usersDto.getDob());
    }
}
