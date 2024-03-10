package com.cdut.dao;

//该类提供java和数据之间关系的类

import com.cdut.entity.Order;
import com.cdut.utils.JDBCUtils;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.sql.Date;
import java.util.List;

public class OrderDao {
    //获取数据集合，获取数据库中emp数据
    public List<Order> listAllOrder(){
        //创建集合，用于容纳数据
        List<Order> list = new ArrayList<>();
        Connection conn = JDBCUtils.getConnection();
        String sql = "select o.*, p.product_name, p.pic from order_master o join product p on o.product_id = p.product_id";
        //构建sql执行器
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Long orderId = rs.getLong("order_id");
                String orderSn = rs.getString("order_sn");
                Integer customerId = rs.getInt("customer_id");
                Long productId = rs.getLong("product_id");
                String shippingUser = rs.getString("shipping_user");
                String phone = rs.getString("phone");
                String address = rs.getString("address");
                BigDecimal orderMoney = rs.getBigDecimal("order_money");
                Integer productAmount = rs.getInt("product_amount");
                Timestamp createTime = rs.getTimestamp("create_time");
                Timestamp shippingTime = rs.getTimestamp("shipping_time");
                Timestamp receiveTime = rs.getTimestamp("receive_time");
                Byte orderStatus = rs.getByte("order_status");
                String product = rs.getString("product_name");
                String pic = rs.getString("pic");
                Order order = new Order(orderId,orderSn,customerId,productId,shippingUser,phone,address,orderMoney,productAmount,createTime,shippingTime,receiveTime,orderStatus,product,pic);
                list.add(order);
            }
            JDBCUtils.closeConnection(conn,ps,rs);
        }catch(Exception e){
            e.printStackTrace();
        }
        Collections.reverse(list);
        return list;
    }

    public List<Order> listOrder(){
        //创建集合，用于容纳数据
        List<Order> list = new ArrayList<>();
        Connection conn = JDBCUtils.getConnection();
        String sql = "select o.*, p.product_name, p.pic from order_master o join product p on o.product_id = p.product_id where order_status in(0,1,2)";
        //构建sql执行器
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Long orderId = rs.getLong("order_id");
                String orderSn = rs.getString("order_sn");
                Integer customerId = rs.getInt("customer_id");
                Long productId = rs.getLong("product_id");
                String shippingUser = rs.getString("shipping_user");
                String phone = rs.getString("phone");
                String address = rs.getString("address");
                BigDecimal orderMoney = rs.getBigDecimal("order_money");
                Integer productAmount = rs.getInt("product_amount");
                Timestamp createTime = rs.getTimestamp("create_time");
                Timestamp shippingTime = rs.getTimestamp("shipping_time");
                Timestamp receiveTime = rs.getTimestamp("receive_time");
                Byte orderStatus = rs.getByte("order_status");
                String product = rs.getString("product_name");
                String pic = rs.getString("pic");
                Order order = new Order(orderId,orderSn,customerId,productId,shippingUser,phone,address,orderMoney,productAmount,createTime,shippingTime,receiveTime,orderStatus,product,pic);
                list.add(order);
            }
            JDBCUtils.closeConnection(conn,ps,rs);
        }catch(Exception e){
            e.printStackTrace();
        }
        Collections.reverse(list);
        return list;
    }

    public List<Order> listReturn(){
        //创建集合，用于容纳数据
        List<Order> list = new ArrayList<>();
        Connection conn = JDBCUtils.getConnection();
        String sql = "select o.*, p.product_name, p.pic from order_master o join product p on o.product_id = p.product_id where order_status in(3,4)";
        //构建sql执行器
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Long orderId = rs.getLong("order_id");
                String orderSn = rs.getString("order_sn");
                Integer customerId = rs.getInt("customer_id");
                Long productId = rs.getLong("product_id");
                String shippingUser = rs.getString("shipping_user");
                String phone = rs.getString("phone");
                String address = rs.getString("address");
                BigDecimal orderMoney = rs.getBigDecimal("order_money");
                Integer productAmount = rs.getInt("product_amount");
                Timestamp createTime = rs.getTimestamp("create_time");
                Timestamp shippingTime = rs.getTimestamp("shipping_time");
                Timestamp receiveTime = rs.getTimestamp("receive_time");
                Byte orderStatus = rs.getByte("order_status");
                String product = rs.getString("product_name");
                String pic = rs.getString("pic");
                Order order = new Order(orderId,orderSn,customerId,productId,shippingUser,phone,address,orderMoney,productAmount,createTime,shippingTime,receiveTime,orderStatus,product,pic);
                list.add(order);
            }
            JDBCUtils.closeConnection(conn,ps,rs);
        }catch(Exception e){
            e.printStackTrace();
        }
        Collections.reverse(list);
        return list;
    }

    public List<Order> listAllOrderById(Integer id){
        //创建集合，用于容纳数据
        List<Order> list = new ArrayList<>();
        Connection conn = JDBCUtils.getConnection();
        String sql = "select o.*, p.product_name, p.pic from order_master o join product p on o.product_id = p.product_id where customer_id = "+id;
        //构建sql执行器
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Long orderId = rs.getLong("order_id");
                String orderSn = rs.getString("order_sn");
                Integer customerId = rs.getInt("customer_id");
                Long productId = rs.getLong("product_id");
                String shippingUser = rs.getString("shipping_user");
                String phone = rs.getString("phone");
                String address = rs.getString("address");
                BigDecimal orderMoney = rs.getBigDecimal("order_money");
                Integer productAmount = rs.getInt("product_amount");
                Timestamp createTime = rs.getTimestamp("create_time");
                Timestamp shippingTime = rs.getTimestamp("shipping_time");
                Timestamp receiveTime = rs.getTimestamp("receive_time");
                Byte orderStatus = rs.getByte("order_status");
                String product = rs.getString("product_name");
                String pic = rs.getString("pic");
                Order order = new Order(orderId,orderSn,customerId,productId,shippingUser,phone,address,orderMoney,productAmount,createTime,shippingTime,receiveTime,orderStatus,product,pic);
                list.add(order);
            }
            JDBCUtils.closeConnection(conn,ps,rs);
        }catch(Exception e){
            e.printStackTrace();
        }
        Collections.reverse(list);
        return list;
    }

    public List<Order> listOrderById(Integer id){
        //创建集合，用于容纳数据
        List<Order> list = new ArrayList<>();
        Connection conn = JDBCUtils.getConnection();
        String sql = "select o.*, p.product_name, p.pic from order_master o join product p on o.product_id = p.product_id where order_status in(0,1,2) and customer_id = "+id;
        //构建sql执行器
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Long orderId = rs.getLong("order_id");
                String orderSn = rs.getString("order_sn");
                Integer customerId = rs.getInt("customer_id");
                Long productId = rs.getLong("product_id");
                String shippingUser = rs.getString("shipping_user");
                String phone = rs.getString("phone");
                String address = rs.getString("address");
                BigDecimal orderMoney = rs.getBigDecimal("order_money");
                Integer productAmount = rs.getInt("product_amount");
                Timestamp createTime = rs.getTimestamp("create_time");
                Timestamp shippingTime = rs.getTimestamp("shipping_time");
                Timestamp receiveTime = rs.getTimestamp("receive_time");
                Byte orderStatus = rs.getByte("order_status");
                String product = rs.getString("product_name");
                String pic = rs.getString("pic");
                Order order = new Order(orderId,orderSn,customerId,productId,shippingUser,phone,address,orderMoney,productAmount,createTime,shippingTime,receiveTime,orderStatus,product,pic);
                list.add(order);
            }
            JDBCUtils.closeConnection(conn,ps,rs);
        }catch(Exception e){
            e.printStackTrace();
        }
        Collections.reverse(list);
        return list;
    }

    public List<Order> listReturnById(Integer id){
        //创建集合，用于容纳数据
        List<Order> list = new ArrayList<>();
        Connection conn = JDBCUtils.getConnection();
        String sql = "select o.*, p.product_name, p.pic from order_master o join product p on o.product_id = p.product_id where order_status in(3,4) and customer_id = "+id;
        //构建sql执行器
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Long orderId = rs.getLong("order_id");
                String orderSn = rs.getString("order_sn");
                Integer customerId = rs.getInt("customer_id");
                Long productId = rs.getLong("product_id");
                String shippingUser = rs.getString("shipping_user");
                String phone = rs.getString("phone");
                String address = rs.getString("address");
                BigDecimal orderMoney = rs.getBigDecimal("order_money");
                Integer productAmount = rs.getInt("product_amount");
                Timestamp createTime = rs.getTimestamp("create_time");
                Timestamp shippingTime = rs.getTimestamp("shipping_time");
                Timestamp receiveTime = rs.getTimestamp("receive_time");
                Byte orderStatus = rs.getByte("order_status");
                String product = rs.getString("product_name");
                String pic = rs.getString("pic");
                Order order = new Order(orderId,orderSn,customerId,productId,shippingUser,phone,address,orderMoney,productAmount,createTime,shippingTime,receiveTime,orderStatus,product,pic);
                list.add(order);
            }
            JDBCUtils.closeConnection(conn,ps,rs);
        }catch(Exception e){
            e.printStackTrace();
        }
        Collections.reverse(list);
        return list;
    }

    public Order findOrderById(Long id){
        Connection conn = JDBCUtils.getConnection();
        String sql = "select o.*, p.product_name, p.pic from order_master o join product p on o.product_id = p.product_id where order_id ="+id;
        //构建sql执行器
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                Long orderId = rs.getLong("order_id");
                String orderSn = rs.getString("order_sn");
                Integer customerId = rs.getInt("customer_id");
                Long productId = rs.getLong("product_id");
                String shippingUser = rs.getString("shipping_user");
                String phone = rs.getString("phone");
                String address = rs.getString("address");
                BigDecimal orderMoney = rs.getBigDecimal("order_money");
                Integer productAmount = rs.getInt("product_amount");
                Timestamp createTime = rs.getTimestamp("create_time");
                Timestamp shippingTime = rs.getTimestamp("shipping_time");
                Timestamp receiveTime = rs.getTimestamp("receive_time");
                Byte orderStatus = rs.getByte("order_status");
                String product = rs.getString("product_name");
                String pic = rs.getString("pic");
                Order order = new Order(orderId,orderSn,customerId,productId,shippingUser,phone,address,orderMoney,productAmount,createTime,shippingTime,receiveTime,orderStatus,product,pic);
                return order;
            }
            JDBCUtils.closeConnection(conn,ps,rs);
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public Integer insertOrder(Order order){
        Connection conn = JDBCUtils.getConnection();
        String sql = "insert into order_master (order_sn,customer_id,product_id,shipping_user,phone,address,order_money,product_amount,create_time,shipping_time,receive_time,order_status)values(?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement(sql);
            //补齐sql的问号，数字是几就是第几个问号
            ps.setString(1,order.getOrderSn());
            ps.setInt(2,order.getCustomerId());
            ps.setLong(3,order.getProductId());
            ps.setString(4,order.getShippingUser());
            ps.setString(5,order.getPhone());
            ps.setString(6,order.getAddress());
            ps.setBigDecimal(7,order.getOrderMoney());
            ps.setInt(8,order.getProductAmount());
            ps.setTimestamp(9,order.getCreateTime());
            ps.setTimestamp(10,order.getShippingTime());
            ps.setTimestamp(11,order.getReceiveTime());
            ps.setByte(12,order.getOrderStatus());
            //返回受影响的行数
            int count = ps.executeUpdate();
            JDBCUtils.closeConnection(conn,ps,null);
            return count;
        }catch(Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    public Integer deleteOrder(Long id){
        Connection conn = JDBCUtils.getConnection();
        String sql = "delete from order_master where order_id ="+id;
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement(sql);
            int count = ps.executeUpdate();
            JDBCUtils.closeConnection(conn,ps,null);
            return count;
        }catch(Exception e){
            e.printStackTrace();
        }
        return 0;
    }

//    insert into order_master (order_sn,customer_id,product_id,shipping_user,phone,address,order_money,create_time,shipping_time,receive_time,order_status)values(?,?,?,?,?,?,?,?,?,?,?)
    public Integer updateOrder(Order order,Long id){
        Connection conn = JDBCUtils.getConnection();
        String sql = "update order_master set order_sn=?, customer_id=?, product_id=?, shipping_user=?, phone=?, address=?, order_money=?, product_amount=?, create_time=?, shipping_time=?, receive_time=?, order_status=? where order_id = ?";
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement(sql);
            ps.setString(1,order.getOrderSn());
            ps.setInt(2,order.getCustomerId());
            ps.setLong(3,order.getProductId());
            ps.setString(4,order.getShippingUser());
            ps.setString(5,order.getPhone());
            ps.setString(6,order.getAddress());
            ps.setBigDecimal(7,order.getOrderMoney());
            ps.setInt(8,order.getProductAmount());
            ps.setTimestamp(9,order.getCreateTime());
            ps.setTimestamp(10,order.getShippingTime());
            ps.setTimestamp(11,order.getReceiveTime());
            ps.setByte(12,order.getOrderStatus());
            ps.setLong(13,id);
            //返回受影响的行数
            int count = ps.executeUpdate();
            JDBCUtils.closeConnection(conn,ps,null);
            return count;
        }catch(Exception e){
            e.printStackTrace();
        }
        return 0;
    }
}
