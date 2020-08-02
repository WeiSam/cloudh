package io.sam.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * @Classname PmcontrolsPersonCheck
 * @Description TODO
 * @Date 2020/7/22 13:55
 * @Auther by zhuweimu
 */

/**
 * 人身检查信息表
 */
@Data
public class PmcontrolsPersonCheck implements Serializable {
    /**
     * 主键ID
     */
    private Integer id;

    /**
     * 数据库逻辑ID
     */
    private String magicId;

    /**
     * 人员逻辑ID
     */
    private String personMagicId;

    /**
     * 有无病史：Y-有 N-无
     */
    private Object hasSick;

    /**
     * 以往病史
     */
    private String sickHistory;

    /**
     * 病史综合描述
     */
    private String sickDesc;

    /**
     * 有无伤情：Y-有 N-无
     */
    private Object hasInjury;

    /**
     * 自述有无伤情  自述情况
     */
    private String injuryDesc;

    /**
     * 自述造成伤情原因
     */
    private String injuryReason;

    /**
     * 体表有无伤情：Y-有 N-无
     */
    private Object hasSurfaceInjury;

    /**
     * 是否饮酒 Y-是 N-否
     */
    private Object isDrinked;

    /**
     * 是否需要救治 Y-是 N-否
     */
    private Object isNeedCure;

    /**
     * 删除标记  Y  已删除   N  未删除
     */
    private Object isDeleted;

    /**
     * 创建用户MAGIC_ID
     */
    private String createUser;

    /**
     * 修改用户MAGIC_ID
     */
    private String updatedUser;

    /**
     * 创建时间
     */
    private Date createdTime;

    /**
     * 更新时间
     */
    private Date updatedTime;

    private static final long serialVersionUID = 1L;

}