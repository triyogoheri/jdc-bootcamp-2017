package com.agit.jdc.bootcamp.main.viewmodel;

import com.agit.jdc.bootcamp.common.dto.usermanagement.UserDTO;
import com.agit.jdc.bootcamp.shared.zul.CommonViewModel;
import com.agit.jdc.bootcamp.common.security.SecurityUtil;
import com.agit.jdc.bootcamp.util.DateUtil;
import com.agit.jdc.bootcamp.util.JDCStringUtil;
import java.util.Date;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zul.Window;

/**
 *
 * @author bayutridewanto
 */
public class DashboardVM {
    /* data user */
    private UserDTO user;
    private String userNPWP;
    private String role;
    private String uriPhoto;

    @Init
    public void init(@ContextParam(ContextType.COMPONENT) Window window) {
        user = SecurityUtil.getUser();
        userNPWP = SecurityUtil.getUserName();
        role = SecurityUtil.getUser().getRoleDTO().getRoleID();
        
        switch (role) {
            default:
                uriPhoto = "/images/agit-logo.png";
                break;
        }
    }

    @Command({"buttonOk", "buttonClose"})
    public void buttonOk(@ContextParam(ContextType.VIEW) Window window) {
        CommonViewModel.onCloseTab();
    }

    /* helper */
    public String concatUsername(String s1, String s2) {
        if (!JDCStringUtil.hasValue(s2)) {
            s2 = "-";
        }
        return s1.concat(s2);
    }

    public String concatDate(String s1, Date s2) {
        String s3 = DateUtil.dateToString(s2, "dd-MMM-yyy HH:mm:ss");
        if (!JDCStringUtil.hasValue(s2)) {
            s3 = "-";
        }
        return s1.concat(s3);
    }

    /* Getter&Setter */
    public String getUserNPWP() {
        return userNPWP;
    }

    public void setUserNPWP(String userNPWP) {
        this.userNPWP = userNPWP;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUriPhoto() {
        return uriPhoto;
    }

    public void setUriPhoto(String uriPhoto) {
        this.uriPhoto = uriPhoto;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

}
