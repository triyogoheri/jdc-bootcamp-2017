package com.agit.jdc.bootcamp.usermanagement.domain.user;

public class UserSpecificationBuilder {

    private String fullName;
    private String email;
    private String mobilePhone;
    private AccessTime accessTime;
    private UserLoginInfo userLoginInfo;

    public UserSpecificationBuilder() {
    }

    public UserSpecificationBuilder setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public UserSpecificationBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public UserSpecificationBuilder setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
        return this;
    }

    public UserSpecificationBuilder setAccessTime(AccessTime accessTime) {
        this.accessTime = accessTime;
        return this;
    }

    public UserSpecificationBuilder setUserLoginInfo(UserLoginInfo userLoginInfo) {
        this.userLoginInfo = userLoginInfo;
        return this;
    }

    public UserSpecification createUserSpecification() {
        return new UserSpecification(fullName, email, mobilePhone, accessTime, userLoginInfo);
    }
    
}
