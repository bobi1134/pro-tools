package cn.mrx.myPro.controller;

import cn.mrx.myPro.pojo.phone.Phone;
import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Author: Mr.x
 * Date: 2016/12/14.
 * Description:
 */
@Controller
@RequestMapping("/phone")
public class PhoneController {

    /**
     * 手机归属地查询页面
     * @return
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(){
        return "phone/index";
    }

    /**
     * 执行查询
     * @param phone
     * @param model
     * @return
     */
    @RequestMapping(value = "/get", method = RequestMethod.POST)
    public String get(String phone, Model model){
        StringBuffer sb = new StringBuffer();
        try {
            String key = "********";
            String url = "http://apis.juhe.cn/mobile/get?phone="+phone+"&key="+key;
            URL getUrl = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) getUrl.openConnection();
            connection.connect();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
            String line = "";
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            System.out.println("请求结果："+sb.toString());
            Phone _phone = JSON.parseObject(sb.toString(), Phone.class);
            model.addAttribute("_phone",_phone);
            model.addAttribute("phone",phone);
            reader.close();
            connection.disconnect();
        }catch (Exception e){
            e.printStackTrace();
        }
        return "phone/index";
    }
}
