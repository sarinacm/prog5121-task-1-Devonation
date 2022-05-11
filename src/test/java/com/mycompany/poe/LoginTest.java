package com.mycompany.poe;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.Test;

public class LoginTest {

    public LoginTest() {
    }
    //created an object from the class in question
    Login login = new Login();

    //check to see if the username enetereed is correct for the criteria that's outlined in POE document
    @Test
    public void testCheckUserNameCorrectlyFormatted() {
        login.setUsername("kyl_1");
        boolean actual = login.checkUserName();
        assertTrue(actual);
    }

    //check to see if the username enetereed is incorrect for the criteria that's outlined in POE document
    @Test
    public void testCheckUserNamePoorlyFormatted() {
        login.setUsername("kyl!!!!");
        boolean actual = login.checkUserName();
        assertFalse(actual);
    }

    //check to see if the password enetereed is correct for the criteria that's outlined in POE document
    @Test
    public void testCheckPasswordComplexitySuccess() {
        login.setPassword("Ch&&sec@ke99!");
        boolean actual = login.checkPasswordComplexity();
        assertTrue(actual);
    }

    //check to see if the password enetereed is incorrect for the criteria that's outlined in POE document
    @Test
    public void testCheckPasswordComplexityFailure() {
        login.setPassword("password");
        boolean actual = login.checkPasswordComplexity();
        assertFalse(actual);
    }

    //check to see if the login details entered match the registered details
    @Test
    public void loginUserSuccess() {
        login.setUsername("kyl_1");
        login.setPassword("Ch&&sec@ke99!");
        login.setLogUsername("kyl_1");
        login.setLogPassword("Ch&&sec@ke99!");
        boolean actual = login.loginUser();
        assertTrue(actual);
    }

    //check to see if the login details entered do not match the registered details
    @Test
    public void loginUserFailure() {
        login.setUsername("kyl_1");
        login.setPassword("Ch&&sec@ke99!");
        login.setLogUsername("kyl!!!");
        login.setLogPassword("password");
        boolean actual = login.loginUser();
        assertFalse(actual);
    }
}
