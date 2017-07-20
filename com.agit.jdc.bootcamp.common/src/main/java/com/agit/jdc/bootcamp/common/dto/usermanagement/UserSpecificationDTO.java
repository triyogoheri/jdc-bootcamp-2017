package com.agit.jdc.bootcamp.common.dto.usermanagement;

import java.io.Serializable;

/**
 *
 * @author bayutridewanto
 */
public class UserSpecificationDTO implements Serializable {

    private String fullName;
    private String email;
    private String mobilePhone;
    private AccessTimeDTO accessTimeDTO;
    private UserLoginInfoDTO userLoginInfoDTO;

    public UserSpecificationDTO() {
    }

    public UserSpecificationDTO(String fullName, String email, String mobilePhone, AccessTimeDTO accessTimeDTO, UserLoginInfoDTO userLoginInfoDTO) {
        this.fullName = fullName;
        this.email = email;
        this.mobilePhone = mobilePhone;
        this.accessTimeDTO = accessTimeDTO;
        this.userLoginInfoDTO = userLoginInfoDTO;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public AccessTimeDTO getAccessTimeDTO() {
        return accessTimeDTO;
    }

    public void setAccessTimeDTO(AccessTimeDTO accessTimeDTO) {
        this.accessTimeDTO = accessTimeDTO;
    }

    public UserLoginInfoDTO getUserLoginInfoDTO() {
        return userLoginInfoDTO;
    }

    public void setUserLoginInfoDTO(UserLoginInfoDTO userLoginInfoDTO) {
        this.userLoginInfoDTO = userLoginInfoDTO;
    }

    @Override
    public String toString() {
        return "UserSpecificationDTO{" + "fullName=" + fullName + ", email=" + email + ", mobilePhone=" + mobilePhone + ", accessTimeDTO=" + accessTimeDTO + ", userLoginInfoDTO=" + userLoginInfoDTO + '}';
    }

    public static UserSpecificationDTO getInstance() {
        UserSpecificationDTO userSpecification = new UserSpecificationDTOBuilder()
                .setAccessTimeDTO(AccessTimeDTO.getInstance())
                .setEmail("email")
                .setFullName("fullName")
                .setMobilePhone("mobilePhone")
                .setUserLoginInfoDTO(UserLoginInfoDTO.getInstance())
                .createUserSpecificationDTO();

        return userSpecification;

    }
}
