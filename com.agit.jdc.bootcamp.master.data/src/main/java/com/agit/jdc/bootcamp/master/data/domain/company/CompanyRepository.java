package com.agit.jdc.bootcamp.master.data.domain.company;

import com.agit.jdc.bootcamp.shared.type.PlatformType;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ASUS
 */
public interface CompanyRepository {

    void saveOrUpdate(Company company);

    void deleteData(Company company);

    Company findByID(String companyID);

    List<Company> findByParameter(Map map);

    List<Company> findByParams(String companyID, String companyName, String businessGroupID, PlatformType platform);

    List<Company> findAll();

}
