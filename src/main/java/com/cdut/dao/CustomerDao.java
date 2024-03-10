package com.cdut.dao;

//该类提供java和数据之间关系的类

import com.cdut.entity.Customer;
import com.cdut.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomerDao {
    public List<Customer> listCustomer(){
        //创建集合，用于容纳数据
        List<Customer> list = new ArrayList<>();
        Connection conn = JDBCUtils.getConnection();
        String sql = "select * from customer";
        //构建sql执行器
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Integer customerId = rs.getInt("customer_id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String nickname = rs.getString("nickname");
                String gender = rs.getString("gender");
                String phone = rs.getString("phone");
                String addr = rs.getString("addr");
                String sign = rs.getString("sign");
                String question = rs.getString("question");
                String answer = rs.getString("answer");
                Customer cus = new Customer(customerId,username,password,nickname,gender,phone,addr,sign,question,answer);
                list.add(cus);
            }
            JDBCUtils.closeConnection(conn,ps,rs);
        }catch(Exception e){
            e.printStackTrace();
        }
        Collections.reverse(list);
        return list;
    }

    public Customer findCustomerById(Integer id){
        Connection conn = JDBCUtils.getConnection();
        String sql = "select * from customer where customer_id ="+id;
        //构建sql执行器
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                Integer customerId = rs.getInt("customer_id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String nickname = rs.getString("nickname");
                String gender = rs.getString("gender");
                String phone = rs.getString("phone");
                String addr = rs.getString("addr");
                String sign = rs.getString("sign");
                String question = rs.getString("question");
                String answer = rs.getString("answer");
                Customer cus = new Customer(customerId,username,password,nickname,gender,phone,addr,sign,question,answer);
                return cus;
            }
            JDBCUtils.closeConnection(conn,ps,rs);
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public Customer findCustomerByName(String name){
        Connection conn = JDBCUtils.getConnection();
        String sql = "select * from customer where username ='"+name+"'";
        //构建sql执行器
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                Integer customerId = rs.getInt("customer_id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String nickname = rs.getString("nickname");
                String gender = rs.getString("gender");
                String phone = rs.getString("phone");
                String addr = rs.getString("addr");
                String sign = rs.getString("sign");
                String question = rs.getString("question");
                String answer = rs.getString("answer");
                Customer cus = new Customer(customerId,username,password,nickname,gender,phone,addr,sign,question,answer);
                return cus;
            }
            JDBCUtils.closeConnection(conn,ps,rs);
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }



    public Integer insertCustomer(Customer cus){
        Connection conn = JDBCUtils.getConnection();
        String sql = "insert into customer (username,password,nickname,gender,phone,addr,sign)values(?,?,?,?,?,?,?)";
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement(sql);
            //补齐sql的问号，数字是几就是第几个问号
            ps.setString(1,cus.getUsername());
            ps.setString(2,cus.getPassword());
            ps.setString(3,cus.getNickname());
            ps.setString(4,cus.getGender());
            ps.setString(5,cus.getPhone());
            ps.setString(6,cus.getAddr());
            ps.setString(7,cus.getSign());
            //返回受影响的行数
            int count = ps.executeUpdate();
            JDBCUtils.closeConnection(conn,ps,null);
            return count;
        }catch(Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    public Integer deleteCustomer(Integer id){
        Connection conn = JDBCUtils.getConnection();
        String sql = "delete from customer where customer_id ="+id;
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

    public Integer updateCustomer(Customer cus,Integer id){
        Connection conn = JDBCUtils.getConnection();
        String sql = "update customer set username=?, password=?, nickname=?, gender=?, phone=?, addr=?, sign=? where customer_id = ?";
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement(sql);
            ps.setString(1,cus.getUsername());
            ps.setString(2,cus.getPassword());
            ps.setString(3,cus.getNickname());
            ps.setString(4,cus.getGender());
            ps.setString(5,cus.getPhone());
            ps.setString(6,cus.getAddr());
            ps.setString(7,cus.getSign());
            ps.setInt(8,id);
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
