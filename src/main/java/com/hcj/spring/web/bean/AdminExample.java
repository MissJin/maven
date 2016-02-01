package com.hcj.spring.web.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class AdminExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AdminExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("password is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("password is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("password =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("password <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("password >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("password >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("password <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("password <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("password like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("password not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("password in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("password not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("password between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("password not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andRoleidIsNull() {
            addCriterion("roleId is null");
            return (Criteria) this;
        }

        public Criteria andRoleidIsNotNull() {
            addCriterion("roleId is not null");
            return (Criteria) this;
        }

        public Criteria andRoleidEqualTo(Integer value) {
            addCriterion("roleId =", value, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidNotEqualTo(Integer value) {
            addCriterion("roleId <>", value, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidGreaterThan(Integer value) {
            addCriterion("roleId >", value, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidGreaterThanOrEqualTo(Integer value) {
            addCriterion("roleId >=", value, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidLessThan(Integer value) {
            addCriterion("roleId <", value, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidLessThanOrEqualTo(Integer value) {
            addCriterion("roleId <=", value, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidIn(List<Integer> values) {
            addCriterion("roleId in", values, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidNotIn(List<Integer> values) {
            addCriterion("roleId not in", values, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidBetween(Integer value1, Integer value2) {
            addCriterion("roleId between", value1, value2, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidNotBetween(Integer value1, Integer value2) {
            addCriterion("roleId not between", value1, value2, "roleid");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNull() {
            addCriterion("user_name is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("user_name =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("user_name <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("user_name >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_name >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("user_name <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("user_name <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("user_name like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("user_name not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("user_name in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("user_name not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("user_name between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("user_name not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andCodeIsNull() {
            addCriterion("code is null");
            return (Criteria) this;
        }

        public Criteria andCodeIsNotNull() {
            addCriterion("code is not null");
            return (Criteria) this;
        }

        public Criteria andCodeEqualTo(String value) {
            addCriterion("code =", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotEqualTo(String value) {
            addCriterion("code <>", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThan(String value) {
            addCriterion("code >", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThanOrEqualTo(String value) {
            addCriterion("code >=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThan(String value) {
            addCriterion("code <", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThanOrEqualTo(String value) {
            addCriterion("code <=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLike(String value) {
            addCriterion("code like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotLike(String value) {
            addCriterion("code not like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeIn(List<String> values) {
            addCriterion("code in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotIn(List<String> values) {
            addCriterion("code not in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeBetween(String value1, String value2) {
            addCriterion("code between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotBetween(String value1, String value2) {
            addCriterion("code not between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andSellRateIsNull() {
            addCriterion("sell_rate is null");
            return (Criteria) this;
        }

        public Criteria andSellRateIsNotNull() {
            addCriterion("sell_rate is not null");
            return (Criteria) this;
        }

        public Criteria andSellRateEqualTo(BigDecimal value) {
            addCriterion("sell_rate =", value, "sellRate");
            return (Criteria) this;
        }

        public Criteria andSellRateNotEqualTo(BigDecimal value) {
            addCriterion("sell_rate <>", value, "sellRate");
            return (Criteria) this;
        }

        public Criteria andSellRateGreaterThan(BigDecimal value) {
            addCriterion("sell_rate >", value, "sellRate");
            return (Criteria) this;
        }

        public Criteria andSellRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("sell_rate >=", value, "sellRate");
            return (Criteria) this;
        }

        public Criteria andSellRateLessThan(BigDecimal value) {
            addCriterion("sell_rate <", value, "sellRate");
            return (Criteria) this;
        }

        public Criteria andSellRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("sell_rate <=", value, "sellRate");
            return (Criteria) this;
        }

        public Criteria andSellRateIn(List<BigDecimal> values) {
            addCriterion("sell_rate in", values, "sellRate");
            return (Criteria) this;
        }

        public Criteria andSellRateNotIn(List<BigDecimal> values) {
            addCriterion("sell_rate not in", values, "sellRate");
            return (Criteria) this;
        }

        public Criteria andSellRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sell_rate between", value1, value2, "sellRate");
            return (Criteria) this;
        }

        public Criteria andSellRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sell_rate not between", value1, value2, "sellRate");
            return (Criteria) this;
        }

        public Criteria andAdminTypeIsNull() {
            addCriterion("admin_type is null");
            return (Criteria) this;
        }

        public Criteria andAdminTypeIsNotNull() {
            addCriterion("admin_type is not null");
            return (Criteria) this;
        }

        public Criteria andAdminTypeEqualTo(Integer value) {
            addCriterion("admin_type =", value, "adminType");
            return (Criteria) this;
        }

        public Criteria andAdminTypeNotEqualTo(Integer value) {
            addCriterion("admin_type <>", value, "adminType");
            return (Criteria) this;
        }

        public Criteria andAdminTypeGreaterThan(Integer value) {
            addCriterion("admin_type >", value, "adminType");
            return (Criteria) this;
        }

        public Criteria andAdminTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("admin_type >=", value, "adminType");
            return (Criteria) this;
        }

        public Criteria andAdminTypeLessThan(Integer value) {
            addCriterion("admin_type <", value, "adminType");
            return (Criteria) this;
        }

        public Criteria andAdminTypeLessThanOrEqualTo(Integer value) {
            addCriterion("admin_type <=", value, "adminType");
            return (Criteria) this;
        }

        public Criteria andAdminTypeIn(List<Integer> values) {
            addCriterion("admin_type in", values, "adminType");
            return (Criteria) this;
        }

        public Criteria andAdminTypeNotIn(List<Integer> values) {
            addCriterion("admin_type not in", values, "adminType");
            return (Criteria) this;
        }

        public Criteria andAdminTypeBetween(Integer value1, Integer value2) {
            addCriterion("admin_type between", value1, value2, "adminType");
            return (Criteria) this;
        }

        public Criteria andAdminTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("admin_type not between", value1, value2, "adminType");
            return (Criteria) this;
        }

        public Criteria andAllChildNumberIsNull() {
            addCriterion("all_child_number is null");
            return (Criteria) this;
        }

        public Criteria andAllChildNumberIsNotNull() {
            addCriterion("all_child_number is not null");
            return (Criteria) this;
        }

        public Criteria andAllChildNumberEqualTo(Integer value) {
            addCriterion("all_child_number =", value, "allChildNumber");
            return (Criteria) this;
        }

        public Criteria andAllChildNumberNotEqualTo(Integer value) {
            addCriterion("all_child_number <>", value, "allChildNumber");
            return (Criteria) this;
        }

        public Criteria andAllChildNumberGreaterThan(Integer value) {
            addCriterion("all_child_number >", value, "allChildNumber");
            return (Criteria) this;
        }

        public Criteria andAllChildNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("all_child_number >=", value, "allChildNumber");
            return (Criteria) this;
        }

        public Criteria andAllChildNumberLessThan(Integer value) {
            addCriterion("all_child_number <", value, "allChildNumber");
            return (Criteria) this;
        }

        public Criteria andAllChildNumberLessThanOrEqualTo(Integer value) {
            addCriterion("all_child_number <=", value, "allChildNumber");
            return (Criteria) this;
        }

        public Criteria andAllChildNumberIn(List<Integer> values) {
            addCriterion("all_child_number in", values, "allChildNumber");
            return (Criteria) this;
        }

        public Criteria andAllChildNumberNotIn(List<Integer> values) {
            addCriterion("all_child_number not in", values, "allChildNumber");
            return (Criteria) this;
        }

        public Criteria andAllChildNumberBetween(Integer value1, Integer value2) {
            addCriterion("all_child_number between", value1, value2, "allChildNumber");
            return (Criteria) this;
        }

        public Criteria andAllChildNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("all_child_number not between", value1, value2, "allChildNumber");
            return (Criteria) this;
        }

        public Criteria andDirectChildNumberIsNull() {
            addCriterion("direct_child_number is null");
            return (Criteria) this;
        }

        public Criteria andDirectChildNumberIsNotNull() {
            addCriterion("direct_child_number is not null");
            return (Criteria) this;
        }

        public Criteria andDirectChildNumberEqualTo(Integer value) {
            addCriterion("direct_child_number =", value, "directChildNumber");
            return (Criteria) this;
        }

        public Criteria andDirectChildNumberNotEqualTo(Integer value) {
            addCriterion("direct_child_number <>", value, "directChildNumber");
            return (Criteria) this;
        }

        public Criteria andDirectChildNumberGreaterThan(Integer value) {
            addCriterion("direct_child_number >", value, "directChildNumber");
            return (Criteria) this;
        }

        public Criteria andDirectChildNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("direct_child_number >=", value, "directChildNumber");
            return (Criteria) this;
        }

        public Criteria andDirectChildNumberLessThan(Integer value) {
            addCriterion("direct_child_number <", value, "directChildNumber");
            return (Criteria) this;
        }

        public Criteria andDirectChildNumberLessThanOrEqualTo(Integer value) {
            addCriterion("direct_child_number <=", value, "directChildNumber");
            return (Criteria) this;
        }

        public Criteria andDirectChildNumberIn(List<Integer> values) {
            addCriterion("direct_child_number in", values, "directChildNumber");
            return (Criteria) this;
        }

        public Criteria andDirectChildNumberNotIn(List<Integer> values) {
            addCriterion("direct_child_number not in", values, "directChildNumber");
            return (Criteria) this;
        }

        public Criteria andDirectChildNumberBetween(Integer value1, Integer value2) {
            addCriterion("direct_child_number between", value1, value2, "directChildNumber");
            return (Criteria) this;
        }

        public Criteria andDirectChildNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("direct_child_number not between", value1, value2, "directChildNumber");
            return (Criteria) this;
        }

        public Criteria andMobileIsNull() {
            addCriterion("mobile is null");
            return (Criteria) this;
        }

        public Criteria andMobileIsNotNull() {
            addCriterion("mobile is not null");
            return (Criteria) this;
        }

        public Criteria andMobileEqualTo(String value) {
            addCriterion("mobile =", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotEqualTo(String value) {
            addCriterion("mobile <>", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThan(String value) {
            addCriterion("mobile >", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThanOrEqualTo(String value) {
            addCriterion("mobile >=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThan(String value) {
            addCriterion("mobile <", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThanOrEqualTo(String value) {
            addCriterion("mobile <=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLike(String value) {
            addCriterion("mobile like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotLike(String value) {
            addCriterion("mobile not like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileIn(List<String> values) {
            addCriterion("mobile in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotIn(List<String> values) {
            addCriterion("mobile not in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileBetween(String value1, String value2) {
            addCriterion("mobile between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotBetween(String value1, String value2) {
            addCriterion("mobile not between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andParentAdminIdIsNull() {
            addCriterion("parent_admin_id is null");
            return (Criteria) this;
        }

        public Criteria andParentAdminIdIsNotNull() {
            addCriterion("parent_admin_id is not null");
            return (Criteria) this;
        }

        public Criteria andParentAdminIdEqualTo(Integer value) {
            addCriterion("parent_admin_id =", value, "parentAdminId");
            return (Criteria) this;
        }

        public Criteria andParentAdminIdNotEqualTo(Integer value) {
            addCriterion("parent_admin_id <>", value, "parentAdminId");
            return (Criteria) this;
        }

        public Criteria andParentAdminIdGreaterThan(Integer value) {
            addCriterion("parent_admin_id >", value, "parentAdminId");
            return (Criteria) this;
        }

        public Criteria andParentAdminIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("parent_admin_id >=", value, "parentAdminId");
            return (Criteria) this;
        }

        public Criteria andParentAdminIdLessThan(Integer value) {
            addCriterion("parent_admin_id <", value, "parentAdminId");
            return (Criteria) this;
        }

        public Criteria andParentAdminIdLessThanOrEqualTo(Integer value) {
            addCriterion("parent_admin_id <=", value, "parentAdminId");
            return (Criteria) this;
        }

        public Criteria andParentAdminIdIn(List<Integer> values) {
            addCriterion("parent_admin_id in", values, "parentAdminId");
            return (Criteria) this;
        }

        public Criteria andParentAdminIdNotIn(List<Integer> values) {
            addCriterion("parent_admin_id not in", values, "parentAdminId");
            return (Criteria) this;
        }

        public Criteria andParentAdminIdBetween(Integer value1, Integer value2) {
            addCriterion("parent_admin_id between", value1, value2, "parentAdminId");
            return (Criteria) this;
        }

        public Criteria andParentAdminIdNotBetween(Integer value1, Integer value2) {
            addCriterion("parent_admin_id not between", value1, value2, "parentAdminId");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andChildSellRateIsNull() {
            addCriterion("child_sell_rate is null");
            return (Criteria) this;
        }

        public Criteria andChildSellRateIsNotNull() {
            addCriterion("child_sell_rate is not null");
            return (Criteria) this;
        }

        public Criteria andChildSellRateEqualTo(BigDecimal value) {
            addCriterion("child_sell_rate =", value, "childSellRate");
            return (Criteria) this;
        }

        public Criteria andChildSellRateNotEqualTo(BigDecimal value) {
            addCriterion("child_sell_rate <>", value, "childSellRate");
            return (Criteria) this;
        }

        public Criteria andChildSellRateGreaterThan(BigDecimal value) {
            addCriterion("child_sell_rate >", value, "childSellRate");
            return (Criteria) this;
        }

        public Criteria andChildSellRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("child_sell_rate >=", value, "childSellRate");
            return (Criteria) this;
        }

        public Criteria andChildSellRateLessThan(BigDecimal value) {
            addCriterion("child_sell_rate <", value, "childSellRate");
            return (Criteria) this;
        }

        public Criteria andChildSellRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("child_sell_rate <=", value, "childSellRate");
            return (Criteria) this;
        }

        public Criteria andChildSellRateIn(List<BigDecimal> values) {
            addCriterion("child_sell_rate in", values, "childSellRate");
            return (Criteria) this;
        }

        public Criteria andChildSellRateNotIn(List<BigDecimal> values) {
            addCriterion("child_sell_rate not in", values, "childSellRate");
            return (Criteria) this;
        }

        public Criteria andChildSellRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("child_sell_rate between", value1, value2, "childSellRate");
            return (Criteria) this;
        }

        public Criteria andChildSellRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("child_sell_rate not between", value1, value2, "childSellRate");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}