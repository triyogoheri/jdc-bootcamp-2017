package com.agit.jdc.bootcamp.usermanagement.interfaces.web.facade.dto.assembler.user;

import com.agit.jdc.bootcamp.common.dto.usermanagement.UserSpecificationDTO;
import com.agit.jdc.bootcamp.common.dto.usermanagement.UserSpecificationDTOBuilder;
import com.agit.jdc.bootcamp.shared.object.IObjectAssembler;
import com.agit.jdc.bootcamp.usermanagement.domain.user.UserSpecification;
import com.agit.jdc.bootcamp.usermanagement.domain.user.UserSpecificationBuilder;

/**
 *
 * @author bayutridewanto
 */
public class UserSpecificationDTOAssembler implements IObjectAssembler<UserSpecification, UserSpecificationDTO> {

    @Override
    public UserSpecificationDTO toDTO(UserSpecification domainObject) {
        return new UserSpecificationDTOBuilder()
                .setAccessTimeDTO(new AccessTimeDTOAssembler().toDTO(domainObject.getAccessTime()))
                .setUserLoginInfoDTO(new UserLoginInfoDTOAssembler().toDTO(domainObject.getUserLoginInfo()))
                .setEmail(domainObject.getEmail())
                .setFullName(domainObject.getFullName())
                .setMobilePhone(domainObject.getMobilePhone())
                .createUserSpecificationDTO();
    }

    @Override
    public UserSpecification toDomain(UserSpecificationDTO dtoObject) {
        return new UserSpecificationBuilder()
                .setUserLoginInfo(new UserLoginInfoDTOAssembler().toDomain(dtoObject.getUserLoginInfoDTO()))
                .setAccessTime(new AccessTimeDTOAssembler().toDomain(dtoObject.getAccessTimeDTO()))
                .setEmail(dtoObject.getEmail())
                .setFullName(dtoObject.getFullName())
                .setMobilePhone(dtoObject.getMobilePhone())
                .createUserSpecification();
    }

}
