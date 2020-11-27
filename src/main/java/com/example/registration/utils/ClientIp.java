package com.example.registration.utils;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * 获取客户端ip工具类
 * @author meihua
 */
public class ClientIp {

    private static final Logger logger = LoggerFactory.getLogger(ClientIp.class);

    private static final String UNKNOWN = "unknown";


    /**
     * 获取用户实际IP地址
     * @param request 当前请求对象
     * @return 实际IP地址
     */
    public static String getRemoteIp(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        logger.trace("当前IP来源[X-Forwarded-For], 值[{}]", ip);
        if(!StringUtils.isEmpty(ip) && !UNKNOWN.equalsIgnoreCase(ip)){
            //多次反向代理后会有多个ip值，第一个ip才是真实ip
            int index = ip.indexOf(',');
            if(index != -1){
                return ip.substring(0, index);
            }else{
                return ip;
            }
        }
        ip = request.getHeader("X-Real-IP");
        logger.trace("当前IP来源[X-Real-IP], 值[{}]", ip);
        if(!StringUtils.isEmpty(ip) && !UNKNOWN.equalsIgnoreCase(ip)){
            return ip;
        }
        if (StringUtils.isEmpty(ip) || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
            logger.trace("当前IP来源[Proxy-Client-IP], 值[{}]", ip);
        }
        if (StringUtils.isEmpty(ip) || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
            logger.trace("当前IP来源[WL-Proxy-Client-IP], 值[{}]", ip);
        }
        if (StringUtils.isEmpty(ip) || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
            logger.trace("当前IP来源[HTTP_CLIENT_IP], 值[{}]", ip);
        }
        if (StringUtils.isEmpty(ip) || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
            logger.trace("当前IP来源[HTTP_X_FORWARDED_FOR], 值[{}]", ip);
        }
        if (StringUtils.isEmpty(ip) || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
            logger.trace("当前IP来源[getRemoteAddr], 值[{}]", ip);
        }
        if ("0:0:0:0:0:0:0:1".equals(ip)) {
            String ipv4FromLocal = getIpv4FromLocal();
            if (StringUtils.isNotEmpty(ipv4FromLocal)) {
                ip = ipv4FromLocal;
            }
        }
        return ip;
    }

    /**
     * 获取本地IP地址
     * @return IP地址
     */
    private static String getIpv4FromLocal() {
        String ip = null;
        InputStream is = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        try {
            Process process = Runtime.getRuntime().exec("cmd.exe /c ipconfig | findstr IPv4");
            is = process.getInputStream();
            isr = new InputStreamReader(is);
            br = new BufferedReader(isr);
            String line = br.readLine();
            ip = line.substring(line.indexOf(':') + 1).trim();
        } catch (IOException e) {
            logger.warn("获取本地IP异常", e);
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
                if (isr != null) {
                    isr.close();
                }
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                logger.debug("流关闭异常", e);
            }
        }
        return ip;
    }

    /**
     * 获取客户端源端口
     * @param request
     * @return
     */
    public static Long getRemotePort( HttpServletRequest request){
        try{
            String port = request.getHeader("remote-port");
            if(port!=null&&port!="") {
                try{
                    return Long.parseLong(port);
                }catch(NumberFormatException ex){
                    logger.error("convert port to long error , port:	"+port);
                    return null;
                }
            }else{
                return null;
            }
        }catch(Exception e){
            logger.error("get romote port error,error message:"+e.getMessage());
            return null;
        }
    }

}