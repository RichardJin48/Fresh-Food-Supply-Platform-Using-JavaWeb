package com.cdut.dao;

import com.cdut.entity.ShoppingCart;
import com.cdut.utils.JDBCUtils;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShoppingCartDao {
    public List<ShoppingCart> listShoppingCart(){
        //创建集合，用于容纳数据
        List<ShoppingCart> list = new ArrayList<>();
        Connection conn = JDBCUtils.getConnection();
        String sql = "select s.*, p.product_name, p.pic from shopping_cart s join product p on s.product_id = p.product_id";
        //构建sql执行器
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Long cartId = rs.getLong("cart_id");
                Integer customerId = rs.getInt("customer_id");
                Long productId = rs.getLong("product_id");
                Integer productAmount = rs.getInt("product_amount");
                BigDecimal price = rs.getBigDecimal("price");
                Timestamp addTime = rs.getTimestamp("add_time");
                Timestamp modifiedTime = rs.getTimestamp("modified_time");
                String product = rs.getString("product_name");
                String pic = rs.getString("pic");
                ShoppingCart shoppingCart = new ShoppingCart(cartId,customerId,productId,productAmount,price,addTime,modifiedTime,product,pic);
                list.add(shoppingCart);
            }
            JDBCUtils.closeConnection(conn,ps,rs);
        }catch(Exception e){
            e.printStackTrace();
        }
        Collections.reverse(list);
        return list;
    }

    public List<ShoppingCart> listShoppingCartById(Integer id){
        //创建集合，用于容纳数据
        List<ShoppingCart> list = new ArrayList<>();
        Connection conn = JDBCUtils.getConnection();
        String sql = "select s.*, p.product_name, p.pic from shopping_cart s join product p on s.product_id = p.product_id where customer_id = "+id;
        //构建sql执行器
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Long cartId = rs.getLong("cart_id");
                Integer customerId = rs.getInt("customer_id");
                Long productId = rs.getLong("product_id");
                Integer productAmount = rs.getInt("product_amount");
                BigDecimal price = rs.getBigDecimal("price");
                Timestamp addTime = rs.getTimestamp("add_time");
                Timestamp modifiedTime = rs.getTimestamp("modified_time");
                String product = rs.getString("product_name");
                String pic = rs.getString("pic");
                ShoppingCart shoppingCart = new ShoppingCart(cartId,customerId,productId,productAmount,price,addTime,modifiedTime,product,pic);
                list.add(shoppingCart);
            }
            JDBCUtils.closeConnection(conn,ps,rs);
        }catch(Exception e){
            e.printStackTrace();
        }
        Collections.reverse(list);
        return list;
    }

    public ShoppingCart findShoppingCartById(Long id){
        Connection conn = JDBCUtils.getConnection();
        String sql = "select s.*, p.product_name, p.pic from shopping_cart s join product p on s.product_id = p.product_id where cart_id ="+id;
        //构建sql执行器
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                Long cartId = rs.getLong("cart_id");
                Integer customerId = rs.getInt("customer_id");
                Long productId = rs.getLong("product_id");
                Integer productAmount = rs.getInt("product_amount");
                BigDecimal price = rs.getBigDecimal("price");
                Timestamp addTime = rs.getTimestamp("add_time");
                Timestamp modifiedTime = rs.getTimestamp("modified_time");
                String product = rs.getString("product_name");
                String pic = rs.getString("pic");
                ShoppingCart shoppingCart = new ShoppingCart(cartId,customerId,productId,productAmount,price,addTime,modifiedTime,product,pic);
                return shoppingCart;
            }
            JDBCUtils.closeConnection(conn,ps,rs);
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public Integer insertShoppingCart(ShoppingCart shoppingCart){
        Connection conn = JDBCUtils.getConnection();
        String sql = "insert into shopping_cart (customer_id,product_id,product_amount,price,add_time,modified_time)values(?,?,?,?,?,?)";
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement(sql);
            //补齐sql的问号，数字是几就是第几个问号
            ps.setInt(1,shoppingCart.getCustomerId());
            ps.setLong(2,shoppingCart.getProductId());
            ps.setInt(3,shoppingCart.getProductAmount());
            ps.setBigDecimal(4,shoppingCart.getPrice());
            ps.setTimestamp(5,shoppingCart.getAddTime());
            ps.setTimestamp(6,shoppingCart.getModifiedTime());
            //返回受影响的行数
            int count = ps.executeUpdate();
            JDBCUtils.closeConnection(conn,ps,null);
            return count;
        }catch(Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    public Integer deleteShoppingCart(Long id){
        Connection conn = JDBCUtils.getConnection();
        String sql = "delete from shopping_cart where cart_id ="+id;
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

    public Integer updateShoppingCart(ShoppingCart shoppingCart,Long id){
        Connection conn = JDBCUtils.getConnection();
        String sql = "update shopping_cart set customer_id=?, product_id=?,product_amount=?,price=?,add_time=?,modified_time=? where cart_id = ?";
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement(sql);
            ps.setInt(1,shoppingCart.getCustomerId());
            ps.setLong(2,shoppingCart.getProductId());
            ps.setInt(3,shoppingCart.getProductAmount());
            ps.setBigDecimal(4,shoppingCart.getPrice());
            ps.setTimestamp(5,shoppingCart.getAddTime());
            ps.setTimestamp(6,shoppingCart.getModifiedTime());
            ps.setLong(7,id);
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
