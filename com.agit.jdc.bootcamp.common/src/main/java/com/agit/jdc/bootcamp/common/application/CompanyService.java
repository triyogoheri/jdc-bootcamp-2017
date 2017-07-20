package com.agit.jdc.bootcamp.common.application;

import com.agit.jdc.bootcamp.common.dto.company.CompanyDTO;
import com.agit.jdc.bootcamp.shared.type.PlatformType;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ASUS
 */
public interface CompanyService {

    CompanyDTO getDummyData();

    void saveOrUpdate(CompanyDTO company);

    void deleteData(CompanyDTO company);

    CompanyDTO findByID(String companyID);

    List<CompanyDTO> findByParameter(Map map);

    List<CompanyDTO> findByParams(String companyID, String companyName, String businessGroupID, PlatformType platform);

    List<CompanyDTO> findAll();

}
