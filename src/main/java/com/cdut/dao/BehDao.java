package com.cdut.dao;

//该类提供java和数据之间关系的类

import com.cdut.entity.Beh;
import com.cdut.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BehDao {
    //获取数据集合，获取数据库中emp数据
    public List<Beh> listBeh(){
        //创建集合，用于容纳数据
        List<Beh> list = new ArrayList<>();
        Connection conn = JDBCUtils.getConnection();
        String sql = "select * from beh where beh_type = 0";
        //构建sql执行器
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Integer behId = rs.getInt("beh_id");
                Integer customerId = rs.getInt("customer_id");
                Long productId = rs.getLong("product_id");
                Integer behCount = rs.getInt("beh_count");
                Timestamp behTime = rs.getTimestamp("beh_time");
                Integer behType = rs.getInt("beh_type");
                Beh beh = new Beh(behId,customerId,productId,behCount,behTime,behType);
                list.add(beh);
            }
            JDBCUtils.closeConnection(conn,ps,rs);
        }catch(Exception e){
            e.printStackTrace();
        }
        Collections.reverse(list);
        return list;
    }

    public List<Beh> listCol(){
        //创建集合，用于容纳数据
        List<Beh> list = new ArrayList<>();
        Connection conn = JDBCUtils.getConnection();
        String sql = "select b.*, p.product_name, p.pic from beh b join product p on b.product_id = p.product_id where beh_type = 1";
        //构建sql执行器
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Integer behId = rs.getInt("beh_id");
                Integer customerId = rs.getInt("customer_id");
                Long productId = rs.getLong("product_id");
                Integer behCount = rs.getInt("beh_count");
                Timestamp behTime = rs.getTimestamp("beh_time");
                Integer behType = rs.getInt("beh_type");
                String product = rs.getString("product_name");
                String pic = rs.getString("pic");
                Beh beh = new Beh(behId,customerId,productId,behCount,behTime,behType,product,pic);
                list.add(beh);
            }
            JDBCUtils.closeConnection(conn,ps,rs);
        }catch(Exception e){
            e.printStackTrace();
        }
        Collections.reverse(list);
        return list;
    }

    public List<Beh> listColById(Integer id){
        //创建集合，用于容纳数据
        List<Beh> list = new ArrayList<>();
        Connection conn = JDBCUtils.getConnection();
        String sql = "select b.*, p.product_name, p.pic from beh b join product p on b.product_id = p.product_id where beh_type = 1 and customer_id ="+id;
        //构建sql执行器
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Integer behId = rs.getInt("beh_id");
                Integer customerId = rs.getInt("customer_id");
                Long productId = rs.getLong("product_id");
                Integer behCount = rs.getInt("beh_count");
                Timestamp behTime = rs.getTimestamp("beh_time");
                Integer behType = rs.getInt("beh_type");
                String product = rs.getString("product_name");
                String pic = rs.getString("pic");
                Beh beh = new Beh(behId,customerId,productId,behCount,behTime,behType,product,pic);
                list.add(beh);
            }
            JDBCUtils.closeConnection(conn,ps,rs);
        }catch(Exception e){
            e.printStackTrace();
        }
        Collections.reverse(list);
        return list;
    }

    public List<Beh> searchCol(Integer cusId, Integer proId){
        //创建集合，用于容纳数据
        List<Beh> list = new ArrayList<>();
        Connection conn = JDBCUtils.getConnection();
        String sql = "select b.*, p.product_name, p.pic from beh b join product p on b.product_id = p.product_id where beh_type = 1 and customer_id = "+cusId+" and product_id = "+proId;
        //构建sql执行器
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Integer behId = rs.getInt("beh_id");
                Integer customerId = rs.getInt("customer_id");
                Long productId = rs.getLong("product_id");
                Integer behCount = rs.getInt("beh_count");
                Timestamp behTime = rs.getTimestamp("beh_time");
                Integer behType = rs.getInt("beh_type");
                String product = rs.getString("product_name");
                String pic = rs.getString("pic");
                Beh beh = new Beh(behId,customerId,productId,behCount,behTime,behType,product,pic);
                list.add(beh);
            }
            JDBCUtils.closeConnection(conn,ps,rs);
        }catch(Exception e){
            e.printStackTrace();
        }
        Collections.reverse(list);
        return list;
    }

    public List<Beh> listRec(){
        //创建集合，用于容纳数据
        List<Beh> list = new ArrayList<>();
        Connection conn = JDBCUtils.getConnection();
        String sql = "select * from beh where beh_type = 2";
        //构建sql执行器
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Integer behId = rs.getInt("beh_id");
                Integer customerId = rs.getInt("customer_id");
                Long productId = rs.getLong("product_id");
                Integer behCount = rs.getInt("beh_count");
                Timestamp behTime = rs.getTimestamp("beh_time");
                Integer behType = rs.getInt("beh_type");
                Beh beh = new Beh(behId,customerId,productId,behCount,behTime,behType);
                list.add(beh);
            }
            JDBCUtils.closeConnection(conn,ps,rs);
        }catch(Exception e){
            e.printStackTrace();
        }
        Collections.reverse(list);
        return list;
    }

    public Beh findBehById(Integer id){
        Connection conn = JDBCUtils.getConnection();
        String sql = "select b.*, p.product_name, p.pic from beh b join product p on b.product_id = p.product_id where beh_id ="+id;
        //构建sql执行器
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                Integer behId = rs.getInt("beh_id");
                Integer customerId = rs.getInt("customer_id");
                Long productId = rs.getLong("product_id");
                Integer behCount = rs.getInt("beh_count");
                Timestamp behTime = rs.getTimestamp("beh_time");
                Integer behType = rs.getInt("beh_type");
                String product = rs.getString("product_name");
                String pic = rs.getString("pic");
                Beh beh = new Beh(behId,customerId,productId,behCount,behTime,behType,product,pic);
                return beh;
            }
            JDBCUtils.closeConnection(conn,ps,rs);
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public Integer insertBeh(Beh beh){
        Connection conn = JDBCUtils.getConnection();
        String sql = "insert into beh (customer_id,product_id,beh_count,beh_time,beh_type)values(?,?,?,?,?)";
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement(sql);
            //补齐sql的问号，数字是几就是第几个问号
            ps.setInt(1,beh.getCustomerId());
            ps.setLong(2,beh.getProductId());
            ps.setInt(3,beh.getBehCount());
            ps.setTimestamp(4,beh.getBehTime());
            ps.setInt(5,beh.getBehType());
            //返回受影响的行数
            int count = ps.executeUpdate();
            JDBCUtils.closeConnection(conn,ps,null);
            return count;
        }catch(Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    public Integer deleteBeh(Integer id){
        Connection conn = JDBCUtils.getConnection();
        String sql = "delete from beh where beh_id ="+id;
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

    public Integer updateBeh(Beh beh,Integer id){
        Connection conn = JDBCUtils.getConnection();
        String sql = "update beh set customer_id=?, product_id=?, beh_count=?, beh_time=?, beh_type=? where beh_id = ?";
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement(sql);
            ps.setInt(1,beh.getCustomerId());
            ps.setLong(2,beh.getProductId());
            ps.setInt(3,beh.getBehCount());
            ps.setTimestamp(4,beh.getBehTime());
            ps.setInt(5,beh.getBehType());
            ps.setInt(6,id);
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
