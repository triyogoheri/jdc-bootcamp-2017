package com.agit.jdc.bootcamp.usermanagement.application.impl;

import com.agit.jdc.bootcamp.common.application.RoleService;
import com.agit.jdc.bootcamp.common.dto.usermanagement.PrivilegeDTO;
import com.agit.jdc.bootcamp.common.dto.usermanagement.RoleDTO;
import com.agit.jdc.bootcamp.common.dto.usermanagement.RoleDTOBuilder;
import com.agit.jdc.bootcamp.common.dto.usermanagement.RolePrivilegeDTO;
import com.agit.jdc.bootcamp.shared.type.AccessType;
import com.agit.jdc.bootcamp.shared.type.StatusData;
import com.agit.jdc.bootcamp.usermanagement.domain.privilege.PrivilegeRepository;
import com.agit.jdc.bootcamp.usermanagement.domain.role.Role;
import com.agit.jdc.bootcamp.usermanagement.domain.role.RoleRepository;
import com.agit.jdc.bootcamp.usermanagement.interfaces.web.facade.dto.assembler.role.RoleDTOAssembler;
import com.agit.jdc.bootcamp.usermanagement.interfaces.web.facade.dto.assembler.role.RolePrivilegeDTOAssembler;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.commons.lang3.Validate;

/**
 *
 * @author bayutridewanto
 */
public class RoleServiceImpl implements RoleService {

    private RoleRepository roleRepository;
    private PrivilegeRepository privilegeRepository;
    private RoleDTOAssembler roleDTOAssembler;
    private RolePrivilegeDTOAssembler rolePrivilegeDTOAssembler;

    @Override
    public void saveOrUpdate(RoleDTO roleDTO) {
        Role role = roleRepository.findByID(roleDTO.getRoleID());

        if (role == null) {
            role = roleDTOAssembler.toDomain(roleDTO);
        } else {
            /* update specification */
            role.assignNewSpecification(
                    roleDTO.getRoleName(),
                    roleDTO.getRoleDescription(),
                    roleDTO.getRoleStatus(),
                    rolePrivilegeDTOAssembler.toDomains(roleDTO.getRolePrivilegeDTOs()));
        }

        roleRepository.saveOrUpdate(role);
    }

    @Override
    public RoleDTO findByID(String roleID) {
        Validate.notNull(roleRepository);
        Role role = (Role) roleRepository.findByID(roleID);
        if (role != null) {
            return roleDTOAssembler.toDTO(role);
        }

        return null;
    }

    @Override
    public List<RoleDTO> findAll() {
        Validate.notNull(roleRepository);
        List<Role> roles = (List<Role>) roleRepository.findAll();
        return roleDTOAssembler.toDTOs(roles);
    }

    @Override
    public List<RoleDTO> findAllByStatus(StatusData statusData) {
        Validate.notNull(roleRepository);
        List<Role> roles = (List<Role>) roleRepository.findAllByStatus(statusData);
        return roleDTOAssembler.toDTOs(roles);
    }

    @Override
    public List<RoleDTO> findByParameter(String roleName) {
        Validate.notNull(roleRepository);
        List<Role> roles = (List<Role>) roleRepository.findByParameter(roleName);
        return roleDTOAssembler.toDTOs(roles);
    }

    @Override
    public List<String> grantedAuthoritys(String roleID) {
        List<String> privileges = new ArrayList();
        Role role = roleRepository.findByID(roleID);
        if (role != null) {
            RoleDTO roleDTO = roleDTOAssembler.toDTO(role);
            for (RolePrivilegeDTO rolePrivilegeDTO : roleDTO.getRolePrivilegeDTOs()) {
                if (rolePrivilegeDTO.getAccessType() == AccessType.DENY) {
                    privileges.remove(rolePrivilegeDTO.getPrivilegeDTO().getPrivilegeID());
                    privileges.removeAll(privileges(rolePrivilegeDTO.getPrivilegeDTO().getChildren()));
                } else {
                    privileges.add(rolePrivilegeDTO.getPrivilegeDTO().getPrivilegeID());
                    privileges.addAll(privileges(rolePrivilegeDTO.getPrivilegeDTO().getChildren()));
                }
            }
        }
        return privileges;
    }

    protected List<String> privileges(List<PrivilegeDTO> children) {
        List<String> auth = new ArrayList<>();
        for (PrivilegeDTO privilege : children) {
            auth.add(privilege.getPrivilegeID());
            auth.addAll(privileges(privilege.getChildren()));
        }
        return auth;
    }

    public void setRoleRepository(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public void setPrivilegeRepository(PrivilegeRepository privilegeRepository) {
        this.privilegeRepository = privilegeRepository;
    }

    public void setRoleDTOAssembler(RoleDTOAssembler roleDTOAssembler) {
        this.roleDTOAssembler = roleDTOAssembler;
    }

    public void setRolePrivilegeDTOAssembler(RolePrivilegeDTOAssembler rolePrivilegeDTOAssembler) {
        this.rolePrivilegeDTOAssembler = rolePrivilegeDTOAssembler;
    }

    @Override
    public RoleDTO getDummyRolePrivilege() {
        RolePrivilegeDTO rp = RolePrivilegeDTO.getInstance();
        List<RolePrivilegeDTO> listRolePrivilege = new ArrayList<>();
        listRolePrivilege.add(rp);

        RoleDTO role = new RoleDTOBuilder()
                .setRoleID("roleID")
                .setRoleName("roleName")
                .setRoleStatus(StatusData.ACTIVE)
                .setCreationalBy("creationalBy")
                .setCreationalDate(new Date())
                .setRoleDescription("roleDescription")
                .setRolePrivilegeDTOs(listRolePrivilege)
                .createRoleDTO();
        return role;
    }

}
