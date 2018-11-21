package com.study.www.demo20mail.model.mail;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AppMailLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AppMailLogExample() {
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

        public Criteria andMailhostIsNull() {
            addCriterion("mailHost is null");
            return (Criteria) this;
        }

        public Criteria andMailhostIsNotNull() {
            addCriterion("mailHost is not null");
            return (Criteria) this;
        }

        public Criteria andMailhostEqualTo(String value) {
            addCriterion("mailHost =", value, "mailhost");
            return (Criteria) this;
        }

        public Criteria andMailhostNotEqualTo(String value) {
            addCriterion("mailHost <>", value, "mailhost");
            return (Criteria) this;
        }

        public Criteria andMailhostGreaterThan(String value) {
            addCriterion("mailHost >", value, "mailhost");
            return (Criteria) this;
        }

        public Criteria andMailhostGreaterThanOrEqualTo(String value) {
            addCriterion("mailHost >=", value, "mailhost");
            return (Criteria) this;
        }

        public Criteria andMailhostLessThan(String value) {
            addCriterion("mailHost <", value, "mailhost");
            return (Criteria) this;
        }

        public Criteria andMailhostLessThanOrEqualTo(String value) {
            addCriterion("mailHost <=", value, "mailhost");
            return (Criteria) this;
        }

        public Criteria andMailhostLike(String value) {
            addCriterion("mailHost like", value, "mailhost");
            return (Criteria) this;
        }

        public Criteria andMailhostNotLike(String value) {
            addCriterion("mailHost not like", value, "mailhost");
            return (Criteria) this;
        }

        public Criteria andMailhostIn(List<String> values) {
            addCriterion("mailHost in", values, "mailhost");
            return (Criteria) this;
        }

        public Criteria andMailhostNotIn(List<String> values) {
            addCriterion("mailHost not in", values, "mailhost");
            return (Criteria) this;
        }

        public Criteria andMailhostBetween(String value1, String value2) {
            addCriterion("mailHost between", value1, value2, "mailhost");
            return (Criteria) this;
        }

        public Criteria andMailhostNotBetween(String value1, String value2) {
            addCriterion("mailHost not between", value1, value2, "mailhost");
            return (Criteria) this;
        }

        public Criteria andSendmailusernameIsNull() {
            addCriterion("sendMailUserName is null");
            return (Criteria) this;
        }

        public Criteria andSendmailusernameIsNotNull() {
            addCriterion("sendMailUserName is not null");
            return (Criteria) this;
        }

        public Criteria andSendmailusernameEqualTo(String value) {
            addCriterion("sendMailUserName =", value, "sendmailusername");
            return (Criteria) this;
        }

        public Criteria andSendmailusernameNotEqualTo(String value) {
            addCriterion("sendMailUserName <>", value, "sendmailusername");
            return (Criteria) this;
        }

        public Criteria andSendmailusernameGreaterThan(String value) {
            addCriterion("sendMailUserName >", value, "sendmailusername");
            return (Criteria) this;
        }

        public Criteria andSendmailusernameGreaterThanOrEqualTo(String value) {
            addCriterion("sendMailUserName >=", value, "sendmailusername");
            return (Criteria) this;
        }

        public Criteria andSendmailusernameLessThan(String value) {
            addCriterion("sendMailUserName <", value, "sendmailusername");
            return (Criteria) this;
        }

        public Criteria andSendmailusernameLessThanOrEqualTo(String value) {
            addCriterion("sendMailUserName <=", value, "sendmailusername");
            return (Criteria) this;
        }

        public Criteria andSendmailusernameLike(String value) {
            addCriterion("sendMailUserName like", value, "sendmailusername");
            return (Criteria) this;
        }

        public Criteria andSendmailusernameNotLike(String value) {
            addCriterion("sendMailUserName not like", value, "sendmailusername");
            return (Criteria) this;
        }

        public Criteria andSendmailusernameIn(List<String> values) {
            addCriterion("sendMailUserName in", values, "sendmailusername");
            return (Criteria) this;
        }

        public Criteria andSendmailusernameNotIn(List<String> values) {
            addCriterion("sendMailUserName not in", values, "sendmailusername");
            return (Criteria) this;
        }

        public Criteria andSendmailusernameBetween(String value1, String value2) {
            addCriterion("sendMailUserName between", value1, value2, "sendmailusername");
            return (Criteria) this;
        }

        public Criteria andSendmailusernameNotBetween(String value1, String value2) {
            addCriterion("sendMailUserName not between", value1, value2, "sendmailusername");
            return (Criteria) this;
        }

        public Criteria andSenderaddressIsNull() {
            addCriterion("senderAddress is null");
            return (Criteria) this;
        }

        public Criteria andSenderaddressIsNotNull() {
            addCriterion("senderAddress is not null");
            return (Criteria) this;
        }

        public Criteria andSenderaddressEqualTo(String value) {
            addCriterion("senderAddress =", value, "senderaddress");
            return (Criteria) this;
        }

        public Criteria andSenderaddressNotEqualTo(String value) {
            addCriterion("senderAddress <>", value, "senderaddress");
            return (Criteria) this;
        }

        public Criteria andSenderaddressGreaterThan(String value) {
            addCriterion("senderAddress >", value, "senderaddress");
            return (Criteria) this;
        }

        public Criteria andSenderaddressGreaterThanOrEqualTo(String value) {
            addCriterion("senderAddress >=", value, "senderaddress");
            return (Criteria) this;
        }

        public Criteria andSenderaddressLessThan(String value) {
            addCriterion("senderAddress <", value, "senderaddress");
            return (Criteria) this;
        }

        public Criteria andSenderaddressLessThanOrEqualTo(String value) {
            addCriterion("senderAddress <=", value, "senderaddress");
            return (Criteria) this;
        }

        public Criteria andSenderaddressLike(String value) {
            addCriterion("senderAddress like", value, "senderaddress");
            return (Criteria) this;
        }

        public Criteria andSenderaddressNotLike(String value) {
            addCriterion("senderAddress not like", value, "senderaddress");
            return (Criteria) this;
        }

        public Criteria andSenderaddressIn(List<String> values) {
            addCriterion("senderAddress in", values, "senderaddress");
            return (Criteria) this;
        }

        public Criteria andSenderaddressNotIn(List<String> values) {
            addCriterion("senderAddress not in", values, "senderaddress");
            return (Criteria) this;
        }

        public Criteria andSenderaddressBetween(String value1, String value2) {
            addCriterion("senderAddress between", value1, value2, "senderaddress");
            return (Criteria) this;
        }

        public Criteria andSenderaddressNotBetween(String value1, String value2) {
            addCriterion("senderAddress not between", value1, value2, "senderaddress");
            return (Criteria) this;
        }

        public Criteria andAcceptaddressIsNull() {
            addCriterion("acceptAddress is null");
            return (Criteria) this;
        }

        public Criteria andAcceptaddressIsNotNull() {
            addCriterion("acceptAddress is not null");
            return (Criteria) this;
        }

        public Criteria andAcceptaddressEqualTo(String value) {
            addCriterion("acceptAddress =", value, "acceptaddress");
            return (Criteria) this;
        }

        public Criteria andAcceptaddressNotEqualTo(String value) {
            addCriterion("acceptAddress <>", value, "acceptaddress");
            return (Criteria) this;
        }

        public Criteria andAcceptaddressGreaterThan(String value) {
            addCriterion("acceptAddress >", value, "acceptaddress");
            return (Criteria) this;
        }

        public Criteria andAcceptaddressGreaterThanOrEqualTo(String value) {
            addCriterion("acceptAddress >=", value, "acceptaddress");
            return (Criteria) this;
        }

        public Criteria andAcceptaddressLessThan(String value) {
            addCriterion("acceptAddress <", value, "acceptaddress");
            return (Criteria) this;
        }

        public Criteria andAcceptaddressLessThanOrEqualTo(String value) {
            addCriterion("acceptAddress <=", value, "acceptaddress");
            return (Criteria) this;
        }

        public Criteria andAcceptaddressLike(String value) {
            addCriterion("acceptAddress like", value, "acceptaddress");
            return (Criteria) this;
        }

        public Criteria andAcceptaddressNotLike(String value) {
            addCriterion("acceptAddress not like", value, "acceptaddress");
            return (Criteria) this;
        }

        public Criteria andAcceptaddressIn(List<String> values) {
            addCriterion("acceptAddress in", values, "acceptaddress");
            return (Criteria) this;
        }

        public Criteria andAcceptaddressNotIn(List<String> values) {
            addCriterion("acceptAddress not in", values, "acceptaddress");
            return (Criteria) this;
        }

        public Criteria andAcceptaddressBetween(String value1, String value2) {
            addCriterion("acceptAddress between", value1, value2, "acceptaddress");
            return (Criteria) this;
        }

        public Criteria andAcceptaddressNotBetween(String value1, String value2) {
            addCriterion("acceptAddress not between", value1, value2, "acceptaddress");
            return (Criteria) this;
        }

        public Criteria andSubjectIsNull() {
            addCriterion("subject is null");
            return (Criteria) this;
        }

        public Criteria andSubjectIsNotNull() {
            addCriterion("subject is not null");
            return (Criteria) this;
        }

        public Criteria andSubjectEqualTo(String value) {
            addCriterion("subject =", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectNotEqualTo(String value) {
            addCriterion("subject <>", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectGreaterThan(String value) {
            addCriterion("subject >", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectGreaterThanOrEqualTo(String value) {
            addCriterion("subject >=", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectLessThan(String value) {
            addCriterion("subject <", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectLessThanOrEqualTo(String value) {
            addCriterion("subject <=", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectLike(String value) {
            addCriterion("subject like", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectNotLike(String value) {
            addCriterion("subject not like", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectIn(List<String> values) {
            addCriterion("subject in", values, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectNotIn(List<String> values) {
            addCriterion("subject not in", values, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectBetween(String value1, String value2) {
            addCriterion("subject between", value1, value2, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectNotBetween(String value1, String value2) {
            addCriterion("subject not between", value1, value2, "subject");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("Status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("Status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("Status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("Status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("Status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("Status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("Status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("Status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("Status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("Status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("Status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("Status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("CreateTime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("CreateTime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterion("CreateTime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("CreateTime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterion("CreateTime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CreateTime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterion("CreateTime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("CreateTime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterion("CreateTime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterion("CreateTime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterion("CreateTime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("CreateTime not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatebyIsNull() {
            addCriterion("CreateBy is null");
            return (Criteria) this;
        }

        public Criteria andCreatebyIsNotNull() {
            addCriterion("CreateBy is not null");
            return (Criteria) this;
        }

        public Criteria andCreatebyEqualTo(String value) {
            addCriterion("CreateBy =", value, "createby");
            return (Criteria) this;
        }

        public Criteria andCreatebyNotEqualTo(String value) {
            addCriterion("CreateBy <>", value, "createby");
            return (Criteria) this;
        }

        public Criteria andCreatebyGreaterThan(String value) {
            addCriterion("CreateBy >", value, "createby");
            return (Criteria) this;
        }

        public Criteria andCreatebyGreaterThanOrEqualTo(String value) {
            addCriterion("CreateBy >=", value, "createby");
            return (Criteria) this;
        }

        public Criteria andCreatebyLessThan(String value) {
            addCriterion("CreateBy <", value, "createby");
            return (Criteria) this;
        }

        public Criteria andCreatebyLessThanOrEqualTo(String value) {
            addCriterion("CreateBy <=", value, "createby");
            return (Criteria) this;
        }

        public Criteria andCreatebyLike(String value) {
            addCriterion("CreateBy like", value, "createby");
            return (Criteria) this;
        }

        public Criteria andCreatebyNotLike(String value) {
            addCriterion("CreateBy not like", value, "createby");
            return (Criteria) this;
        }

        public Criteria andCreatebyIn(List<String> values) {
            addCriterion("CreateBy in", values, "createby");
            return (Criteria) this;
        }

        public Criteria andCreatebyNotIn(List<String> values) {
            addCriterion("CreateBy not in", values, "createby");
            return (Criteria) this;
        }

        public Criteria andCreatebyBetween(String value1, String value2) {
            addCriterion("CreateBy between", value1, value2, "createby");
            return (Criteria) this;
        }

        public Criteria andCreatebyNotBetween(String value1, String value2) {
            addCriterion("CreateBy not between", value1, value2, "createby");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNull() {
            addCriterion("UpdateTime is null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNotNull() {
            addCriterion("UpdateTime is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeEqualTo(Date value) {
            addCriterion("UpdateTime =", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotEqualTo(Date value) {
            addCriterion("UpdateTime <>", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThan(Date value) {
            addCriterion("UpdateTime >", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("UpdateTime >=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThan(Date value) {
            addCriterion("UpdateTime <", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThanOrEqualTo(Date value) {
            addCriterion("UpdateTime <=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIn(List<Date> values) {
            addCriterion("UpdateTime in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotIn(List<Date> values) {
            addCriterion("UpdateTime not in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeBetween(Date value1, Date value2) {
            addCriterion("UpdateTime between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotBetween(Date value1, Date value2) {
            addCriterion("UpdateTime not between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatebyIsNull() {
            addCriterion("UpdateBy is null");
            return (Criteria) this;
        }

        public Criteria andUpdatebyIsNotNull() {
            addCriterion("UpdateBy is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatebyEqualTo(String value) {
            addCriterion("UpdateBy =", value, "updateby");
            return (Criteria) this;
        }

        public Criteria andUpdatebyNotEqualTo(String value) {
            addCriterion("UpdateBy <>", value, "updateby");
            return (Criteria) this;
        }

        public Criteria andUpdatebyGreaterThan(String value) {
            addCriterion("UpdateBy >", value, "updateby");
            return (Criteria) this;
        }

        public Criteria andUpdatebyGreaterThanOrEqualTo(String value) {
            addCriterion("UpdateBy >=", value, "updateby");
            return (Criteria) this;
        }

        public Criteria andUpdatebyLessThan(String value) {
            addCriterion("UpdateBy <", value, "updateby");
            return (Criteria) this;
        }

        public Criteria andUpdatebyLessThanOrEqualTo(String value) {
            addCriterion("UpdateBy <=", value, "updateby");
            return (Criteria) this;
        }

        public Criteria andUpdatebyLike(String value) {
            addCriterion("UpdateBy like", value, "updateby");
            return (Criteria) this;
        }

        public Criteria andUpdatebyNotLike(String value) {
            addCriterion("UpdateBy not like", value, "updateby");
            return (Criteria) this;
        }

        public Criteria andUpdatebyIn(List<String> values) {
            addCriterion("UpdateBy in", values, "updateby");
            return (Criteria) this;
        }

        public Criteria andUpdatebyNotIn(List<String> values) {
            addCriterion("UpdateBy not in", values, "updateby");
            return (Criteria) this;
        }

        public Criteria andUpdatebyBetween(String value1, String value2) {
            addCriterion("UpdateBy between", value1, value2, "updateby");
            return (Criteria) this;
        }

        public Criteria andUpdatebyNotBetween(String value1, String value2) {
            addCriterion("UpdateBy not between", value1, value2, "updateby");
            return (Criteria) this;
        }

        public Criteria andIsdelIsNull() {
            addCriterion("IsDel is null");
            return (Criteria) this;
        }

        public Criteria andIsdelIsNotNull() {
            addCriterion("IsDel is not null");
            return (Criteria) this;
        }

        public Criteria andIsdelEqualTo(Integer value) {
            addCriterion("IsDel =", value, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelNotEqualTo(Integer value) {
            addCriterion("IsDel <>", value, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelGreaterThan(Integer value) {
            addCriterion("IsDel >", value, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelGreaterThanOrEqualTo(Integer value) {
            addCriterion("IsDel >=", value, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelLessThan(Integer value) {
            addCriterion("IsDel <", value, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelLessThanOrEqualTo(Integer value) {
            addCriterion("IsDel <=", value, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelIn(List<Integer> values) {
            addCriterion("IsDel in", values, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelNotIn(List<Integer> values) {
            addCriterion("IsDel not in", values, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelBetween(Integer value1, Integer value2) {
            addCriterion("IsDel between", value1, value2, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelNotBetween(Integer value1, Integer value2) {
            addCriterion("IsDel not between", value1, value2, "isdel");
            return (Criteria) this;
        }

        public Criteria andAuthcodeIsNull() {
            addCriterion("authCode is null");
            return (Criteria) this;
        }

        public Criteria andAuthcodeIsNotNull() {
            addCriterion("authCode is not null");
            return (Criteria) this;
        }

        public Criteria andAuthcodeEqualTo(String value) {
            addCriterion("authCode =", value, "authcode");
            return (Criteria) this;
        }

        public Criteria andAuthcodeNotEqualTo(String value) {
            addCriterion("authCode <>", value, "authcode");
            return (Criteria) this;
        }

        public Criteria andAuthcodeGreaterThan(String value) {
            addCriterion("authCode >", value, "authcode");
            return (Criteria) this;
        }

        public Criteria andAuthcodeGreaterThanOrEqualTo(String value) {
            addCriterion("authCode >=", value, "authcode");
            return (Criteria) this;
        }

        public Criteria andAuthcodeLessThan(String value) {
            addCriterion("authCode <", value, "authcode");
            return (Criteria) this;
        }

        public Criteria andAuthcodeLessThanOrEqualTo(String value) {
            addCriterion("authCode <=", value, "authcode");
            return (Criteria) this;
        }

        public Criteria andAuthcodeLike(String value) {
            addCriterion("authCode like", value, "authcode");
            return (Criteria) this;
        }

        public Criteria andAuthcodeNotLike(String value) {
            addCriterion("authCode not like", value, "authcode");
            return (Criteria) this;
        }

        public Criteria andAuthcodeIn(List<String> values) {
            addCriterion("authCode in", values, "authcode");
            return (Criteria) this;
        }

        public Criteria andAuthcodeNotIn(List<String> values) {
            addCriterion("authCode not in", values, "authcode");
            return (Criteria) this;
        }

        public Criteria andAuthcodeBetween(String value1, String value2) {
            addCriterion("authCode between", value1, value2, "authcode");
            return (Criteria) this;
        }

        public Criteria andAuthcodeNotBetween(String value1, String value2) {
            addCriterion("authCode not between", value1, value2, "authcode");
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