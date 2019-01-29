package com.zc.conf;

import com.zc.base.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
public class ControllerConfig {

    protected final static String RESULTTOAST = "result";

    protected static Map<String, Object> RESULT;

//    protected HttpSession SESSION;
//
//    protected String CSRFTOKEN;
//
//    @Autowired
//    protected HttpServletRequest request;

    public ControllerConfig(){
        RESULT = new HashMap<>();
        RESULT.put(RESULTTOAST, StatusCode.SUCCESS);
        /*SESSION = request.getSession();
        Cookie[] cookies = request.getCookies();
        for(Cookie cookie : cookies){
            if("x-CSRFToken".equals(cookie.getName())){
                CSRFTOKEN = cookie.getValue();
            }
        }*/
    }


}
