package com.agit.jdc.bootcamp.common.application;

import com.agit.jdc.bootcamp.common.dto.usermanagement.RoleDTO;
import com.agit.jdc.bootcamp.shared.type.StatusData;
import java.util.List;

/**
 *
 * @author bayutridewanto
 */
public interface RoleService {

    void saveOrUpdate(RoleDTO role);
    
    RoleDTO getDummyRolePrivilege();

    RoleDTO findByID(String roleID);

    List<RoleDTO> findAll();

    List<RoleDTO> findAllByStatus(StatusData statusData);

    List<RoleDTO> findByParameter(String roleName);

    List<String> grantedAuthoritys(String roleID);
}
