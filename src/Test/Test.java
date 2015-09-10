package Test;

import com.littleh.math.MathOpEnum;
import com.littleh.math.Operations;

/**
 * Created by Dennis on 9/7/2015.
 */


public class Test {




    public static void main(String[] args) {
        int a = 4;
        int b = 6;
        Operations operations = new Operations();
        System.out.println(operations.run(MathOpEnum.ADD, a, b));
        System.out.println(operations.run(MathOpEnum.SUBTRACT,a,b));
        System.out.println(operations.run(MathOpEnum.SQUARE,a));


    }


}
