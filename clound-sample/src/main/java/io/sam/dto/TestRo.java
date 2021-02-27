package io.sam.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author zhuweimu
 * @classname TestRo
 * @description
 * @date 2020/12/15 14:15
 */
public class TestRo {

    private List<PPAMatchResultBean> PPAMatchResult;

    @JsonProperty("USErDTos")
    private List<UserDto> USErDTos;

    public List<UserDto> getUSErDTos() {
        return USErDTos;
    }

    public void setUSErDTos(List<UserDto> USErDTos) {
        this.USErDTos = USErDTos;
    }

    public List<PPAMatchResultBean> getPPAMatchResult() {
        return PPAMatchResult;
    }

    public void setPPAMatchResult(List<PPAMatchResultBean> PPAMatchResult) {
        this.PPAMatchResult = PPAMatchResult;
    }

    public static class PPAMatchResultBean {
        /**
         * deviceId : 1
         * taskId : 10
         * cameraDetail : 摄像头自定义信息
         * captureTime : 2016-12-12 12:12:10
         * faceUrl : http://192.168.1.1:8080/D/Capture/1.jpeg
         * bodyUrl : http://192.168.1.1:8080/D/CaptureBody/1.jpeg
         * similarity : {"value":70.1,"personInfo":{"personId":11,"name":"小李","gender":1,"birthday":"1990-06-22","age":11,"certificateType":1,"certificateId":"74110","birthPlace":"广州","groupId":1,"groupType":10,"registerTime":"2015-06-10 12:13:02","remark":"备注","userId":"4544fdfdfd","imageInfo":{"registerUrl":"http://172.16.16.234:9090/1.jpeg","captureUrl":"http://172.16.16.234:9090/1.jpeg","frontUrl":"http://172.16.16.234:9090/1.jpeg","flankUrl":"http://172.16.16.234:9090/1.jpeg","backUrl":"http://172.16.16.234:9090/1.jpeg"}},"matchType":1}
         */

        private String deviceId;
        private int taskId;
        private String cameraDetail;
        private String captureTime;
        private String faceUrl;
        private String bodyUrl;
        private SimilarityBean similarity;

        public String getDeviceId() {
            return deviceId;
        }

        public void setDeviceId(String deviceId) {
            this.deviceId = deviceId;
        }

        public int getTaskId() {
            return taskId;
        }

        public void setTaskId(int taskId) {
            this.taskId = taskId;
        }

        public String getCameraDetail() {
            return cameraDetail;
        }

        public void setCameraDetail(String cameraDetail) {
            this.cameraDetail = cameraDetail;
        }

        public String getCaptureTime() {
            return captureTime;
        }

        public void setCaptureTime(String captureTime) {
            this.captureTime = captureTime;
        }

        public String getFaceUrl() {
            return faceUrl;
        }

        public void setFaceUrl(String faceUrl) {
            this.faceUrl = faceUrl;
        }

        public String getBodyUrl() {
            return bodyUrl;
        }

        public void setBodyUrl(String bodyUrl) {
            this.bodyUrl = bodyUrl;
        }

        public SimilarityBean getSimilarity() {
            return similarity;
        }

        public void setSimilarity(SimilarityBean similarity) {
            this.similarity = similarity;
        }

        public static class SimilarityBean {
            /**
             * value : 70.1
             * personInfo : {"personId":11,"name":"小李","gender":1,"birthday":"1990-06-22","age":11,"certificateType":1,"certificateId":"74110","birthPlace":"广州","groupId":1,"groupType":10,"registerTime":"2015-06-10 12:13:02","remark":"备注","userId":"4544fdfdfd","imageInfo":{"registerUrl":"http://172.16.16.234:9090/1.jpeg","captureUrl":"http://172.16.16.234:9090/1.jpeg","frontUrl":"http://172.16.16.234:9090/1.jpeg","flankUrl":"http://172.16.16.234:9090/1.jpeg","backUrl":"http://172.16.16.234:9090/1.jpeg"}}
             * matchType : 1
             */

            private double value;
            private PersonInfoBean personInfo;
            private int matchType;

            public double getValue() {
                return value;
            }

            public void setValue(double value) {
                this.value = value;
            }

            public PersonInfoBean getPersonInfo() {
                return personInfo;
            }

            public void setPersonInfo(PersonInfoBean personInfo) {
                this.personInfo = personInfo;
            }

            public int getMatchType() {
                return matchType;
            }

            public void setMatchType(int matchType) {
                this.matchType = matchType;
            }

            public static class PersonInfoBean {
                /**
                 * personId : 11
                 * name : 小李
                 * gender : 1
                 * birthday : 1990-06-22
                 * age : 11
                 * certificateType : 1
                 * certificateId : 74110
                 * birthPlace : 广州
                 * groupId : 1
                 * groupType : 10
                 * registerTime : 2015-06-10 12:13:02
                 * remark : 备注
                 * userId : 4544fdfdfd
                 * imageInfo : {"registerUrl":"http://172.16.16.234:9090/1.jpeg","captureUrl":"http://172.16.16.234:9090/1.jpeg","frontUrl":"http://172.16.16.234:9090/1.jpeg","flankUrl":"http://172.16.16.234:9090/1.jpeg","backUrl":"http://172.16.16.234:9090/1.jpeg"}
                 */

                private int personId;
                private String name;
                private int gender;
                private String birthday;
                private int age;
                private int certificateType;
                private String certificateId;
                private String birthPlace;
                private int groupId;
                private int groupType;
                private String registerTime;
                private String remark;
                private String userId;
                private ImageInfoBean imageInfo;

                public int getPersonId() {
                    return personId;
                }

                public void setPersonId(int personId) {
                    this.personId = personId;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public int getGender() {
                    return gender;
                }

                public void setGender(int gender) {
                    this.gender = gender;
                }

                public String getBirthday() {
                    return birthday;
                }

                public void setBirthday(String birthday) {
                    this.birthday = birthday;
                }

                public int getAge() {
                    return age;
                }

                public void setAge(int age) {
                    this.age = age;
                }

                public int getCertificateType() {
                    return certificateType;
                }

                public void setCertificateType(int certificateType) {
                    this.certificateType = certificateType;
                }

                public String getCertificateId() {
                    return certificateId;
                }

                public void setCertificateId(String certificateId) {
                    this.certificateId = certificateId;
                }

                public String getBirthPlace() {
                    return birthPlace;
                }

                public void setBirthPlace(String birthPlace) {
                    this.birthPlace = birthPlace;
                }

                public int getGroupId() {
                    return groupId;
                }

                public void setGroupId(int groupId) {
                    this.groupId = groupId;
                }

                public int getGroupType() {
                    return groupType;
                }

                public void setGroupType(int groupType) {
                    this.groupType = groupType;
                }

                public String getRegisterTime() {
                    return registerTime;
                }

                public void setRegisterTime(String registerTime) {
                    this.registerTime = registerTime;
                }

                public String getRemark() {
                    return remark;
                }

                public void setRemark(String remark) {
                    this.remark = remark;
                }

                public String getUserId() {
                    return userId;
                }

                public void setUserId(String userId) {
                    this.userId = userId;
                }

                public ImageInfoBean getImageInfo() {
                    return imageInfo;
                }

                public void setImageInfo(ImageInfoBean imageInfo) {
                    this.imageInfo = imageInfo;
                }

                public static class ImageInfoBean {
                    /**
                     * registerUrl : http://172.16.16.234:9090/1.jpeg
                     * captureUrl : http://172.16.16.234:9090/1.jpeg
                     * frontUrl : http://172.16.16.234:9090/1.jpeg
                     * flankUrl : http://172.16.16.234:9090/1.jpeg
                     * backUrl : http://172.16.16.234:9090/1.jpeg
                     */

                    private String registerUrl;
                    private String captureUrl;
                    private String frontUrl;
                    private String flankUrl;
                    private String backUrl;

                    public String getRegisterUrl() {
                        return registerUrl;
                    }

                    public void setRegisterUrl(String registerUrl) {
                        this.registerUrl = registerUrl;
                    }

                    public String getCaptureUrl() {
                        return captureUrl;
                    }

                    public void setCaptureUrl(String captureUrl) {
                        this.captureUrl = captureUrl;
                    }

                    public String getFrontUrl() {
                        return frontUrl;
                    }

                    public void setFrontUrl(String frontUrl) {
                        this.frontUrl = frontUrl;
                    }

                    public String getFlankUrl() {
                        return flankUrl;
                    }

                    public void setFlankUrl(String flankUrl) {
                        this.flankUrl = flankUrl;
                    }

                    public String getBackUrl() {
                        return backUrl;
                    }

                    public void setBackUrl(String backUrl) {
                        this.backUrl = backUrl;
                    }
                }
            }
        }
    }
}
