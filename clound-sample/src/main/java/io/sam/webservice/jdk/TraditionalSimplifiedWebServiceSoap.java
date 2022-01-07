
package io.sam.webservice.jdk;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "TraditionalSimplifiedWebServiceSoap", targetNamespace = "http://webxml.com.cn/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface TraditionalSimplifiedWebServiceSoap {


    /**
     * <br /><h3>繁体字转换为简体字</h3><p>输入参数：sText = 字符串； 返回数据：字符串。</p><br />
     * 
     * @param sText
     * @return
     *     returns java.lang.String
     */
    @WebMethod(action = "http://webxml.com.cn/toSimplifiedChinese")
    @WebResult(name = "toSimplifiedChineseResult", targetNamespace = "http://webxml.com.cn/")
    @RequestWrapper(localName = "toSimplifiedChinese", targetNamespace = "http://webxml.com.cn/", className = "cn.com.webxml.ToSimplifiedChinese")
    @ResponseWrapper(localName = "toSimplifiedChineseResponse", targetNamespace = "http://webxml.com.cn/", className = "cn.com.webxml.ToSimplifiedChineseResponse")
    public String toSimplifiedChinese(
        @WebParam(name = "sText", targetNamespace = "http://webxml.com.cn/")
        String sText);

    /**
     * <br /><h3>简体字转换为繁体字</h3><p>输入参数：sText = 字符串； 返回数据：字符串。</p><br />
     * 
     * @param sText
     * @return
     *     returns java.lang.String
     */
    @WebMethod(action = "http://webxml.com.cn/toTraditionalChinese")
    @WebResult(name = "toTraditionalChineseResult", targetNamespace = "http://webxml.com.cn/")
    @RequestWrapper(localName = "toTraditionalChinese", targetNamespace = "http://webxml.com.cn/", className = "cn.com.webxml.ToTraditionalChinese")
    @ResponseWrapper(localName = "toTraditionalChineseResponse", targetNamespace = "http://webxml.com.cn/", className = "cn.com.webxml.ToTraditionalChineseResponse")
    public String toTraditionalChinese(
        @WebParam(name = "sText", targetNamespace = "http://webxml.com.cn/")
        String sText);

}
