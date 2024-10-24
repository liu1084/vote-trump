package org.trump.vote.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VoteRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public VoteRecordExample() {
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

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andTwitterUserIdIsNull() {
            addCriterion("twitter_user_id is null");
            return (Criteria) this;
        }

        public Criteria andTwitterUserIdIsNotNull() {
            addCriterion("twitter_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andTwitterUserIdEqualTo(String value) {
            addCriterion("twitter_user_id =", value, "twitterUserId");
            return (Criteria) this;
        }

        public Criteria andTwitterUserIdNotEqualTo(String value) {
            addCriterion("twitter_user_id <>", value, "twitterUserId");
            return (Criteria) this;
        }

        public Criteria andTwitterUserIdGreaterThan(String value) {
            addCriterion("twitter_user_id >", value, "twitterUserId");
            return (Criteria) this;
        }

        public Criteria andTwitterUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("twitter_user_id >=", value, "twitterUserId");
            return (Criteria) this;
        }

        public Criteria andTwitterUserIdLessThan(String value) {
            addCriterion("twitter_user_id <", value, "twitterUserId");
            return (Criteria) this;
        }

        public Criteria andTwitterUserIdLessThanOrEqualTo(String value) {
            addCriterion("twitter_user_id <=", value, "twitterUserId");
            return (Criteria) this;
        }

        public Criteria andTwitterUserIdLike(String value) {
            addCriterion("twitter_user_id like", value, "twitterUserId");
            return (Criteria) this;
        }

        public Criteria andTwitterUserIdNotLike(String value) {
            addCriterion("twitter_user_id not like", value, "twitterUserId");
            return (Criteria) this;
        }

        public Criteria andTwitterUserIdIn(List<String> values) {
            addCriterion("twitter_user_id in", values, "twitterUserId");
            return (Criteria) this;
        }

        public Criteria andTwitterUserIdNotIn(List<String> values) {
            addCriterion("twitter_user_id not in", values, "twitterUserId");
            return (Criteria) this;
        }

        public Criteria andTwitterUserIdBetween(String value1, String value2) {
            addCriterion("twitter_user_id between", value1, value2, "twitterUserId");
            return (Criteria) this;
        }

        public Criteria andTwitterUserIdNotBetween(String value1, String value2) {
            addCriterion("twitter_user_id not between", value1, value2, "twitterUserId");
            return (Criteria) this;
        }

        public Criteria andVoteDateIsNull() {
            addCriterion("vote_date is null");
            return (Criteria) this;
        }

        public Criteria andVoteDateIsNotNull() {
            addCriterion("vote_date is not null");
            return (Criteria) this;
        }

        public Criteria andVoteDateEqualTo(Date value) {
            addCriterion("vote_date =", value, "voteDate");
            return (Criteria) this;
        }

        public Criteria andVoteDateNotEqualTo(Date value) {
            addCriterion("vote_date <>", value, "voteDate");
            return (Criteria) this;
        }

        public Criteria andVoteDateGreaterThan(Date value) {
            addCriterion("vote_date >", value, "voteDate");
            return (Criteria) this;
        }

        public Criteria andVoteDateGreaterThanOrEqualTo(Date value) {
            addCriterion("vote_date >=", value, "voteDate");
            return (Criteria) this;
        }

        public Criteria andVoteDateLessThan(Date value) {
            addCriterion("vote_date <", value, "voteDate");
            return (Criteria) this;
        }

        public Criteria andVoteDateLessThanOrEqualTo(Date value) {
            addCriterion("vote_date <=", value, "voteDate");
            return (Criteria) this;
        }

        public Criteria andVoteDateIn(List<Date> values) {
            addCriterion("vote_date in", values, "voteDate");
            return (Criteria) this;
        }

        public Criteria andVoteDateNotIn(List<Date> values) {
            addCriterion("vote_date not in", values, "voteDate");
            return (Criteria) this;
        }

        public Criteria andVoteDateBetween(Date value1, Date value2) {
            addCriterion("vote_date between", value1, value2, "voteDate");
            return (Criteria) this;
        }

        public Criteria andVoteDateNotBetween(Date value1, Date value2) {
            addCriterion("vote_date not between", value1, value2, "voteDate");
            return (Criteria) this;
        }

        public Criteria andProofImageUrlIsNull() {
            addCriterion("proof_image_url is null");
            return (Criteria) this;
        }

        public Criteria andProofImageUrlIsNotNull() {
            addCriterion("proof_image_url is not null");
            return (Criteria) this;
        }

        public Criteria andProofImageUrlEqualTo(String value) {
            addCriterion("proof_image_url =", value, "proofImageUrl");
            return (Criteria) this;
        }

        public Criteria andProofImageUrlNotEqualTo(String value) {
            addCriterion("proof_image_url <>", value, "proofImageUrl");
            return (Criteria) this;
        }

        public Criteria andProofImageUrlGreaterThan(String value) {
            addCriterion("proof_image_url >", value, "proofImageUrl");
            return (Criteria) this;
        }

        public Criteria andProofImageUrlGreaterThanOrEqualTo(String value) {
            addCriterion("proof_image_url >=", value, "proofImageUrl");
            return (Criteria) this;
        }

        public Criteria andProofImageUrlLessThan(String value) {
            addCriterion("proof_image_url <", value, "proofImageUrl");
            return (Criteria) this;
        }

        public Criteria andProofImageUrlLessThanOrEqualTo(String value) {
            addCriterion("proof_image_url <=", value, "proofImageUrl");
            return (Criteria) this;
        }

        public Criteria andProofImageUrlLike(String value) {
            addCriterion("proof_image_url like", value, "proofImageUrl");
            return (Criteria) this;
        }

        public Criteria andProofImageUrlNotLike(String value) {
            addCriterion("proof_image_url not like", value, "proofImageUrl");
            return (Criteria) this;
        }

        public Criteria andProofImageUrlIn(List<String> values) {
            addCriterion("proof_image_url in", values, "proofImageUrl");
            return (Criteria) this;
        }

        public Criteria andProofImageUrlNotIn(List<String> values) {
            addCriterion("proof_image_url not in", values, "proofImageUrl");
            return (Criteria) this;
        }

        public Criteria andProofImageUrlBetween(String value1, String value2) {
            addCriterion("proof_image_url between", value1, value2, "proofImageUrl");
            return (Criteria) this;
        }

        public Criteria andProofImageUrlNotBetween(String value1, String value2) {
            addCriterion("proof_image_url not between", value1, value2, "proofImageUrl");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeIsNull() {
            addCriterion("create_datetime is null");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeIsNotNull() {
            addCriterion("create_datetime is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeEqualTo(Date value) {
            addCriterion("create_datetime =", value, "createDatetime");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeNotEqualTo(Date value) {
            addCriterion("create_datetime <>", value, "createDatetime");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeGreaterThan(Date value) {
            addCriterion("create_datetime >", value, "createDatetime");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_datetime >=", value, "createDatetime");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeLessThan(Date value) {
            addCriterion("create_datetime <", value, "createDatetime");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeLessThanOrEqualTo(Date value) {
            addCriterion("create_datetime <=", value, "createDatetime");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeIn(List<Date> values) {
            addCriterion("create_datetime in", values, "createDatetime");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeNotIn(List<Date> values) {
            addCriterion("create_datetime not in", values, "createDatetime");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeBetween(Date value1, Date value2) {
            addCriterion("create_datetime between", value1, value2, "createDatetime");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeNotBetween(Date value1, Date value2) {
            addCriterion("create_datetime not between", value1, value2, "createDatetime");
            return (Criteria) this;
        }

        public Criteria andUpdateDatetimeIsNull() {
            addCriterion("update_datetime is null");
            return (Criteria) this;
        }

        public Criteria andUpdateDatetimeIsNotNull() {
            addCriterion("update_datetime is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateDatetimeEqualTo(Date value) {
            addCriterion("update_datetime =", value, "updateDatetime");
            return (Criteria) this;
        }

        public Criteria andUpdateDatetimeNotEqualTo(Date value) {
            addCriterion("update_datetime <>", value, "updateDatetime");
            return (Criteria) this;
        }

        public Criteria andUpdateDatetimeGreaterThan(Date value) {
            addCriterion("update_datetime >", value, "updateDatetime");
            return (Criteria) this;
        }

        public Criteria andUpdateDatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_datetime >=", value, "updateDatetime");
            return (Criteria) this;
        }

        public Criteria andUpdateDatetimeLessThan(Date value) {
            addCriterion("update_datetime <", value, "updateDatetime");
            return (Criteria) this;
        }

        public Criteria andUpdateDatetimeLessThanOrEqualTo(Date value) {
            addCriterion("update_datetime <=", value, "updateDatetime");
            return (Criteria) this;
        }

        public Criteria andUpdateDatetimeIn(List<Date> values) {
            addCriterion("update_datetime in", values, "updateDatetime");
            return (Criteria) this;
        }

        public Criteria andUpdateDatetimeNotIn(List<Date> values) {
            addCriterion("update_datetime not in", values, "updateDatetime");
            return (Criteria) this;
        }

        public Criteria andUpdateDatetimeBetween(Date value1, Date value2) {
            addCriterion("update_datetime between", value1, value2, "updateDatetime");
            return (Criteria) this;
        }

        public Criteria andUpdateDatetimeNotBetween(Date value1, Date value2) {
            addCriterion("update_datetime not between", value1, value2, "updateDatetime");
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