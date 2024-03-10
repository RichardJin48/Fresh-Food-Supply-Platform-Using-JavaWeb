package com.cdut.web;

import com.cdut.dao.*;
import com.cdut.entity.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@WebServlet(name = "ShoppingCartServlet", urlPatterns = "/shoppingCart")
public class ShoppingCartServlet extends HttpServlet {
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
            listShoppingCart(req, resp);
        }
        else if("toAdd".equals(opt)){
            toAdd(req, resp);
        }
        else if("addShoppingCart".equals(opt)){
            addShoppingCart(req, resp);
        }
        else if("toAdd2".equals(opt)){
            toAdd2(req, resp);
        }
        else if("addShoppingCart2".equals(opt)){
            addShoppingCart2(req, resp);
        }
        else if("toDelete".equals(opt)){
            toDelete(req, resp);
        }
        else if("deleteShoppingCart".equals(opt)){
            deleteShoppingCart(req, resp);
        }
        else if("toEdit".equals(opt)){
            toEdit(req, resp);
        }
        else if("editShoppingCart".equals(opt)){
            editShoppingCart(req, resp);
        }
        else if("list2".equals(opt)) {
            listShoppingCart2(req, resp);
        }
        else if("toDelete2".equals(opt)){
            toDelete2(req, resp);
        }
        else if("deleteShoppingCart2".equals(opt)){
            deleteShoppingCart2(req, resp);
        }
    }

    private void listShoppingCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ShoppingCartDao dao = new ShoppingCartDao();
        List<ShoppingCart> shoppingCarts = dao.listShoppingCart();
        //将数据设置到请求中
        req.setAttribute("shoppingCarts",shoppingCarts);
        //通过身份证号识别登录的用户
        String userCard = req.getParameter("userCard");
        EmpDao dao2 = new EmpDao();
        Emp user = dao2.findEmpByIdCard(userCard);
        req.setAttribute("user",user);
        //通过转发器将数据交给jsp
        req.getRequestDispatcher("/shoppingCart/shoppingCartlist.jsp").forward(req,resp);
    }

    private void listShoppingCart2(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        CustomerDao dao2 = new CustomerDao();
        Customer user = dao2.findCustomerByName(userName);
        req.setAttribute("user",user);
        ShoppingCartDao dao = new ShoppingCartDao();
        List<ShoppingCart> shoppingCarts = dao.listShoppingCartById(user.getCustomerId());
        //将数据设置到请求中
        req.setAttribute("shoppingCarts",shoppingCarts);
        //通过转发器将数据交给jsp
        req.getRequestDispatcher("/new/shoppingCart.jsp").forward(req,resp);
    }

    private void toAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userCard = req.getParameter("userCard");
        req.setAttribute("title","Add Shopping Cart");
        req.setAttribute("url1","/shoppingCart?opt=addShoppingCart&userCard="+userCard);//点击确认后跳转链接
        req.setAttribute("url2","/shoppingCart?opt=list&userCard="+userCard);//点击取消后跳转链接
        req.getRequestDispatcher("/shoppingCart/add.jsp").forward(req,resp);
    }

    private void addShoppingCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer customerId = Integer.parseInt(req.getParameter("customerId"));
        Long productId = Long.parseLong(req.getParameter("productId"));
        Integer productAmount = Integer.parseInt(req.getParameter("productAmount"));
        BigDecimal price = new BigDecimal(req.getParameter("price"));
        Timestamp addTime = new Timestamp(System.currentTimeMillis());
        Timestamp modifiedTime = new Timestamp(System.currentTimeMillis());
        ShoppingCart shoppingCart = new ShoppingCart(null,customerId,productId,productAmount,price,addTime,modifiedTime);
        ShoppingCartDao dao = new ShoppingCartDao();
        Integer count = dao.insertShoppingCart(shoppingCart);
        String userCard = req.getParameter("userCard");
        if (count > 0) {
            resp.sendRedirect("/shoppingCart?opt=list&userCard=" + userCard);
        }
    }

    private void toAdd2(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        String productId = req.getParameter("productId");
        req.setAttribute("title","Add to Cart");
        req.setAttribute("url1","/shoppingCart?opt=addShoppingCart2&productId="+productId+"&userName="+userName);//点击确认后跳转链接
        req.setAttribute("url2","/product?opt=show&productId="+productId+"&userName="+userName);//点击取消后跳转链接
        req.getRequestDispatcher("/shoppingCart/add2.jsp").forward(req,resp);
    }

    private void addShoppingCart2(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CustomerDao dao2 = new CustomerDao();
        String userName = req.getParameter("userName");
        Customer cus = dao2.findCustomerByName(userName);
        Integer customerId = cus.getCustomerId();
        Long productId = Long.parseLong(req.getParameter("productId"));
        ProductDao dao3 = new ProductDao();
        Product pro = dao3.findProductById(productId);
        Integer productAmount = Integer.parseInt(req.getParameter("productAmount"));
        BigDecimal price = pro.getPrice().multiply(BigDecimal.valueOf(productAmount));
        Timestamp addTime = new Timestamp(System.currentTimeMillis());
        Timestamp modifiedTime = new Timestamp(System.currentTimeMillis());
        ShoppingCart shoppingCart = new ShoppingCart(null,customerId,productId,productAmount,price,addTime,modifiedTime);
        ShoppingCartDao dao = new ShoppingCartDao();
        Integer count = dao.insertShoppingCart(shoppingCart);
        if (count > 0) {
            resp.sendRedirect("/product?opt=show&productId="+productId+"&userName="+userName);
        }
    }

    private void toDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cartId = req.getParameter("cartId");
        String userCard = req.getParameter("userCard");
        ShoppingCartDao dao = new ShoppingCartDao();
        ShoppingCart shoppingCart = dao.findShoppingCartById(Long.parseLong(cartId));
        req.setAttribute("inf","Delete this shopping cart information?");
        req.setAttribute("url1","/shoppingCart?opt=list&userCard="+userCard);//点击取消后跳转链接
        req.setAttribute("url2","/shoppingCart?opt=deleteShoppingCart&cartId="+cartId+"&userCard="+userCard);//点击确认后跳转链接
        req.getRequestDispatcher("/emp/confirm.jsp").forward(req, resp);
    }

    private void deleteShoppingCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cartId = req.getParameter("cartId");
        ShoppingCartDao dao = new ShoppingCartDao();
        Integer count = dao.deleteShoppingCart(Long.parseLong(cartId));
        String userCard = req.getParameter("userCard");
        if(count>0){
            resp.sendRedirect("/shoppingCart?opt=list&userCard="+userCard);
        }
    }

    private void toDelete2(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cartId = req.getParameter("cartId");
        String userName = req.getParameter("userName");
        ShoppingCartDao dao = new ShoppingCartDao();
        ShoppingCart shoppingCart = dao.findShoppingCartById(Long.parseLong(cartId));
        req.setAttribute("inf","Delete this shopping cart information?");
        req.setAttribute("url1","/shoppingCart?opt=list2&userName="+userName);//点击取消后跳转链接
        req.setAttribute("url2","/shoppingCart?opt=deleteShoppingCart2&cartId="+cartId+"&userName="+userName);//点击确认后跳转链接
        req.getRequestDispatcher("/emp/confirm.jsp").forward(req, resp);
    }

    private void deleteShoppingCart2(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cartId = req.getParameter("cartId");
        ShoppingCartDao dao = new ShoppingCartDao();
        Integer count = dao.deleteShoppingCart(Long.parseLong(cartId));
        String userName = req.getParameter("userName");
        if(count>0){
            resp.sendRedirect("/shoppingCart?opt=list2&userName="+userName);
        }
    }

    private void toEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cartId = req.getParameter("cartId");
        ShoppingCartDao dao = new ShoppingCartDao();
        ShoppingCart shoppingCart = dao.findShoppingCartById(Long.parseLong(cartId));
        req.setAttribute("shoppingCart",shoppingCart);
        String userCard = req.getParameter("userCard");
        req.setAttribute("title","Edit Shopping Cart");
        req.setAttribute("url1","/shoppingCart?opt=editShoppingCart&userCard="+userCard);//点击确认后跳转链接
        req.setAttribute("url2","/shoppingCart?opt=list&userCard="+userCard);//点击取消后跳转链接
        req.getRequestDispatcher("/shoppingCart/edit.jsp").forward(req,resp);
    }

    private void editShoppingCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ShoppingCartDao dao = new ShoppingCartDao();
        String cartId = req.getParameter("cartId");
        Integer customerId = Integer.parseInt(req.getParameter("customerId"));
        Long productId = Long.parseLong(req.getParameter("productId"));
        Integer productAmount = Integer.parseInt(req.getParameter("productAmount"));
        BigDecimal price = new BigDecimal(req.getParameter("price"));
        Timestamp addTime = dao.findShoppingCartById(Long.parseLong(cartId)).getAddTime();
        Timestamp modifiedTime = new Timestamp(System.currentTimeMillis());
        ShoppingCart shoppingCart = new ShoppingCart(null,customerId,productId,productAmount,price,addTime,modifiedTime);
        Integer count = dao.updateShoppingCart(shoppingCart, Long.parseLong(cartId));
        if (count > 0) {
            //重新刷新列表页面
            String userCard = req.getParameter("userCard");
            resp.sendRedirect("/shoppingCart?opt=list&userCard=" + userCard);
        }
    }
}
