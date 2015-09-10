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

    HashMap<MathOpEnum, Object> mathOps;

    public Operations(){
      mathOps = new HashMap<MathOpEnum,Object>();
      mathOps.put(MathOpEnum.ADD, (BinMathOp) (a, b)->a+b);
      mathOps.put(MathOpEnum.SUBTRACT, (BinMathOp)(a,b)->a-b);
      mathOps.put(MathOpEnum.MULTIPLY, (BinMathOp) (a,b)->a*b);
      mathOps.put(MathOpEnum.DIVIDE, (BinMathOp) (a,b)->{
                                    double r=Double.NaN;
                                    if(b!=0){
                                     r=a/b;}
                                    return r;});
      mathOps.put(MathOpEnum.MOD, (BinMathOp) (a,b) -> a%b);
      mathOps.put(MathOpEnum.SQUARE, (UniMathOp) (a)-> (a*a));
      mathOps.put(MathOpEnum.CUBE, (UniMathOp) (a) -> (a*a*a));

    }



    public double run(MathOpEnum opName, double a){
        UniMathOp uniMathOp = null;
        try {
            uniMathOp = (UniMathOp) mathOps.get(opName);
        }catch(Exception e){

        }
        return uniMathOp.run(a);
    }
    public double run(MathOpEnum opName, double a, double b){
        BinMathOp binMathOp = null;
        try {
             binMathOp = (BinMathOp) mathOps.get(opName);
        }catch (Exception e){

        }

        return binMathOp.run(a,b);
    }

}
