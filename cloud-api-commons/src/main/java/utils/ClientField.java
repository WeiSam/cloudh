package utils;

/**
 * @author zhuweimu
 * @Classname ClientField
 * @Description
 * @Date 2020/8/3 17:12
 */
public class ClientField {

    /**
     * 参数名称
     */
    private String paramName;
    /**
     * 参数类型
     */
    private Class<?> paramType;
    /**
     * 参数值
     */
    private Object paramValue;

    public ClientField() {
        super();
    }

    public ClientField(String paramName, Class<?> paramType, Object paramValue) {
        super();
        this.paramName = paramName;
        this.paramType = paramType;
        this.paramValue = paramValue;
    }

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    public Class<?> getParamType() {
        return paramType;
    }

    public void setParamType(Class<?> paramType) {
        this.paramType = paramType;
    }

    public Object getParamValue() {
        return paramValue;
    }

    public void setParamValue(Object paramValue) {
        this.paramValue = paramValue;
    }
}
