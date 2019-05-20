package com.alley.rain.thinkinjava;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alley.rain.thinkinjava.array.Girl;

/**
 * Description: 使用给定的参数replacement替换字符串所有匹配给定的正则表达式regex的子字符串
 * User: dyf
 * Date: 2019-05-20
 * Time: 23:44
 */
public class ReplaceAllTest {
    public static void main(String[] args) {
        Girl girl = new Girl("loeiy", "男", "18539271637");
        String str = JSON.toJSONString(girl);
        JSONObject jsonObject = JSON.parseObject(str);
        String cellPhone = jsonObject.getString("cellPhone");
        String res = cellPhone.replaceAll("^(13[0-9]|14[579]|15[0-3,5-9]|16[6]|17[0135678]|18[0-9]|19[89])\\d{8}$", "********"); // 若cellPhone匹配正则会转换，否则不变
        jsonObject.put("cellPhone", res);
        System.out.println(jsonObject.toJSONString());
    }
}
