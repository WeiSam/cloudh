package io.sam.utils;

import java.lang.reflect.Field;

/**
 * @author zhuweimu
 * @classname QuanZhouPopulationConfig
 * @description
 * @date 2021/2/2 15:30
 */
public class QuanZhouPopulationConfig extends BaseDicConfig {

    private static final String KEY = "QUANZHOU_M_POPULATION_";

    /**
     * URL
     */
    public static final String QUANZHOU_M_POPULATION_URL = "QUANZHOU_M_POPULATION_URL";

    /**
     * 操作人员单位名称
     */
    public static final String QUANZHOU_M_POPULATION_OPER_DWMC = "QUANZHOU_M_POPULATION_OPER_DWMC";

    /**
     * 操作人员姓名
     */
    public static final String QUANZHOU_M_POPULATION_OPER_XM = "QUANZHOU_M_POPULATION_OPER_XM";

    /**
     * 请求终端IP地址
     */
    public static final String QUANZHOU_M_POPULATION_OPER_IP = "QUANZHOU_M_POPULATION_OPER_IP";

    /**
     * 请求终端MAC地址
     */
    public final String QUANZHOU_M_POPULATION_OPER_MAC = "QUANZHOU_M_POPULATION_OPER_MAC";

    /**
     * 操作人员证件号码
     */
    public static final String QUANZHOU_M_POPULATION_OPER_ZJHM = "QUANZHOU_M_POPULATION_OPER_ZJHM";

    /**
     * 办案单位编码
     */
    public static final String QUANZHOU_M_POPULATION_OPER_DWDM = "QUANZHOU_M_POPULATION_OPER_DWDM";

    /**
     * 请求事由
     */
    public static final String QUANZHOU_M_POPULATION_OPER_QQSY = "QUANZHOU_M_POPULATION_OPER_QQSY";

    /**
     * 公钥
     */
    public static final String QUANZHOU_M_POPULATION_PBKEY = "QUANZHOU_M_POPULATION_PBKEY";

    /**
     * 私钥
     */
    public static final String QUANZHOU_M_POPULATION_PRKEY = "QUANZHOU_M_POPULATION_PRKEY";


    @Override
    public Boolean isDicField(Field field) {
        return this.isDicField(field,KEY);
    }
}
