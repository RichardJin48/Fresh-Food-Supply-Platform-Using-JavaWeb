package com.cdut.web;

import com.cdut.dao.CustomerDao;
import com.cdut.dao.EmpDao;
import com.cdut.dao.OrderDao;
import com.cdut.entity.Customer;
import com.cdut.entity.Emp;
import com.cdut.entity.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@WebServlet(name = "ReturnServlet", urlPatterns = "/return")
public class ReturnServlet extends HttpServlet {
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
            listOrder(req, resp);
        }
        else if("toAdd".equals(opt)){
            toAdd(req, resp);
        }
        else if("addOrder".equals(opt)){
            addOrder(req, resp);
        }
        else if("toDelete".equals(opt)){
            toDelete(req, resp);
        }
        else if("deleteOrder".equals(opt)){
            deleteOrder(req, resp);
        }
        else if("toEdit".equals(opt)){
            toEdit(req, resp);
        }
        else if("editOrder".equals(opt)){
            editOrder(req, resp);
        }
        else if("list2".equals(opt)) {
            listOrder2(req, resp);
        }
        else if("addOrder2".equals(opt)){
            addOrder2(req, resp);
        }
        else if("toDelete2".equals(opt)){
            toDelete2(req, resp);
        }
        else if("deleteOrder2".equals(opt)){
            deleteOrder2(req, resp);
        }
        else if("toEdit2".equals(opt)){
            toEdit2(req, resp);
        }
        else if("editOrder2".equals(opt)){
            editOrder2(req, resp);
        }
        else if("send".equals(opt)){
            send(req, resp);
        }
        else if("receive".equals(opt)){
            receive(req, resp);
        }
        else if("cancel".equals(opt)){
            cancel(req, resp);
        }
    }

    private void listOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        OrderDao dao = new OrderDao();
        List<Order> orders = dao.listReturn();
        //将数据设置到请求中
        req.setAttribute("orders",orders);
        //通过身份证号识别登录的用户
        String userCard = req.getParameter("userCard");
        EmpDao dao2 = new EmpDao();
        Emp user = dao2.findEmpByIdCard(userCard);
        req.setAttribute("user",user);
        //通过转发器将数据交给jsp
        req.getRequestDispatcher("/return/orderlist.jsp").forward(req,resp);
    }

    private void listOrder2(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        OrderDao dao = new OrderDao();
        String userName = req.getParameter("userName");
        CustomerDao dao2 = new CustomerDao();
        Customer user = dao2.findCustomerByName(userName);
        req.setAttribute("user",user);
        List<Order> orders = dao.listReturnById(user.getCustomerId());
        req.setAttribute("orders",orders);
        //通过转发器将数据交给jsp
        req.getRequestDispatcher("/return/orderlist2.jsp").forward(req,resp);
    }

    private void toAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userCard = req.getParameter("userCard");
        req.setAttribute("title","Add an Return Order");
        req.setAttribute("url1","/return?opt=addOrder&userCard="+userCard);//点击确认后跳转链接
        req.setAttribute("url2","/return?opt=list&userCard="+userCard);//点击取消后跳转链接
        req.getRequestDispatcher("/return/add.jsp").forward(req,resp);
    }

    private void addOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer customerId = Integer.parseInt(req.getParameter("customerId"));
        Long productId = Long.parseLong(req.getParameter("productId"));
        String orderSn = Integer.toString(customerId);
        orderSn += "-";
        orderSn += Long.toString(productId);
        orderSn += "-s";
        String shippingUser = req.getParameter("shippingUser");
        String phone = req.getParameter("phone");
        String address = req.getParameter("address");
        BigDecimal orderMoney = new BigDecimal(req.getParameter("orderMoney"));
        Integer productAmount = Integer.parseInt(req.getParameter("productAmount"));
        Timestamp createTime = new Timestamp(System.currentTimeMillis());
        Timestamp shippingTime = Timestamp.valueOf(req.getParameter("shippingTime"));
        Timestamp receiveTime = Timestamp.valueOf(req.getParameter("receiveTime"));
        if(req.getParameter("shippingTime").equals("")){
            shippingTime = null;
        }
        if(req.getParameter("receiveTime").equals("")){
            receiveTime = null;
        }
        Byte orderStatus = Byte.parseByte(req.getParameter("orderStatus"));
        Order order = new Order(null,orderSn,customerId,productId,shippingUser,phone,address,orderMoney,productAmount,createTime,shippingTime,receiveTime,orderStatus);
        OrderDao dao = new OrderDao();
        Integer count = dao.insertOrder(order);
        String userCard = req.getParameter("userCard");
        if (count > 0) {
            resp.sendRedirect("/return?opt=list&userCard=" + userCard);
        }
    }

    private void addOrder2(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        String orderId = req.getParameter("orderId");
        OrderDao dao = new OrderDao();
        Order order = dao.findOrderById(Long.parseLong(orderId));
        order.setOrderStatus((byte) 3);
        order.setCreateTime(new Timestamp(System.currentTimeMillis()));
        dao.updateOrder(order,Long.parseLong(orderId));
        resp.sendRedirect("/order?opt=list2&userName=" + userName);
    }

    private void send(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        String orderId = req.getParameter("orderId");
        OrderDao dao = new OrderDao();
        Order order = dao.findOrderById(Long.parseLong(orderId));
        order.setShippingTime(new Timestamp(System.currentTimeMillis()));
        order.setReceiveTime(null);
        dao.updateOrder(order,Long.parseLong(orderId));
        resp.sendRedirect("/return?opt=list2&userName=" + userName);
    }

    private void receive(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userCard = req.getParameter("userCard");
        String orderId = req.getParameter("orderId");
        OrderDao dao = new OrderDao();
        Order order = dao.findOrderById(Long.parseLong(orderId));
        order.setOrderStatus((byte) 4);
        order.setReceiveTime(new Timestamp(System.currentTimeMillis()));
        dao.updateOrder(order,Long.parseLong(orderId));
        resp.sendRedirect("/return?opt=list&userCard=" + userCard);
    }

    private void cancel(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        String orderId = req.getParameter("orderId");
        OrderDao dao = new OrderDao();
        Order order = dao.findOrderById(Long.parseLong(orderId));
        order.setOrderStatus((byte) 2);
        dao.updateOrder(order,Long.parseLong(orderId));
        resp.sendRedirect("/return?opt=list2&userName=" + userName);
    }

    private void toDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String orderId = req.getParameter("orderId");
        String userCard = req.getParameter("userCard");
        OrderDao dao = new OrderDao();
        Order order = dao.findOrderById(Long.parseLong(orderId));
        String sn = order.getOrderSn();
        req.setAttribute("inf","Delete the return order "+sn+"?");
        req.setAttribute("url1","/return?opt=list&userCard="+userCard);//点击取消后跳转链接
        req.setAttribute("url2","/return?opt=deleteOrder&orderId="+orderId+"&userCard="+userCard);//点击确认后跳转链接
        req.getRequestDispatcher("/emp/confirm.jsp").forward(req, resp);
    }

    private void deleteOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String orderId = req.getParameter("orderId");
        OrderDao dao = new OrderDao();
        Integer count = dao.deleteOrder(Long.parseLong(orderId));
        String userCard = req.getParameter("userCard");
        if(count>0){
            resp.sendRedirect("/return?opt=list&userCard="+userCard);
        }
    }

    private void toDelete2(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String orderId = req.getParameter("orderId");
        String userName = req.getParameter("userName");
        OrderDao dao = new OrderDao();
        Order order = dao.findOrderById(Long.parseLong(orderId));
        String sn = order.getOrderSn();
        req.setAttribute("inf","Delete the return order "+sn+"?");
        req.setAttribute("url1","/return?opt=list2&userName="+userName);//点击取消后跳转链接
        req.setAttribute("url2","/return?opt=deleteOrder2&orderId="+orderId+"&userName="+userName);//点击确认后跳转链接
        req.getRequestDispatcher("/emp/confirm.jsp").forward(req, resp);
    }

    private void deleteOrder2(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String orderId = req.getParameter("orderId");
        OrderDao dao = new OrderDao();
        Integer count = dao.deleteOrder(Long.parseLong(orderId));
        String userName = req.getParameter("userName");
        if(count>0){
            resp.sendRedirect("/return?opt=list2&userName="+userName);
        }
    }

    private void toEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String orderId = req.getParameter("orderId");
        OrderDao dao = new OrderDao();
        Order order = dao.findOrderById(Long.parseLong(orderId));
        req.setAttribute("order",order);
        String userCard = req.getParameter("userCard");
        req.setAttribute("title","Edit the Return Order");
        req.setAttribute("url1","/return?opt=editOrder&userCard="+userCard);//点击确认后跳转链接
        req.setAttribute("url2","/return?opt=list&userCard="+userCard);//点击取消后跳转链接
        req.getRequestDispatcher("/return/edit.jsp").forward(req,resp);
    }

    private void editOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        OrderDao dao = new OrderDao();
        String orderId = req.getParameter("orderId");
        String orderSn = req.getParameter("orderSn");
        Integer customerId = Integer.parseInt(req.getParameter("customerId"));
        Long productId = Long.parseLong(req.getParameter("productId"));
        String shippingUser = req.getParameter("shippingUser");
        String phone = req.getParameter("phone");
        String address = req.getParameter("address");
        BigDecimal orderMoney = new BigDecimal(req.getParameter("orderMoney"));
        Integer productAmount = Integer.parseInt(req.getParameter("productAmount"));
        Timestamp createTime = dao.findOrderById(Long.parseLong(orderId)).getCreateTime();
        Timestamp shippingTime = Timestamp.valueOf(req.getParameter("shippingTime"));
        Timestamp receiveTime = Timestamp.valueOf(req.getParameter("receiveTime"));
        if(req.getParameter("shippingTime").equals("")){
            shippingTime = null;
        }
        if(req.getParameter("receiveTime").equals("")){
            receiveTime = null;
        }
        Byte orderStatus = Byte.parseByte(req.getParameter("orderStatus"));
        Order order = new Order(null,orderSn,customerId,productId,shippingUser,phone,address,orderMoney,productAmount,createTime,shippingTime,receiveTime,orderStatus);
        Integer count = dao.updateOrder(order, Long.parseLong(orderId));
        if (count > 0) {
            //重新刷新列表页面
            String userCard = req.getParameter("userCard");
            resp.sendRedirect("/return?opt=list&userCard=" + userCard);
        }
    }

    private void toEdit2(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String orderId = req.getParameter("orderId");
        OrderDao dao = new OrderDao();
        Order order = dao.findOrderById(Long.parseLong(orderId));
        req.setAttribute("order",order);
        String userName = req.getParameter("userName");
        req.setAttribute("title","Edit the Return Order");
        req.setAttribute("url1","/return?opt=editOrder2&userName="+userName);//点击确认后跳转链接
        req.setAttribute("url2","/return?opt=list2&userName="+userName);//点击取消后跳转链接
        req.getRequestDispatcher("/return/edit2.jsp").forward(req,resp);
    }

    private void editOrder2(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        OrderDao dao = new OrderDao();
        String orderId = req.getParameter("orderId");
        Order order = dao.findOrderById(Long.parseLong(orderId));
        String shippingUser = req.getParameter("shippingUser");
        String phone = req.getParameter("phone");
        String address = req.getParameter("address");
        order.setShippingUser(shippingUser);
        order.setPhone(phone);
        order.setAddress(address);
        Integer count = dao.updateOrder(order, Long.parseLong(orderId));
        if (count > 0) {
            //重新刷新列表页面
            String userName = req.getParameter("userName");
            resp.sendRedirect("/return?opt=list2&userName=" + userName);
        }
    }
}
