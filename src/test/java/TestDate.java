import org.junit.*;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class TestDate {

    @Test
    public void test1(){
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = format.parse("2016-12-6 16:30:58");//将字符串转换为Date
            System.out.println("date:" + date);

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            System.out.println(calendar.get(Calendar.YEAR));//获取年
            System.out.println(calendar.get(Calendar.MONTH) + 1);//获取月
            System.out.println(calendar.get(Calendar.DAY_OF_MONTH));//获取日
            System.out.println(calendar.get(Calendar.HOUR_OF_DAY));//获取时
            System.out.println(calendar.get(Calendar.MINUTE));//获取分
            System.out.println(calendar.get(Calendar.SECOND));//获取秒
        }catch (ParseException e){
            e.printStackTrace();
        }
    }

    @Test
    public void test2() {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str = format.format(date);
        System.out.println(str);
    }
}
