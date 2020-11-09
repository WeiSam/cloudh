package io.sam.db.domain;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @classname InterfaceLog
 * @description 
 * @date 2020/11/5 15:09
 * @author zhuweimu
 */
@Getter
@Setter
@ToString
public class InterfaceLog {
    /**
    * 主健
    */
    private Long id;

    /**
    * 流水号
    */
    private Object numId;

    /**
    * 应用标识
    */
    private String regId;

    /**
    * 用户标识
    */
    private String userId;

    /**
    * 单位名称
    */
    private String organization;

    /**
    * 单位机构代码
    */
    private String organizationId;

    /**
    * 用户名
    */
    private String userName;

    /**
    * 终端标识
    */
    private String terminalId;

    /**
    * 接口服务时间
    */
    private String interfaceTime;

    /**
    * 请求方名称
    */
    private String requester;

    /**
    * 操作结果
    */
    private String interfaceResult;

    /**
    * 失败原因代码
    */
    private String errorCode;

    /**
    * 操作所在模块或功能名称
    */
    private String interfaceName;

    /**
    * 接口服务条件
    */
    private String interfaceCondition;

    /**
    * 日志入库时间
    */
    private Date insertTime;

    /**
    * 日志采集方式
    */
    private String collectType;

    /**
    * 日志采集批次号
    */
    private String sendid;
}