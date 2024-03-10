package com.cdut.dao;

//该类提供java和数据之间关系的类

import com.cdut.entity.Ann;
import com.cdut.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AnnDao {
    //获取数据集合，获取数据库中emp数据
    public List<Ann> listAnn(){
        //创建集合，用于容纳数据
        List<Ann> list = new ArrayList<>();
        Connection conn = JDBCUtils.getConnection();
        String sql = "select * from ann";
        //构建sql执行器
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Integer annId = rs.getInt("ann_id");
                String title = rs.getString("title");
                String content = rs.getString("content");
                Timestamp releaseTime = rs.getTimestamp("release_time");
                Timestamp modifiedTime = rs.getTimestamp("modified_time");
                Ann ann = new Ann(annId,title,content,releaseTime,modifiedTime);
                list.add(ann);
            }
            JDBCUtils.closeConnection(conn,ps,rs);
        }catch(Exception e){
            e.printStackTrace();
        }
        Collections.reverse(list);
        return list;
    }

    public Ann findAnnById(Integer id){
        Connection conn = JDBCUtils.getConnection();
        String sql = "select * from ann where ann_id ="+id;
        //构建sql执行器
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                Integer annId = rs.getInt("ann_id");
                String title = rs.getString("title");
                String content = rs.getString("content");
                Timestamp releaseTime = rs.getTimestamp("release_time");
                Timestamp modifiedTime = rs.getTimestamp("modified_time");
                Ann ann = new Ann(annId,title,content,releaseTime,modifiedTime);
                return ann;
            }
            JDBCUtils.closeConnection(conn,ps,rs);
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public Integer insertAnn(Ann ann){
        Connection conn = JDBCUtils.getConnection();
        String sql = "insert into ann (title,content,release_time,modified_time)values(?,?,?,?)";
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement(sql);
            //补齐sql的问号，数字是几就是第几个问号
            ps.setString(1,ann.getTitle());
            ps.setString(2,ann.getContent());
            ps.setTimestamp(3,ann.getReleaseTime());
            ps.setTimestamp(4,ann.getModifiedTime());
            //返回受影响的行数
            int count = ps.executeUpdate();
            JDBCUtils.closeConnection(conn,ps,null);
            return count;
        }catch(Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    public Integer deleteAnn(Integer id){
        Connection conn = JDBCUtils.getConnection();
        String sql = "delete from ann where ann_id ="+id;
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

    public Integer updateAnn(Ann ann,Integer id){
        Connection conn = JDBCUtils.getConnection();
        String sql = "update ann set title=?, content=?, release_time=?, modified_time=? where ann_id = ?";
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement(sql);
            ps.setString(1,ann.getTitle());
            ps.setString(2,ann.getContent());
            ps.setTimestamp(3,ann.getReleaseTime());
            ps.setTimestamp(4,ann.getModifiedTime());
            ps.setInt(5,id);
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
