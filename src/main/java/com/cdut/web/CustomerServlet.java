package com.cdut.web;

import com.cdut.dao.AnnDao;
import com.cdut.dao.CustomerDao;
import com.cdut.dao.EmpDao;
import com.cdut.dao.ProductDao;
import com.cdut.entity.Ann;
import com.cdut.entity.Customer;
import com.cdut.entity.Emp;
import com.cdut.entity.Product;
import com.cdut.utils.CheckUtils;
import com.cdut.utils.Md5Utils;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


@WebServlet(name = "CustomerServlet", urlPatterns = "/cus")
public class CustomerServlet extends HttpServlet {
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
        if ("list".equals(opt)) {
            listCus(req, resp);
        } else if ("toAdd".equals(opt)) {
            toAdd(req, resp);
        } else if ("addCus".equals(opt)) {
            addCus(req, resp);
        } else if ("toDelete".equals(opt)) {
            toDelete(req, resp);
        } else if ("deleteCus".equals(opt)) {
            deleteCus(req, resp);
        } else if ("toEdit".equals(opt)) {
            toEdit(req, resp);
        } else if ("editCus".equals(opt)) {
            editCus(req, resp);
        } else if ("toLogin".equals(opt)) {
            toLogin(req, resp);
        } else if ("login".equals(opt)) {
            login(req, resp);
        } else if ("index".equals(opt)) {
            index(req, resp);
        } else if ("main".equals(opt)) {
            main(req, resp);
        } else if ("show".equals(opt)) {
            showUser(req, resp);
        } else if ("checkAccount".equals(opt)) {
            checkAccount(req, resp);
        } else if ("changePSD".equals(opt)) {
            changePSD(req, resp);
        }
    }

    private void toLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/cus/login.jsp").forward(req, resp);
    }

    private void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        password = Md5Utils.md5(password);
        CustomerDao dao = new CustomerDao();
        Customer cus = dao.findCustomerByName(username);

        resp.setContentType("application/json;charset=UTF-8");
        PrintWriter out = resp.getWriter();


        if (cus == null) {
            out.print("{\"status\": \"username_error\"}");
        } else if (cus.getPassword().equals(password)) {
            out.print("{\"status\": \"success\"}");
        } else {
            out.print("{\"status\": \"password_error\"}");
        }
        out.flush();
        out.close();
    }

    private void index(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //该功能仅对用户开放
        CustomerDao dao = new CustomerDao();
        String userName = req.getParameter("userName");
        Customer user = dao.findCustomerByName(userName);
        req.setAttribute("user", user);
        //通过转发器将数据交给jsp
        req.getRequestDispatcher("/cus/index.jsp").forward(req, resp);
    }

    private void main(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //该功能仅对用户开放
        CustomerDao dao = new CustomerDao();
        String userName = req.getParameter("userName");
        Customer user = dao.findCustomerByName(userName);
        req.setAttribute("user", user);
        AnnDao dao2 = new AnnDao();
        Ann ann = dao2.listAnn().get(0);
        System.out.println(ann);
        req.setAttribute("ann", ann);
        ProductDao dao3 = new ProductDao();
        List<Product> p1 = dao3.listProductRec();
        List<Product> p2 = dao3.listProductPub();
        req.setAttribute("p1", p1);
        req.setAttribute("p2", p2);
        //通过转发器将数据交给jsp
        req.getRequestDispatcher("/new/index.jsp").forward(req, resp);
    }

    private void showUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //该功能仅对用户开放
        String userName = req.getParameter("userName");
        CustomerDao dao = new CustomerDao();
        Customer user = dao.findCustomerByName(userName);
        req.setAttribute("user", user);
        //通过转发器将数据交给jsp
        req.getRequestDispatcher("/cus/show.jsp").forward(req, resp);
    }

    private void listCus(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //该功能仅对员工开放
        CustomerDao dao = new CustomerDao();
        List<Customer> cuss = dao.listCustomer();
        //将数据设置到请求中
        req.setAttribute("cuss", cuss);
        //通过身份证号识别登录的用户
        String userCard = req.getParameter("userCard");
        EmpDao dao2 = new EmpDao();
        Emp user = dao2.findEmpByIdCard(userCard);
        req.setAttribute("user", user);
        //通过转发器将数据交给jsp
        req.getRequestDispatcher("/cus/cuslist.jsp").forward(req, resp);
    }

    private void toAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String mode = req.getParameter("mode");
        if (mode.equals("1")) {
            //员工模式
            String userCard = req.getParameter("userCard");
            req.setAttribute("title", "Add Customer");
            req.setAttribute("url1", "/cus?opt=addCus&userCard=" + userCard + "&mode=1");
            req.setAttribute("url2", "/cus?opt=list&userCard=" + userCard);
        } else if (mode.equals("2")) {
            //用户模式
            req.setAttribute("title", "User Register");
            req.setAttribute("url1", "/cus?opt=addCus" + "&mode=2");
            req.setAttribute("url2", "/cus?opt=toLogin");
        }
        req.getRequestDispatcher("/cus/add.jsp").forward(req, resp);
    }

    private void addCus(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String nickname = req.getParameter("nickname");
        String gender = req.getParameter("gender");
        String phone = req.getParameter("phone");
        String addr = req.getParameter("addr");
        String sign = req.getParameter("sign");
        String ques = req.getParameter("ques");
        String ans = req.getParameter("ans");
        System.out.println(username+phone+nickname+gender+phone);
        if (gender == null) {
            gender = "";
        }
        String mode = req.getParameter("mode");
        if (!CheckUtils.checkCustomer(username, password, phone).equals("correct")) {
            if (mode.equals("1")) {
                String userCard = req.getParameter("userCard");
                req.setAttribute("url", "/cus?opt=toAdd&userCard=" + userCard + "&mode=" + mode);
            } else {
                req.setAttribute("url", "/cus?opt=toAdd&mode=" + mode);
            }
            req.setAttribute("inf", CheckUtils.checkCustomer(username, password, phone));
            req.getRequestDispatcher("/emp/error.jsp").forward(req, resp);
        } else {
            CustomerDao dao = new CustomerDao();
            //检查用户名是否已被注册
            Customer existCus = dao.findCustomerByName(username);
            if (existCus != null) {
                if (mode.equals("1")) {
                    String userCard = req.getParameter("userCard");
                    req.setAttribute("url", "/cus?opt=toAdd&userCard=" + userCard + "&mode=" + mode);
                } else {
                    req.setAttribute("url", "/cus?opt=toAdd" + "&mode=" + mode);
                }
//                req.setAttribute("inf", "The username has been registered!");
//                req.getRequestDispatcher("/emp/error.jsp").forward(req, resp);
                resp.getWriter().write("username_error");
            } else {
                password = Md5Utils.md5(password);
                Customer cus = new Customer(null, username, password, nickname, gender, phone, addr, sign, ques, ans);
                Integer count = dao.insertCustomer(cus);
                if (count > 0) {
                    if (mode.equals("1")) {
                        String userCard = req.getParameter("userCard");
                        resp.sendRedirect("/cus?opt=list&userCard=" + userCard);
                    } else if (mode.equals("2")) {
//                        req.setAttribute("url", "/cus?opt=toLogin");
//                        req.setAttribute("inf", "Registration succeeded! Please re-enter the username and password to log in");
//                        req.getRequestDispatcher("/emp/error.jsp").forward(req, resp);
                        resp.getWriter().write("success");
                    }
                }
            }
        }
    }

    private void toDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //该功能仅对员工开放
        String customerId = req.getParameter("customerId");
        String userCard = req.getParameter("userCard");
        CustomerDao dao = new CustomerDao();
        Customer cus = dao.findCustomerById(Integer.parseInt(customerId));
        String username = cus.getUsername();
        req.setAttribute("inf", "Delete" + username + "?");
        req.setAttribute("url1", "/cus?opt=list&userCard=" + userCard);
        req.setAttribute("url2", "/cus?opt=deleteCus&customerId=" + customerId + "&userCard=" + userCard);
        req.getRequestDispatcher("/emp/confirm.jsp").forward(req, resp);
    }

    private void deleteCus(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String customerId = req.getParameter("customerId");
        CustomerDao dao = new CustomerDao();
        Integer count = dao.deleteCustomer(Integer.parseInt(customerId));
        String userCard = req.getParameter("userCard");
        if (count > 0) {
            resp.sendRedirect("/cus?opt=list&userCard=" + userCard);
        }
    }

    private void toEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String customerId = req.getParameter("customerId");
        CustomerDao dao = new CustomerDao();
        Customer cus = dao.findCustomerById(Integer.parseInt(customerId));
        String male = "";
        String female = "";
        if (cus.getGender().equals("Male")) {
            male = "checked";
        } else if (cus.getGender().equals("Female")) {
            female = "checked";
        }
        req.setAttribute("cus", cus);
        req.setAttribute("male", male);
        req.setAttribute("female", female);
        String mode = req.getParameter("mode");
        if (mode.equals("1")) {
            //员工模式
            String userCard = req.getParameter("userCard");
            req.setAttribute("title", "Edit Customer");
            req.setAttribute("url1", "/cus?opt=editCus&userCard=" + userCard + "&mode=1");
            req.setAttribute("url2", "/cus?opt=list&userCard=" + userCard);
        } else if (mode.equals("2")) {
            //用户模式
            String userName = req.getParameter("userName");
            req.setAttribute("title", "Edit Personal Information");
            req.setAttribute("url1", "/cus?opt=editCus&userName=" + userName + "&mode=2");
            req.setAttribute("url2", "/cus?opt=show&userName=" + userName);
        }
        //  通过转发器 将数据交给jsp继续处理
        req.getRequestDispatcher("/cus/edit.jsp").forward(req, resp);
    }

    private void editCus(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String customerId = req.getParameter("customerId");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String nickname = req.getParameter("nickname");
        String gender = req.getParameter("gender");
        String phone = req.getParameter("phone");
        String addr = req.getParameter("addr");
        String sign = req.getParameter("sign");
        String question = req.getParameter("question");
        String answer = req.getParameter("answer");
        if (gender == null) {
            gender = "";
        }
        String mode = req.getParameter("mode");
        if (!CheckUtils.checkCustomer2(username, password, phone).equals("correct")) {
            if (mode.equals("1")) {
                String userCard = req.getParameter("userCard");
                req.setAttribute("url", "/cus?opt=toEdit&customerId=" + customerId + "&userCard=" + userCard + "&mode=" + mode);
            } else {
                String userName = req.getParameter("userName");
                req.setAttribute("url", "/cus?opt=toEdit&customerId=" + customerId + "&userName=" + userName + "&mode=" + mode);
            }
            req.setAttribute("inf", CheckUtils.checkCustomer2(username, password, phone));
            req.getRequestDispatcher("/emp/error.jsp").forward(req, resp);
        } else {
            CustomerDao dao = new CustomerDao();
            //检查用户名是否已被注册
            Customer existCus = dao.findCustomerByName(username);
            Customer selfCus = dao.findCustomerById(Integer.parseInt(customerId));
            if (existCus != null && !selfCus.getUsername().equals(username)) {
                if (mode.equals("1")) {
                    String userCard = req.getParameter("userCard");
                    req.setAttribute("url", "/cus?opt=toEdit&customerId=" + customerId + "&userCard=" + userCard + "&mode=" + mode);
                } else {
                    String userName = req.getParameter("userName");
                    req.setAttribute("url", "/cus?opt=toEdit&customerId=" + customerId + "&userName=" + userName + "&mode=" + mode);
                }
                req.setAttribute("inf", "The username has been registered!");
                req.getRequestDispatcher("/emp/error.jsp").forward(req, resp);
            } else {
                if (password.equals("")) {
                    //不输入密码则保持原密码
                    password = dao.findCustomerById(Integer.parseInt(customerId)).getPassword();
                } else {
                    password = Md5Utils.md5(password);
                }
                Customer cus = new Customer(null, username, password, nickname, gender, phone, addr, sign, question, answer);
                Integer count = dao.updateCustomer(cus, Integer.parseInt(customerId));
                if (count > 0) {
                    //重新刷新列表页面
                    if (mode.equals("1")) {
                        String userCard = req.getParameter("userCard");
                        resp.sendRedirect("/cus?opt=list&userCard=" + userCard);
                    } else if (mode.equals("2")) {
                        String userName = req.getParameter("userName");
                        resp.sendRedirect("/cus?opt=index&userName=" + userName);
                    }
                }
            }
        }
    }


    private Customer checkAccount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String account = req.getParameter("account");
        String question = req.getParameter("question");
        String answer = req.getParameter("answer");

        CustomerDao dao = new CustomerDao();
        Customer cus = dao.findCustomerByName(account);
        System.out.println("cus = " + cus);


        ObjectMapper mapper = new ObjectMapper();
        String cusJson = mapper.writeValueAsString(cus);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(cusJson);

        return cus;

    }

    private void changePSD(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String newPSD = req.getParameter("newPassword");
        String name = req.getParameter("name");

        String regex = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[a-z])[0-9a-zA-Z]{8,16}$";

        if (newPSD.matches(regex)) {
            CustomerDao dao = new CustomerDao();
            Customer cus = dao.findCustomerByName(name);

            newPSD = Md5Utils.md5(newPSD);
            cus.setPassword(newPSD);
            dao.updateCustomer(cus, cus.getCustomerId());
            resp.getWriter().write("success");
        } else {
            resp.getWriter().write("format failed");
        }



    }
}
