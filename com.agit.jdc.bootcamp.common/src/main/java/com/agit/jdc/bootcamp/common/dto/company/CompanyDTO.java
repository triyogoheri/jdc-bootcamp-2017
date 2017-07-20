package com.agit.jdc.bootcamp.common.dto.company;

import com.agit.jdc.bootcamp.shared.type.PlatformType;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author ASUS
 */
public class CompanyDTO implements Serializable {

    /* attribut for this domain */
    private String companyID;
    private String businessGroupID;
    private String companyName;
    private String companyDescription;
    private String address;
    private String npwp;
    private String telp;
    private PlatformType platform;
    private String createdBy;
    private Date createdDate;
    private String updatedBy;
    private Date updatedDate;

    public CompanyDTO() {
    }

    public CompanyDTO(String companyID, String businessGroupID, String companyName, String companyDescription, String address, String npwp, String telp, PlatformType platform, String createdBy, Date createdDate, String updatedBy, Date updatedDate) {
        this.companyID = companyID;
        this.businessGroupID = businessGroupID;
        this.companyName = companyName;
        this.companyDescription = companyDescription;
        this.address = address;
        this.npwp = npwp;
        this.telp = telp;
        this.platform = platform;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.updatedBy = updatedBy;
        this.updatedDate = updatedDate;
    }

    public String getCompanyID() {
        return companyID;
    }

    public void setCompanyID(String companyID) {
        this.companyID = companyID;
    }

    public String getBusinessGroupID() {
        return businessGroupID;
    }

    public void setBusinessGroupID(String businessGroupID) {
        this.businessGroupID = businessGroupID;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyDescription() {
        return companyDescription;
    }

    public void setCompanyDescription(String companyDescription) {
        this.companyDescription = companyDescription;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNpwp() {
        return npwp;
    }

    public void setNpwp(String npwp) {
        this.npwp = npwp;
    }

    public String getTelp() {
        return telp;
    }

    public void setTelp(String telp) {
        this.telp = telp;
    }

    public PlatformType getPlatform() {
        return platform;
    }

    public void setPlatform(PlatformType platform) {
        this.platform = platform;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss", timezone = "Asia/Bangkok")
    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss", timezone = "Asia/Bangkok")
    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    @Override
    public String toString() {
        return "CompanyDTO{" + "companyID=" + companyID + ", businessGroupID=" + businessGroupID + ", companyName=" + companyName + ", companyDescription=" + companyDescription + ", address=" + address + ", npwp=" + npwp + ", telp=" + telp + ", platform=" + platform + ", createdBy=" + createdBy + ", createdDate=" + createdDate + ", updatedBy=" + updatedBy + ", updatedDate=" + updatedDate + '}';
    }

}
