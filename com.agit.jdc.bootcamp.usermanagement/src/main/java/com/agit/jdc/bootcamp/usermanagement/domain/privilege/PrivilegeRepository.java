package com.agit.jdc.bootcamp.usermanagement.domain.privilege;

import com.agit.jdc.bootcamp.shared.type.StatusData;
import java.util.List;
import java.util.Map;

/**
 *
 * @author bayutridewanto
 */
public interface PrivilegeRepository {

    void saveOrUpdate(Privilege privilege);

    Privilege findByID(String privilegeID, StatusData status);
    
    List<Privilege> findByListID(List<String> privilegeID, StatusData status);

    List<Privilege> findAll();

    List<Privilege> findByParameter(String privilegeId);
    
    List<Privilege> findByParams(Map map);

    List<Privilege> findByParentId(String parentId, boolean isMenu);

    List<String> getAllAuthorities();

}
