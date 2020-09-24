package io.sam.model;

/**
 * @author zhuweimu
 * @classname LockResult
 * @description
 * @date 2020/9/21 19:33
 */
public class LockResult<T> {

    /**
     * 是否成功上锁
     */
    boolean isSuccess;

    /**
     * 执行结果
     */
    Object obj;

    T t;

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}
