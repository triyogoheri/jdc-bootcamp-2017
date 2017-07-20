package com.agit.jdc.bootcamp.shared.type;

/**
 *
 * @author bayutridewanto
 */
public enum StatusData {
    ACTIVE(0, "Active"), 
    INACTIVE(1, "Inactive"), 
    DELETED(2, "Deleted");

    private Integer id;
    private String description;

    private StatusData(Integer id, String description) {
        this.id = id;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
