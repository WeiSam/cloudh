package io.sam.db.domain;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @classname QbBaqry
 * @description 
 * @date 2020/11/5 15:12
 * @author zhuweimu
 */
@Getter
@Setter
@ToString
public class QbBaqry {
    /**
    * 案件编号--执法闭环
    */
    private String ajbh;

    /**
    * 人员编号--执法闭环
    */
    private String rybh;

    /**
    * 人员姓名
    */
    private String xm;

    /**
    * 身份证号码
    */
    private String sfzh;

    /**
    * 入办案区登记时间
    */
    private Date rssj;

    /**
    * 离办案区登记时间
    */
    private Date lssj;

    /**
    * 人员轨迹展示页面地址
    */
    private String rygj;

    /**
    * 是否信息采集 1 是 0 否
    */
    private String sfcj;

    /**
    * 是否身体检查 1 是 0 否
    */
    private String sfstjc;

    /**
    * 随身物品展示页面地址
    */
    private String sswp;

    /**
    * 实时定位
    */
    private String qcsp;

    /**
    * 承办单位编号
    */
    private String cbdwBh;

    /**
    * 承办民警身份证号
    */
    private String cbrSfzh;

    /**
    * 信息采集展示页面地址-人员档案
    */
    private String sfcjdz;

    /**
    * 身体检查展示页面地址-人员档案
    */
    private String sfstjcdz;
}