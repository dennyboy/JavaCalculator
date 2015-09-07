package com.littleh.math;

import java.util.HashMap;

/**
 * Operations adds a series of mathematical operations <br>
 * to the mathOps HashMap.  The class utilizes Lambda <br>
 * expressions and requires Java 8+ to run.
 *
 * @author Denny
 * @since 9/7/2015
 */
public class Operations {

    HashMap<String, Object> mathOps;



    public Operations(){
      mathOps = new HashMap<String,Object>();
      mathOps.put("add", (BinMathOp) (a, b)->a+b);
      mathOps.put("subtract", (BinMathOp)(a,b)->a-b);
      mathOps.put("multiply", (BinMathOp) (a,b)->a*b);
      mathOps.put("divide", (BinMathOp) (a,b)->{
                                    double r=0;
                                    if(b!=0){
                                     r=a/b;}
                                    return r;});

      mathOps.put("square", (UniMathOp) (a)-> (a*a));
      mathOps.put("cube", (UniMathOp) (a) -> (a*a*a));

    }



    public double run(String opName, double a){
        UniMathOp uniMathOp = (UniMathOp) mathOps.get(opName);
        return uniMathOp.run(a);
    }
    public double run(String opName, double a, double b){
        BinMathOp binMathOp = (BinMathOp) mathOps.get(opName);
        return binMathOp.run(a,b);
    }

}
