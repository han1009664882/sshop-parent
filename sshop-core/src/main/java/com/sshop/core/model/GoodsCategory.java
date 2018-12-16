package com.sshop.core.model;

import com.sshop.core.base.BaseModel;

/**
 * 商品分类
 * */
@SuppressWarnings("serial")
public class GoodsCategory extends BaseModel {

    //id
    private Integer id;
    //商品编码
    private String code;
    //分类名称
    private String  name;
    //排序
    private Integer sort;
    
    //是否是默认选项0默认 1=不是
    private Integer isdefault;


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getIsdefault() {
        return isdefault;
    }

    public void setIsdefault(Integer isdefault) {
        this.isdefault = isdefault;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}