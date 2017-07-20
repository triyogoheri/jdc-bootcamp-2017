package com.agit.jdc.bootcamp.usermanagement.interfaces.web.rest;

import com.agit.jdc.bootcamp.common.application.UserService;
import com.agit.jdc.bootcamp.common.dto.usermanagement.UserDTO;
import com.agit.jdc.bootcamp.common.dto.usermanagement.UserLoginInfoDTO;
import com.agit.jdc.bootcamp.shared.status.StatusCode;
import com.agit.jdc.bootcamp.shared.type.ReleaseType;
import com.agit.jdc.bootcamp.shared.type.StatusData;
import com.agit.jdc.bootcamp.usermanagement.interfaces.web.facade.UserServiceFacade;
import java.util.List;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
public class UserServiceRestImpl implements UserServiceFacade {

    @Autowired
    private UserService userService;

    @Override
    @RequestMapping(value = "/jdc.service.user.save", method = RequestMethod.POST)
    public ResponseEntity<Void> saveOrUpdate(@RequestBody UserDTO user) {
        Validate.notNull(userService);
        userService.saveOrUpdate(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    @RequestMapping(value = "/jdc.service.user.getDummy", method = RequestMethod.GET)
    public ResponseEntity<UserDTO> getDummyUser() {
        return new ResponseEntity<>(userService.getDummyUser(), HttpStatus.FOUND);
    }

    @Override
    @RequestMapping(value = "/jdc.service.user.getByID/{id}", method = RequestMethod.GET)
    public ResponseEntity<UserDTO> findByID(@PathVariable("id") String userName) {
        UserDTO userDTO = userService.findByID(userName);
        if (userDTO != null) {
            return new ResponseEntity<>((userDTO), HttpStatus.FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    @RequestMapping(value = "/jdc.service.user.getByRemote/{id}", method = RequestMethod.GET)
    public ResponseEntity<UserDTO> findByRemote(@PathVariable("id") String remote) {
        UserDTO userDTO = userService.findByID(remote);
        if (userDTO != null) {
            return new ResponseEntity<>((userDTO), HttpStatus.FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    @RequestMapping(value = "/jdc.service.user.getAll", method = RequestMethod.GET)
    public ResponseEntity<List<UserDTO>> findAllUser() {
        List<UserDTO> userDTOs = userService.findAllUser();
        if (!userDTOs.isEmpty()) {
            return new ResponseEntity<>((userDTOs), HttpStatus.FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    @RequestMapping(value = "/jdc.service.user.getByParameter/{fullName}/{userName}/{roleID}/{userStatus}", method = RequestMethod.GET)
    public ResponseEntity<List<UserDTO>> findByParameter(@PathVariable("fullName") String fullName, @PathVariable("userName") String userName, @PathVariable("roleID") String roleID, @PathVariable("userStatus") StatusData userStatus) {
        List<UserDTO> userDTOs = userService.findByParameter(fullName, userName, roleID, userStatus);
        if (!userDTOs.isEmpty()) {
            return new ResponseEntity<>((userDTOs), HttpStatus.FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    @RequestMapping(value = "/jdc.service.user.release/{releaseType}/{release}", method = RequestMethod.GET)
    public ResponseEntity<StatusCode> release(@PathVariable("releaseType") String releaseType, @PathVariable("release") String release) {
        Validate.notNull(userService);
        userService.release(releaseType, release);
        UserDTO user;
        if (releaseType.equals(ReleaseType.USERNAME.name())) {
            user = userService.findByID(release);
        } else {
            user = userService.findByRemote(release);
        }
        if (user != null) {
            UserLoginInfoDTO u = user.getUserSpecificationDTO().getUserLoginInfoDTO();
            u.setRemoteHost(null);
            u.setRemoteAddress(null);
            user.getUserSpecificationDTO().setUserLoginInfoDTO(u);
            userService.saveOrUpdate(user);
            return new ResponseEntity<>((StatusCode.CREATED), HttpStatus.CREATED);
        }
        return new ResponseEntity<>((StatusCode.FOUND), HttpStatus.FOUND);

    }

    @Override
    @RequestMapping(value = "/jdc.service.user.releaseAll", method = RequestMethod.GET)
    public ResponseEntity<StatusCode> releaseAll() {
        Validate.notNull(userService);
        userService.releaseAll();
        return new ResponseEntity<>((StatusCode.CREATED), HttpStatus.CREATED);
    }

    @Override
    @RequestMapping(value = "/jdc.service.user.count/{roleID}", method = RequestMethod.GET)
    public ResponseEntity<Integer> count(@PathVariable("roleID") String roleID) {
        Validate.notNull(userService);
        return new ResponseEntity<>((userService.count(roleID)), HttpStatus.CREATED);
    }

    @Override
    @RequestMapping(value = "/jdc.service.user.updatePassword/{userName}/{newPassword}", method = RequestMethod.GET)
    public ResponseEntity<StatusCode> updatePassword(@PathVariable("userName") String userName, @PathVariable("newPassword") String newPassword) {
        Validate.notNull(userService);
        UserDTO user = userService.findByID(userName);
        user.setPassword(new BCryptPasswordEncoder().encode(newPassword));
        userService.saveOrUpdate(user);
        return new ResponseEntity<>((StatusCode.UPDATED), HttpStatus.CREATED);
    }

    @Override
    @RequestMapping(value = "/jdc.service.user.updateLockUnlock/{userName}/{loginAttempt}", method = RequestMethod.GET)
    public ResponseEntity<StatusCode> updateLockUnlock(@PathVariable("userName") String userName, @PathVariable("loginAttempt") Integer loginAttempt) {
        Validate.notNull(userService);
        UserDTO user = userService.findByID(userName);
        UserLoginInfoDTO u = user.getUserSpecificationDTO().getUserLoginInfoDTO();
        u.setLoginAttempt(loginAttempt);
        user.getUserSpecificationDTO().setUserLoginInfoDTO(u);
        userService.saveOrUpdate(user);
        return new ResponseEntity<>((StatusCode.UPDATED), HttpStatus.CREATED);
    }

    @Override
    @RequestMapping(value = "/jdc.service.user.updateLoginInfo/{userName}/{loginInfo}", method = RequestMethod.GET)
    public ResponseEntity<StatusCode> updateLoginInfo(@PathVariable("userName") String userName, @PathVariable("loginInfo") UserLoginInfoDTO loginInfo) {
        Validate.notNull(userService);
        UserDTO user = userService.findByID(userName);
        user.getUserSpecificationDTO().setUserLoginInfoDTO(loginInfo);
        userService.saveOrUpdate(user);
        return new ResponseEntity<>((StatusCode.UPDATED), HttpStatus.CREATED);
    }

    @Override
    @RequestMapping(value = "/jdc.service.user.delete/{userName}", method = RequestMethod.GET)
    public ResponseEntity<StatusCode> delete(@PathVariable("userName") String userName) {
        Validate.notNull(userService);
        UserDTO user = userService.findByID(userName);
        user.setUserStatus(StatusData.DELETED);
        userService.saveOrUpdate(user);
        return new ResponseEntity<>((StatusCode.UPDATED), HttpStatus.CREATED);
    }

    @Override
    @RequestMapping(value = "/jdc.service.user.isNotExistUserName/{userName}", method = RequestMethod.GET)
    public ResponseEntity<Boolean> isNotExistUserName(@PathVariable("userName") String userName) {
        Validate.notNull(userService);
        UserDTO user = userService.findByID(userName);
        return new ResponseEntity<>((user.getUserName() == null ? Boolean.TRUE : Boolean.FALSE), HttpStatus.CREATED);
    }

    @Override
    @RequestMapping(value = "/jdc.service.user.isNotExistIPAddress/{ipAddress}", method = RequestMethod.GET)
    public ResponseEntity<Boolean> isNotExistIPAddress(@PathVariable("ipAddress") String ipAddress) {
        Validate.notNull(userService);
        UserDTO user = userService.findByRemote(ipAddress);
        return new ResponseEntity<>((user.getUserName() == null ? Boolean.TRUE : Boolean.FALSE), HttpStatus.CREATED);
    }

    @Override
    @RequestMapping(value = "/jdc.service.user.checkAuthentication/{username}/{password}", method = RequestMethod.GET)
    public ResponseEntity<Boolean> getAuthentication(@PathVariable("username") String username, @PathVariable("password") String password) {
        Validate.notNull(userService);
        return new ResponseEntity<>((userService.getAuthentication(username, password)), HttpStatus.CREATED);
    }

}
