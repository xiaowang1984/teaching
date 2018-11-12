package com.neuedu.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class StudentlogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StudentlogExample() {
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

        public Criteria andSidIsNull() {
            addCriterion("sid is null");
            return (Criteria) this;
        }

        public Criteria andSidIsNotNull() {
            addCriterion("sid is not null");
            return (Criteria) this;
        }

        public Criteria andSidEqualTo(Integer value) {
            addCriterion("sid =", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidNotEqualTo(Integer value) {
            addCriterion("sid <>", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidGreaterThan(Integer value) {
            addCriterion("sid >", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidGreaterThanOrEqualTo(Integer value) {
            addCriterion("sid >=", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidLessThan(Integer value) {
            addCriterion("sid <", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidLessThanOrEqualTo(Integer value) {
            addCriterion("sid <=", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidIn(List<Integer> values) {
            addCriterion("sid in", values, "sid");
            return (Criteria) this;
        }

        public Criteria andSidNotIn(List<Integer> values) {
            addCriterion("sid not in", values, "sid");
            return (Criteria) this;
        }

        public Criteria andSidBetween(Integer value1, Integer value2) {
            addCriterion("sid between", value1, value2, "sid");
            return (Criteria) this;
        }

        public Criteria andSidNotBetween(Integer value1, Integer value2) {
            addCriterion("sid not between", value1, value2, "sid");
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

        public Criteria andMoodcodeIsNull() {
            addCriterion("moodcode is null");
            return (Criteria) this;
        }

        public Criteria andMoodcodeIsNotNull() {
            addCriterion("moodcode is not null");
            return (Criteria) this;
        }

        public Criteria andMoodcodeEqualTo(Integer value) {
            addCriterion("moodcode =", value, "moodcode");
            return (Criteria) this;
        }

        public Criteria andMoodcodeNotEqualTo(Integer value) {
            addCriterion("moodcode <>", value, "moodcode");
            return (Criteria) this;
        }

        public Criteria andMoodcodeGreaterThan(Integer value) {
            addCriterion("moodcode >", value, "moodcode");
            return (Criteria) this;
        }

        public Criteria andMoodcodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("moodcode >=", value, "moodcode");
            return (Criteria) this;
        }

        public Criteria andMoodcodeLessThan(Integer value) {
            addCriterion("moodcode <", value, "moodcode");
            return (Criteria) this;
        }

        public Criteria andMoodcodeLessThanOrEqualTo(Integer value) {
            addCriterion("moodcode <=", value, "moodcode");
            return (Criteria) this;
        }

        public Criteria andMoodcodeIn(List<Integer> values) {
            addCriterion("moodcode in", values, "moodcode");
            return (Criteria) this;
        }

        public Criteria andMoodcodeNotIn(List<Integer> values) {
            addCriterion("moodcode not in", values, "moodcode");
            return (Criteria) this;
        }

        public Criteria andMoodcodeBetween(Integer value1, Integer value2) {
            addCriterion("moodcode between", value1, value2, "moodcode");
            return (Criteria) this;
        }

        public Criteria andMoodcodeNotBetween(Integer value1, Integer value2) {
            addCriterion("moodcode not between", value1, value2, "moodcode");
            return (Criteria) this;
        }

        public Criteria andLecturercodeIsNull() {
            addCriterion("lecturercode is null");
            return (Criteria) this;
        }

        public Criteria andLecturercodeIsNotNull() {
            addCriterion("lecturercode is not null");
            return (Criteria) this;
        }

        public Criteria andLecturercodeEqualTo(Integer value) {
            addCriterion("lecturercode =", value, "lecturercode");
            return (Criteria) this;
        }

        public Criteria andLecturercodeNotEqualTo(Integer value) {
            addCriterion("lecturercode <>", value, "lecturercode");
            return (Criteria) this;
        }

        public Criteria andLecturercodeGreaterThan(Integer value) {
            addCriterion("lecturercode >", value, "lecturercode");
            return (Criteria) this;
        }

        public Criteria andLecturercodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("lecturercode >=", value, "lecturercode");
            return (Criteria) this;
        }

        public Criteria andLecturercodeLessThan(Integer value) {
            addCriterion("lecturercode <", value, "lecturercode");
            return (Criteria) this;
        }

        public Criteria andLecturercodeLessThanOrEqualTo(Integer value) {
            addCriterion("lecturercode <=", value, "lecturercode");
            return (Criteria) this;
        }

        public Criteria andLecturercodeIn(List<Integer> values) {
            addCriterion("lecturercode in", values, "lecturercode");
            return (Criteria) this;
        }

        public Criteria andLecturercodeNotIn(List<Integer> values) {
            addCriterion("lecturercode not in", values, "lecturercode");
            return (Criteria) this;
        }

        public Criteria andLecturercodeBetween(Integer value1, Integer value2) {
            addCriterion("lecturercode between", value1, value2, "lecturercode");
            return (Criteria) this;
        }

        public Criteria andLecturercodeNotBetween(Integer value1, Integer value2) {
            addCriterion("lecturercode not between", value1, value2, "lecturercode");
            return (Criteria) this;
        }

        public Criteria andManagercodeIsNull() {
            addCriterion("managercode is null");
            return (Criteria) this;
        }

        public Criteria andManagercodeIsNotNull() {
            addCriterion("managercode is not null");
            return (Criteria) this;
        }

        public Criteria andManagercodeEqualTo(Integer value) {
            addCriterion("managercode =", value, "managercode");
            return (Criteria) this;
        }

        public Criteria andManagercodeNotEqualTo(Integer value) {
            addCriterion("managercode <>", value, "managercode");
            return (Criteria) this;
        }

        public Criteria andManagercodeGreaterThan(Integer value) {
            addCriterion("managercode >", value, "managercode");
            return (Criteria) this;
        }

        public Criteria andManagercodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("managercode >=", value, "managercode");
            return (Criteria) this;
        }

        public Criteria andManagercodeLessThan(Integer value) {
            addCriterion("managercode <", value, "managercode");
            return (Criteria) this;
        }

        public Criteria andManagercodeLessThanOrEqualTo(Integer value) {
            addCriterion("managercode <=", value, "managercode");
            return (Criteria) this;
        }

        public Criteria andManagercodeIn(List<Integer> values) {
            addCriterion("managercode in", values, "managercode");
            return (Criteria) this;
        }

        public Criteria andManagercodeNotIn(List<Integer> values) {
            addCriterion("managercode not in", values, "managercode");
            return (Criteria) this;
        }

        public Criteria andManagercodeBetween(Integer value1, Integer value2) {
            addCriterion("managercode between", value1, value2, "managercode");
            return (Criteria) this;
        }

        public Criteria andManagercodeNotBetween(Integer value1, Integer value2) {
            addCriterion("managercode not between", value1, value2, "managercode");
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