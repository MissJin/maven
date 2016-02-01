package com.hcj.spring.web.bean;

import java.math.BigDecimal;

public class Admin {
    private Integer id;

    private String name;

    private String password;

    private Integer roleid;

    private String userName;

    private String code;

    private BigDecimal sellRate;

    private Integer adminType;

    private Integer allChildNumber;

    private Integer directChildNumber;

    private String mobile;

    private Integer parentAdminId;

    private Integer status;

    private BigDecimal childSellRate;

    public Admin(){}

    public Admin(String userName ,String password) {
        this.userName = userName;
        this.password = password;
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
        this.name = name == null ? null : name.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public BigDecimal getSellRate() {
        return sellRate;
    }

    public void setSellRate(BigDecimal sellRate) {
        this.sellRate = sellRate;
    }

    public Integer getAdminType() {
        return adminType;
    }

    public void setAdminType(Integer adminType) {
        this.adminType = adminType;
    }

    public Integer getAllChildNumber() {
        return allChildNumber;
    }

    public void setAllChildNumber(Integer allChildNumber) {
        this.allChildNumber = allChildNumber;
    }

    public Integer getDirectChildNumber() {
        return directChildNumber;
    }

    public void setDirectChildNumber(Integer directChildNumber) {
        this.directChildNumber = directChildNumber;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public Integer getParentAdminId() {
        return parentAdminId;
    }

    public void setParentAdminId(Integer parentAdminId) {
        this.parentAdminId = parentAdminId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public BigDecimal getChildSellRate() {
        return childSellRate;
    }

    public void setChildSellRate(BigDecimal childSellRate) {
        this.childSellRate = childSellRate;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", roleid=" + roleid +
                ", userName='" + userName + '\'' +
                ", code='" + code + '\'' +
                ", sellRate=" + sellRate +
                ", adminType=" + adminType +
                ", allChildNumber=" + allChildNumber +
                ", directChildNumber=" + directChildNumber +
                ", mobile='" + mobile + '\'' +
                ", parentAdminId=" + parentAdminId +
                ", status=" + status +
                ", childSellRate=" + childSellRate +
                '}';
    }
}