package com.agit.jdc.bootcamp.privilegemanagement;

import com.agit.jdc.bootcamp.common.application.PrivilegeService;
import com.agit.jdc.bootcamp.common.dto.usermanagement.PrivilegeDTO;
import com.agit.jdc.bootcamp.usermanagement.domain.privilege.PrivilegeRepository;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
public class PrivilegeServiceTest {

    @Autowired
    PrivilegeRepository privilegeRepository;

    @Autowired
    PrivilegeService privilegeService;

    @Test
    public void PrivilegeServiceTest() {
        Validate.notNull(privilegeRepository);

        print("Starting Privilege Processing");

        /* Create Dummy Privilege */
        PrivilegeDTO privilege = PrivilegeDTO.getInstance();

        /* Data Dummy Privilege */
        System.out.println("Privilege :" + privilege);

        privilegeService.saveOrUpdate(privilege);
        System.out.println("Privilege has been saved succesfully");

        System.out.println("");
        print("Find by ID");
        PrivilegeDTO u = privilegeService.findByID(privilege.getPrivilegeID());
        System.out.println("Data Privilege :" + u.toString());

        System.out.println("");
        print("Find ALL");
        List<PrivilegeDTO> listPrivilege = privilegeService.findAll();
        for (PrivilegeDTO us : listPrivilege) {
            System.out.println("Privilege :" + us.toString());
        }

        System.out.println("");
        print("Find By Parameter");
        Map map = new HashMap();
        map.put("privilegeID", privilege.getPrivilegeID());
        List<PrivilegeDTO> listPrivilegeParams = privilegeService.findByParams(map);
        for (PrivilegeDTO tk : listPrivilegeParams) {
            System.out.println("Data Privilege :" + tk.toString());
        }

    }

    private void print(String msg) {
        System.out.println("------------------------------------------------------------------------");
        System.out.println(msg);
        System.out.println("------------------------------------------------------------------------");
    }
}
