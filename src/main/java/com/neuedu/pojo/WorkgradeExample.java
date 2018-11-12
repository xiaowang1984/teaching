package com.neuedu.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class WorkgradeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WorkgradeExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        protected void addCriterionForJDBCTime(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Time(value.getTime()), property);
        }

        protected void addCriterionForJDBCTime(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Time> timeList = new ArrayList<java.sql.Time>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                timeList.add(new java.sql.Time(iter.next().getTime()));
            }
            addCriterion(condition, timeList, property);
        }

        protected void addCriterionForJDBCTime(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Time(value1.getTime()), new java.sql.Time(value2.getTime()), property);
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

        public Criteria andWIdIsNull() {
            addCriterion("w_id is null");
            return (Criteria) this;
        }

        public Criteria andWIdIsNotNull() {
            addCriterion("w_id is not null");
            return (Criteria) this;
        }

        public Criteria andWIdEqualTo(Integer value) {
            addCriterion("w_id =", value, "wId");
            return (Criteria) this;
        }

        public Criteria andWIdNotEqualTo(Integer value) {
            addCriterion("w_id <>", value, "wId");
            return (Criteria) this;
        }

        public Criteria andWIdGreaterThan(Integer value) {
            addCriterion("w_id >", value, "wId");
            return (Criteria) this;
        }

        public Criteria andWIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("w_id >=", value, "wId");
            return (Criteria) this;
        }

        public Criteria andWIdLessThan(Integer value) {
            addCriterion("w_id <", value, "wId");
            return (Criteria) this;
        }

        public Criteria andWIdLessThanOrEqualTo(Integer value) {
            addCriterion("w_id <=", value, "wId");
            return (Criteria) this;
        }

        public Criteria andWIdIn(List<Integer> values) {
            addCriterion("w_id in", values, "wId");
            return (Criteria) this;
        }

        public Criteria andWIdNotIn(List<Integer> values) {
            addCriterion("w_id not in", values, "wId");
            return (Criteria) this;
        }

        public Criteria andWIdBetween(Integer value1, Integer value2) {
            addCriterion("w_id between", value1, value2, "wId");
            return (Criteria) this;
        }

        public Criteria andWIdNotBetween(Integer value1, Integer value2) {
            addCriterion("w_id not between", value1, value2, "wId");
            return (Criteria) this;
        }

        public Criteria andDatIsNull() {
            addCriterion("dat is null");
            return (Criteria) this;
        }

        public Criteria andDatIsNotNull() {
            addCriterion("dat is not null");
            return (Criteria) this;
        }

        public Criteria andDatEqualTo(Date value) {
            addCriterionForJDBCDate("dat =", value, "dat");
            return (Criteria) this;
        }

        public Criteria andDatNotEqualTo(Date value) {
            addCriterionForJDBCDate("dat <>", value, "dat");
            return (Criteria) this;
        }

        public Criteria andDatGreaterThan(Date value) {
            addCriterionForJDBCDate("dat >", value, "dat");
            return (Criteria) this;
        }

        public Criteria andDatGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("dat >=", value, "dat");
            return (Criteria) this;
        }

        public Criteria andDatLessThan(Date value) {
            addCriterionForJDBCDate("dat <", value, "dat");
            return (Criteria) this;
        }

        public Criteria andDatLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("dat <=", value, "dat");
            return (Criteria) this;
        }

        public Criteria andDatIn(List<Date> values) {
            addCriterionForJDBCDate("dat in", values, "dat");
            return (Criteria) this;
        }

        public Criteria andDatNotIn(List<Date> values) {
            addCriterionForJDBCDate("dat not in", values, "dat");
            return (Criteria) this;
        }

        public Criteria andDatBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("dat between", value1, value2, "dat");
            return (Criteria) this;
        }

        public Criteria andDatNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("dat not between", value1, value2, "dat");
            return (Criteria) this;
        }

        public Criteria andAddsIsNull() {
            addCriterion("adds is null");
            return (Criteria) this;
        }

        public Criteria andAddsIsNotNull() {
            addCriterion("adds is not null");
            return (Criteria) this;
        }

        public Criteria andAddsEqualTo(Integer value) {
            addCriterion("adds =", value, "adds");
            return (Criteria) this;
        }

        public Criteria andAddsNotEqualTo(Integer value) {
            addCriterion("adds <>", value, "adds");
            return (Criteria) this;
        }

        public Criteria andAddsGreaterThan(Integer value) {
            addCriterion("adds >", value, "adds");
            return (Criteria) this;
        }

        public Criteria andAddsGreaterThanOrEqualTo(Integer value) {
            addCriterion("adds >=", value, "adds");
            return (Criteria) this;
        }

        public Criteria andAddsLessThan(Integer value) {
            addCriterion("adds <", value, "adds");
            return (Criteria) this;
        }

        public Criteria andAddsLessThanOrEqualTo(Integer value) {
            addCriterion("adds <=", value, "adds");
            return (Criteria) this;
        }

        public Criteria andAddsIn(List<Integer> values) {
            addCriterion("adds in", values, "adds");
            return (Criteria) this;
        }

        public Criteria andAddsNotIn(List<Integer> values) {
            addCriterion("adds not in", values, "adds");
            return (Criteria) this;
        }

        public Criteria andAddsBetween(Integer value1, Integer value2) {
            addCriterion("adds between", value1, value2, "adds");
            return (Criteria) this;
        }

        public Criteria andAddsNotBetween(Integer value1, Integer value2) {
            addCriterion("adds not between", value1, value2, "adds");
            return (Criteria) this;
        }

        public Criteria andDelsIsNull() {
            addCriterion("dels is null");
            return (Criteria) this;
        }

        public Criteria andDelsIsNotNull() {
            addCriterion("dels is not null");
            return (Criteria) this;
        }

        public Criteria andDelsEqualTo(Integer value) {
            addCriterion("dels =", value, "dels");
            return (Criteria) this;
        }

        public Criteria andDelsNotEqualTo(Integer value) {
            addCriterion("dels <>", value, "dels");
            return (Criteria) this;
        }

        public Criteria andDelsGreaterThan(Integer value) {
            addCriterion("dels >", value, "dels");
            return (Criteria) this;
        }

        public Criteria andDelsGreaterThanOrEqualTo(Integer value) {
            addCriterion("dels >=", value, "dels");
            return (Criteria) this;
        }

        public Criteria andDelsLessThan(Integer value) {
            addCriterion("dels <", value, "dels");
            return (Criteria) this;
        }

        public Criteria andDelsLessThanOrEqualTo(Integer value) {
            addCriterion("dels <=", value, "dels");
            return (Criteria) this;
        }

        public Criteria andDelsIn(List<Integer> values) {
            addCriterion("dels in", values, "dels");
            return (Criteria) this;
        }

        public Criteria andDelsNotIn(List<Integer> values) {
            addCriterion("dels not in", values, "dels");
            return (Criteria) this;
        }

        public Criteria andDelsBetween(Integer value1, Integer value2) {
            addCriterion("dels between", value1, value2, "dels");
            return (Criteria) this;
        }

        public Criteria andDelsNotBetween(Integer value1, Integer value2) {
            addCriterion("dels not between", value1, value2, "dels");
            return (Criteria) this;
        }

        public Criteria andStucountIsNull() {
            addCriterion("stucount is null");
            return (Criteria) this;
        }

        public Criteria andStucountIsNotNull() {
            addCriterion("stucount is not null");
            return (Criteria) this;
        }

        public Criteria andStucountEqualTo(Integer value) {
            addCriterion("stucount =", value, "stucount");
            return (Criteria) this;
        }

        public Criteria andStucountNotEqualTo(Integer value) {
            addCriterion("stucount <>", value, "stucount");
            return (Criteria) this;
        }

        public Criteria andStucountGreaterThan(Integer value) {
            addCriterion("stucount >", value, "stucount");
            return (Criteria) this;
        }

        public Criteria andStucountGreaterThanOrEqualTo(Integer value) {
            addCriterion("stucount >=", value, "stucount");
            return (Criteria) this;
        }

        public Criteria andStucountLessThan(Integer value) {
            addCriterion("stucount <", value, "stucount");
            return (Criteria) this;
        }

        public Criteria andStucountLessThanOrEqualTo(Integer value) {
            addCriterion("stucount <=", value, "stucount");
            return (Criteria) this;
        }

        public Criteria andStucountIn(List<Integer> values) {
            addCriterion("stucount in", values, "stucount");
            return (Criteria) this;
        }

        public Criteria andStucountNotIn(List<Integer> values) {
            addCriterion("stucount not in", values, "stucount");
            return (Criteria) this;
        }

        public Criteria andStucountBetween(Integer value1, Integer value2) {
            addCriterion("stucount between", value1, value2, "stucount");
            return (Criteria) this;
        }

        public Criteria andStucountNotBetween(Integer value1, Integer value2) {
            addCriterion("stucount not between", value1, value2, "stucount");
            return (Criteria) this;
        }

        public Criteria andStucommitIsNull() {
            addCriterion("stucommit is null");
            return (Criteria) this;
        }

        public Criteria andStucommitIsNotNull() {
            addCriterion("stucommit is not null");
            return (Criteria) this;
        }

        public Criteria andStucommitEqualTo(Integer value) {
            addCriterion("stucommit =", value, "stucommit");
            return (Criteria) this;
        }

        public Criteria andStucommitNotEqualTo(Integer value) {
            addCriterion("stucommit <>", value, "stucommit");
            return (Criteria) this;
        }

        public Criteria andStucommitGreaterThan(Integer value) {
            addCriterion("stucommit >", value, "stucommit");
            return (Criteria) this;
        }

        public Criteria andStucommitGreaterThanOrEqualTo(Integer value) {
            addCriterion("stucommit >=", value, "stucommit");
            return (Criteria) this;
        }

        public Criteria andStucommitLessThan(Integer value) {
            addCriterion("stucommit <", value, "stucommit");
            return (Criteria) this;
        }

        public Criteria andStucommitLessThanOrEqualTo(Integer value) {
            addCriterion("stucommit <=", value, "stucommit");
            return (Criteria) this;
        }

        public Criteria andStucommitIn(List<Integer> values) {
            addCriterion("stucommit in", values, "stucommit");
            return (Criteria) this;
        }

        public Criteria andStucommitNotIn(List<Integer> values) {
            addCriterion("stucommit not in", values, "stucommit");
            return (Criteria) this;
        }

        public Criteria andStucommitBetween(Integer value1, Integer value2) {
            addCriterion("stucommit between", value1, value2, "stucommit");
            return (Criteria) this;
        }

        public Criteria andStucommitNotBetween(Integer value1, Integer value2) {
            addCriterion("stucommit not between", value1, value2, "stucommit");
            return (Criteria) this;
        }

        public Criteria andPersonIsNull() {
            addCriterion("person is null");
            return (Criteria) this;
        }

        public Criteria andPersonIsNotNull() {
            addCriterion("person is not null");
            return (Criteria) this;
        }

        public Criteria andPersonEqualTo(Integer value) {
            addCriterion("person =", value, "person");
            return (Criteria) this;
        }

        public Criteria andPersonNotEqualTo(Integer value) {
            addCriterion("person <>", value, "person");
            return (Criteria) this;
        }

        public Criteria andPersonGreaterThan(Integer value) {
            addCriterion("person >", value, "person");
            return (Criteria) this;
        }

        public Criteria andPersonGreaterThanOrEqualTo(Integer value) {
            addCriterion("person >=", value, "person");
            return (Criteria) this;
        }

        public Criteria andPersonLessThan(Integer value) {
            addCriterion("person <", value, "person");
            return (Criteria) this;
        }

        public Criteria andPersonLessThanOrEqualTo(Integer value) {
            addCriterion("person <=", value, "person");
            return (Criteria) this;
        }

        public Criteria andPersonIn(List<Integer> values) {
            addCriterion("person in", values, "person");
            return (Criteria) this;
        }

        public Criteria andPersonNotIn(List<Integer> values) {
            addCriterion("person not in", values, "person");
            return (Criteria) this;
        }

        public Criteria andPersonBetween(Integer value1, Integer value2) {
            addCriterion("person between", value1, value2, "person");
            return (Criteria) this;
        }

        public Criteria andPersonNotBetween(Integer value1, Integer value2) {
            addCriterion("person not between", value1, value2, "person");
            return (Criteria) this;
        }

        public Criteria andAvgtimeIsNull() {
            addCriterion("avgtime is null");
            return (Criteria) this;
        }

        public Criteria andAvgtimeIsNotNull() {
            addCriterion("avgtime is not null");
            return (Criteria) this;
        }

        public Criteria andAvgtimeEqualTo(Date value) {
            addCriterionForJDBCTime("avgtime =", value, "avgtime");
            return (Criteria) this;
        }

        public Criteria andAvgtimeNotEqualTo(Date value) {
            addCriterionForJDBCTime("avgtime <>", value, "avgtime");
            return (Criteria) this;
        }

        public Criteria andAvgtimeGreaterThan(Date value) {
            addCriterionForJDBCTime("avgtime >", value, "avgtime");
            return (Criteria) this;
        }

        public Criteria andAvgtimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("avgtime >=", value, "avgtime");
            return (Criteria) this;
        }

        public Criteria andAvgtimeLessThan(Date value) {
            addCriterionForJDBCTime("avgtime <", value, "avgtime");
            return (Criteria) this;
        }

        public Criteria andAvgtimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("avgtime <=", value, "avgtime");
            return (Criteria) this;
        }

        public Criteria andAvgtimeIn(List<Date> values) {
            addCriterionForJDBCTime("avgtime in", values, "avgtime");
            return (Criteria) this;
        }

        public Criteria andAvgtimeNotIn(List<Date> values) {
            addCriterionForJDBCTime("avgtime not in", values, "avgtime");
            return (Criteria) this;
        }

        public Criteria andAvgtimeBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("avgtime between", value1, value2, "avgtime");
            return (Criteria) this;
        }

        public Criteria andAvgtimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("avgtime not between", value1, value2, "avgtime");
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