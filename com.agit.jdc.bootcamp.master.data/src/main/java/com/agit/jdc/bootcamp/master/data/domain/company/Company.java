package com.agit.jdc.bootcamp.master.data.domain.company;

import com.agit.jdc.bootcamp.shared.object.EntityObject;
import com.agit.jdc.bootcamp.shared.type.PlatformType;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author ASUS
 */
public class Company implements EntityObject<Company> {

    /* for hibernate purpose */
    long id;

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

    public Company() {
    }

    public Company(String companyID, String businessGroupID, String companyName, String companyDescription, String address, String npwp, String telp, PlatformType platform, String createdBy, Date createdDate, String updatedBy, Date updatedDate) {
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

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.companyID);
        hash = 29 * hash + Objects.hashCode(this.businessGroupID);
        hash = 29 * hash + Objects.hashCode(this.companyName);
        hash = 29 * hash + Objects.hashCode(this.companyDescription);
        hash = 29 * hash + Objects.hashCode(this.address);
        hash = 29 * hash + Objects.hashCode(this.npwp);
        hash = 29 * hash + Objects.hashCode(this.telp);
        hash = 29 * hash + Objects.hashCode(this.platform);
        hash = 29 * hash + Objects.hashCode(this.createdBy);
        hash = 29 * hash + Objects.hashCode(this.createdDate);
        hash = 29 * hash + Objects.hashCode(this.updatedBy);
        hash = 29 * hash + Objects.hashCode(this.updatedDate);
        return hash;
    }

    @Override
    public String toString() {
        return "Company{" + "id=" + id + ", companyID=" + companyID + ", businessGroupID=" + businessGroupID + ", companyName=" + companyName + ", companyDescription=" + companyDescription + ", address=" + address + ", npwp=" + npwp + ", telp=" + telp + ", platform=" + platform + ", createdBy=" + createdBy + ", createdDate=" + createdDate + ", updatedBy=" + updatedBy + ", updatedDate=" + updatedDate + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Company other = (Company) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    /* for updating data purpose */
    public void assignNewCompany(Company company) {
        this.companyID = company.companyID;
        this.businessGroupID = company.businessGroupID;
        this.companyName = company.companyName;
        this.companyDescription = company.companyDescription;
        this.address = company.address;
        this.npwp = company.npwp;
        this.telp = company.telp;
        this.platform = company.platform;
        this.updatedBy = company.updatedBy;
        this.updatedDate = company.updatedDate;
    }

    @Override
    public boolean sameIdentityAs(Company other) {
        return this.equals(other);
    }

}
