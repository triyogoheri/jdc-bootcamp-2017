package com.agit.jdc.bootcamp.usermanagement.interfaces.web.facade;

import com.agit.jdc.bootcamp.common.dto.usermanagement.PrivilegeDTO;
import java.util.List;
import java.util.Map;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author lintang
 */
public interface PrivilegeServiceFacade {

    ResponseEntity<Void> saveOrUpdate(PrivilegeDTO privilege);
    
    ResponseEntity<PrivilegeDTO> getDummyPrivilege();

    ResponseEntity<PrivilegeDTO> findByID(String privilegeID);

    ResponseEntity<List<PrivilegeDTO>> findByListID(List<String> privilegeID);

    ResponseEntity<List<PrivilegeDTO>> findAll();

    ResponseEntity<List<PrivilegeDTO>> findByParameter(String privilegeId);

    ResponseEntity<List<PrivilegeDTO>> findByParams(Map map);

    ResponseEntity<List<PrivilegeDTO>> findByParentId(String parentId, boolean isMenu);

    ResponseEntity<List<PrivilegeDTO>> findMenu();

    ResponseEntity<List<PrivilegeDTO>> findMenu(String privilegeID);
}
