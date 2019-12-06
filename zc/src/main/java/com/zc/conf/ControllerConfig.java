package com.zc.conf;

import com.alibaba.fastjson.JSONObject;
import com.zc.base.StatusCode;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
public class ControllerConfig {

    protected final static String RESULTTOAST = "success";

    protected static JSONObject RESULT;

//    protected HttpSession SESSION;
//
//    protected String CSRFTOKEN;
//
//    @Autowired
//    protected HttpServletRequest request;

    public ControllerConfig() {
        RESULT = new JSONObject();
        /*SESSION = request.getSession();
        Cookie[] cookies = request.getCookies();
        for(Cookie cookie : cookies){
            if("x-CSRFToken".equals(cookie.getName())){
                CSRFTOKEN = cookie.getValue();
            }
        }*/
    }

    /**
     * 获取访问者IP
     * 在一般情况下使用Request.getRemoteAddr()即可，但是经过nginx等反向代理软件后，这个方法会失效。
     * <p>
     * 本方法先从Header中获取X-Real-IP，如果不存在再从X-Forwarded-For获得第一个IP(用,分割)，
     * 如果还不存在则调用Request .getRemoteAddr()。
     *
     * @param request
     * @return
     */
    public static String getIpAddr(HttpServletRequest request) {
        // 获取ip方式1
//        String ipAddress = null;
//        try {
//            ipAddress = request.getHeader("x-forwarded-for");
//            if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
//                ipAddress = request.getHeader("Proxy-Client-IP");
//            }
//            if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
//                ipAddress = request.getHeader("WL-Proxy-Client-IP");
//            }
//            if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
//                ipAddress = request.getRemoteAddr();
//                if (ipAddress.equals("127.0.0.1")) {
//                    // 根据网卡取本机配置的IP
//                    InetAddress inet = null;
//                    try {
//                        inet = InetAddress.getLocalHost();
//                    } catch (UnknownHostException e) {
//                        e.printStackTrace();
//                    }
//                    ipAddress = inet.getHostAddress();
//                }
//            }
//            // 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
//            if (ipAddress != null && ipAddress.length() > 15) { // "***.***.***.***".length()
//                // = 15
//                if (ipAddress.indexOf(",") > 0) {
//                    ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
//                }
//            }
//        } catch (Exception e) {
//            ipAddress="";
//        }
//        // ipAddress = this.getRequest().getRemoteAddr();
//        return ipAddress;
        // 获取ip方式2
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return "0:0:0:0:0:0:0:1".equals(ip) ? "127.0.0.1" : ip;
        // 获取ip方式3
//        StringBuffer resBuffer=null;
//        try {
//            URL url = new URL("http://pv.sohu.com/cityjson?ie=utf-8");
//            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
//            InputStream is = httpURLConnection.getInputStream();
//            InputStreamReader isr=new InputStreamReader(is,"utf-8");
//            BufferedReader br=new BufferedReader(isr);
//            resBuffer=new StringBuffer();
//            String line=null;
//            while((line=br.readLine())!=null){
//                resBuffer.append(line);
//            }
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        // var returnCitySN = {"cip": "60.216.196.110", "cid": "370100", "cname": "山东省济南市"};
//        String res = resBuffer.toString();
//        // {"cip": "60.216.196.110", "cid": "370100", "cname": "山东省济南市"}
//        res = res.substring(res.lastIndexOf("=")+2, res.length()-1);
//        return res;
    }

}
