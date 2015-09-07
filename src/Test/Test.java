package Test;

import com.littleh.math.Operations;

/**
 * Created by Dennis on 9/7/2015.
 */


public class Test {




    public static void main(String[] args) {
        int a = 4;
        int b = 6;
        Operations operations = new Operations();
        System.out.println(operations.run("add", a, b));
        System.out.println(operations.run("subtract",a,b));
        System.out.println(operations.run("square",a));


    }


}
