package com.agit.jdc.bootcamp.usermanagement.interfaces.web.facade;

import com.agit.jdc.bootcamp.common.dto.usermanagement.UserDTO;
import com.agit.jdc.bootcamp.common.dto.usermanagement.UserLoginInfoDTO;
import com.agit.jdc.bootcamp.shared.status.StatusCode;
import com.agit.jdc.bootcamp.shared.type.StatusData;
import java.util.List;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author lintang
 */
public interface UserServiceFacade {

    ResponseEntity<Void> saveOrUpdate(UserDTO user);

    ResponseEntity<UserDTO> getDummyUser();

    ResponseEntity<UserDTO> findByID(String userName);

    ResponseEntity<UserDTO> findByRemote(String remote);

    ResponseEntity<List<UserDTO>> findAllUser();

    ResponseEntity<List<UserDTO>> findByParameter(String fullName, String userName, String roleID, StatusData userStatus);

    ResponseEntity<StatusCode> release(String releaseType, String release);

    ResponseEntity<StatusCode> releaseAll();

    ResponseEntity<Integer> count(String roleID);

    ResponseEntity<StatusCode> updatePassword(String userName, String newPassword);

    ResponseEntity<StatusCode> updateLockUnlock(String userName, Integer loginAttempt);

    ResponseEntity<StatusCode> updateLoginInfo(String userName, UserLoginInfoDTO loginInfo);

    ResponseEntity<StatusCode> delete(String userName);

    ResponseEntity<Boolean> isNotExistUserName(String userName);

    ResponseEntity<Boolean> isNotExistIPAddress(String ipAddress);

    ResponseEntity<Boolean> getAuthentication(String username, String password);
}
