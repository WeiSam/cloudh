package io.sam.dto;


public class ChongqingRequest {
    /**
     * 数据发送的序列号 必填
     */
    private String uuid;
    /**
     * 数据发送用户id 由管理平台下发 必填
     */
    private String userId;
    /**
     * 密钥 由管理平台下发 必填
     */
    private String licenseKey;
    /**
     * 数据格式 非必填
     */
    private String format ;
    /**
     * 上报的业务数据类型：personInfo 人员信息，realtimePerson 各流程环节实时人数，realTimePoliceIn 接待民警数，realTimeTotalIn 总接待人数，personTmpIn人员临时进出区,historyVideoInfo 各流程环节历史视频，goodsInfo 物品信息，alarmInfo 告警信息，roomPerson 功能室人流量实时分布，shareData 数据共享实时数据，signInfo 场所巡查信息，sendIpcInfo 实时审讯视频信息，noticeDataInfo 消息提醒信息，historyInterrogateVideo 历史审讯视频信息，sendVideoInfo 视频配置信息，sendArchiveData执法卷宗管理统计实时数据上报(案件)，sendPoliceCseArchiveData执法卷宗管理统计实时数据上报(警情)，checkPointCount 考评环节扣分(抽案考评)，appraisalCount 抽案/日常考评实时情况，dailyPoint 单位考评平均扣分实时 (日常考评)，sendMeasureStatstic 强制措施信息，propertyInfo 财物信息增量同步上报，propertyTotal财物数据总数实时上报，flowTotal流转信息每日上报，warningInfo物管场所告警上报,warehouseTotal仓库使用情况实时上报
     */
    private String business;
    /**
     * 实际传参数据
     */
    private Object datas;
    /**
     * 批次数量
     */
    private Integer num ;
    /**
     * 同步方式 0-异步 1-同步 默认1
     */
    private Integer sync;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLicenseKey() {
        return licenseKey;
    }

    public void setLicenseKey(String licenseKey) {
        this.licenseKey = licenseKey;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getBusiness() {
        return business;
    }

    public void setBusiness(String business) {
        this.business = business;
    }

    public Object getDatas() {
        return datas;
    }

    public void setDatas(Object datas) {
        this.datas = datas;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getSync() {
        return sync;
    }

    public void setSync(Integer sync) {
        this.sync = sync;
    }
}
