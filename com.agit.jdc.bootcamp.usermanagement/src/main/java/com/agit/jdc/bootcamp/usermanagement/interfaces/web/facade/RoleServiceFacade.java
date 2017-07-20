package com.agit.jdc.bootcamp.usermanagement.interfaces.web.facade;

import com.agit.jdc.bootcamp.common.dto.usermanagement.RoleDTO;
import com.agit.jdc.bootcamp.shared.type.StatusData;
import java.util.List;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author lintang
 */
public interface RoleServiceFacade {

    ResponseEntity<Void> saveOrUpdate(RoleDTO role);
    
    ResponseEntity<RoleDTO> getDummyRolePrivilege();

    ResponseEntity<RoleDTO> findByID(String roleID);

    ResponseEntity<List<RoleDTO>> findAll();

    ResponseEntity<List<RoleDTO>> findAllByStatus(StatusData statusData);

    ResponseEntity<List<RoleDTO>> findByParameter(String roleName);

    ResponseEntity<List<String>> grantedAuthoritys(String roleID);
}
