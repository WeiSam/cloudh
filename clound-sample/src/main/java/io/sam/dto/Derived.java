package io.sam.dto;

public class Derived extends Base
{
    /**
     * 变量初始化优于当前类构造函数的初始化，父类的构造函数优于子类的变量初始化
     */
    public String whenAmISet = "set when declared";
    public String whenAmISet1 = "set when declared";

    public Derived() {
        whenAmISet1 = "构造函数";
    }

    @Override
    void preProcess()
    {
        whenAmISet = "set in preProcess()";
        whenAmISet1 = "set in preProcess()";
    }
}