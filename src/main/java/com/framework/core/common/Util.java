package com.framework.core.common;

import com.alibaba.fastjson.JSONObject;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author: pujx
 * @Date: 2019/5/22 11:26
 */
public class Util {

    public static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_FORMAT = "yyyy-MM-dd";
    public static final char UNDERLINE = '_';




    private static String defaultRuleKey = "normal";


    public static String getStringValue(Object obj) {
        if (obj == null) {
            return "";
        } else {
            return obj.toString();
        }
    }

    /**
     * 获取map的值
     *
     * @param dataMap
     * @param keyStr
     * @return
     */
    public static String getMapValue(Map dataMap, String keyStr) {
        String valueStr = "";
        if (dataMap != null && dataMap.size() > 0) {
            valueStr = getStringValue(dataMap.get(keyStr));
        }
        return valueStr;
    }

    /**
     * 日期格式换转化为日期字符串
     *
     * @param date
     * @return
     */
    public static String date2StringFormat(Date date) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }

    /**
     * 字符串类型转换为日期时间类型
     *
     * @param date 日期字符串
     * @return
     * @throws Exception
     */
    public static Date string2DateFormat(String date) throws Exception {
        if (date != null && !"".equals(date)) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return sdf.parse(date);
        } else {
            return null;
        }
    }

    /**
     * 日期比较函数
     *
     * @param DATE1
     * @param DATE2
     * @return
     */
    public static int compare_date(String DATE1, String DATE2) {
        DateFormat df = new SimpleDateFormat(DATETIME_FORMAT);
        try {
            Date dt1 = df.parse(DATE1);
            Date dt2 = df.parse(DATE2);
            if (dt1.getTime() > dt2.getTime()) {
                return 1;
            } else if (dt1.getTime() < dt2.getTime()) {
                return -1;
            } else {
                return 0;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return 0;
    }

    public static String gb2312ToUtf8(String str) {
        String urlEncode = "";
        try {
            urlEncode = URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return urlEncode;
    }

    private static String[] encodes = {"US-ASCII", "UTF-8", "UTF-16LE", "UTF-16BE", "ISO-8859-1", "GB2312", "GBK",
            "GB18030"}; // 编码类型探测遍历的类型

    // 探测获取并返回strToIndentifyEncoding输入参数的编码
    public static String getEncoding(String strToIndentifyEncoding) {
        for (String encode : encodes)
            try {
                if (strToIndentifyEncoding.equals(new String(strToIndentifyEncoding.getBytes(), encode)))
                    return encode;
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        return null; // 未识别编码格式返回null
    }

    /**
     * 将JSON转换为对应的JavaBean
     *
     * @param jsonObject 需要转换的JSON对象
     * @param t          需要转换的JavaBean
     * @param <T>        泛型
     * @return 返回转换后的JavaBean
     * @throws IllegalAccessException 抛出IllegalAccessException异常
     */
    public static <T extends Object> T jsonToObject(JSONObject jsonObject, T t) throws IllegalAccessException {
        // 反射获取该JavaBean所有的属性
        Field[] fields = t.getClass().getDeclaredFields();
        // 遍历所有属性
        for (Field field : fields) {
            // 如果该属性对应了JSON中的某个值,则对JavaBean进行赋值
            if (jsonObject.get(field.getName()) != null) {
                // 将JavaBean属性的Accessible设为True,避免Private属性无法读取
                field.setAccessible(true);
                // 对相应属性进行赋值
                if (field.getType() == Date.class) {
                    field.set(t, new Date(Long.parseLong(jsonObject.get(field.getName()).toString())));
                } else if (field.getType() == Byte.class) {
                    field.set(t, Byte.parseByte(jsonObject.get(field.getName()).toString()));
                } else {
                    field.set(t, jsonObject.get(field.getName()));
                }
            }
        }
        // 返回转换后的JavaBean
        return t;
    }

    /**
     * 生成主键ID
     *
     * @return
     */
    public static String getGeneratID() {
        String dateStr = "";
        Date currentTime = new Date();
        DateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        dateStr = sdf.format(currentTime) + randomInt(6);
        return dateStr;
    }
    /**
     * 生成Int类型的随机数
     *
     * @param length
     * @return
     */
    public static String randomInt(int length) {
        StringBuilder s = new StringBuilder();
        String INT = "0123456789";
        Random rd = new Random();
        char num = 0;
        for (int i = 0; i < length; i++) {
            num = INT.charAt(rd.nextInt(INT.length()));// 产生数字0-9的随机数
            s.append(num);
        }
        return s.toString();
    }
    /**
     * 判断字符串是否为空
     *
     * @param str
     * @return
     */
    public static boolean isEmpty(String str) {
        return null == str || "".equals(str.trim());
    }

    /**
     * 获得文件名的后缀名
     *
     * @param fileName
     * @return
     */
    public static String getExt(String fileName) {
        return fileName.substring(fileName.lastIndexOf(".") + 1);
    }

    /**
     * 逗号分隔转换为集合
     *
     * @param param
     * @return
     */
    public static List<String> getInParam(String param) {
        boolean flag = param.contains(",");
        List<String> list = new ArrayList<String>();
        if (flag) {
            list = Arrays.asList(param.split(","));
        } else {
            list.add(param);
        }
        return list;
    }

    /**
     * 驼峰转下划线
     *
     * @param param
     * @return
     */
    public static String camelToUnderline(String param) {
        if (param == null || "".equals(param.trim())) {
            return "";
        }
        int len = param.length();
        StringBuilder sb = new StringBuilder(len);
        sb.append(param.substring(0, 1).toLowerCase());//首字母不加下划线
        for (int i = 1; i < len; i++) {
            char c = param.charAt(i);
            if (Character.isUpperCase(c)) {
                sb.append(UNDERLINE);
                sb.append(Character.toLowerCase(c));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    /**
     * 下划线转驼峰
     *
     * @param param
     * @return
     */
    public static String underlineToCamel(String param) {
        param=param.toLowerCase();
        if (param == null || "".equals(param.trim())) {
            return "";
        }
        int len = param.length();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            char c = param.charAt(i);
            if (c == UNDERLINE) {
                if (++i < len) {
                    sb.append(Character.toUpperCase(param.charAt(i)));
                }
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

//    /**
//     * 解析JWT标准格式的 Token(header.payload.signature) 中payload的信息
//     *
//     * @param payloadStr JWT标准的Token字符串中的payload字符串
//     * @return JSON 格式字符串
//     */
//    public static String decodePayloadFromToken(String payloadStr) throws Exception {
//        // 解析成功后返回JSON 格式字符串
//        // return new String(Base64Utils.decode(payloadStr.getBytes()),"UTF-8");
//        return new String(Base64.decodeBase64(payloadStr.getBytes()), "UTF-8");
//    }


    /**
     * 获取用户的真实ip
     *
     * @param request
     * @return
     */
    public static String getRequestIP(HttpServletRequest request) {

        // 优先取X-Real-IP
        String ip = request.getHeader("X-Real-IP");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("x-forwarded-for");
        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
            if ("0:0:0:0:0:0:0:1".equals(ip)) {
                ip = "127.0.0.1";
            }
        }

        if ("unknown".equalsIgnoreCase(ip)) {
            ip = "unknown";
            return ip;
        }

        int pos = ip.indexOf(',');
        if (pos >= 0) {
            ip = ip.substring(0, pos);
        }

        return ip;
    }

    /**
     * 四舍五入 防范
     *
     * @param decimalNum 保留小数点位数
     * @param num        待四舍五入数字
     * @return
     */
    public static double round(int decimalNum, double num) {
        return new BigDecimal(num).setScale(decimalNum, RoundingMode.HALF_UP).doubleValue();
    }
    public static String getDateString() {
        String dateStr = "";
        Date currentTime = new Date();
        DateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        dateStr = sdf.format(currentTime);
        return dateStr;
    }

    /**
     *验证字符串长度是否符合要求，一个汉字等于两个字符
     *
     * @param strParameter 要验证的字符串
     * @param limitLength 验证的长度
     * @return 符合长度ture 超出范围fals
     */
    public static boolean validateStrByLength(String strParameter , int limitLength)
    {
        int temp_int=0;
        byte[] b=strParameter.getBytes();

        for(int i=0 ; i<b.length ; i++)
        {
            if(b[i]>=0)
            {
                temp_int=temp_int+1;
            }
            else
            {
                temp_int=temp_int+2;
                i++;
            }
        }

        if(temp_int > limitLength)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
}