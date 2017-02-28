package cn.mrx.myPro.controller;

import cn.mrx.myPro.pojo.history.History;
import cn.mrx.myPro.pojo.history.Result;
import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Author: Mr.x
 * Date: 2016/12/14.
 * Description:
 */
@Controller
@RequestMapping("/history")
public class HistoryController {

    /**
     * 历史的今天页面
     * @param model
     * @return
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(Model model){
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String strDate = format.format(date);
        model.addAttribute("date", strDate);
        return "history/index";
    }

    /**
     * 执行查询
     * @param date
     * @param model
     * @return
     */
    @RequestMapping(value = "/get", method = RequestMethod.POST)
    public String get(String date, Model model){
        System.out.println("date:"+date);
        int month = 1;
        int day = 1;
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date _date = format.parse(date);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(_date);
            month = calendar.get(Calendar.MONTH) + 1;
            day = calendar.get(Calendar.DAY_OF_MONTH);

        }catch (ParseException e){
            e.printStackTrace();
        }
        System.out.println("month:"+month);
        System.out.println("day:"+day);
        StringBuffer sb = new StringBuffer();
        try {
            String key = "********";
            String url = "http://api.juheapi.com/japi/toh?key="+key+"&v=1.0&month="+month+"&day="+day;
            URL getUrl = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) getUrl.openConnection();
            connection.connect();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
            String line = "";
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            System.out.println("请求结果："+sb.toString());
            List<Result> results = new ArrayList<Result>();
            History history = JSON.parseObject(sb.toString(), History.class);
            for (int i = 0; i < history.getResult().size(); i++) {
                results.add(history.getResult().get(i));
            }
            model.addAttribute("results",results);
            model.addAttribute("date",date);
            reader.close();
            connection.disconnect();
        }catch (Exception e){
            e.printStackTrace();
        }
        return "history/index";
    }
}
