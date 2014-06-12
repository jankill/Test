package com.dongyf.spring.controller;

import com.dongyf.spring.biz.TreeService;
import com.dongyf.spring.entity.User;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dongyf on 2014/5/16.
 */
@Scope("prototype")
@Controller
public class CustomerController {

    private static final String RANGE_PREFIX = "items ";

    private static final String CONTENT_RANGE_HEADER = "Content-Range";

    private static final String ACCEPT_JSON = "Accept=application/json";
    private static final String EQUAL_SIGN = "=";
    private static final String LINE_THROUGH = "-";
    private static final String SLASH = "/";

    @Resource
    public void setTreeService(TreeService treeService) {
        this.treeService = treeService;
    }

    private TreeService treeService;
    ObjectMapper objectMapper = new ObjectMapper();

    @RequestMapping(value = "showMessage")
    public ModelAndView showGridNode(ModelAndView modelAndView) {
        modelAndView.setViewName("showMessage");
        return modelAndView;
    }

    @RequestMapping(value = "tree")
    public ModelAndView showTree(ModelAndView modelAndView) {
        modelAndView.setViewName("tree");
        return modelAndView;
    }

    private int handlerRange(String range) {

        return 0;
    }

    private int getRangeValue(int index, String rangeValue) {

        return Integer.parseInt(rangeValue.split(LINE_THROUGH)[index]);

    }

    @RequestMapping(value = "getAllInv", method = RequestMethod.GET)
    @ResponseBody
    public HttpEntity<List<User>> UserDemo(HttpServletRequest request, HttpServletResponse response) {

        StringBuilder stringBuilder = new StringBuilder(RANGE_PREFIX);
        String range = request.getHeader("Range");
        if (range.isEmpty()) {
            return null;
        }
        String rangeValue = range.split(EQUAL_SIGN)[1];
        int startRange = getRangeValue(0, rangeValue);
        int endRange = getRangeValue(1, rangeValue);

        response.setCharacterEncoding("utf-8");
        response.setContentType("application/Json");
        List<User> list = new ArrayList<User>();
        User user = new User();
        for (int i = 0; i < 200; i++) {
            user.setId(i);
            user.setUserName("dongyf" + i);
            user.setEmail(120348 + i + "@qq.com");
            list.add(user);
            user = new User();
        }
        List<User> resultUser = new ArrayList<User>();
        for (int i = startRange; i <= endRange; i++) {
            resultUser.add(list.get(i));
        }
        response.addHeader(CONTENT_RANGE_HEADER, stringBuilder.append(startRange).append(LINE_THROUGH).append(endRange).append(SLASH).append(list.size()).toString());

        return new HttpEntity<List<User>>(resultUser);
    }

}
