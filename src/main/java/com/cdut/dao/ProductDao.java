package com.cdut.dao;

import com.cdut.entity.Product;
import com.cdut.utils.JDBCUtils;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductDao {
    public List<Product> listProduct(){
        //创建集合，用于容纳数据
        List<Product> list = new ArrayList<>();
        Connection conn = JDBCUtils.getConnection();
        String sql = "select * from product";
        //构建sql执行器
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Long productId = rs.getLong("product_id");
                String productName = rs.getString("product_name");
                Long categoryId = rs.getLong("category_id");
                BigDecimal price = rs.getBigDecimal("price");
                Byte publishStatus = rs.getByte("publish_status");
                Float weight = rs.getFloat("weight");
                Date productionDate = rs.getDate("production_date");
                String recommend = rs.getString("recommend");
                String descript = rs.getString("descript");
                Integer stock = rs.getInt("stock");
                Integer salesVolume = rs.getInt("sales_volume");
                Timestamp inDate = rs.getTimestamp("indate");
                Timestamp modifiedTime = rs.getTimestamp("modified_time");
                String pic = rs.getString("pic");
                Product product = new Product(productId, productName, categoryId, price, publishStatus, productionDate, descript, recommend, weight, stock, salesVolume, inDate, modifiedTime, pic);
                list.add(product);
            }
            JDBCUtils.closeConnection(conn,ps,rs);
        }catch(Exception e){
            e.printStackTrace();
        }
        Collections.reverse(list);
        return list;
    }

    public List<Product> listProductPub(){
        //创建集合，用于容纳数据
        List<Product> list = new ArrayList<>();
        Connection conn = JDBCUtils.getConnection();
        String sql = "select * from product where publish_status = 1";
        //构建sql执行器
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Long productId = rs.getLong("product_id");
                String productName = rs.getString("product_name");
                Long categoryId = rs.getLong("category_id");
                BigDecimal price = rs.getBigDecimal("price");
                Byte publishStatus = rs.getByte("publish_status");
                Float weight = rs.getFloat("weight");
                Date productionDate = rs.getDate("production_date");
                String recommend = rs.getString("recommend");
                String descript = rs.getString("descript");
                Integer stock = rs.getInt("stock");
                Integer salesVolume = rs.getInt("sales_volume");
                Timestamp inDate = rs.getTimestamp("indate");
                Timestamp modifiedTime = rs.getTimestamp("modified_time");
                String pic = rs.getString("pic");
                Product product = new Product(productId, productName, categoryId, price, publishStatus, productionDate, descript, recommend, weight, stock, salesVolume, inDate, modifiedTime, pic);
                list.add(product);
            }
            JDBCUtils.closeConnection(conn,ps,rs);
        }catch(Exception e){
            e.printStackTrace();
        }
        Collections.reverse(list);
        return list;
    }

    public List<Product> searchProductPub(String keyword){
        //创建集合，用于容纳数据
        List<Product> list = new ArrayList<>();
        Connection conn = JDBCUtils.getConnection();
        String sql = "select * from product where publish_status = 1 and product_name like '%"+keyword+"%'";
        System.out.println(sql);
        //构建sql执行器
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Long productId = rs.getLong("product_id");
                String productName = rs.getString("product_name");
                Long categoryId = rs.getLong("category_id");
                BigDecimal price = rs.getBigDecimal("price");
                Byte publishStatus = rs.getByte("publish_status");
                Float weight = rs.getFloat("weight");
                Date productionDate = rs.getDate("production_date");
                String recommend = rs.getString("recommend");
                String descript = rs.getString("descript");
                Integer stock = rs.getInt("stock");
                Integer salesVolume = rs.getInt("sales_volume");
                Timestamp inDate = rs.getTimestamp("indate");
                Timestamp modifiedTime = rs.getTimestamp("modified_time");
                String pic = rs.getString("pic");
                Product product = new Product(productId, productName, categoryId, price, publishStatus, productionDate, descript, recommend, weight, stock, salesVolume, inDate, modifiedTime, pic);
                list.add(product);
            }
            JDBCUtils.closeConnection(conn,ps,rs);
        }catch(Exception e){
            e.printStackTrace();
        }
        Collections.reverse(list);
        return list;
    }

    public List<Product> listProductPubByCategory(Integer category){
        //创建集合，用于容纳数据
        List<Product> list = new ArrayList<>();
        Connection conn = JDBCUtils.getConnection();
        String sql = "select * from product where publish_status = 1 and category_id = " + category;
        System.out.println(sql);
        //构建sql执行器
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Long productId = rs.getLong("product_id");
                String productName = rs.getString("product_name");
                Long categoryId = rs.getLong("category_id");
                BigDecimal price = rs.getBigDecimal("price");
                Byte publishStatus = rs.getByte("publish_status");
                Float weight = rs.getFloat("weight");
                Date productionDate = rs.getDate("production_date");
                String recommend = rs.getString("recommend");
                String descript = rs.getString("descript");
                Integer stock = rs.getInt("stock");
                Integer salesVolume = rs.getInt("sales_volume");
                Timestamp inDate = rs.getTimestamp("indate");
                Timestamp modifiedTime = rs.getTimestamp("modified_time");
                String pic = rs.getString("pic");
                Product product = new Product(productId, productName, categoryId, price, publishStatus, productionDate, descript, recommend, weight, stock, salesVolume, inDate, modifiedTime, pic);
                list.add(product);
            }
            JDBCUtils.closeConnection(conn,ps,rs);
        }catch(Exception e){
            e.printStackTrace();
        }
        Collections.reverse(list);
        return list;
    }

    public List<Product> searchProductPubByCategory(String keyword, Integer category){
        //创建集合，用于容纳数据
        List<Product> list = new ArrayList<>();
        Connection conn = JDBCUtils.getConnection();
        String sql = "select * from product where publish_status = 1 and product_name like '%"+keyword+"%' and category_id = " + category;
        System.out.println(sql);
        //构建sql执行器
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Long productId = rs.getLong("product_id");
                String productName = rs.getString("product_name");
                Long categoryId = rs.getLong("category_id");
                BigDecimal price = rs.getBigDecimal("price");
                Byte publishStatus = rs.getByte("publish_status");
                Float weight = rs.getFloat("weight");
                Date productionDate = rs.getDate("production_date");
                String recommend = rs.getString("recommend");
                String descript = rs.getString("descript");
                Integer stock = rs.getInt("stock");
                Integer salesVolume = rs.getInt("sales_volume");
                Timestamp inDate = rs.getTimestamp("indate");
                Timestamp modifiedTime = rs.getTimestamp("modified_time");
                String pic = rs.getString("pic");
                Product product = new Product(productId, productName, categoryId, price, publishStatus, productionDate, descript, recommend, weight, stock, salesVolume, inDate, modifiedTime, pic);
                list.add(product);
            }
            JDBCUtils.closeConnection(conn,ps,rs);
        }catch(Exception e){
            e.printStackTrace();
        }
        Collections.reverse(list);
        return list;
    }

    public List<Product> listProductRec(){
        //创建集合，用于容纳数据
        List<Product> list = new ArrayList<>();
        Connection conn = JDBCUtils.getConnection();
        String sql = "select * from product where recommend = 'Yes' and publish_status = 1";
        //构建sql执行器
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Long productId = rs.getLong("product_id");
                String productName = rs.getString("product_name");
                Long categoryId = rs.getLong("category_id");
                BigDecimal price = rs.getBigDecimal("price");
                Byte publishStatus = rs.getByte("publish_status");
                Float weight = rs.getFloat("weight");
                Date productionDate = rs.getDate("production_date");
                String recommend = rs.getString("recommend");
                String descript = rs.getString("descript");
                Integer stock = rs.getInt("stock");
                Integer salesVolume = rs.getInt("sales_volume");
                Timestamp inDate = rs.getTimestamp("indate");
                Timestamp modifiedTime = rs.getTimestamp("modified_time");
                String pic = rs.getString("pic");
                Product product = new Product(productId, productName, categoryId, price, publishStatus, productionDate, descript, recommend, weight, stock, salesVolume, inDate, modifiedTime, pic);
                list.add(product);
            }
            JDBCUtils.closeConnection(conn,ps,rs);
        }catch(Exception e){
            e.printStackTrace();
        }
        Collections.reverse(list);
        return list;
    }

    public Product findProductById(Long id){
        Connection conn = JDBCUtils.getConnection();
        String sql = "select * from product where product_id ="+id;
        //构建sql执行器
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                Long productId = rs.getLong("product_id");
                String productName = rs.getString("product_name");
                Long categoryId = rs.getLong("category_id");
                BigDecimal price = rs.getBigDecimal("price");
                Byte publishStatus = rs.getByte("publish_status");
                Float weight = rs.getFloat("weight");
                Date productionDate = rs.getDate("production_date");
                String recommend = rs.getString("recommend");
                String descript = rs.getString("descript");
                Integer stock = rs.getInt("stock");
                Integer salesVolume = rs.getInt("sales_volume");
                Timestamp inDate = rs.getTimestamp("indate");
                Timestamp modifiedTime = rs.getTimestamp("modified_time");
                String pic = rs.getString("pic");
                Product product = new Product(productId, productName, categoryId, price, publishStatus, productionDate, descript, recommend, weight, stock, salesVolume, inDate, modifiedTime, pic);
                return product;
            }
            JDBCUtils.closeConnection(conn,ps,rs);
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public Integer insertProduct(Product Product){
        Connection conn = JDBCUtils.getConnection();
        String sql = "insert into product (product_name,category_id,recommend,price,publish_status,weight,production_date,descript,stock,sales_volume,indate,modified_time,pic)values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement(sql);
            //补齐sql的问号，数字是几就是第几个问号
            ps.setString(1,Product.getProductName());
            ps.setLong(2,Product.getCategoryId());
            ps.setString(3,Product.getRecommend());
            ps.setBigDecimal(4,Product.getPrice());
            ps.setByte(5,Product.getPublishStatus());
            ps.setFloat(6,Product.getWeight());
            ps.setDate(7, Product.getProductionDate());
            ps.setString(8, Product.getDescript());
            ps.setInt(9,Product.getStock());
            ps.setInt(10,Product.getSalesVolume());
            ps.setTimestamp(11,Product.getIndate());
            ps.setTimestamp(12,Product.getModifiedTime());
            ps.setString(13,Product.getPic());

            //返回受影响的行数
            Integer count = ps.executeUpdate();
            JDBCUtils.closeConnection(conn,ps,null);
            return count;
        }catch(Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    public Integer deleteProduct(Long id){
        Connection conn = JDBCUtils.getConnection();
        String sql = "delete from product where product_id ="+id;
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement(sql);
            Integer count = ps.executeUpdate();
            JDBCUtils.closeConnection(conn,ps,null);
            return count;
        }catch(Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    public Integer updateProduct(Product Product, Long id){
        Connection conn = JDBCUtils.getConnection();
        String sql = "update product set product_name=?, category_id=?,recommend=?,price=?,publish_status=?,weight=?,production_date=?,descript=?,stock=?,sales_volume=?,indate=?,modified_time=?,pic=? where product_id = ?";
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement(sql);
            ps.setString(1,Product.getProductName());
            ps.setLong(2,Product.getCategoryId());
            ps.setString(3,Product.getRecommend());
            ps.setBigDecimal(4,Product.getPrice());
            ps.setByte(5,Product.getPublishStatus());
            ps.setFloat(6,Product.getWeight());
            ps.setDate(7, Product.getProductionDate());
            ps.setString(8, Product.getDescript());
            ps.setInt(9,Product.getStock());
            ps.setInt(10,Product.getSalesVolume());
            ps.setTimestamp(11,Product.getIndate());
            ps.setTimestamp(12,Product.getModifiedTime());
            ps.setString(13,Product.getPic());
            ps.setLong(14,id);

            //返回受影响的行数
            Integer count = ps.executeUpdate();
            JDBCUtils.closeConnection(conn,ps,null);
            return count;
        }catch(Exception e){
            e.printStackTrace();
        }
        return 0;
    }
}
