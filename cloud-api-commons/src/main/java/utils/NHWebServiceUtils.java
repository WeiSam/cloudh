package utils;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;

import javax.xml.namespace.QName;
import javax.xml.rpc.ParameterMode;
import javax.xml.rpc.encoding.XMLType;
import java.util.Collection;
import java.util.Collections;

/**
 * @author zhuweimu
 * @Classname NHWebServiceUtils
 * @Description
 * @Date 2020/8/3 17:14
 */
public class NHWebServiceUtils {

    public static String sendWebService(ClientBean clientBean) {
        if (clientBean.getClientFields() != null && !clientBean.getClientFields().isEmpty()) {
            return sendWebServiceRequest(clientBean);
        }else {
            return sendWebServiceRequestNonParam(clientBean);
        }
    }
    public static String sendWebServiceRequest(ClientBean clientBean) {
        try {
            Object[] paramValues;
            //实例化访问对象
            Service service = new Service();
            //实例化调用对象
            Call call = (Call) service.createCall();
            //在调用对象中添加WebService地址
            call.setTargetEndpointAddress(new java.net.URL(clientBean.getEndpointUrl()));
            paramValues = new Object[clientBean.getClientFields().size()];
            int i = 0;
            //设置入参，第一个参数是命名空间以及参数名，这两个参数是采用一个Qname变量打包传入的，第二个参数是入参的类型（字符或者数字）第三个参数是入参种类
            if (clientBean.getClientFields() != null && !clientBean.getClientFields().isEmpty()) {
                for (ClientField field : clientBean.getClientFields()) {
                    QName qn = new QName(clientBean.getTargetNamespace(), field.getParamName());
                    if (field.getParamType() == String.class) {
                        call.addParameter(qn, XMLType.XSD_STRING, ParameterMode.IN);
                    } else if (field.getParamType() == int.class) {
                        call.addParameter(qn, XMLType.XSD_INT, ParameterMode.IN);
                    } else if (field.getParamType() == Integer.class) {
                        call.addParameter(qn, XMLType.XSD_INTEGER, ParameterMode.IN);
                    } else if (field.getParamType() == Double.class) {
                        call.addParameter(qn, XMLType.XSD_DOUBLE, ParameterMode.IN);
                    } else if (field.getParamType() == Float.class) {
                        call.addParameter(qn, XMLType.XSD_FLOAT, ParameterMode.IN);
                    } else if (field.getParamType() == Long.class) {
                        call.addParameter(qn, XMLType.XSD_LONG, ParameterMode.IN);
                    } else {
                        throw new Exception("请确定传入参数类型是否正确，或者该参数类型还没有被注册。");
                    }
                    //获取参数值
                    paramValues[i] = field.getParamValue();
                    i++;
                }
            }
            //设置返回值格式（字符串或者组装对象）
            call.setReturnType(new QName(clientBean.getTargetNamespace(), clientBean.getMethodName()),String.class);
            //是否是SOAPAction这里需要看WebService是否要求如下格式，如果没有要求可以不添加此设置
            call.setUseSOAPAction(true);
            //如果前面要求是SOAPAction的话需要添加下面设置，指定访问那个命名空间上的那个方法
            call.setSOAPActionURI(clientBean.getActionUrl());
            //在调用对象中添加WebService对应的命名空间，以及将要调用的函数名
            call.setOperationName(new QName(clientBean.getTargetNamespace(), clientBean.getMethodName()));
            String ret;
            //调用目标方法,设置参数值将返回值转换为String类型
            ret = (String) call.invoke(paramValues);
            return ret;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String sendWebServiceRequestNonParam(ClientBean clientBean){
        String ret = "";
        try {
            //实例化访问对象
            Service service = new Service();
            //实例化调用对象
            Call call = (Call) service.createCall();
            //在调用对象中添加WebService地址
            call.setTargetEndpointAddress(new java.net.URL(clientBean.getEndpointUrl()));
            //设置返回值格式（字符串或者组装对象）
            call.setReturnType(XMLType.XSD_STRING);
            //是否是SOAPAction这里需要看WebService是否要求如下格式，如果没有要求可以不添加此设置
            call.setUseSOAPAction(true);
            //如果前面要求是SOAPAction的话需要添加下面设置，指定访问那个命名空间上的那个方法
            call.setSOAPActionURI(clientBean.getActionUrl());
            //在调用对象中添加WebService对应的命名空间，以及将要调用的函数名
            call.setOperationName(new QName(clientBean.getTargetNamespace(), clientBean.getMethodName()));
            //调用目标方法,设置参数值将返回值转换为String类型
            ret = (String) call.invoke(new String []{});
        }catch (Exception e){
            e.printStackTrace();
        }
        return ret;
    }

    public static String callWebserviceASMX(ClientBean clientBean,String json) {
        //获取webservice接口地址
        String url = clientBean.getEndpointUrl();
        //获取域名地址，server定义的
        String soapaction = clientBean.getTargetNamespace();
        String method = clientBean.getMethodName();

        Service service = new Service();

        try {
            Call call = (Call) service.createCall();
            call.setTargetEndpointAddress(url);
            //设置要调用的方法
            call.setOperationName(new QName(soapaction, method));
            //设置要返回的数据类型
            call.setReturnType(new QName(soapaction, method), String.class);
            call.setUseSOAPAction(true);
            call.setSOAPActionURI(soapaction + method);
            //调用方法并传递参数
            String result = (String) call.invoke(new Object[]{json});

            System.out.println("result is:::" + result);

            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
