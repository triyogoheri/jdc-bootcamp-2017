package com.agit.jdc.bootcamp.usermanagement;

import com.agit.jdc.bootcamp.common.application.UserService;
import com.agit.jdc.bootcamp.usermanagement.domain.user.UserRepository;
import org.apache.commons.lang.Validate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author lintang
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
    "classpath:/jdc-context-application.xml",
    "classpath:/jdc-context-infrastructure.xml"})
public class AuthenticationUserServiceTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @Test
    public void AuthenticationUserServiceTest() {
        Validate.notNull(userRepository);
        print("Starting User Processing");

        print("User Authentication...");
        String username = "bayuhendra";
        String password = "Password123";
        System.out.println("Username :" + username);
        System.out.println("Password :" + password);
        Boolean auth = userService.getAuthentication(username, password);
        System.out.println("Authentication :" + auth);

    }

    private void print(String msg) {
        System.out.println("------------------------------------------------------------------------");
        System.out.println(msg);
        System.out.println("------------------------------------------------------------------------");
    }
}
