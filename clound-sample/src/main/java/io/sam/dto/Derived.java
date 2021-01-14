package io.sam.dto;

public class Derived extends Base
{
    public String whenAmISet = "set when declared";
    @Override
    void preProcess()
    {
        whenAmISet = "set in preProcess()";
    }
}