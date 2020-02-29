package com.allen.web.servlet;

import com.allen.dao.AdminDao;
import com.allen.dao.impl.AdminDaoImpl;
import com.allen.domain.Admin;
import com.allen.service.AdminService;
import com.allen.service.impl.AdminServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
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
        //3、创建Admin对象
        Admin loginAdmin = new Admin();
        //3.2使用BeanUtils封装
        try {
            BeanUtils.populate(loginAdmin,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //获取用户填写的验证码
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
            //4、调用AdminDao的login方法
            AdminService service = new AdminServiceImpl();
            Admin admin = service.login(loginAdmin);
            //5、判断admin
            if(admin == null){
                //存储提示信息到request
                request.setAttribute("cc_error","用户名或密码错误，");
                //转发到登录页面
                request.getRequestDispatcher("/login.jsp").forward(request,response);
            }else {
                //登陆成功
                //存储数据
                session.setAttribute("admin",admin);
                request.setAttribute("lastTime",admin.getLastTime());
                service.updateLastTime(admin);
                //转发到登录页面
                request.getRequestDispatcher("/login.jsp").forward(request,response);

            }
        }else {
            //验证码不一致
            //存储提示信息到request
            request.setAttribute("cc_error","验证码错误，");
            //转发到登录页面
            request.getRequestDispatcher("/login.jsp").forward(request,response);

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
