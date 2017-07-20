package com.agit.jdc.bootcamp.common.dto.company;

import com.agit.jdc.bootcamp.shared.type.PlatformType;
import java.util.Date;

public class CompanyDTOBuilder {

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

    public CompanyDTOBuilder() {
    }

    public CompanyDTOBuilder setCompanyID(String companyID) {
        this.companyID = companyID;
        return this;
    }

    public CompanyDTOBuilder setBusinessGroupID(String businessGroupID) {
        this.businessGroupID = businessGroupID;
        return this;
    }

    public CompanyDTOBuilder setCompanyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    public CompanyDTOBuilder setCompanyDescription(String companyDescription) {
        this.companyDescription = companyDescription;
        return this;
    }

    public CompanyDTOBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public CompanyDTOBuilder setNpwp(String npwp) {
        this.npwp = npwp;
        return this;
    }

    public CompanyDTOBuilder setTelp(String telp) {
        this.telp = telp;
        return this;
    }

    public CompanyDTOBuilder setPlatform(PlatformType platform) {
        this.platform = platform;
        return this;
    }

    public CompanyDTOBuilder setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public CompanyDTOBuilder setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public CompanyDTOBuilder setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
        return this;
    }

    public CompanyDTOBuilder setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
        return this;
    }

    public CompanyDTO createCompanyDTO() {
        return new CompanyDTO(companyID, businessGroupID, companyName, companyDescription, address, npwp, telp, platform, createdBy, createdDate, updatedBy, updatedDate);
    }

    @Override
    public String toString() {
        return "CompanyDTOBuilder{" + "companyID=" + companyID + ", businessGroupID=" + businessGroupID + ", companyName=" + companyName + ", companyDescription=" + companyDescription + ", address=" + address + ", npwp=" + npwp + ", telp=" + telp + ", platform=" + platform + ", createdBy=" + createdBy + ", createdDate=" + createdDate + ", updatedBy=" + updatedBy + ", updatedDate=" + updatedDate + '}';
    }

}
