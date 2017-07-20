package com.agit.jdc.bootcamp.usermanagement.domain.user;

import com.agit.jdc.bootcamp.shared.object.ValueObject;
import java.util.Objects;

/**
 *
 * @author bayutridewanto
 */
public class UserSpecification implements ValueObject<UserSpecification> {

    private String fullName;
    private String email;
    private String mobilePhone;
    private AccessTime accessTime;
    private UserLoginInfo userLoginInfo;

    public UserSpecification() {
    }

    public UserSpecification(String fullName, String email, String mobilePhone, AccessTime accessTime, UserLoginInfo userLoginInfo) {
        this.fullName = fullName;
        this.email = email;
        this.mobilePhone = mobilePhone;
        this.accessTime = accessTime;
        this.userLoginInfo = userLoginInfo;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public AccessTime getAccessTime() {
        return accessTime;
    }

    public UserLoginInfo getUserLoginInfo() {
        return userLoginInfo;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + Objects.hashCode(this.fullName);
        hash = 47 * hash + Objects.hashCode(this.email);
        hash = 47 * hash + Objects.hashCode(this.mobilePhone);
        hash = 47 * hash + Objects.hashCode(this.accessTime);
        hash = 47 * hash + Objects.hashCode(this.userLoginInfo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final UserSpecification other = (UserSpecification) obj;
        if (!Objects.equals(this.fullName, other.fullName)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.mobilePhone, other.mobilePhone)) {
            return false;
        }
        if (!Objects.equals(this.accessTime, other.accessTime)) {
            return false;
        }
        if (!Objects.equals(this.userLoginInfo, other.userLoginInfo)) {
            return false;
        }
        return true;
    }

    @Override
    public boolean sameValueAs(UserSpecification other) {
        return this.equals(other);
    }

    public void assignNewLoginInfo(UserLoginInfo loginInfo) {
        this.userLoginInfo = loginInfo;
    }

}
