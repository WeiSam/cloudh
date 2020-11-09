package io.sam.dto;

public class GetEnclosingClassOfClass {
    public GetEnclosingClassOfClass() {
        // OuterClass is inside in GetEnclosingClassOfClass class 
        // that means OuterClass is inner class of 
        // GetEnclosingClassOfClass
        class OuterClass {
            public void outerMethod() {
                // InnerClass is inside in OuterClass class that means
                // InnerClass is inner class of OuterClass
 
                class InnerClass {
                    public void innerMethod() {
                        System.out.println(getClass().getEnclosingClass());
                    }
                }
 
                System.out.println(getClass().getEnclosingClass());
                // Creating an instance of InnerClass
                InnerClass ic = new InnerClass();
                ic.innerMethod();
            }
        }
 
        // Creating an instance of OuterClass
        OuterClass oc = new OuterClass();
        oc.outerMethod();
    }

    public class InnerClass02 {

    }
 
    public static void main(String[] args) {
        class InnerClass02 {

        }
        InnerClass02 innerClass02 = new InnerClass02();
        GetEnclosingClassOfClass enclo_class = new GetEnclosingClassOfClass();
    }
}
