package services;

import com.skyrock.interview.models.Users;
import com.skyrock.interview.repositories.UsersRepository;
import com.skyrock.interview.services.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class UsersServiceTest {
    @InjectMocks
    UserService userService;

    @Mock
    UsersRepository usersRepository;

    @Test
    public void tesUserCreate(){

        final Users users = new Users();
        users.setId(0L);
        users.setTitle("title");
        users.setFirstName("firstName");
        users.setSurname("surname");
        users.setDob("dob");
        users.setJobTitle("jobTitle");
        users.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        when(usersRepository.save(any(Users.class))).thenReturn(users);

        final Users result = userService.createUser(users);

        Assert.assertEquals(users, result);

    }

    @Test
    public void tesUserUpdate(){

        final Users users = new Users();
        users.setId(0L);
        users.setTitle("title");
        users.setFirstName("firstName");
        users.setSurname("surname");
        users.setDob("dob");
        users.setJobTitle("jobTitle");
        users.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        when(userService.createUser(any(Users.class))).thenReturn(users);

        final Users result = userService.updateUser(0L, users);

        Assert.assertEquals(users, result);

    }

    @Test
    public void testGetOneUser(){

        Users users = new Users();
        users.setId(0L);
        users.setTitle("title");
        users.setFirstName("firstName");
        users.setSurname("surname");
        users.setDob("dob");
        users.setJobTitle("jobTitle");
        users.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        final Optional<Users> users1 = Optional.of(users);
        when(usersRepository.findById(0L)).thenReturn(java.util.Optional.of(users));
        final Optional<Users> result = userService.getSingleUser(0L);
        Assert.assertEquals(users1, result);

    }

    @Test
    public void testGetByFirstLastAndId() {
        // Setup

        // Configure UserService.findByFirstNameLastNameAndId(...).
        final Users users = new Users();
        users.setId(0L);
        users.setTitle("title");
        users.setFirstName("firstName");
        users.setSurname("surname");
        users.setDob("dob");
        users.setJobTitle("jobTitle");
        users.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        when(usersRepository.findByFirstNameAndSurnameAndId("firstName", "lastName", 0L)).thenReturn(users);

        // Run the test
        final Users result = userService.findByFirstNameLastNameAndId("firstName", "lastName", 0L);

        // Verify the results
        Assert.assertEquals(users, result);
    }

    @Test
    public void testUpdateUser() {


        // Configure UserService.updateUser(...).
        final Users users1 = new Users();
        users1.setId(0L);
        users1.setTitle("title");
        users1.setFirstName("firstName");
        users1.setSurname("surname");
        users1.setDob("dob");
        users1.setJobTitle("jobTitle");
        users1.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        when(usersRepository.save(any(Users.class))).thenReturn(users1);

        // Run the test
        final Users result = userService.updateUser(0L, users1);

        // Verify the results
        Assert.assertEquals(users1, result);
    }

    @Test
    public void testDeleteUser() {

        // Run the test
        userService.deleteUser(0L);

        // Verify the results
        verify(usersRepository).deleteById(0L);
    }

    @Test
    public void testGetAllUsers() {
        // Setup

        // Configure UserService.getAllUsers(...).
        final Users users1 = new Users();
        users1.setId(0L);
        users1.setTitle("title");
        users1.setFirstName("firstName");
        users1.setSurname("surname");
        users1.setDob("dob");
        users1.setJobTitle("jobTitle");
        users1.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        final List<Users> users = Arrays.asList(users1);
        when(usersRepository.findAll()).thenReturn(users);

        // Run the test
        final List<Users> result = userService.getAllUsers();

        // Verify the results
        Assert.assertEquals(users, result);
    }




}
