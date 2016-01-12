package com.air.utils.ip;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** 
 * @author yanghao
 * @date 2014年10月2日 下午3:18:14
 */
public class IPHelper {

    /**
     * @category 判断一个ip地址是不是ipv4
     * 
     * @param ipAddress
     * @return 指定的字符串是否为ipv4地址
     */
    public static boolean isIPV4(String ipAddress) {
        String ip = "([1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}";
        Pattern pattern = Pattern.compile(ip);
        Matcher matcher = pattern.matcher(ipAddress);
        return matcher.matches();
    }

    /**
     * @category 检测IPV4地址格式是否正确
     * @param ipv4Address
     * @return
     */
    public static boolean checkIPV4(String ipv4Address) {
        try {
            String number = ipv4Address.substring(0, ipv4Address.indexOf('.'));
            if (Integer.parseInt(number) > 255) {
                return false;
            }
            ipv4Address = ipv4Address.substring(ipv4Address.indexOf('.') + 1);
            number = ipv4Address.substring(0, ipv4Address.indexOf('.'));
            if (Integer.parseInt(number) > 255) {
                return false;
            }
            ipv4Address = ipv4Address.substring(ipv4Address.indexOf('.') + 1);
            number = ipv4Address.substring(0, ipv4Address.indexOf('.'));
            if (Integer.parseInt(number) > 255) {
                return false;
            }
            number = ipv4Address.substring(ipv4Address.indexOf('.') + 1);
            return Integer.parseInt(number) <= 255;
        } catch (Exception e) {
            return false;
        }
    }
}
