package com.agit.jdc.bootcamp.usermanagement.interfaces.web.rest;

import com.agit.jdc.bootcamp.common.application.PrivilegeService;
import com.agit.jdc.bootcamp.common.dto.usermanagement.PrivilegeDTO;
import com.agit.jdc.bootcamp.usermanagement.interfaces.web.facade.PrivilegeServiceFacade;
import java.util.List;
import java.util.Map;
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
public class PrivilegeServiceRestImpl implements PrivilegeServiceFacade {

    @Autowired
    private PrivilegeService privilegeService;

    @Override
    @RequestMapping(value = "/jdc.service.privilege.save", method = RequestMethod.POST)
    public ResponseEntity<Void> saveOrUpdate(@RequestBody PrivilegeDTO privilege) {
        Validate.notNull(privilegeService);
        privilegeService.saveOrUpdate(privilege);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    @RequestMapping(value = "/jdc.service.privilege.getByID/{id}", method = RequestMethod.GET)
    public ResponseEntity<PrivilegeDTO> findByID(@PathVariable("id") String privilegeID) {
        PrivilegeDTO privilegeDTO = privilegeService.findByID(privilegeID);
        if (privilegeDTO != null) {
            return new ResponseEntity<>((privilegeDTO), HttpStatus.FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    @RequestMapping(value = "/jdc.service.privilege.getDummy", method = RequestMethod.GET)
    public ResponseEntity<PrivilegeDTO> getDummyPrivilege() {
        return new ResponseEntity<>(privilegeService.getDummyPrivilege(), HttpStatus.FOUND);
    }

    @Override
    @RequestMapping(value = "/jdc.service.privilege.getByListID/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<PrivilegeDTO>> findByListID(@PathVariable("id") List<String> privilegeID) {
        List<PrivilegeDTO> privilegeDTOs = privilegeService.findByListID(privilegeID);
        if (!privilegeDTOs.isEmpty()) {
            return new ResponseEntity<>((privilegeDTOs), HttpStatus.FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    @RequestMapping(value = "/jdc.service.privilege.getAll", method = RequestMethod.GET)
    public ResponseEntity<List<PrivilegeDTO>> findAll() {
        List<PrivilegeDTO> privilegeDTOs = privilegeService.findAll();
        if (!privilegeDTOs.isEmpty()) {
            return new ResponseEntity<>((privilegeDTOs), HttpStatus.FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    @RequestMapping(value = "/jdc.service.privilege.getByParameter/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<PrivilegeDTO>> findByParameter(@PathVariable("id") String privilegeId) {
        List<PrivilegeDTO> privilegeDTOs = privilegeService.findByParameter(privilegeId);
        if (!privilegeDTOs.isEmpty()) {
            return new ResponseEntity<>((privilegeDTOs), HttpStatus.FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    @RequestMapping(value = "/jdc.service.privilege.getByParams/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<PrivilegeDTO>> findByParams(@PathVariable("id") Map map) {
        List<PrivilegeDTO> privilegeDTOs = privilegeService.findByParams(map);
        if (!privilegeDTOs.isEmpty()) {
            return new ResponseEntity<>((privilegeDTOs), HttpStatus.FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    @RequestMapping(value = "/jdc.service.privilege.getByParentID/{parentId}/{isMenu}", method = RequestMethod.GET)
    public ResponseEntity<List<PrivilegeDTO>> findByParentId(@PathVariable("parentId") String parentId, @PathVariable("isMenu") boolean isMenu) {
        List<PrivilegeDTO> privilegeDTOs = privilegeService.findByParentId(parentId, isMenu);
        if (!privilegeDTOs.isEmpty()) {
            return new ResponseEntity<>((privilegeDTOs), HttpStatus.FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    @RequestMapping(value = "/jdc.service.privilege.getMenu", method = RequestMethod.GET)
    public ResponseEntity<List<PrivilegeDTO>> findMenu() {
        List<PrivilegeDTO> privilegeDTOs = privilegeService.findMenu();
        if (!privilegeDTOs.isEmpty()) {
            return new ResponseEntity<>((privilegeDTOs), HttpStatus.FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    @RequestMapping(value = "/jdc.service.privilege.getMenuByPrivilegeID/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<PrivilegeDTO>> findMenu(@PathVariable("id") String privilegeID) {
        List<PrivilegeDTO> privilegeDTOs = privilegeService.findMenu(privilegeID);
        if (!privilegeDTOs.isEmpty()) {
            return new ResponseEntity<>((privilegeDTOs), HttpStatus.FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
