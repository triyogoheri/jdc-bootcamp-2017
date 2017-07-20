package com.agit.jdc.bootcamp.shared.object;

import java.util.Date;

public class CreationalSpecificationBuilder {

    private Date createdDate;
    private String createdBy;
    private Date updatedDate;
    private String updatedBy;

    public CreationalSpecificationBuilder() {
    }

    public CreationalSpecificationBuilder setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public CreationalSpecificationBuilder setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public CreationalSpecificationBuilder setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
        return this;
    }

    public CreationalSpecificationBuilder setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
        return this;
    }

    public CreationalSpecification createCreationalSpecification() {
        return new CreationalSpecification(createdDate, createdBy, updatedDate, updatedBy);
    }

}
