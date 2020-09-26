package io.sam.controller;

import java.util.List;

/**
 * @Classname TaiWeiSiTaskReq
 * @Description 创建任务请求体
 * @Date 2020/7/23 16:39
 * @Auther by zhuweimu
 */
public class TaiWeiSiTaskReq {
    /**
     * 泰维思相似度配置
     */
    private String threshold;
    /**
     * 泰维思返回结果最大人员数量配置
     */
    private String topNumber;
    /**
     * 泰维思参与比对的算法列表
     */
    private List<String> algorithmId;
    /**
     * 泰维思检索的目标库列表
     */
    private List<String> repositoryId;

    /**
     * 源图片Url 路径
     */
    private String imgUrl;

    public String getThreshold() {
        return threshold;
    }

    public void setThreshold(String threshold) {
        this.threshold = threshold;
    }

    public String getTopNumber() {
        return topNumber;
    }

    public void setTopNumber(String topNumber) {
        this.topNumber = topNumber;
    }

    public List<String> getAlgorithmId() {
        return algorithmId;
    }

    public void setAlgorithmId(List<String> algorithmId) {
        this.algorithmId = algorithmId;
    }

    public List<String> getRepositoryId() {
        return repositoryId;
    }

    public void setRepositoryId(List<String> repositoryId) {
        this.repositoryId = repositoryId;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
