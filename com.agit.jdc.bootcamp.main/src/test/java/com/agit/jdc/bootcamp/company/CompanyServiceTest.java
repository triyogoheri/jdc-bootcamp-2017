package com.agit.jdc.bootcamp.company;

import com.agit.jdc.bootcamp.common.application.CompanyService;
import com.agit.jdc.bootcamp.common.dto.company.CompanyDTO;
import com.agit.jdc.bootcamp.master.data.domain.company.CompanyRepository;
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
public class CompanyServiceTest {

    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    CompanyService companyService;

    @Test
    public void CompanyServiceTest() {
        Validate.notNull(companyRepository);

        print("Starting Company Processing");

        /* Create Dummy Company */
        CompanyDTO company = companyService.getDummyData();

        /* Data Dummy Company */
        System.out.println("Company :" + company);

        companyService.saveOrUpdate(company);
        System.out.println("Company has been saved succesfully");

        System.out.println("");
        print("Find by ID");
        CompanyDTO u = companyService.findByID(company.getCompanyID());
        System.out.println("Data Company :" + u.toString());

        System.out.println("");
        print("Find All");
        List<CompanyDTO> listCompanyParams = companyService.findAll();
        for (CompanyDTO tk : listCompanyParams) {
            System.out.println("Data Company :" + tk.toString());
        }

    }

    private void print(String msg) {
        System.out.println("------------------------------------------------------------------------");
        System.out.println(msg);
        System.out.println("------------------------------------------------------------------------");
    }
}
