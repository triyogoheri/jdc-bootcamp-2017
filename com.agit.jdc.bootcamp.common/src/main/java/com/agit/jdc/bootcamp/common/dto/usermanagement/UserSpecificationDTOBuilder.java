/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.jdc.bootcamp.common.dto.usermanagement;


public class UserSpecificationDTOBuilder {

    private String fullName;
    private String email;
    private String mobilePhone;
    private AccessTimeDTO accessTimeDTO;
    private UserLoginInfoDTO userLoginInfoDTO;

    public UserSpecificationDTOBuilder() {
    }

    public UserSpecificationDTOBuilder setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public UserSpecificationDTOBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public UserSpecificationDTOBuilder setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
        return this;
    }

    public UserSpecificationDTOBuilder setAccessTimeDTO(AccessTimeDTO accessTimeDTO) {
        this.accessTimeDTO = accessTimeDTO;
        return this;
    }

    public UserSpecificationDTOBuilder setUserLoginInfoDTO(UserLoginInfoDTO userLoginInfoDTO) {
        this.userLoginInfoDTO = userLoginInfoDTO;
        return this;
    }

    public UserSpecificationDTO createUserSpecificationDTO() {
        return new UserSpecificationDTO(fullName, email, mobilePhone, accessTimeDTO, userLoginInfoDTO);
    }
    
}
