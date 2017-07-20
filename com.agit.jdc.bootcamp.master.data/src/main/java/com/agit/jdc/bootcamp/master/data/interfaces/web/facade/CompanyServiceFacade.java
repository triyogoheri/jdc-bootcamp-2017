package com.agit.jdc.bootcamp.master.data.interfaces.web.facade;

import com.agit.jdc.bootcamp.common.dto.company.CompanyDTO;
import com.agit.jdc.bootcamp.shared.type.PlatformType;
import java.util.List;
import java.util.Map;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author ASUS
 */
public interface CompanyServiceFacade {

    ResponseEntity<CompanyDTO> getDummyData();

    ResponseEntity<Void> saveOrUpdate(CompanyDTO company);

    ResponseEntity<Void> deleteData(CompanyDTO company);

    ResponseEntity<CompanyDTO> findByID(String companyID);

    ResponseEntity<List<CompanyDTO>> findByParameter(Map map);

    ResponseEntity<List<CompanyDTO>> findByParams(String companyID, String companyName, String businessGroupID, PlatformType platform);

    ResponseEntity<List<CompanyDTO>> findAll();

}
