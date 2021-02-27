package io.sam.config;

import java.io.Serializable;

class OrgInfo implements Serializable {
        private String sk;
        private String ak;
        private String userName;
        private String userCode;
        private String idCard;
        private String organizeCode;
        private String organizeName;

        public String getSk() {
            return sk;
        }

        public void setSk(String sk) {
            this.sk = sk;
        }

        public String getAk() {
            return ak;
        }

        public void setAk(String ak) {
            this.ak = ak;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getUserCode() {
            return userCode;
        }

        public void setUserCode(String userCode) {
            this.userCode = userCode;
        }

        public String getIdCard() {
            return idCard;
        }

        public void setIdCard(String idCard) {
            this.idCard = idCard;
        }

        public String getOrganizeCode() {
            return organizeCode;
        }

        public void setOrganizeCode(String organizeCode) {
            this.organizeCode = organizeCode;
        }

        public String getOrganizeName() {
            return organizeName;
        }

        public void setOrganizeName(String organizeName) {
            this.organizeName = organizeName;
        }
    }