package com.sshop.core.model;

import com.sshop.core.base.BaseModel;

@SuppressWarnings("serial")
public class DnaValue extends BaseModel {
    private Integer id;
    private String typeCode;
    private String typePcode;
    private String goodCode;
    private Integer userId;
    private Double value;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getTypePcode() {
        return typePcode;
    }

    public void setTypePcode(String typePcode) {
        this.typePcode = typePcode;
    }

    public String getGoodCode() {
        return goodCode;
    }

    public void setGoodCode(String goodCode) {
        this.goodCode = goodCode;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "DNA{" +
                "id=" + id +
                ", typeCode='" + typeCode + '\'' +
                ", typePcode='" + typePcode + '\'' +
                ", goodCode='" + goodCode + '\'' +
                ", userId=" + userId +
                ", value=" + value +
                '}';
    }
}