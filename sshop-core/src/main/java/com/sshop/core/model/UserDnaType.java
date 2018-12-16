package com.sshop.core.model;

public class UserDnaType {
    private Integer id;
    private String code;
    private String fcode;
    private String typeName;
    private String typeUnit;
    private Integer order;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getFcode() {
        return fcode;
    }

    public void setFcode(String fcode) {
        this.fcode = fcode;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeUnit() {
        return typeUnit;
    }

    public void setTypeUnit(String typeUnit) {
        this.typeUnit = typeUnit;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "DNATYPE{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", fcode='" + fcode + '\'' +
                ", typeName='" + typeName + '\'' +
                ", typeUnit='" + typeUnit + '\'' +
                ", order=" + order +
                '}';
    }
}