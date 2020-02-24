package com.allen.sevlet;

import com.allen.dao.UserDao;
import com.allen.domain.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1、设置request编码
        request.setCharacterEncoding("utf-8");
        //2、获取所有请求参数
        Map<String, String[]> map = request.getParameterMap();
        //3、创建User对象
        User loginUser = new User();
        //3.2使用BeanUtils封装
        try {
            BeanUtils.populate(loginUser,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        String checkCode = request.getParameter("checkCode");
        //先获取生成的验证码
        HttpSession session = request.getSession();
        String checkCode_session = (String) session.getAttribute("checkCode_session");
        //删除session中存储的验证码
        session.removeAttribute("checkCode_session");
        //先判断验证码是否正确
        if (checkCode_session != null && checkCode_session.equalsIgnoreCase(checkCode)){
            //忽略大小写比较字符串
            //验证码正确
            //判断用户名和密码是否一致
            //4、调用UserDao的login方法
            UserDao dao = new UserDao();
            User user = dao.login(loginUser);

            //5、判断user
            if(user == null){
                //存储提示信息到request
                request.setAttribute("cc_error","用户名或密码错误");
                //转发到登录页面
                request.getRequestDispatcher("/login.jsp").forward(request,response);
            }else {
                //登陆成功
                //存储数据
                session.setAttribute("user",user.getUsername());
                //重定向到success.jsp
                response.sendRedirect(request.getContextPath()+"/success.jsp");
            }
        }else {
            //验证码不一致
            //存储提示信息到request
            request.setAttribute("cc_error","验证码错误");
            //转发到登录页面
            request.getRequestDispatcher("/login.jsp").forward(request,response);

        }




    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
