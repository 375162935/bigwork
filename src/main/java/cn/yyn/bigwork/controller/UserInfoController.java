package cn.yyn.bigwork.controller;

import cn.yyn.bigwork.bean.Role;
import cn.yyn.bigwork.bean.UserInfo;
import cn.yyn.bigwork.service.UserService;
import net.sf.json.JSONObject;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

/**
 * @author 杨以诺
 * by 2020-05-19 17:18
 */
@Controller
@RequestMapping("/user")
public class UserInfoController {

    @Autowired
    private UserService userService;

    //用户登录
    @ResponseBody
    @RequestMapping("/login")
    public String Login(@Param("username") String username,
                        @Param("password") String password,
                        HttpSession session) {
        JSONObject jsonObject = new JSONObject();
        UserInfo userInfo = userService.findUserByUserName(username);
        if (userInfo == null) {
            System.out.println("账号不存在");
            jsonObject.put("result", "0");
        } else if (!password.equals(userInfo.getPassword())) {
            System.out.println("密码错误");
            jsonObject.put("result", "1");
        } else {
            System.out.println("登陆成功");
            jsonObject.put("result", username);
            session.setAttribute("user", userInfo);
        }
        String json = jsonObject.toString();
        return jsonObject.toString();
    }

    //检测账号是否存在
    @ResponseBody
    @RequestMapping("/register_username")
    public String register_username(String username) {
        JSONObject jsonObject = new JSONObject();
        UserInfo userInfo = userService.findUserByUserName(username);
        if (userInfo == null) {
            jsonObject.put("result", "1");
        } else {
            jsonObject.put("result", "2");
        }
        return jsonObject.toString();
    }

    //用户注册
    @ResponseBody
    @RequestMapping("/register")
    public String register(@Param("username") String username,
                           @Param("password") String password,
                           @Param("trueName") String trueName,
                           @Param("phone") String phone,
                           @Param("gender") String gender,
                           @Param("birthday") Date birthday) {
        JSONObject jsonObject = new JSONObject();
        System.out.println(gender);
        UserInfo userInfo = userService.findUserByUserName(username);
        if (userInfo == null) {
            userInfo = new UserInfo();
            userInfo.setUsername(username);
            userInfo.setPassword(password);
            userInfo.setTrueName(trueName);
            userInfo.setPhone(phone);
            userInfo.setGender(gender);
            userInfo.setBirthday(birthday);
            userInfo.setCreateTime(new Date());
            System.out.println(userInfo);
            this.userService.addUserInfo(userInfo);
            System.out.println("添加成功");
            jsonObject.put("result", username);
        } else {
            System.out.println("账号已存在");
            jsonObject.put("result", "0");
        }
        return jsonObject.toString();
    }

    //个人信息页
    @RequestMapping("/pages_user")
    public ModelAndView pages_user(HttpSession session) {
        UserInfo userInfo= (UserInfo) session.getAttribute("user");
        ModelAndView mv = new ModelAndView();
        mv.addObject("userInfo",userInfo);
        mv.setViewName("emp/pages_user");
        return mv;
    }

    @ResponseBody
    @RequestMapping("/upd_user")
    public String upd_user(@Param("trueName") String trueName,
                           @Param("email") String email,
                           @Param("password") String password,
                           @Param("phone") String phone,
                           @Param("message") String message,
                           @Param("country") String country,
                           HttpSession session){
        JSONObject jsonObject=new JSONObject();
        UserInfo userInfo= (UserInfo) session.getAttribute("user");
        if (trueName.replaceAll(" ","")!=""){
            userInfo.setTrueName(trueName);
        }
        if (email.replaceAll(" ","")!=""){
            userInfo.setEmail(email);
        }
        if (password.replaceAll(" ","")!=""){
            userInfo.setPassword(password);
        }
        if (phone.replaceAll(" ","")!=""){
            userInfo.setPhone(phone);
        }
        if (message.replaceAll(" ","")!=""){
            userInfo.setMessage(message);
        }
        if (country.replaceAll(" ","")!=""){
            userInfo.setCountry(country);
        }
        System.out.println(userInfo);
        Integer i=userService.updUserInfo(userInfo);
        if (i>0){
            System.out.println("修改成功");
            session.setAttribute("user",userInfo);
            jsonObject.put("result","0");
        }else {
            System.out.println("修改失败");
            jsonObject.put("result","1");
        }
        return jsonObject.toString();
    }

    //退出
    @RequestMapping("/exit")
    public String exit(HttpSession session) {
        try {
            session.removeAttribute("user");
        } catch (Exception e) {

        }
        return "redirect:/";
    }
}