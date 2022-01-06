package io.sam.queue;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;

/**
 * @author zhuweimu
 * @classname NonSenseReceiveRo
 * @description
 * @date 2020/12/11 14:28
 */
public class NonSenseReceiveRo {

    /**
     * 匹配数据
     */
    @JsonProperty("matchResult")
    private List<PPAMatchResultBean> matchResult;
    /**
     * 抓拍数据
     */
    @JsonProperty("captureResult")
    private List<PPACaptureResultBean> captureResult;

    public List<PPAMatchResultBean> getMatchResult() {
        return matchResult;
    }

    public void setMatchResult(List<PPAMatchResultBean> matchResult) {
        this.matchResult = matchResult;
    }

    public List<PPACaptureResultBean> getCaptureResult() {
        return captureResult;
    }

    public void setCaptureResult(List<PPACaptureResultBean> captureResult) {
        this.captureResult = captureResult;
    }

    public static class PPAMatchResultBean {

        private String deviceId;
        private int taskId;
        private String cameraDetail;
        private Date captureTime;
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

        public Date getCaptureTime() {
            return captureTime;
        }

        public void setCaptureTime(Date captureTime) {
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
                private int id;
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

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
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

    public static class PPACaptureResultBean {

        private String deviceId;
        private int taskId;
        private String cameraDetail;
        private String captureTime;
        private String faceUrl;
        private String bodyUrl;

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
    }

}
