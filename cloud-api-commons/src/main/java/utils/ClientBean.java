package utils;

import java.util.List;

/**
 * @author zhuweimu
 * @Classname ClientBean
 * @Description
 * @Date 2020/8/3 17:13
 */
public class ClientBean {

    /**
     * WebService接口请求地址
     */
    private String endpointUrl;
    /**
     * WebService接口请求的命名空间
     */
    private String targetNamespace;
    /**
     * WebService接口请求actionUrl
     */
    private String actionUrl;
    /**
     * WebService接口请求方法名称
     */
    private String methodName;
    /**
     * WebService请求参数集合
     */
    private List<ClientField> clientFields;

    public ClientBean() {
        super();
    }

    public ClientBean(String endpointUrl, String targetNamespace,
                      String actionUrl, String methodName, List<ClientField> clientFields) {
        super();
        this.endpointUrl = endpointUrl;
        this.targetNamespace = targetNamespace;
        this.actionUrl = actionUrl;
        this.methodName = methodName;
        this.clientFields = clientFields;
    }

    public String getEndpointUrl() {
        return endpointUrl;
    }

    public void setEndpointUrl(String endpointUrl) {
        this.endpointUrl = endpointUrl;
    }

    public String getTargetNamespace() {
        return targetNamespace;
    }

    public void setTargetNamespace(String targetNamespace) {
        this.targetNamespace = targetNamespace;
    }

    public String getActionUrl() {
        return actionUrl;
    }

    public void setActionUrl(String actionUrl) {
        this.actionUrl = actionUrl;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public List<ClientField> getClientFields() {
        return clientFields;
    }

    public void setClientFields(List<ClientField> clientFields) {
        this.clientFields = clientFields;
    }
}
