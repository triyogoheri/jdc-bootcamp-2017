package com.agit.jdc.bootcamp.groupmanagement;

import com.agit.jdc.bootcamp.common.application.RoleService;
import com.agit.jdc.bootcamp.common.dto.usermanagement.RoleDTO;
import com.agit.jdc.bootcamp.usermanagement.domain.role.RoleRepository;
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
public class RoleServiceTest {

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    RoleService roleService;

    @Test
    public void RoleServiceTest() {
        Validate.notNull(roleRepository);

        print("Starting Role Processing");

        /* Create Dummy Role */
        RoleDTO role = RoleDTO.getInstance();

        /* Data Dummy Role */
        System.out.println("Role :" + role);

        roleService.saveOrUpdate(role);
        System.out.println("Role has been saved succesfully");

        System.out.println("");
        print("Find by ID");
        RoleDTO u = roleService.findByID(role.getRoleID());
        System.out.println("Data Role :" + u.toString());

        System.out.println("");
        print("Find ALL");
        List<RoleDTO> listRole = roleService.findAll();
        for (RoleDTO us : listRole) {
            System.out.println("Role :" + us.toString());
        }

        System.out.println("");
        print("Find By Parameter");
        List<RoleDTO> listRoleParams = roleService.findByParameter(role.getRoleName());
        for (RoleDTO tk : listRoleParams) {
            System.out.println("Data Role :" + tk.toString());
        }

    }

    private void print(String msg) {
        System.out.println("------------------------------------------------------------------------");
        System.out.println(msg);
        System.out.println("------------------------------------------------------------------------");
    }
}
