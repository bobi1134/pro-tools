import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author: Mr.x
 * Date: 2016/12/15.
 * Description:
 */
public class TestArray_List {

    @Test
    public void test(){
        String str = "aa,bb,cc,dd";
        String array[] = str.split(",");
        System.out.println("字符串 - 数组：");
        for (String s : array){
            System.out.println(s);
        }

        System.out.println("数组 - 集合：\n");
        //数组转变为集合
        List<String> list = new ArrayList<String>();
        list = Arrays.asList(array);
        for (String s : list){
            System.out.println(s);
        }

        System.out.println("集合 - 数组：\n");
        //集合转变为数组
        Object[] array2 = list.toArray();
        for (Object s : array2){
            System.out.println(s);
        }
    }
}
