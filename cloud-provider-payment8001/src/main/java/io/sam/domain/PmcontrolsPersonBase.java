package io.sam.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.Builder;
import lombok.Data;

/**
 * @Classname PmcontrolsPersonBase
 * @Description TODO
 * @Date 2020/7/22 11:13
 * @Auther by zhuweimu
 */
/**
    * 人员综合信息表
    */
@Data
@Builder
public class PmcontrolsPersonBase implements Serializable {
    /**
    * 主键ID
    */
    private Integer id;

    /**
    * 数据库逻辑ID
    */
    private String magicId;

    /**
    * 人脸库PERSON_ID
    */
    private String facePeasonId;

    /**
    * 姓名
    */
    private String name;

    /**
    * 编号
    */
    private String num;

    /**
    * 案件类型  gov 行政 criminal 刑事（原： 1-刑事 2-行政）
    */
    private Object caseType;

    /**
    * 身份类型：id_card-身份证 passport-护照 driver_license-驾驶证 other-其他,hk_land_pass-港澳居民来往内地通行证,tw_land_pass-台湾居民来往大陆通行证,hk_pass-港澳通行证,tw_pass-台湾通行证(原：1-身份证；2-护照；3-驾驶证；4-其他)
    */
    private Object identityType;

    /**
    * 人员情况：suspect-嫌疑人；witness-证人；victim-被害人；other-其他,guardian-监护人或法定代理人,identify-辨认人,foil-辨认陪衬人员,translator-翻译人员,informant-报案人（原 1-嫌疑人；2-证人；3-被害人；4-其他）
    */
    private Object personType;

    /**
    * 身份证号码
    */
    private String identityNum;

    /**
    * 性别（male男/female女/unknown未知）（原： 1-男 2-女）
    */
    private Object gender;

    /**
    * 年龄
    */
    private Integer age;

    /**
    * 国籍
    */
    private String nationality;

    /**
    * 国籍代码
    */
    private String nationalityCode;

    /**
    * 户籍地址
    */
    private String regAddress;

    /**
    * 暂住地址
    */
    private String tempAddress;

    /**
    * 工作单位
    */
    private String workUint;

    /**
    * 生日
    */
    private String birthDate;

    /**
    * 联系方式
    */
    private String tel;

    /**
    * 详细涉案案由
    */
    private String caseReasonDetail;

    /**
    * 详细进区原由
    */
    private String detailReason;

    /**
    * 涉案案由
    */
    private String reasonType;

    /**
    * 进入区域原因：surrender_oneself 投案自首|public_order_subpona 治安传唤|continue_inquire 继续盘问|criminal_subpona 刑事传唤|witnness 证人|residential_surveillance 监视居住|summon_by_warrant 拘传|criminal_detention 刑事拘留|await_trial 取保候审|foil_personnel 辨认陪衬人员|arrest 逮捕|victim 被害人|other 其他|minor_companion 陪同未成年人询问的合适人员|sober_up_person 醒酒人员|seize_and_turn_over 扭送|communications 传讯|routine_urine 例行尿检
    */
    private String enterType;

    /**
    * 人员指纹
    */
    private String fingerPrint;

    /**
    * 信息采集勾选
    */
    private String collectionChecked;

    /**
    * 措施状态 none-默认 delay_forensics-延时取证 delay_detention-延时拘留 （原：0-默认；1-延时取证；2-延时拘留）
    */
    private Object delayStatus;

    /**
    * 办案区名称
    */
    private String orgName;

    /**
    * 办案区CODE
    */
    private String orgCode;

    /**
    * 办案区MAGICID
    */
    private String orgMagicId;

    /**
    * 主办民警名称
    */
    private String policeName;

    /**
    * 主办民警编号
    */
    private String policeCode;

    /**
    * 主办民警MAGICID
    */
    private String policeMagicId;

    /**
    * 主办单位MAGICID
    */
    private String masterOrgMagicId;

    /**
    * 是否信息对比 N 否 Y 是
    */
    private Object isChecked;

    /**
    * 是否入库 N 否 Y 是
    */
    private Object isPersisted;

    /**
    * Enter = 0 进入办案区--待登记;  Register = 1 登记--待检查;   Check = 1001 人身检查 ; Belongs = 1002 随身物品;  InfoGather = 1003 信息采集;  Waiting = 1004 候问;  Trial= 1005 审讯--讯问;    Distribute = 1006 分配;  Leave = 4 离开办案;  approval = 1007 离开审批;  leaveAWhileFlag = 1008 临时出区期间的轨迹标;  leaveAWhile = 1009 临时出区; 
    */
    private String stepProgressStatus;

    /**
    * 是否被管控 true-是 false-否（原：1-是；0-否）
    */
    private Boolean isPersonControls;

    /**
    * 文书编号
    */
    private String docNo;

    /**
    * 涉案编号
    */
    private String caseCode;

    /**
    * 涉案逻辑Id
    */
    private String caseMagicId;

    /**
    * 人脸照片地址
    */
    private String faceImgUrl;

    /**
    * 委托领取人姓名
    */
    private String entrustName;

    /**
    * 委托领取人联系方式
    */
    private String entrustContact;

    /**
    * 人员当前所在功能室MagicId
    */
    private String currentRoomMagicId;

    /**
    * 采集信息详情
    */
    private String infoCollection;

    /**
    * 人员注册通道：wpf：终端，app：警务云app，tablet：平板，third：第三方
    */
    private String channel;

    /**
    * 删除标记  Y  已删除   N  未删除
    */
    private Object isDeleted;

    /**
    * 人员离开时间
    */
    private Date leaveTime;

    /**
    * 离开截止时间
    */
    private Date leaveDeadline;

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

    /**
    * 体温（单位：摄氏度）
    */
    private String temperature;

    private static final long serialVersionUID = 1L;
}