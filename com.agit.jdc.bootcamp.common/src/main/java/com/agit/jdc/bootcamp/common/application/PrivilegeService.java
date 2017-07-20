package com.agit.jdc.bootcamp.common.application;

import com.agit.jdc.bootcamp.common.dto.usermanagement.PrivilegeDTO;
import java.util.List;
import java.util.Map;

/**
 *
 * @author bayutridewanto
 */
public interface PrivilegeService {

    void saveOrUpdate(PrivilegeDTO privilege);
    
    PrivilegeDTO getDummyPrivilege();

    PrivilegeDTO findByID(String privilegeID);
    
    List<PrivilegeDTO> findByListID(List<String> privilegeID);

    List<PrivilegeDTO> findAll();

    List<PrivilegeDTO> findByParameter(String privilegeId);
    
    List<PrivilegeDTO> findByParams(Map map);

    List<PrivilegeDTO> findByParentId(String parentId, boolean isMenu);

    List<PrivilegeDTO> findMenu();
    
    List<PrivilegeDTO> findMenu(String privilegeID);
}
