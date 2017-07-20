package com.agit.jdc.bootcamp.usermanagement;

import com.agit.jdc.bootcamp.common.application.UserService;
import com.agit.jdc.bootcamp.common.dto.usermanagement.UserDTO;
import com.agit.jdc.bootcamp.shared.type.StatusData;
import com.agit.jdc.bootcamp.usermanagement.domain.user.UserRepository;
import java.util.List;
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
public class UserServiceTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @Test
    public void UserServiceTest() {
        Validate.notNull(userRepository);

        print("Starting User Processing");

        /* Create Dummy User */
        UserDTO user = UserDTO.getInstance();

        /* Data Dummy User */
        System.out.println("User :" + user);

        userService.saveOrUpdate(user);
        System.out.println("User has been saved succesfully");

        System.out.println("");
        print("Find by ID");
        UserDTO u = userService.findByID(user.getUserName());
        System.out.println("Data User :" + u.toString());

        System.out.println("");
        print("Find ALL");
        List<UserDTO> listUser = userService.findAllUser();
        for (UserDTO us : listUser) {
            System.out.println("User :" + us.toString());
        }

        System.out.println("");
        print("Find By Parameter");
        List<UserDTO> listUserParams = userService.findByParameter("", user.getUserName(), "", StatusData.DELETED);
        for (UserDTO tk : listUserParams) {
            System.out.println("Data User :" + tk.toString());
        }

    }

    private void print(String msg) {
        System.out.println("------------------------------------------------------------------------");
        System.out.println(msg);
        System.out.println("------------------------------------------------------------------------");
    }
}
