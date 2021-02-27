package io.sam.dto;

import java.util.List;

/**
 * @author zhuweimu
 * @classname YanTaiRepositoryResp
 * @description
 * @date 2020/9/10 16:56
 */
public class YanTaiRepositoryResp extends YanTaiBaseResp{

    /**
     * 人像库信息
     */
    private List<RepositoryInfo> results;

    public static class RepositoryInfo{

        /**
         * 库ID
         */
        private String id;

        /**
         * 库名称
         */
        private String name;

        private int iid;

        public int getIid() {
            return iid;
        }

        public void setIid(int iid) {
            this.iid = iid;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public List<RepositoryInfo> getResults() {
        return results;
    }

    public void setResults(List<RepositoryInfo> results) {
        this.results = results;
    }
}
