import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author: Mr.x
 * Date: 2016/12/15.
 * Description:
 */
public class TestsubString {

    @Test
    public void test1(){
        String str = "abcdefghijklmn";

        //c
        System.out.println(str.charAt(2));
        //5
        System.out.println(str.indexOf("f"));
        //3
        System.out.println(str.indexOf("def"));

        //defghijklmn
        System.out.println(str.substring(3));
        //abc
        System.out.println(str.substring(0, 3));
        //ghijklmn
        System.out.println(str.substring(str.indexOf("g")));
        //ghijklmn
        System.out.println(str.substring(str.indexOf("g"), str.length()));
        //ghij
        System.out.println(str.substring(str.indexOf("g"), str.length() - 4));
    }
}
