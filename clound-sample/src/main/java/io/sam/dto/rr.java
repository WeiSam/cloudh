package io.sam.dto;

/**
 * @author zhuweimu
 * @classname rr
 * @description
 * @date 2020/12/8 9:26
 */
public class rr {


    /**
     * condition : {"personId":1}
     */

    private ConditionBean condition;

    public ConditionBean getCondition() {
        return condition;
    }

    public void setCondition(ConditionBean condition) {
        this.condition = condition;
    }

    public static class ConditionBean {
        /**
         * personId : 1
         */

        private int personId;

        public int getPersonId() {
            return personId;
        }

        public void setPersonId(int personId) {
            this.personId = personId;
        }
    }
}
