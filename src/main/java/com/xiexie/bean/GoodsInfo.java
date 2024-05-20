package com.xiexie.bean;

import java.io.Serializable;

/**
 * goods_info
 * @author 
 */
public class GoodsInfo implements Serializable {
    /**
     * 货品编号
     */
    private Integer goodsId;

    /**
     * 货品类型（饮料、食品、洗漱、办公）
     */
    private String goodsType;

    /**
     * 货品名称
     */
    private String goodsName;

    /**
     * 货品售价
     */
    private String goodsRent;

    /**
     * 货品数量
     */
    private Integer goodsCount;

    /**
     * 供货商
     */
    private String supplier;

    /**
     * 电话
     */
    private String telphone;

    /**
     * 上架状态（0未上架，1上架）
     */
    private Integer goodsState;

    private static final long serialVersionUID = 1L;

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsRent() {
        return goodsRent;
    }

    public void setGoodsRent(String goodsRent) {
        this.goodsRent = goodsRent;
    }

    public Integer getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(Integer goodsCount) {
        this.goodsCount = goodsCount;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    public Integer getGoodsState() {
        return goodsState;
    }

    public void setGoodsState(Integer goodsState) {
        this.goodsState = goodsState;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        GoodsInfo other = (GoodsInfo) that;
        return (this.getGoodsId() == null ? other.getGoodsId() == null : this.getGoodsId().equals(other.getGoodsId()))
            && (this.getGoodsType() == null ? other.getGoodsType() == null : this.getGoodsType().equals(other.getGoodsType()))
            && (this.getGoodsName() == null ? other.getGoodsName() == null : this.getGoodsName().equals(other.getGoodsName()))
            && (this.getGoodsRent() == null ? other.getGoodsRent() == null : this.getGoodsRent().equals(other.getGoodsRent()))
            && (this.getGoodsCount() == null ? other.getGoodsCount() == null : this.getGoodsCount().equals(other.getGoodsCount()))
            && (this.getSupplier() == null ? other.getSupplier() == null : this.getSupplier().equals(other.getSupplier()))
            && (this.getTelphone() == null ? other.getTelphone() == null : this.getTelphone().equals(other.getTelphone()))
            && (this.getGoodsState() == null ? other.getGoodsState() == null : this.getGoodsState().equals(other.getGoodsState()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getGoodsId() == null) ? 0 : getGoodsId().hashCode());
        result = prime * result + ((getGoodsType() == null) ? 0 : getGoodsType().hashCode());
        result = prime * result + ((getGoodsName() == null) ? 0 : getGoodsName().hashCode());
        result = prime * result + ((getGoodsRent() == null) ? 0 : getGoodsRent().hashCode());
        result = prime * result + ((getGoodsCount() == null) ? 0 : getGoodsCount().hashCode());
        result = prime * result + ((getSupplier() == null) ? 0 : getSupplier().hashCode());
        result = prime * result + ((getTelphone() == null) ? 0 : getTelphone().hashCode());
        result = prime * result + ((getGoodsState() == null) ? 0 : getGoodsState().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", goodsId=").append(goodsId);
        sb.append(", goodsType=").append(goodsType);
        sb.append(", goodsName=").append(goodsName);
        sb.append(", goodsRent=").append(goodsRent);
        sb.append(", goodsCount=").append(goodsCount);
        sb.append(", supplier=").append(supplier);
        sb.append(", telphone=").append(telphone);
        sb.append(", goodsState=").append(goodsState);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}