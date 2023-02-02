package io.sam;

import java.util.List;

/**
 * @author zhuweimu
 * @description
 * @date 2023/1/12 10:01
 */
public class CaptureDataB {


    /**
     * code : 0
     * error : null
     * msg : 请求成功
     * data : {"page":1,"pageSize":4,"sortBy":null,"sortOrder":"asc","rows":[{"deviceId":4,"deviceName":"走廊2-cam2","taskId":80,"personId":25839,"personName":"20220111lx001","gender":1,"groupId":7,"groupType":2,"captureTime":"2023-01-11 16:24:28","cameraDetail":"192.168.114.163","matchType":0,"registerMatch":{"faceUrl":"http://192.168.125.3:9009/gspicture/server/download?type=0&path=/GosunImages/20230111/b0be4e91-95a5-47ea-85de-52d2573c241b/16/1673425472_343244.jpeg","registerUrl":"http://192.168.125.3:9009/gspicture/server/download?type=0&path=/GosunImages/ppa/register/20230111/b0be4e91-95a5-47ea-85de-52d2573c241b/16/1673425203_341949.jpeg","similarity":81},"captureMatch":{"faceUrl":"http://192.168.125.3:9009/gspicture/server/download?type=0&path=/GosunImages/20230111/b0be4e91-95a5-47ea-85de-52d2573c241b/16/1673425472_343244.jpeg","similarity":88,"capRegisterUrl":"http://192.168.125.3:9009/gspicture/server/download?type=0&path=/GosunImages/20230111/b0be4e91-95a5-47ea-85de-52d2573c241b/16/1673425437_343062.jpeg"},"frontMatch":{"similarity":95,"frontUrl":"http://192.168.125.3:9009/gspicture/server/download?type=0&path=/GosunImages/20230111/b0be4e91-95a5-47ea-85de-52d2573c241b/16/1673425326_342477.jpeg","bodyUrl":"http://192.168.125.3:9009/gspicture/server/download?type=0&path=/GosunImages/20230111/b0be4e91-95a5-47ea-85de-52d2573c241b/16/1673425472_343245.jpeg"},"flankMatch":{"similarity":80,"flankUrl":"http://192.168.125.3:9009/gspicture/server/download?type=0&path=/GosunImages/20230111/b0be4e91-95a5-47ea-85de-52d2573c241b/16/1673425374_342715.jpeg","bodyUrl":"http://192.168.125.3:9009/gspicture/server/download?type=0&path=/GosunImages/20230111/b0be4e91-95a5-47ea-85de-52d2573c241b/16/1673425472_343245.jpeg"},"backMatch":null},{"deviceId":4,"deviceName":"走廊2-cam2","taskId":80,"personId":25839,"personName":"20220111lx001","gender":1,"groupId":7,"groupType":2,"captureTime":"2023-01-11 16:24:27","cameraDetail":"192.168.114.163","matchType":0,"registerMatch":{"faceUrl":"http://192.168.125.3:9009/gspicture/server/download?type=0&path=/GosunImages/20230111/b0be4e91-95a5-47ea-85de-52d2573c241b/16/1673425469_343224.jpeg","registerUrl":"http://192.168.125.3:9009/gspicture/server/download?type=0&path=/GosunImages/ppa/register/20230111/b0be4e91-95a5-47ea-85de-52d2573c241b/16/1673425203_341949.jpeg","similarity":80},"captureMatch":{"faceUrl":"http://192.168.125.3:9009/gspicture/server/download?type=0&path=/GosunImages/20230111/b0be4e91-95a5-47ea-85de-52d2573c241b/16/1673425469_343224.jpeg","similarity":84,"capRegisterUrl":"http://192.168.125.3:9009/gspicture/server/download?type=0&path=/GosunImages/20230111/b0be4e91-95a5-47ea-85de-52d2573c241b/16/1673425437_343062.jpeg"},"frontMatch":{"similarity":96,"frontUrl":"http://192.168.125.3:9009/gspicture/server/download?type=0&path=/GosunImages/20230111/b0be4e91-95a5-47ea-85de-52d2573c241b/16/1673425326_342477.jpeg","bodyUrl":"http://192.168.125.3:9009/gspicture/server/download?type=0&path=/GosunImages/20230111/b0be4e91-95a5-47ea-85de-52d2573c241b/16/1673425469_343225.jpeg"},"flankMatch":{"similarity":82,"flankUrl":"http://192.168.125.3:9009/gspicture/server/download?type=0&path=/GosunImages/20230111/b0be4e91-95a5-47ea-85de-52d2573c241b/16/1673425374_342715.jpeg","bodyUrl":"http://192.168.125.3:9009/gspicture/server/download?type=0&path=/GosunImages/20230111/b0be4e91-95a5-47ea-85de-52d2573c241b/16/1673425469_343225.jpeg"},"backMatch":null},{"deviceId":6,"deviceName":"走廊3-cam2","taskId":82,"personId":25839,"personName":"20220111lx001","gender":1,"groupId":7,"groupType":2,"captureTime":"2023-01-11 16:24:20","cameraDetail":"192.168.114.161","matchType":0,"registerMatch":{"faceUrl":"http://192.168.125.3:9009/gspicture/server/download?type=0&path=/GosunImages/20230111/b0be4e91-95a5-47ea-85de-52d2573c241b/16/1673425462_343188.jpeg","registerUrl":"http://192.168.125.3:9009/gspicture/server/download?type=0&path=/GosunImages/ppa/register/20230111/b0be4e91-95a5-47ea-85de-52d2573c241b/16/1673425203_341949.jpeg","similarity":86},"captureMatch":{"faceUrl":"http://192.168.125.3:9009/gspicture/server/download?type=0&path=/GosunImages/20230111/b0be4e91-95a5-47ea-85de-52d2573c241b/16/1673425462_343188.jpeg","similarity":91,"capRegisterUrl":"http://192.168.125.3:9009/gspicture/server/download?type=0&path=/GosunImages/20230111/b0be4e91-95a5-47ea-85de-52d2573c241b/16/1673425437_343062.jpeg"},"frontMatch":{"similarity":94,"frontUrl":"http://192.168.125.3:9009/gspicture/server/download?type=0&path=/GosunImages/20230111/b0be4e91-95a5-47ea-85de-52d2573c241b/16/1673425326_342477.jpeg","bodyUrl":"http://192.168.125.3:9009/gspicture/server/download?type=0&path=/GosunImages/20230111/b0be4e91-95a5-47ea-85de-52d2573c241b/16/1673425462_343189.jpeg"},"flankMatch":{"similarity":80,"flankUrl":"http://192.168.125.3:9009/gspicture/server/download?type=0&path=/GosunImages/20230111/b0be4e91-95a5-47ea-85de-52d2573c241b/16/1673425374_342715.jpeg","bodyUrl":"http://192.168.125.3:9009/gspicture/server/download?type=0&path=/GosunImages/20230111/b0be4e91-95a5-47ea-85de-52d2573c241b/16/1673425462_343189.jpeg"},"backMatch":null},{"deviceId":6,"deviceName":"走廊3-cam2","taskId":82,"personId":25839,"personName":"20220111lx001","gender":1,"groupId":7,"groupType":2,"captureTime":"2023-01-11 16:24:19","cameraDetail":"192.168.114.161","matchType":0,"registerMatch":{"faceUrl":"http://192.168.125.3:9009/gspicture/server/download?type=0&path=/GosunImages/20230111/b0be4e91-95a5-47ea-85de-52d2573c241b/16/1673425459_343172.jpeg","registerUrl":"http://192.168.125.3:9009/gspicture/server/download?type=0&path=/GosunImages/ppa/register/20230111/b0be4e91-95a5-47ea-85de-52d2573c241b/16/1673425203_341949.jpeg","similarity":82},"captureMatch":{"faceUrl":"http://192.168.125.3:9009/gspicture/server/download?type=0&path=/GosunImages/20230111/b0be4e91-95a5-47ea-85de-52d2573c241b/16/1673425459_343172.jpeg","similarity":86,"capRegisterUrl":"http://192.168.125.3:9009/gspicture/server/download?type=0&path=/GosunImages/20230111/b0be4e91-95a5-47ea-85de-52d2573c241b/16/1673425437_343062.jpeg"},"frontMatch":{"similarity":93,"frontUrl":"http://192.168.125.3:9009/gspicture/server/download?type=0&path=/GosunImages/20230111/b0be4e91-95a5-47ea-85de-52d2573c241b/16/1673425326_342477.jpeg","bodyUrl":"http://192.168.125.3:9009/gspicture/server/download?type=0&path=/GosunImages/20230111/b0be4e91-95a5-47ea-85de-52d2573c241b/16/1673425459_343173.jpeg"},"flankMatch":{"similarity":79,"flankUrl":"http://192.168.125.3:9009/gspicture/server/download?type=0&path=/GosunImages/20230111/b0be4e91-95a5-47ea-85de-52d2573c241b/16/1673425374_342715.jpeg","bodyUrl":"http://192.168.125.3:9009/gspicture/server/download?type=0&path=/GosunImages/20230111/b0be4e91-95a5-47ea-85de-52d2573c241b/16/1673425459_343173.jpeg"},"backMatch":null}],"records":31,"total":8}
     */

    private int code;
    private Object error;
    private String msg;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getError() {
        return error;
    }

    public void setError(Object error) {
        this.error = error;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * page : 1
         * pageSize : 4
         * sortBy : null
         * sortOrder : asc
         * rows : [{"deviceId":4,"deviceName":"走廊2-cam2","taskId":80,"personId":25839,"personName":"20220111lx001","gender":1,"groupId":7,"groupType":2,"captureTime":"2023-01-11 16:24:28","cameraDetail":"192.168.114.163","matchType":0,"registerMatch":{"faceUrl":"http://192.168.125.3:9009/gspicture/server/download?type=0&path=/GosunImages/20230111/b0be4e91-95a5-47ea-85de-52d2573c241b/16/1673425472_343244.jpeg","registerUrl":"http://192.168.125.3:9009/gspicture/server/download?type=0&path=/GosunImages/ppa/register/20230111/b0be4e91-95a5-47ea-85de-52d2573c241b/16/1673425203_341949.jpeg","similarity":81},"captureMatch":{"faceUrl":"http://192.168.125.3:9009/gspicture/server/download?type=0&path=/GosunImages/20230111/b0be4e91-95a5-47ea-85de-52d2573c241b/16/1673425472_343244.jpeg","similarity":88,"capRegisterUrl":"http://192.168.125.3:9009/gspicture/server/download?type=0&path=/GosunImages/20230111/b0be4e91-95a5-47ea-85de-52d2573c241b/16/1673425437_343062.jpeg"},"frontMatch":{"similarity":95,"frontUrl":"http://192.168.125.3:9009/gspicture/server/download?type=0&path=/GosunImages/20230111/b0be4e91-95a5-47ea-85de-52d2573c241b/16/1673425326_342477.jpeg","bodyUrl":"http://192.168.125.3:9009/gspicture/server/download?type=0&path=/GosunImages/20230111/b0be4e91-95a5-47ea-85de-52d2573c241b/16/1673425472_343245.jpeg"},"flankMatch":{"similarity":80,"flankUrl":"http://192.168.125.3:9009/gspicture/server/download?type=0&path=/GosunImages/20230111/b0be4e91-95a5-47ea-85de-52d2573c241b/16/1673425374_342715.jpeg","bodyUrl":"http://192.168.125.3:9009/gspicture/server/download?type=0&path=/GosunImages/20230111/b0be4e91-95a5-47ea-85de-52d2573c241b/16/1673425472_343245.jpeg"},"backMatch":null},{"deviceId":4,"deviceName":"走廊2-cam2","taskId":80,"personId":25839,"personName":"20220111lx001","gender":1,"groupId":7,"groupType":2,"captureTime":"2023-01-11 16:24:27","cameraDetail":"192.168.114.163","matchType":0,"registerMatch":{"faceUrl":"http://192.168.125.3:9009/gspicture/server/download?type=0&path=/GosunImages/20230111/b0be4e91-95a5-47ea-85de-52d2573c241b/16/1673425469_343224.jpeg","registerUrl":"http://192.168.125.3:9009/gspicture/server/download?type=0&path=/GosunImages/ppa/register/20230111/b0be4e91-95a5-47ea-85de-52d2573c241b/16/1673425203_341949.jpeg","similarity":80},"captureMatch":{"faceUrl":"http://192.168.125.3:9009/gspicture/server/download?type=0&path=/GosunImages/20230111/b0be4e91-95a5-47ea-85de-52d2573c241b/16/1673425469_343224.jpeg","similarity":84,"capRegisterUrl":"http://192.168.125.3:9009/gspicture/server/download?type=0&path=/GosunImages/20230111/b0be4e91-95a5-47ea-85de-52d2573c241b/16/1673425437_343062.jpeg"},"frontMatch":{"similarity":96,"frontUrl":"http://192.168.125.3:9009/gspicture/server/download?type=0&path=/GosunImages/20230111/b0be4e91-95a5-47ea-85de-52d2573c241b/16/1673425326_342477.jpeg","bodyUrl":"http://192.168.125.3:9009/gspicture/server/download?type=0&path=/GosunImages/20230111/b0be4e91-95a5-47ea-85de-52d2573c241b/16/1673425469_343225.jpeg"},"flankMatch":{"similarity":82,"flankUrl":"http://192.168.125.3:9009/gspicture/server/download?type=0&path=/GosunImages/20230111/b0be4e91-95a5-47ea-85de-52d2573c241b/16/1673425374_342715.jpeg","bodyUrl":"http://192.168.125.3:9009/gspicture/server/download?type=0&path=/GosunImages/20230111/b0be4e91-95a5-47ea-85de-52d2573c241b/16/1673425469_343225.jpeg"},"backMatch":null},{"deviceId":6,"deviceName":"走廊3-cam2","taskId":82,"personId":25839,"personName":"20220111lx001","gender":1,"groupId":7,"groupType":2,"captureTime":"2023-01-11 16:24:20","cameraDetail":"192.168.114.161","matchType":0,"registerMatch":{"faceUrl":"http://192.168.125.3:9009/gspicture/server/download?type=0&path=/GosunImages/20230111/b0be4e91-95a5-47ea-85de-52d2573c241b/16/1673425462_343188.jpeg","registerUrl":"http://192.168.125.3:9009/gspicture/server/download?type=0&path=/GosunImages/ppa/register/20230111/b0be4e91-95a5-47ea-85de-52d2573c241b/16/1673425203_341949.jpeg","similarity":86},"captureMatch":{"faceUrl":"http://192.168.125.3:9009/gspicture/server/download?type=0&path=/GosunImages/20230111/b0be4e91-95a5-47ea-85de-52d2573c241b/16/1673425462_343188.jpeg","similarity":91,"capRegisterUrl":"http://192.168.125.3:9009/gspicture/server/download?type=0&path=/GosunImages/20230111/b0be4e91-95a5-47ea-85de-52d2573c241b/16/1673425437_343062.jpeg"},"frontMatch":{"similarity":94,"frontUrl":"http://192.168.125.3:9009/gspicture/server/download?type=0&path=/GosunImages/20230111/b0be4e91-95a5-47ea-85de-52d2573c241b/16/1673425326_342477.jpeg","bodyUrl":"http://192.168.125.3:9009/gspicture/server/download?type=0&path=/GosunImages/20230111/b0be4e91-95a5-47ea-85de-52d2573c241b/16/1673425462_343189.jpeg"},"flankMatch":{"similarity":80,"flankUrl":"http://192.168.125.3:9009/gspicture/server/download?type=0&path=/GosunImages/20230111/b0be4e91-95a5-47ea-85de-52d2573c241b/16/1673425374_342715.jpeg","bodyUrl":"http://192.168.125.3:9009/gspicture/server/download?type=0&path=/GosunImages/20230111/b0be4e91-95a5-47ea-85de-52d2573c241b/16/1673425462_343189.jpeg"},"backMatch":null},{"deviceId":6,"deviceName":"走廊3-cam2","taskId":82,"personId":25839,"personName":"20220111lx001","gender":1,"groupId":7,"groupType":2,"captureTime":"2023-01-11 16:24:19","cameraDetail":"192.168.114.161","matchType":0,"registerMatch":{"faceUrl":"http://192.168.125.3:9009/gspicture/server/download?type=0&path=/GosunImages/20230111/b0be4e91-95a5-47ea-85de-52d2573c241b/16/1673425459_343172.jpeg","registerUrl":"http://192.168.125.3:9009/gspicture/server/download?type=0&path=/GosunImages/ppa/register/20230111/b0be4e91-95a5-47ea-85de-52d2573c241b/16/1673425203_341949.jpeg","similarity":82},"captureMatch":{"faceUrl":"http://192.168.125.3:9009/gspicture/server/download?type=0&path=/GosunImages/20230111/b0be4e91-95a5-47ea-85de-52d2573c241b/16/1673425459_343172.jpeg","similarity":86,"capRegisterUrl":"http://192.168.125.3:9009/gspicture/server/download?type=0&path=/GosunImages/20230111/b0be4e91-95a5-47ea-85de-52d2573c241b/16/1673425437_343062.jpeg"},"frontMatch":{"similarity":93,"frontUrl":"http://192.168.125.3:9009/gspicture/server/download?type=0&path=/GosunImages/20230111/b0be4e91-95a5-47ea-85de-52d2573c241b/16/1673425326_342477.jpeg","bodyUrl":"http://192.168.125.3:9009/gspicture/server/download?type=0&path=/GosunImages/20230111/b0be4e91-95a5-47ea-85de-52d2573c241b/16/1673425459_343173.jpeg"},"flankMatch":{"similarity":79,"flankUrl":"http://192.168.125.3:9009/gspicture/server/download?type=0&path=/GosunImages/20230111/b0be4e91-95a5-47ea-85de-52d2573c241b/16/1673425374_342715.jpeg","bodyUrl":"http://192.168.125.3:9009/gspicture/server/download?type=0&path=/GosunImages/20230111/b0be4e91-95a5-47ea-85de-52d2573c241b/16/1673425459_343173.jpeg"},"backMatch":null}]
         * records : 31
         * total : 8
         */

        private int page;
        private int pageSize;
        private Object sortBy;
        private String sortOrder;
        private int records;
        private int total;
        private List<RowsBean> rows;

        public int getPage() {
            return page;
        }

        public void setPage(int page) {
            this.page = page;
        }

        public int getPageSize() {
            return pageSize;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }

        public Object getSortBy() {
            return sortBy;
        }

        public void setSortBy(Object sortBy) {
            this.sortBy = sortBy;
        }

        public String getSortOrder() {
            return sortOrder;
        }

        public void setSortOrder(String sortOrder) {
            this.sortOrder = sortOrder;
        }

        public int getRecords() {
            return records;
        }

        public void setRecords(int records) {
            this.records = records;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public List<RowsBean> getRows() {
            return rows;
        }

        public void setRows(List<RowsBean> rows) {
            this.rows = rows;
        }

        public static class RowsBean {
            /**
             * deviceId : 4
             * deviceName : 走廊2-cam2
             * taskId : 80
             * personId : 25839
             * personName : 20220111lx001
             * gender : 1
             * groupId : 7
             * groupType : 2
             * captureTime : 2023-01-11 16:24:28
             * cameraDetail : 192.168.114.163
             * matchType : 0
             * registerMatch : {"faceUrl":"http://192.168.125.3:9009/gspicture/server/download?type=0&path=/GosunImages/20230111/b0be4e91-95a5-47ea-85de-52d2573c241b/16/1673425472_343244.jpeg","registerUrl":"http://192.168.125.3:9009/gspicture/server/download?type=0&path=/GosunImages/ppa/register/20230111/b0be4e91-95a5-47ea-85de-52d2573c241b/16/1673425203_341949.jpeg","similarity":81}
             * captureMatch : {"faceUrl":"http://192.168.125.3:9009/gspicture/server/download?type=0&path=/GosunImages/20230111/b0be4e91-95a5-47ea-85de-52d2573c241b/16/1673425472_343244.jpeg","similarity":88,"capRegisterUrl":"http://192.168.125.3:9009/gspicture/server/download?type=0&path=/GosunImages/20230111/b0be4e91-95a5-47ea-85de-52d2573c241b/16/1673425437_343062.jpeg"}
             * frontMatch : {"similarity":95,"frontUrl":"http://192.168.125.3:9009/gspicture/server/download?type=0&path=/GosunImages/20230111/b0be4e91-95a5-47ea-85de-52d2573c241b/16/1673425326_342477.jpeg","bodyUrl":"http://192.168.125.3:9009/gspicture/server/download?type=0&path=/GosunImages/20230111/b0be4e91-95a5-47ea-85de-52d2573c241b/16/1673425472_343245.jpeg"}
             * flankMatch : {"similarity":80,"flankUrl":"http://192.168.125.3:9009/gspicture/server/download?type=0&path=/GosunImages/20230111/b0be4e91-95a5-47ea-85de-52d2573c241b/16/1673425374_342715.jpeg","bodyUrl":"http://192.168.125.3:9009/gspicture/server/download?type=0&path=/GosunImages/20230111/b0be4e91-95a5-47ea-85de-52d2573c241b/16/1673425472_343245.jpeg"}
             * backMatch : null
             */

            private int deviceId;
            private String deviceName;
            private int taskId;
            private int personId;
            private String personName;
            private int gender;
            private int groupId;
            private int groupType;
            private String captureTime;
            private String cameraDetail;
            private int matchType;
            private RegisterMatchBean registerMatch;
            private CaptureMatchBean captureMatch;
            private FrontMatchBean frontMatch;
            private FlankMatchBean flankMatch;
            private Object backMatch;

            public int getDeviceId() {
                return deviceId;
            }

            public void setDeviceId(int deviceId) {
                this.deviceId = deviceId;
            }

            public String getDeviceName() {
                return deviceName;
            }

            public void setDeviceName(String deviceName) {
                this.deviceName = deviceName;
            }

            public int getTaskId() {
                return taskId;
            }

            public void setTaskId(int taskId) {
                this.taskId = taskId;
            }

            public int getPersonId() {
                return personId;
            }

            public void setPersonId(int personId) {
                this.personId = personId;
            }

            public String getPersonName() {
                return personName;
            }

            public void setPersonName(String personName) {
                this.personName = personName;
            }

            public int getGender() {
                return gender;
            }

            public void setGender(int gender) {
                this.gender = gender;
            }

            public int getGroupId() {
                return groupId;
            }

            public void setGroupId(int groupId) {
                this.groupId = groupId;
            }

            public int getGroupType() {
                return groupType;
            }

            public void setGroupType(int groupType) {
                this.groupType = groupType;
            }

            public String getCaptureTime() {
                return captureTime;
            }

            public void setCaptureTime(String captureTime) {
                this.captureTime = captureTime;
            }

            public String getCameraDetail() {
                return cameraDetail;
            }

            public void setCameraDetail(String cameraDetail) {
                this.cameraDetail = cameraDetail;
            }

            public int getMatchType() {
                return matchType;
            }

            public void setMatchType(int matchType) {
                this.matchType = matchType;
            }

            public RegisterMatchBean getRegisterMatch() {
                return registerMatch;
            }

            public void setRegisterMatch(RegisterMatchBean registerMatch) {
                this.registerMatch = registerMatch;
            }

            public CaptureMatchBean getCaptureMatch() {
                return captureMatch;
            }

            public void setCaptureMatch(CaptureMatchBean captureMatch) {
                this.captureMatch = captureMatch;
            }

            public FrontMatchBean getFrontMatch() {
                return frontMatch;
            }

            public void setFrontMatch(FrontMatchBean frontMatch) {
                this.frontMatch = frontMatch;
            }

            public FlankMatchBean getFlankMatch() {
                return flankMatch;
            }

            public void setFlankMatch(FlankMatchBean flankMatch) {
                this.flankMatch = flankMatch;
            }

            public Object getBackMatch() {
                return backMatch;
            }

            public void setBackMatch(Object backMatch) {
                this.backMatch = backMatch;
            }

            public static class RegisterMatchBean {
                /**
                 * faceUrl : http://192.168.125.3:9009/gspicture/server/download?type=0&path=/GosunImages/20230111/b0be4e91-95a5-47ea-85de-52d2573c241b/16/1673425472_343244.jpeg
                 * registerUrl : http://192.168.125.3:9009/gspicture/server/download?type=0&path=/GosunImages/ppa/register/20230111/b0be4e91-95a5-47ea-85de-52d2573c241b/16/1673425203_341949.jpeg
                 * similarity : 81
                 */

                private String faceUrl;
                private String registerUrl;
                private int similarity;

                public String getFaceUrl() {
                    return faceUrl;
                }

                public void setFaceUrl(String faceUrl) {
                    this.faceUrl = faceUrl;
                }

                public String getRegisterUrl() {
                    return registerUrl;
                }

                public void setRegisterUrl(String registerUrl) {
                    this.registerUrl = registerUrl;
                }

                public int getSimilarity() {
                    return similarity;
                }

                public void setSimilarity(int similarity) {
                    this.similarity = similarity;
                }
            }

            public static class CaptureMatchBean {
                /**
                 * faceUrl : http://192.168.125.3:9009/gspicture/server/download?type=0&path=/GosunImages/20230111/b0be4e91-95a5-47ea-85de-52d2573c241b/16/1673425472_343244.jpeg
                 * similarity : 88
                 * capRegisterUrl : http://192.168.125.3:9009/gspicture/server/download?type=0&path=/GosunImages/20230111/b0be4e91-95a5-47ea-85de-52d2573c241b/16/1673425437_343062.jpeg
                 */

                private String faceUrl;
                private int similarity;
                private String capRegisterUrl;

                public String getFaceUrl() {
                    return faceUrl;
                }

                public void setFaceUrl(String faceUrl) {
                    this.faceUrl = faceUrl;
                }

                public int getSimilarity() {
                    return similarity;
                }

                public void setSimilarity(int similarity) {
                    this.similarity = similarity;
                }

                public String getCapRegisterUrl() {
                    return capRegisterUrl;
                }

                public void setCapRegisterUrl(String capRegisterUrl) {
                    this.capRegisterUrl = capRegisterUrl;
                }
            }

            public static class FrontMatchBean {
                /**
                 * similarity : 95
                 * frontUrl : http://192.168.125.3:9009/gspicture/server/download?type=0&path=/GosunImages/20230111/b0be4e91-95a5-47ea-85de-52d2573c241b/16/1673425326_342477.jpeg
                 * bodyUrl : http://192.168.125.3:9009/gspicture/server/download?type=0&path=/GosunImages/20230111/b0be4e91-95a5-47ea-85de-52d2573c241b/16/1673425472_343245.jpeg
                 */

                private int similarity;
                private String frontUrl;
                private String bodyUrl;

                public int getSimilarity() {
                    return similarity;
                }

                public void setSimilarity(int similarity) {
                    this.similarity = similarity;
                }

                public String getFrontUrl() {
                    return frontUrl;
                }

                public void setFrontUrl(String frontUrl) {
                    this.frontUrl = frontUrl;
                }

                public String getBodyUrl() {
                    return bodyUrl;
                }

                public void setBodyUrl(String bodyUrl) {
                    this.bodyUrl = bodyUrl;
                }
            }

            public static class FlankMatchBean {
                /**
                 * similarity : 80
                 * flankUrl : http://192.168.125.3:9009/gspicture/server/download?type=0&path=/GosunImages/20230111/b0be4e91-95a5-47ea-85de-52d2573c241b/16/1673425374_342715.jpeg
                 * bodyUrl : http://192.168.125.3:9009/gspicture/server/download?type=0&path=/GosunImages/20230111/b0be4e91-95a5-47ea-85de-52d2573c241b/16/1673425472_343245.jpeg
                 */

                private int similarity;
                private String flankUrl;
                private String bodyUrl;

                public int getSimilarity() {
                    return similarity;
                }

                public void setSimilarity(int similarity) {
                    this.similarity = similarity;
                }

                public String getFlankUrl() {
                    return flankUrl;
                }

                public void setFlankUrl(String flankUrl) {
                    this.flankUrl = flankUrl;
                }

                public String getBodyUrl() {
                    return bodyUrl;
                }

                public void setBodyUrl(String bodyUrl) {
                    this.bodyUrl = bodyUrl;
                }
            }
        }
    }
}
