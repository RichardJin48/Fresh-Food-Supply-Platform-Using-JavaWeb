package com.cdut.web;

import com.cdut.dao.EmpDao;
import com.cdut.entity.Emp;
import com.cdut.utils.CheckUtils;
import com.cdut.utils.Md5Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "EmpServlet", urlPatterns = "/emp")
public class EmpServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");
        //读取前端操作参数
        String opt = req.getParameter("opt");
        if("list".equals(opt)) {
            listEmp(req, resp);
        }
        else if("toAdd".equals(opt)){
            toAdd(req, resp);
        }
        else if("addEmp".equals(opt)){
            addEmp(req, resp);
        }
        else if("toDelete".equals(opt)){
            toDelete(req, resp);
        }
        else if("deleteEmp".equals(opt)){
            deleteEmp(req, resp);
        }
        else if("toEdit".equals(opt)){
            toEdit(req, resp);
        }
        else if("editEmp".equals(opt)){
            editEmp(req, resp);
        }
        else if("toLogin".equals(opt)){
            toLogin(req, resp);
        }
        else if("login".equals(opt)){
            login(req, resp);
        }
        else if("index".equals(opt)) {
            index(req, resp);
        }
        else if("show".equals(opt)) {
            showUser(req, resp);
        }
    }

    private void toLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/emp/login.jsp").forward(req,resp);
    }

    private void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println(username+password);
        password = Md5Utils.md5(password);
        EmpDao dao = new EmpDao();
        Emp sup = dao.findEmpByIdCard(username);

        resp.setContentType("application/json;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        if (sup == null) {
            out.print("{\"status\": \"username_error\"}");
        } else if (sup.getPassword().equals(password)) {
            out.print("{\"status\": \"success\"}");
        } else {
            out.print("{\"status\": \"password_error\"}");
        }
        out.flush();
        out.close();
    }


    private void index(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EmpDao dao = new EmpDao();
        String userCard = req.getParameter("userCard");
        Emp user = dao.findEmpByIdCard(userCard);
        req.setAttribute("user",user);
        //通过转发器将数据交给jsp
        req.getRequestDispatcher("/emp/index.jsp").forward(req,resp);
    }

    private void showUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userCard = req.getParameter("userCard");
        EmpDao dao = new EmpDao();
        Emp user = dao.findEmpByIdCard(userCard);
        req.setAttribute("user",user);
        //通过转发器将数据交给jsp
        req.getRequestDispatcher("/emp/show.jsp").forward(req,resp);
    }

    private void listEmp(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EmpDao dao = new EmpDao();
        List<Emp> emps = dao.listEmp();
        //将数据设置到请求中
        req.setAttribute("emps",emps);
        //通过身份证号识别登录的用户
        String userCard = req.getParameter("userCard");
        Emp user = dao.findEmpByIdCard(userCard);
        req.setAttribute("user",user);
        //通过转发器将数据交给jsp
        req.getRequestDispatcher("/emp/emplist.jsp").forward(req,resp);
    }

    private void toAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String mode = req.getParameter("mode");
        if(mode.equals("1")){
            String userCard = req.getParameter("userCard");
            req.setAttribute("title","Add Staff");
            req.setAttribute("url1","/emp?opt=addEmp&userCard="+userCard+"&mode=1");
            req.setAttribute("url2","/emp?opt=list&userCard="+userCard);
        }
        else if(mode.equals("2")){
            req.setAttribute("title","Staff Register");
            req.setAttribute("url1","/emp?opt=addEmp"+"&mode=2");
            req.setAttribute("url2","/emp?opt=toLogin");
        }
        req.getRequestDispatcher("/emp/add.jsp").forward(req,resp);
    }

    private void addEmp(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String empName = req.getParameter("empName");
        String idCard = req.getParameter("idCard");
        String password = req.getParameter("password");
        String dept = req.getParameter("dept");
        String gender = req.getParameter("gender");
        String age = req.getParameter("age");
        String phone = req.getParameter("phone");
        if(gender == null){
            gender = "";
        }
        if(age.equals("")){
            age = "0";
        }
        String mode = req.getParameter("mode");
        if (!CheckUtils.checkEmp(empName,idCard,phone).equals("correct")) {
            if(mode.equals("1")) {
                String userCard = req.getParameter("userCard");
                req.setAttribute("url","/emp?opt=toAdd&userCard="+userCard+"&mode="+mode);
            }
            else{
                req.setAttribute("url","/emp?opt=toAdd&mode="+mode);
            }
            req.setAttribute("inf",CheckUtils.checkEmp(empName,idCard,phone));
            req.getRequestDispatcher("/emp/error.jsp").forward(req, resp);
        }
        else {
            if(password.equals("")){
                password = idCard.substring(idCard.length()-6);
            }
            password = Md5Utils.md5(password);
            Emp emp = new Emp(null, empName, idCard, password, dept, gender, Integer.parseInt(age), phone);
            EmpDao dao = new EmpDao();
            Integer count = dao.insertEmp(emp);
            if (count > 0) {
                if(mode.equals("1")){
                    String userCard = req.getParameter("userCard");
                    resp.sendRedirect("/emp?opt=list&userCard="+userCard);
                }
                else if(mode.equals("2")){
                    req.setAttribute("url","/emp?opt=toLogin");
                    req.setAttribute("inf","Registration succeeded! Please re-enter the ID number and password to log in");
                    req.getRequestDispatcher("/emp/error.jsp").forward(req, resp);
                }
            }
        }
    }

    private void toDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String empId = req.getParameter("empId");
        String userCard = req.getParameter("userCard");
        EmpDao dao = new EmpDao();
        Emp emp = dao.findEmpById(Integer.parseInt(empId));
        String empName = emp.getEmpName();
        req.setAttribute("inf","Delete"+empName+"?");
        req.setAttribute("url1","/emp?opt=list&userCard="+userCard);
        req.setAttribute("url2","/emp?opt=deleteEmp&empId="+empId+"&userCard="+userCard);
        req.getRequestDispatcher("/emp/confirm.jsp").forward(req, resp);
    }

    private void deleteEmp(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String empId = req.getParameter("empId");
        EmpDao dao = new EmpDao();
        Integer count = dao.deleteEmp(Integer.parseInt(empId));
        String userCard = req.getParameter("userCard");
        if(count>0){
            resp.sendRedirect("/emp?opt=list&userCard="+userCard);
        }
    }

    private void toEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String empId = req.getParameter("empId");
        EmpDao dao = new EmpDao();
        Emp emp = dao.findEmpById(Integer.parseInt(empId));
        String male = "";
        String female = "";
        if(emp.getGender().equals("Male")){
            male = "checked";
        }
        else if(emp.getGender().equals("Female")){
            female = "checked";
        }
        req.setAttribute("emp",emp);
        req.setAttribute("male",male);
        req.setAttribute("female",female);
        String userCard = req.getParameter("userCard");
        String mode = req.getParameter("mode");
        if(mode.equals("1")){
            req.setAttribute("title","Edit Staff");
            req.setAttribute("url1","/emp?opt=editEmp&userCard="+userCard+"&mode=1");
            req.setAttribute("url2","/emp?opt=list&userCard="+userCard);
        }
        else if(mode.equals("2")){
            req.setAttribute("title","Edit Personal Information");
            req.setAttribute("url1","/emp?opt=editEmp&userCard="+userCard+"&mode=2");
            req.setAttribute("url2","/emp?opt=show&userCard="+userCard);
        }
        //  通过转发器 将数据交给jsp继续处理
        req.getRequestDispatcher("/emp/edit.jsp").forward(req,resp);
    }

    private void editEmp(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String empId = req.getParameter("empId");
        String empName = req.getParameter("empName");
        String idCard = req.getParameter("idCard");
        String password = req.getParameter("password");
        String dept = req.getParameter("dept");
        String gender = req.getParameter("gender");
        String age = req.getParameter("age");
        String phone = req.getParameter("phone");
        if (gender == null) {
            gender = "";
        }
        if (age.equals("")) {
            age = "0";
        }
        String userCard = req.getParameter("userCard");
        String mode = req.getParameter("mode");
        if (!CheckUtils.checkEmp(empName,idCard,phone).equals("correct")) {
            req.setAttribute("url","/emp?opt=toEdit&empId="+empId+"&userCard="+userCard+"&mode="+mode);
            req.setAttribute("inf",CheckUtils.checkEmp(empName,idCard,phone));
            req.getRequestDispatcher("/emp/error.jsp").forward(req, resp);
        }
        else {
            EmpDao dao = new EmpDao();
            if(password.equals("")){
                //不输入密码则保持原密码
                password = dao.findEmpById(Integer.parseInt(empId)).getPassword();
            }
            else {
                password = Md5Utils.md5(password);
            }
            Emp emp = new Emp(null, empName, idCard, password, dept, gender, Integer.parseInt(age), phone);
            Integer count = dao.updateEmp(emp, Integer.parseInt(empId));
            if (count > 0) {
                //重新刷新列表页面
                if(mode.equals("1")){
                    resp.sendRedirect("/emp?opt=list&userCard=" + userCard);
                }
                else if(mode.equals("2")){
                    resp.sendRedirect("/emp?opt=index&userCard=" + userCard);
                }
            }
        }
    }
}
