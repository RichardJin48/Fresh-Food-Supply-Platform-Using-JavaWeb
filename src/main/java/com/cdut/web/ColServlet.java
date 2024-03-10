package com.cdut.web;

import com.cdut.dao.BehDao;
import com.cdut.dao.CustomerDao;
import com.cdut.dao.EmpDao;
import com.cdut.entity.Beh;
import com.cdut.entity.Customer;
import com.cdut.entity.Emp;
import com.cdut.dao.ProductDao;
import com.cdut.entity.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ColServlet", urlPatterns = "/col")
public class ColServlet extends HttpServlet {
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
            listBeh(req, resp);
        }
        else if("toAdd".equals(opt)){
            toAdd(req, resp);
        }
        else if("addBeh".equals(opt)){
            addBeh(req, resp);
        }
        else if("toDelete".equals(opt)){
            toDelete(req, resp);
        }
        else if("deleteBeh".equals(opt)){
            deleteBeh(req, resp);
        }
        else if("list2".equals(opt)) {
            listBeh2(req, resp);
        }
        else if("addBeh2".equals(opt)){
            addBeh2(req, resp);
        }
        else if("addBeh3".equals(opt)){
            addBeh3(req, resp);
        }
        else if("addBeh4".equals(opt)){
            addBeh4(req, resp);
        }
        else if("toDelete2".equals(opt)){
            toDelete2(req, resp);
        }
        else if("deleteBeh2".equals(opt)){
            deleteBeh2(req, resp);
        }
        else if("show".equals(opt)){
            show(req, resp);
        }
        else if("show2".equals(opt)){
            show2(req, resp);
        }
    }

    private void listBeh(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BehDao dao = new BehDao();
        List<Beh> behs = dao.listCol();
        //将数据设置到请求中
        req.setAttribute("behs",behs);
        //通过身份证号识别登录的用户
        String userCard = req.getParameter("userCard");
        EmpDao dao2 = new EmpDao();
        Emp user = dao2.findEmpByIdCard(userCard);
        req.setAttribute("user",user);
        //通过转发器将数据交给jsp
        req.getRequestDispatcher("/col/collist.jsp").forward(req,resp);
    }

    private void listBeh2(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //查看指定用户的收藏，专为客户端设计
        String userName = req.getParameter("userName");
        CustomerDao dao2 = new CustomerDao();
        Customer user = dao2.findCustomerByName(userName);
        req.setAttribute("user",user);
        BehDao dao = new BehDao();
        List<Beh> behs = dao.listColById(user.getCustomerId());
        //将数据设置到请求中
        req.setAttribute("behs",behs);
        //通过转发器将数据交给jsp
        req.getRequestDispatcher("/col/collist2.jsp").forward(req,resp);
    }

    private void toAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userCard = req.getParameter("userCard");
        req.setAttribute("title","Add Collection");
        req.setAttribute("url1","/col?opt=addBeh&userCard="+userCard);//点击确认后跳转链接
        req.setAttribute("url2","/col?opt=list&userCard="+userCard);//点击取消后跳转链接
        req.getRequestDispatcher("/col/add.jsp").forward(req,resp);
    }

    private void addBeh(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String customerId = req.getParameter("customerId");
        String productId = req.getParameter("productId");
        Timestamp behTime = new Timestamp(System.currentTimeMillis());
        Beh beh = new Beh(null, Integer.parseInt(customerId), Long.parseLong(productId), 0, behTime, 1);
        BehDao dao = new BehDao();
        Integer count = dao.insertBeh(beh);
        String userCard = req.getParameter("userCard");
        if (count > 0) {
            resp.sendRedirect("/col?opt=list&userCard=" + userCard);
        }
    }

    private void addBeh2(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CustomerDao dao2 = new CustomerDao();
        String userName = req.getParameter("userName");
        Customer cus = dao2.findCustomerByName(userName);
        Integer customerId = cus.getCustomerId();
        String productId = req.getParameter("productId");
        Timestamp behTime = new Timestamp(System.currentTimeMillis());
        Beh beh = new Beh(null, customerId, Long.parseLong(productId), 0, behTime, 1);
        BehDao dao = new BehDao();
        List<Beh> behs = dao.searchCol(customerId,Integer.parseInt(productId));
        Integer count = 1;
        System.out.println(count);
        if(behs.size() == 0){
            count = dao.insertBeh(beh);
        }
        if (count > 0) {
            resp.sendRedirect("/product?opt=show&productId="+productId+"&userName="+userName);
        }
    }

    private void addBeh3(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CustomerDao dao2 = new CustomerDao();
        String userName = req.getParameter("userName");
        Customer cus = dao2.findCustomerByName(userName);
        Integer customerId = cus.getCustomerId();
        String productId = req.getParameter("productId");
        Timestamp behTime = new Timestamp(System.currentTimeMillis());
        Beh beh = new Beh(null, customerId, Long.parseLong(productId), 0, behTime, 1);
        BehDao dao = new BehDao();
        List<Beh> behs = dao.searchCol(customerId,Integer.parseInt(productId));
        Integer count = 1;
        if(behs.size() == 0){
            count = dao.insertBeh(beh);
        }
        String keyword = req.getParameter("keyword");
        if (count > 0) {
            resp.sendRedirect("/product?opt=search&userName=" + userName + "&keyword=" + keyword);
        }
    }

    private void addBeh4(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CustomerDao dao2 = new CustomerDao();
        String userName = req.getParameter("userName");
        Customer cus = dao2.findCustomerByName(userName);
        Integer customerId = cus.getCustomerId();
        String productId = req.getParameter("productId");
        Timestamp behTime = new Timestamp(System.currentTimeMillis());
        Beh beh = new Beh(null, customerId, Long.parseLong(productId), 0, behTime, 1);
        BehDao dao = new BehDao();
        List<Beh> behs = dao.searchCol(customerId,Integer.parseInt(productId));
        Integer count = 1;
        if(behs.size() == 0){
            count = dao.insertBeh(beh);
        }
        String category = req.getParameter("category");
        if (count > 0) {
            resp.sendRedirect("/product?opt=category&userName=" + userName + "&category=" + category);
        }
    }

    private void toDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String behId = req.getParameter("behId");
        String userCard = req.getParameter("userCard");
        req.setAttribute("inf","Delete this favorite?");
        req.setAttribute("url1","/col?opt=list&userCard="+userCard);//点击取消后跳转链接
        req.setAttribute("url2","/col?opt=deleteBeh&behId="+behId+"&userCard="+userCard);//点击确认后跳转链接
        req.getRequestDispatcher("/emp/confirm.jsp").forward(req, resp);
    }

    private void deleteBeh(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String behId = req.getParameter("behId");
        BehDao dao = new BehDao();
        Integer count = dao.deleteBeh(Integer.parseInt(behId));
        String userCard = req.getParameter("userCard");
        if(count>0){
            resp.sendRedirect("/col?opt=list&userCard="+userCard);
        }
    }

    private void toDelete2(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String behId = req.getParameter("behId");
        String userName = req.getParameter("userName");
        req.setAttribute("inf","Delete this favorite?");
        req.setAttribute("url1","/col?opt=list2&userName="+userName);//点击取消后跳转链接
        req.setAttribute("url2","/col?opt=deleteBeh2&behId="+behId+"&userName="+userName);//点击确认后跳转链接
        req.getRequestDispatcher("/emp/confirm.jsp").forward(req, resp);
    }

    private void deleteBeh2(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String behId = req.getParameter("behId");
        BehDao dao = new BehDao();
        Integer count = dao.deleteBeh(Integer.parseInt(behId));
        String userName = req.getParameter("userName");
        if(count>0){
            resp.sendRedirect("/col?opt=list2&userName="+userName);
        }
    }

    private void show(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String behId = req.getParameter("behId");
        BehDao dao = new BehDao();
        Beh beh = dao.findBehById(Integer.parseInt(behId));
        req.setAttribute("beh",beh);
        CustomerDao dao2 = new CustomerDao();
        ProductDao dao3 = new ProductDao();
        Customer cus = dao2.findCustomerById(beh.getCustomerId());
        Product pro = dao3.findProductById(beh.getProductId());
        if(cus != null) {
            req.setAttribute("cusName",cus.getNickname());
        }
        else{
            req.setAttribute("cusName","The customer is not found!");
        }
        if(pro != null) {
            req.setAttribute("proName", pro.getProductName());
        }
        else{
            req.setAttribute("proName", "The product is off the shelf!");
        }
        String userCard = req.getParameter("userCard");
        req.setAttribute("userCard",userCard);
        //通过转发器将数据交给jsp
        req.getRequestDispatcher("/col/show.jsp").forward(req,resp);
    }

    private void show2(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String behId = req.getParameter("behId");
        BehDao dao = new BehDao();
        Beh beh = dao.findBehById(Integer.parseInt(behId));
        req.setAttribute("beh",beh);
        CustomerDao dao2 = new CustomerDao();
        ProductDao dao3 = new ProductDao();
        Customer cus = dao2.findCustomerById(beh.getCustomerId());
        Product pro = dao3.findProductById(beh.getProductId());
        req.setAttribute("product", pro);
        if(pro != null) {
            req.setAttribute("proName", pro.getProductName());
        }
        else{
            req.setAttribute("proName", "The product is not found!");
        }
        String userName = req.getParameter("userName");
        req.setAttribute("userName",userName);
        //通过转发器将数据交给jsp
        req.getRequestDispatcher("/col/show2.jsp").forward(req,resp);
    }
}
