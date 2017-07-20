package com.agit.jdc.bootcamp.master.data.domain.company;

import com.agit.jdc.bootcamp.shared.type.PlatformType;
import java.util.Date;

public class CompanyBuilder {

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

    public CompanyBuilder() {
    }

    public CompanyBuilder setCompanyID(String companyID) {
        this.companyID = companyID;
        return this;
    }

    public CompanyBuilder setBusinessGroupID(String businessGroupID) {
        this.businessGroupID = businessGroupID;
        return this;
    }

    public CompanyBuilder setCompanyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    public CompanyBuilder setCompanyDescription(String companyDescription) {
        this.companyDescription = companyDescription;
        return this;
    }

    public CompanyBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public CompanyBuilder setNpwp(String npwp) {
        this.npwp = npwp;
        return this;
    }

    public CompanyBuilder setTelp(String telp) {
        this.telp = telp;
        return this;
    }

    public CompanyBuilder setPlatform(PlatformType platform) {
        this.platform = platform;
        return this;
    }

    public CompanyBuilder setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public CompanyBuilder setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public CompanyBuilder setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
        return this;
    }

    public CompanyBuilder setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
        return this;
    }

    public Company createCompany() {
        return new Company(companyID, businessGroupID, companyName, companyDescription, address, npwp, telp, platform, createdBy, createdDate, updatedBy, updatedDate);
    }

}
