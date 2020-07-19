package common;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class BaseResponse<T> implements Serializable {

    /**
     * 响应码
     */
    Integer code;//
    /**
     * 提示信息
     */
    String msg = "success";//
    /**
     * 返回数据
     */
    T data;
    /**
     * 请求时间
     */
    Long costTime = 0L;

    public BaseResponse(Integer code, String msg, T data, Long costTime) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.costTime = System.currentTimeMillis() - costTime;
    }

    public static <T> BaseResponse<T> success(){
        BaseResponse<T> baseResponse = new BaseResponse<T>(200,"成功",null,System.currentTimeMillis());
        return baseResponse;
    }

    public static <T> BaseResponse<T> success(T data){
        BaseResponse<T> baseResponse = new BaseResponse<T>(200,"成功",data,System.currentTimeMillis());
        return baseResponse;
    }

    public static <T> BaseResponse<T> success(Integer code, String msg, T data, Long startTime){
        BaseResponse<T> baseResponse = new BaseResponse<T>(code,msg,data,startTime);
        return baseResponse;
    }

    public static <T> BaseResponse<T> error(Integer code, String msg, T data, Long startTime){
        BaseResponse<T> baseResponse = new BaseResponse<T>(code,msg,data,startTime);
        return baseResponse;
    }

}
