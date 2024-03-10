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
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@WebServlet(name = "OrderServlet", urlPatterns = "/order")
public class OrderServlet extends HttpServlet {
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
        else if("toBuy".equals(opt)){
            toBuy(req, resp);
        }
        else if("buy".equals(opt)){
            buy(req, resp);
        }
        else if("toBuy2".equals(opt)){
            toBuy2(req, resp);
        }
        else if("buy2".equals(opt)){
            buy2(req, resp);
        }
        else if("toBuy3".equals(opt)){
            toBuy3(req, resp);
        }
        else if("buy3".equals(opt)){
            buy3(req, resp);
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
        else if("rebuy".equals(opt)){
            rebuy(req, resp);
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
    }

    private void listOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        OrderDao dao = new OrderDao();
        List<Order> orders = dao.listOrder();
        //将数据设置到请求中
        req.setAttribute("orders",orders);
        //通过身份证号识别登录的用户
        String userCard = req.getParameter("userCard");
        EmpDao dao2 = new EmpDao();
        Emp user = dao2.findEmpByIdCard(userCard);
        req.setAttribute("user",user);
        //通过转发器将数据交给jsp
        req.getRequestDispatcher("/order/orderlist.jsp").forward(req,resp);
    }

    private void listOrder2(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        OrderDao dao = new OrderDao();
        String userName = req.getParameter("userName");
        CustomerDao dao2 = new CustomerDao();
        Customer user = dao2.findCustomerByName(userName);
        req.setAttribute("user",user);
        List<Order> orders = dao.listOrderById(user.getCustomerId());
        req.setAttribute("orders",orders);
        //通过转发器将数据交给jsp
        req.getRequestDispatcher("/order/orderlist2.jsp").forward(req,resp);
    }

    private void toAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userCard = req.getParameter("userCard");
        req.setAttribute("title","Add an Order");
        req.setAttribute("url1","/order?opt=addOrder&userCard="+userCard);//点击确认后跳转链接
        req.setAttribute("url2","/order?opt=list&userCard="+userCard);//点击取消后跳转链接
        req.getRequestDispatcher("/order/add.jsp").forward(req,resp);
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
            resp.sendRedirect("/order?opt=list&userCard=" + userCard);
        }
    }

    private void toBuy(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        req.setAttribute("title","Create a New Order");
        req.setAttribute("url1","/order?opt=buy&userName="+userName);//点击确认后跳转链接
        req.setAttribute("url2","/shoppingCart?opt=list2&userName="+userName);//点击取消后跳转链接
        req.getRequestDispatcher("/order/buy.jsp").forward(req,resp);
    }

    private void buy(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        OrderDao dao = new OrderDao();
        CustomerDao dao2 = new CustomerDao();
        ShoppingCartDao dao3 = new ShoppingCartDao();
        ProductDao dao4 = new ProductDao();
        Customer user = dao2.findCustomerByName(userName);
        List<ShoppingCart> shoppingCarts = dao3.listShoppingCartById(user.getCustomerId());
        for(ShoppingCart shoppingCart:shoppingCarts) {
            String orderSn = Integer.toString(shoppingCart.getCustomerId());
            orderSn += "-";
            orderSn += Long.toString(shoppingCart.getProductId());
            orderSn += "-";
            orderSn += Long.toString(shoppingCart.getCartId());
            Integer customerId = shoppingCart.getCustomerId();
            Long productId = shoppingCart.getProductId();
            Product product = dao4.findProductById(productId);
            String shippingUser = req.getParameter("shippingUser");
            String phone = req.getParameter("phone");
            String address = req.getParameter("address");
            BigDecimal orderMoney = shoppingCart.getPrice();
            Integer productAmount = shoppingCart.getProductAmount();
            Timestamp createTime = new Timestamp(System.currentTimeMillis());
            Byte orderStatus = Byte.parseByte("1");
            Order order = new Order(null, orderSn, customerId, productId, shippingUser, phone, address, orderMoney, productAmount, createTime, null, null, orderStatus);
            dao.insertOrder(order);
            dao3.deleteShoppingCart(shoppingCart.getCartId());
            product.setStock(product.getStock()-productAmount);
            product.setSalesVolume(product.getSalesVolume()+productAmount);
            dao4.updateProduct(product, productId);
        }
        resp.sendRedirect("/order?opt=list2&userName=" + userName);
    }

    private void toBuy2(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        String productId = req.getParameter("productId");
        req.setAttribute("title","Create a New Order");
        req.setAttribute("url1","/order?opt=buy2&userName="+userName+"&productId="+productId);//点击确认后跳转链接
        req.setAttribute("url2","/product?opt=show&productId="+productId+"&userName="+userName);//点击取消后跳转链接
        req.getRequestDispatcher("/order/buy2.jsp").forward(req,resp);
    }

    private void buy2(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        String productId = req.getParameter("productId");
        OrderDao dao = new OrderDao();
        CustomerDao dao2 = new CustomerDao();
        ProductDao dao3 = new ProductDao();
        Customer user = dao2.findCustomerByName(userName);
        Product product = dao3.findProductById(Long.parseLong(productId));
        String orderSn = Integer.toString(user.getCustomerId());
        orderSn += "-";
        orderSn += Long.toString(product.getProductId());
        orderSn += "-d";
        Integer customerId = user.getCustomerId();
        String shippingUser = req.getParameter("shippingUser");
        String phone = req.getParameter("phone");
        String address = req.getParameter("address");
        Integer productAmount = Integer.parseInt(req.getParameter("productAmount"));
        BigDecimal orderMoney = product.getPrice().multiply(BigDecimal.valueOf(productAmount));
        Timestamp createTime = new Timestamp(System.currentTimeMillis());
        Byte orderStatus = Byte.parseByte("1");
        Order order = new Order(null, orderSn, customerId, Long.parseLong(productId), shippingUser, phone, address, orderMoney, productAmount, createTime, null, null, orderStatus);
        dao.insertOrder(order);
        product.setStock(product.getStock()-productAmount);
        product.setSalesVolume(product.getSalesVolume()+productAmount);
        dao3.updateProduct(product, Long.parseLong(productId));
        resp.sendRedirect("/order?opt=list2&userName=" + userName);
    }

    private void toBuy3(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        String cartId = req.getParameter("cartId");
        req.setAttribute("title","Create a New Order");
        req.setAttribute("url1","/order?opt=buy3&userName="+userName+"&cartId="+cartId);//点击确认后跳转链接
        req.setAttribute("url2","/shoppingCart?opt=list2&userName="+userName);//点击取消后跳转链接
        req.getRequestDispatcher("/order/buy.jsp").forward(req,resp);
    }

    private void buy3(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        String cartId = req.getParameter("cartId");
        OrderDao dao = new OrderDao();
        ShoppingCartDao dao2 = new ShoppingCartDao();
        ProductDao dao3 = new ProductDao();
        ShoppingCart shoppingCart = dao2.findShoppingCartById(Long.parseLong(cartId));
        String orderSn = Integer.toString(shoppingCart.getCustomerId());
        orderSn += "-";
        orderSn += Long.toString(shoppingCart.getProductId());
        orderSn += "-";
        orderSn += Long.toString(shoppingCart.getCartId());
        Integer customerId = shoppingCart.getCustomerId();
        Long productId = shoppingCart.getProductId();
        Product product = dao3.findProductById(productId);
        String shippingUser = req.getParameter("shippingUser");
        String phone = req.getParameter("phone");
        String address = req.getParameter("address");
        BigDecimal orderMoney = shoppingCart.getPrice();
        Integer productAmount = shoppingCart.getProductAmount();
        Timestamp createTime = new Timestamp(System.currentTimeMillis());
        Byte orderStatus = Byte.parseByte("1");
        Order order = new Order(null, orderSn, customerId, productId, shippingUser, phone, address, orderMoney, productAmount, createTime, null, null, orderStatus);
        dao.insertOrder(order);
        dao2.deleteShoppingCart(shoppingCart.getCartId());
        product.setStock(product.getStock()-productAmount);
        product.setSalesVolume(product.getSalesVolume()+productAmount);
        dao3.updateProduct(product, productId);
        resp.sendRedirect("/order?opt=list2&userName=" + userName);
    }

    private void send(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userCard = req.getParameter("userCard");
        String orderId = req.getParameter("orderId");
        OrderDao dao = new OrderDao();
        Order order = dao.findOrderById(Long.parseLong(orderId));
        order.setShippingTime(new Timestamp(System.currentTimeMillis()));
        order.setReceiveTime(null);
        dao.updateOrder(order,Long.parseLong(orderId));
        resp.sendRedirect("/order?opt=list&userCard=" + userCard);
    }

    private void receive(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        String orderId = req.getParameter("orderId");
        OrderDao dao = new OrderDao();
        Order order = dao.findOrderById(Long.parseLong(orderId));
        order.setOrderStatus((byte) 2);
        order.setReceiveTime(new Timestamp(System.currentTimeMillis()));
        dao.updateOrder(order,Long.parseLong(orderId));
        resp.sendRedirect("/order?opt=list2&userName=" + userName);
    }

    private void cancel(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        String orderId = req.getParameter("orderId");
        OrderDao dao = new OrderDao();
        Order order = dao.findOrderById(Long.parseLong(orderId));
        order.setOrderStatus((byte) 0);
        dao.updateOrder(order,Long.parseLong(orderId));
        ProductDao dao2 = new ProductDao();
        Product product = dao2.findProductById(order.getProductId());
        product.setStock(product.getStock()+order.getProductAmount());
        product.setSalesVolume(product.getSalesVolume()-order.getProductAmount());
        dao2.updateProduct(product, order.getProductId());
        resp.sendRedirect("/order?opt=list2&userName=" + userName);
    }

    private void rebuy(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        String orderId = req.getParameter("orderId");
        OrderDao dao = new OrderDao();
        Order order = dao.findOrderById(Long.parseLong(orderId));
        order.setOrderStatus((byte) 1);
        order.setCreateTime(new Timestamp(System.currentTimeMillis()));
        dao.updateOrder(order,Long.parseLong(orderId));
        ProductDao dao2 = new ProductDao();
        Product product = dao2.findProductById(order.getProductId());
        product.setStock(product.getStock()-order.getProductAmount());
        product.setSalesVolume(product.getSalesVolume()+order.getProductAmount());
        dao2.updateProduct(product, order.getProductId());
        resp.sendRedirect("/order?opt=list2&userName=" + userName);
    }

    private void toDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String orderId = req.getParameter("orderId");
        String userCard = req.getParameter("userCard");
        OrderDao dao = new OrderDao();
        Order order = dao.findOrderById(Long.parseLong(orderId));
        String sn = order.getOrderSn();
        req.setAttribute("inf","Delete the order "+sn+"?");
        req.setAttribute("url1","/order?opt=list&userCard="+userCard);//点击取消后跳转链接
        req.setAttribute("url2","/order?opt=deleteOrder&orderId="+orderId+"&userCard="+userCard);//点击确认后跳转链接
        req.getRequestDispatcher("/emp/confirm.jsp").forward(req, resp);
    }

    private void deleteOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String orderId = req.getParameter("orderId");
        OrderDao dao = new OrderDao();
        Integer count = dao.deleteOrder(Long.parseLong(orderId));
        String userCard = req.getParameter("userCard");
        if(count>0){
            resp.sendRedirect("/order?opt=list&userCard="+userCard);
        }
    }

    private void toDelete2(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String orderId = req.getParameter("orderId");
        String userName = req.getParameter("userName");
        OrderDao dao = new OrderDao();
        Order order = dao.findOrderById(Long.parseLong(orderId));
        String sn = order.getOrderSn();
        req.setAttribute("inf","Delete the order "+sn+"?");
        req.setAttribute("url1","/order?opt=list2&userName="+userName);//点击取消后跳转链接
        req.setAttribute("url2","/order?opt=deleteOrder2&orderId="+orderId+"&userName="+userName);//点击确认后跳转链接
        req.getRequestDispatcher("/emp/confirm.jsp").forward(req, resp);
    }

    private void deleteOrder2(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String orderId = req.getParameter("orderId");
        OrderDao dao = new OrderDao();
        Integer count = dao.deleteOrder(Long.parseLong(orderId));
        String userName = req.getParameter("userName");
        if(count>0){
            resp.sendRedirect("/order?opt=list2&userName="+userName);
        }
    }

    private void toEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String orderId = req.getParameter("orderId");
        OrderDao dao = new OrderDao();
        Order order = dao.findOrderById(Long.parseLong(orderId));
        req.setAttribute("order",order);
        String userCard = req.getParameter("userCard");
        req.setAttribute("title","Edit the Order");
        req.setAttribute("url1","/order?opt=editOrder&userCard="+userCard);//点击确认后跳转链接
        req.setAttribute("url2","/order?opt=list&userCard="+userCard);//点击取消后跳转链接
        req.getRequestDispatcher("/order/edit.jsp").forward(req,resp);
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
            resp.sendRedirect("/order?opt=list&userCard=" + userCard);
        }
    }

    private void toEdit2(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String orderId = req.getParameter("orderId");
        OrderDao dao = new OrderDao();
        Order order = dao.findOrderById(Long.parseLong(orderId));
        req.setAttribute("order",order);
        String userName = req.getParameter("userName");
        req.setAttribute("title","Edit the Order");
        req.setAttribute("url1","/order?opt=editOrder2&userName="+userName);//点击确认后跳转链接
        req.setAttribute("url2","/order?opt=list2&userName="+userName);//点击取消后跳转链接
        req.getRequestDispatcher("/order/edit2.jsp").forward(req,resp);
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
            resp.sendRedirect("/order?opt=list2&userName=" + userName);
        }
    }
}
