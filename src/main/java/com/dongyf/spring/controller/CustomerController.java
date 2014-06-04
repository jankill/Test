package com.dongyf.spring.controller;

import com.google.gson.Gson;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dongyf on 2014/5/16.
 */
@Scope("prototype")
@Controller
public class CustomerController {
    @RequestMapping(value = "showMessage")
    public ModelAndView showGridNode(ModelAndView modelAndView){
        modelAndView.setViewName("showMessage");
        return  modelAndView;
    }

    @RequestMapping(value = "getAllInv",method = RequestMethod.GET)
    @ResponseBody
    public void UserDemo(HttpServletRequest request,HttpServletResponse response){
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/Json");
        List<User> list = new ArrayList<User>();
        User user =new User();
        for (int i =0;i<200;i++){
            user.setId(i);
            user.setUserName("dongyf" + i);
            user.setEmail(120348 + i + "@qq.com");
            list.add(user);
            user = new User();
        }
      Gson gson = new Gson();
        String listJson = gson.toJson(list);
        System.out.println(listJson);
        /*HttpHeaders headers = new HttpHeaders();
        headers.add( "Content-Range" , "items 0-9/200");
*/
        try {
            response.getWriter().write(listJson);
            response.getWriter().flush();
            response.getWriter().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
      /* return new HttpEntity<List<User>>(list,headers);*/
    }
}
