package org.example.pojo;

public class ProductCategory {
    private Short id;

    private String name;

    private Short sortorder = 999;

    private Byte status = 0;

    private Short parentId = 0;

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Short getSortorder() {
        return sortorder;
    }

    public void setSortorder(Short sortorder) {
        this.sortorder = sortorder;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Short getParentId() {
        return parentId;
    }

    public void setParentId(Short parentId) {
        this.parentId = parentId;
    }
}