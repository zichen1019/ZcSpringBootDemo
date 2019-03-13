package com.zc.conf;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RestController;

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

    public ControllerConfig(){
        RESULT = new JSONObject();
        /*SESSION = request.getSession();
        Cookie[] cookies = request.getCookies();
        for(Cookie cookie : cookies){
            if("x-CSRFToken".equals(cookie.getName())){
                CSRFTOKEN = cookie.getValue();
            }
        }*/
    }


}
