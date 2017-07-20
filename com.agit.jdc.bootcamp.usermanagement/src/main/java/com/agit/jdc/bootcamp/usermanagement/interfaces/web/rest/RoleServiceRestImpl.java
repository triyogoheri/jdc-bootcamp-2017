package com.agit.jdc.bootcamp.usermanagement.interfaces.web.rest;

import com.agit.jdc.bootcamp.common.application.RoleService;
import com.agit.jdc.bootcamp.common.dto.usermanagement.RoleDTO;
import com.agit.jdc.bootcamp.shared.type.StatusData;
import com.agit.jdc.bootcamp.usermanagement.interfaces.web.facade.RoleServiceFacade;
import java.util.List;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author lintang
 */
@Controller
public class RoleServiceRestImpl implements RoleServiceFacade {

    @Autowired
    private RoleService roleService;

    @Override
    @RequestMapping(value = "/jdc.service.role.save", method = RequestMethod.POST)
    public ResponseEntity<Void> saveOrUpdate(@RequestBody RoleDTO role) {
        Validate.notNull(roleService);
        roleService.saveOrUpdate(role);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    @RequestMapping(value = "/jdc.service.role.getDummy", method = RequestMethod.GET)
    public ResponseEntity<RoleDTO> getDummyRolePrivilege() {
        return new ResponseEntity<>(roleService.getDummyRolePrivilege(), HttpStatus.FOUND);
    }

    @Override
    @RequestMapping(value = "/jdc.service.role.getByID/{id}", method = RequestMethod.GET)
    public ResponseEntity<RoleDTO> findByID(@PathVariable("id") String roleID) {
        RoleDTO roleDTO = roleService.findByID(roleID);
        if (roleDTO != null) {
            return new ResponseEntity<>((roleDTO), HttpStatus.FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    @RequestMapping(value = "/jdc.service.role.getAll", method = RequestMethod.GET)
    public ResponseEntity<List<RoleDTO>> findAll() {
        List<RoleDTO> roleDTOs = roleService.findAll();
        if (!roleDTOs.isEmpty()) {
            return new ResponseEntity<>((roleDTOs), HttpStatus.FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    @RequestMapping(value = "/jdc.service.role.getAllByStatus/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<RoleDTO>> findAllByStatus(@PathVariable("id") StatusData statusData) {
        List<RoleDTO> roleDTOs = roleService.findAllByStatus(statusData);
        if (!roleDTOs.isEmpty()) {
            return new ResponseEntity<>((roleDTOs), HttpStatus.FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    @RequestMapping(value = "/jdc.service.role.getByParameter/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<RoleDTO>> findByParameter(@PathVariable("id") String roleName) {
        List<RoleDTO> roleDTOs = roleService.findByParameter(roleName);
        if (!roleDTOs.isEmpty()) {
            return new ResponseEntity<>((roleDTOs), HttpStatus.FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    @RequestMapping(value = "/jdc.service.role.grantedAuthoritys/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<String>> grantedAuthoritys(@PathVariable("id") String roleID) {
        List<String> listData = roleService.grantedAuthoritys(roleID);
        if (!listData.isEmpty()) {
            return new ResponseEntity<>((listData), HttpStatus.FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
