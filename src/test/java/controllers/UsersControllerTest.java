package controllers;

import com.skyrock.interview.components.ConverterComponent;
import com.skyrock.interview.controllers.UsersController;
import com.skyrock.interview.dtos.UsersDto;
import com.skyrock.interview.models.Users;
import com.skyrock.interview.services.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class UsersControllerTest {

    @InjectMocks
    UsersController usersController;

    @Mock
    UserService userService;

    @Mock
    ConverterComponent converterComponent;

    @Test
    public void testCreateUser() {
        // Setup
        final UsersDto usersDto = new UsersDto();
        usersDto.setId(0L);
        usersDto.setTitle("title");
        usersDto.setFirstName("firstName");
        usersDto.setSurname("surname");
        usersDto.setDob("dob");
        usersDto.setJobTitle("jobTitle");
        usersDto.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());

        // Configure UserService.createUser(...).
        final Users users = new Users();
        users.setId(0L);
        users.setTitle("title");
        users.setFirstName("firstName");
        users.setSurname("surname");
        users.setDob("dob");
        users.setJobTitle("jobTitle");
        users.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        when(converterComponent.convertToUsersDto(usersDto)).thenReturn(new Users());
        when(userService.createUser(any(Users.class))).thenReturn(users);
        // Run the test
        final Users result = usersController.createUser(usersDto);

        Assert.assertEquals(users, result);
        // Verify the results
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
        when(userService.getAllUsers()).thenReturn(users);

        Map<String, List<Users>> usersMap = new HashMap<>();

         usersMap.put("users", users);
        // Run the test
        final Map<String, List<Users>> result = usersController.getAllUsers();

        // Verify the results
        Assert.assertEquals(usersMap, result);
    }


    @Test
    public void testUpdateUser() {
        // Setup
        final UsersDto usersDto = new UsersDto();
        usersDto.setId(0L);
        usersDto.setTitle("title");
        usersDto.setFirstName("firstName");
        usersDto.setSurname("surname");
        usersDto.setDob("dob");
        usersDto.setJobTitle("jobTitle");
        usersDto.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());

        // Configure ConverterComponent.convertToUsersDto(...).
        final Users users = new Users();
        users.setId(0L);
        users.setTitle("title");
        users.setFirstName("firstName");
        users.setSurname("surname");
        users.setDob("dob");
        users.setJobTitle("jobTitle");
        users.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        when(converterComponent.convertToUsersDto(any(UsersDto.class))).thenReturn(users);

        // Configure UserService.updateUser(...).
        final Users users1 = new Users();
        users1.setId(0L);
        users1.setTitle("title");
        users1.setFirstName("firstName");
        users1.setSurname("surname");
        users1.setDob("dob");
        users1.setJobTitle("jobTitle");
        users1.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        when(userService.updateUser(eq(0L), any(Users.class))).thenReturn(users1);

        // Run the test
        final Users result = usersController.updateUser(0L, usersDto);

        // Verify the results
        Assert.assertEquals(users1, result);
    }

    @Test
    public void testDeleteUser() {

        // Run the test
        usersController.deleteUser(0L);

        // Verify the results
        verify(userService).deleteUser(0L);
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
        when(userService.findByFirstNameLastNameAndId("firstName", "lastName", 0L)).thenReturn(users);

        // Run the test
        final Users result = usersController.getByFirstLastAndId("firstName", "lastName", 0L);

        // Verify the results
        Assert.assertEquals(users, result);
    }

    @Test
    public void testGetSingleUser() {
        // Setup

        // Configure UserService.getSingleUser(...).
        final Users users1 = new Users();
        users1.setId(0L);
        users1.setTitle("title");
        users1.setFirstName("firstName");
        users1.setSurname("surname");
        users1.setDob("dob");
        users1.setJobTitle("jobTitle");
        users1.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        final Optional<Users> users = Optional.of(users1);
        when(userService.getSingleUser(0L)).thenReturn(users);

        // Run the test
        final Optional<Users> result = usersController.getSingleUser(0L);

        // Verify the results
        Assert.assertEquals(users, result);
    }
}
