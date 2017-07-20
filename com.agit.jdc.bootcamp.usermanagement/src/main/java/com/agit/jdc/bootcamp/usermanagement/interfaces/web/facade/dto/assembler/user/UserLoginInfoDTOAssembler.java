package com.agit.jdc.bootcamp.usermanagement.interfaces.web.facade.dto.assembler.user;

import com.agit.jdc.bootcamp.common.dto.usermanagement.UserLoginInfoDTO;
import com.agit.jdc.bootcamp.common.dto.usermanagement.UserLoginInfoDTOBuilder;
import com.agit.jdc.bootcamp.shared.object.IObjectAssembler;
import com.agit.jdc.bootcamp.usermanagement.domain.user.UserLoginInfo;
import com.agit.jdc.bootcamp.usermanagement.domain.user.UserLoginInfoBuilder;

/**
 *
 * @author bayutridewanto
 */
public class UserLoginInfoDTOAssembler implements IObjectAssembler<UserLoginInfo, UserLoginInfoDTO> {

    @Override
    public UserLoginInfoDTO toDTO(UserLoginInfo domainObject) {
        return new UserLoginInfoDTOBuilder()
                .setCredentialsExpiredDate(domainObject.getCredentialsExpiredDate())
                .setLastLogin(domainObject.getLastLogin())
                .setLastLoginFailed(domainObject.getLastLoginFailed())
                .setLoginAttempt(domainObject.getLoginAttempt())
                .setLoginDate(domainObject.getLoginDate())
                .setLogoutDate(domainObject.getLogoutDate())
                .setRemoteAddress(domainObject.getRemoteAddress())
                .setRemoteHost(domainObject.getRemoteHost())
                .setSessionID(domainObject.getSessionID())
                .createUserLoginInfoDTO();
    }

    @Override
    public UserLoginInfo toDomain(UserLoginInfoDTO dtoObject) {
        return new UserLoginInfoBuilder()
                .setCredentialsExpiredDate(dtoObject.getCredentialsExpiredDate())
                .setLastLogin(dtoObject.getLastLogin())
                .setLastLoginFailed(dtoObject.getLastLoginFailed())
                .setLoginAttempt(dtoObject.getLoginAttempt())
                .setLoginDate(dtoObject.getLoginDate())
                .setLogoutDate(dtoObject.getLogoutDate())
                .setRemoteAddress(dtoObject.getRemoteAddress())
                .setRemoteHost(dtoObject.getRemoteHost())
                .setSessionID(dtoObject.getSessionID())
                .createUserLoginInfo();
    }

}
