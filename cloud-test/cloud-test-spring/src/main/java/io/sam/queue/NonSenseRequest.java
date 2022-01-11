package io.sam.queue;

/**
 * @author zhuweimu
 * @description
 * @date 2021/12/14 20:10
 */
public interface NonSenseRequest {

    /**
     * 业务执行
     */
    void process();

    /**
     * 获取人员magicId
     * @return
     */
    String getPersonMagicId();

}
