package org.zwc.ssm.web;

import javax.servlet.http.HttpServletRequest;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zwc.ssm.domain.User;
import org.zwc.ssm.service.IUserService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


/**
 * Created by zhangwenchao on 2017/10/30.
 */

@Controller
public class UserController {

    @Resource(name="userService")
    private IUserService userService;

    @RequestMapping("/user/showUser")
    public void selectUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        long userId = Long.parseLong(request.getParameter("id"));
        User user = this.userService.selectUser(userId);
        ObjectMapper mapper = new ObjectMapper();
        response.getWriter().write(mapper.writeValueAsString(user));
        response.getWriter().close();
    }


    @RequestMapping("/user/list")
    public String getUserList(ModelMap modelMap)  {

       List<User>  userList = this.userService.getUserList();

       modelMap.addAttribute("list",userList);

       return "/user/list";

    }



    @RequestMapping("/user/login")
    @ResponseBody
    public String login(String username,String password, ModelMap modelMap, HttpServletRequest request)  {

        request.getSession().setAttribute("user",username);

        return "ok";

    }




}
