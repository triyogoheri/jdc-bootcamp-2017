package com.agit.jdc.bootcamp.shared.object;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author bayutridewanto
 */
public class CreationalSpecification implements ValueObject<CreationalSpecification> {

    private Date createdDate;
    private String createdBy;
    private Date updatedDate;
    private String updatedBy;

    public CreationalSpecification() {
    }

    public CreationalSpecification(Date createdDate, String createdBy, Date updatedDate, String updatedBy) {
        this.createdDate = createdDate;
        this.createdBy = createdBy;
        this.updatedDate = updatedDate;
        this.updatedBy = updatedBy;
    }

    @JsonIgnore
    public CreationalSpecification getInstance() {
        return new CreationalSpecificationBuilder()
                .setCreatedDate(new Date())
                .setCreatedBy("SYSTEM")
                .setUpdatedDate(null)
                .setUpdatedBy(null)
                .createCreationalSpecification();
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss", timezone = "Asia/Bangkok")
    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss", timezone = "Asia/Bangkok")
    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.createdDate);
        hash = 97 * hash + Objects.hashCode(this.createdBy);
        hash = 97 * hash + Objects.hashCode(this.updatedDate);
        hash = 97 * hash + Objects.hashCode(this.updatedBy);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CreationalSpecification other = (CreationalSpecification) obj;
        if (!Objects.equals(this.createdBy, other.createdBy)) {
            return false;
        }
        if (!Objects.equals(this.updatedBy, other.updatedBy)) {
            return false;
        }
        if (!Objects.equals(this.createdDate, other.createdDate)) {
            return false;
        }
        if (!Objects.equals(this.updatedDate, other.updatedDate)) {
            return false;
        }
        return true;
    }

    @Override
    public boolean sameValueAs(CreationalSpecification other) {
        return this.equals(other);
    }

    @Override
    public String toString() {
        return "CreationalSpecification{" + "createdDate=" + createdDate + ", createdBy=" + createdBy + ", updatedDate=" + updatedDate + ", updatedBy=" + updatedBy + '}';
    }
}
