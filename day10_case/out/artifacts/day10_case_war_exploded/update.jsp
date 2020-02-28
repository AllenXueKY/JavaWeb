<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
    <head>
        <!-- 指定字符集 -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>修改用户</title>

        <link href="css/bootstrap.min.css" rel="stylesheet">
        <script src="js/jquery-2.1.0.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script>
            /*
                分析：
                    1.给表单绑定onsubmit事件。监听器中判断每一个方法校验的结果。
                        如果都为true，则监听器方法返回true
                        如果有一个为false，则监听器方法返回false
                    2.定义一些方法分别校验各个表单项。
                    3.给各个表单项绑定onblur事件。

             */
            window.onload = function(){
                //1.给表单绑定onsubmit事件
                document.getElementById("form").onsubmit = function(){
                    if (checkName() && checkAge() && checkQq() && checkEmail()){
                        return true;
                    }else {
                        alert("请检查后提交");
                        return false;
                    }
                }
                //给用户名和密码框分别绑定离焦事件
                document.getElementById("name").onblur = checkName;
                document.getElementById("age").onblur = checkAge;
                document.getElementById("qq").onblur = checkQq;
                document.getElementById("email").onblur = checkEmail;
            }

            <%--
                如果不符合正则表达式，将div的class = "form-group has-error has-feedback"
                    span class = "glyphicon glyphicon-remove form-control-feedback"

                如果符合，div class = "form-group has-success has-feedback"
                span class = "glyphicon glyphicon-ok form-control-feedback"
            --%>
            //校验用户名
            function checkName(){
                //1.获取用户名的值
                var name = document.getElementById("name").value;
                //2.定义正则表达式
                var reg_name = /^[\u2E80-\u9FFF]+$/;
                //3.判断值是否符合正则的规则
                var flag = reg_name.test(name);
                //4.提示信息
                var s_name = document.getElementById("s_name");
                var d_name = document.getElementById("d_name");
                if(flag){
                    //提示绿色对勾

                    d_name.className = "form-group has-success has-feedback";
                    s_name.className= "glyphicon glyphicon-ok form-control-feedback";
                }else{
                    d_name.className = "form-group has-error has-feedback";
                    s_name.className= "glyphicon glyphicon-remove form-control-feedback";
                }
                return flag;
            }
            //验证年龄
            function checkAge(){
                //1.获取用户名的值
                var age = document.getElementById("age").value;
                //2.定义正则表达式
                var reg_age = /^(?:[1-9][0-9]?|1[01][0-9]|120)$/;
                //3.判断值是否符合正则的规则
                var flag = reg_age.test(age);
                //4.提示信息
                var s_age = document.getElementById("s_age");
                var d_age = document.getElementById("d_age");
                if(flag){
                    //提示绿色对勾

                    d_age.className = "form-group has-success has-feedback";
                    s_age.className= "glyphicon glyphicon-ok form-control-feedback";
                }else{
                    d_age.className = "form-group has-error has-feedback";
                    s_age.className= "glyphicon glyphicon-remove form-control-feedback";
                }
                return flag;
            }

            //验证QQ
            function checkQq(){
                //1.获取用户名的值
                var qq = document.getElementById("qq").value;
                //2.定义正则表达式
                var reg_qq = /^[1-9][0-9]{4,11}$/;
                //3.判断值是否符合正则的规则
                var flag = reg_qq.test(qq);
                //4.提示信息
                var s_qq = document.getElementById("s_qq");
                var d_qq = document.getElementById("d_qq");
                if(flag){
                    //提示绿色对勾

                    d_qq.className = "form-group has-success has-feedback";
                    s_qq.className= "glyphicon glyphicon-ok form-control-feedback";
                }else{
                    d_qq.className = "form-group has-error has-feedback";
                    s_qq.className= "glyphicon glyphicon-remove form-control-feedback";
                }
                return flag;
            }
            //验证Email
            function checkEmail(){
                //1.获取用户名的值
                var email = document.getElementById("email").value;
                //2.定义正则表达式
                var reg_email = /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/;
                //3.判断值是否符合正则的规则
                var flag = reg_email.test(email);
                //4.提示信息
                var s_email = document.getElementById("s_email");
                var d_email = document.getElementById("d_email");
                if(flag){
                    //提示绿色对勾

                    d_email.className = "form-group has-success has-feedback";
                    s_email.className= "glyphicon glyphicon-ok form-control-feedback";
                }else{
                    d_email.className = "form-group has-error has-feedback";
                    s_email.className= "glyphicon glyphicon-remove form-control-feedback";
                }
                return flag;
            }

        </script>
    </head>
    <body>
        <div class="container" style="width: 400px;">
        <h3 style="text-align: center;">修改联系人</h3>
        <form id="form" action="${pageContext.request.contextPath}/userUpdateServlet" method="post">
          <!--隐藏域，提交id-->
            <input type="hidden" name="id" value="${user.id}">

          <div id="d_name" class="form-group">
            <label for="name">姓名：</label>
            <input type="text" class="form-control" id="name" name="name"  value="${user.name}" readonly="readonly" placeholder="Disabled input here..." />
            <span aria-hidden="true" id="s_name"></span>
          </div>

          <div class="form-group">
            <label>性别：</label>
              <c:if test="${user.gender == '男'}">
                <input type="radio" name="gender" value="男" checked />男
                <input type="radio" name="gender" value="女"  />女
              </c:if>
              <c:if test="${user.gender == '女'}">
                  <input type="radio" name="gender" value="男"  />男
                  <input type="radio" name="gender" value="女" checked />女
              </c:if>
          </div>

          <div id="d_age" class="form-group">
            <label for="age">年龄：</label>
            <input type="text" class="form-control" value="${user.age}" id="age"  name="age" placeholder="请输入年龄" />
            <span aria-hidden="true" id="s_age"></span>
          </div>

            <div class="form-group">
                <label for="address">籍贯：</label>
                <select name="address" id="address" class="form-control" >
                    <c:if test="${user.address == '陕西'}">
                        <option value="陕西" selected>陕西</option>
                        <option value="北京">北京</option>
                        <option value="上海">上海</option>
                    </c:if>

                    <c:if test="${user.address == '北京'}">
                        <option value="陕西" >陕西</option>
                        <option value="北京" selected>北京</option>
                        <option value="上海">上海</option>
                    </c:if>

                    <c:if test="${user.address == '上海'}">
                        <option value="陕西" >陕西</option>
                        <option value="北京">北京</option>
                        <option value="上海" selected>上海</option>
                    </c:if>
                </select>
            </div>


          <div id="d_qq" class="form-group">
            <label for="qq">QQ：</label>
            <input type="text" class="form-control" value="${user.qq}" name="qq" id="qq" placeholder="请输入QQ号码"/>
            <span aria-hidden="true" id="s_qq"></span>
          </div>

          <div id="d_email" class="form-group">
            <label for="email">Email：</label>
            <input type="text" class="form-control" value="${user.email}" name="email" id="email" placeholder="请输入邮箱地址"/>
              <span aria-hidden="true" id="s_email"></span>
          </div>

             <div class="form-group" style="text-align: center">
                <input class="btn btn-primary" type="submit" value="提交" />
                <input class="btn btn-default" type="reset" value="重置" />
             <a href="${pageContext.request.contextPath}/userFindByPageServlet">
                 <input class="btn btn-default" type="button" value="返回"/>
             </a>
             </div>
        </form>
        </div>
    </body>
</html>