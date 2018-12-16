package com.sshop.core.constant;

/**
 * 
 * 图片类型
 */
public enum ImagesType {

    //头像
    _HEADER_(0),

    //部件
    _PART_(1),

    //商品明细
    _GOODS_DETAIL_(2),
    
    //商品
    _GOODS_(3),
    
    //部件组合成商品
    __PART_GOODS_DETAIL_(4);

	private ImagesType(){}
	
    private ImagesType(int value) {
        this.value = value;
    }

    private int value;

    public int getValue() {
        return value;
    }

    public static ImagesType valueOf(int value) {
        for (ImagesType s : ImagesType.values()) {
            if (s.getValue() == value) {
                return s;
            }
        }
        throw new IllegalArgumentException("Connot find value " + value + " in eunu PayStatus.");
    }
}
