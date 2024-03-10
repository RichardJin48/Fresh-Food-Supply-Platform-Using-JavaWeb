package com.cdut.dao;

//该类提供java和数据之间关系的类

import com.cdut.entity.Emp;
import com.cdut.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmpDao {
    //获取数据集合，获取数据库中emp数据
    public List<Emp> listEmp(){
        //创建集合，用于容纳数据
        List<Emp> list = new ArrayList<>();
        Connection conn = JDBCUtils.getConnection();
        String sql = "select * from emp";
        //构建sql执行器
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Integer empId = rs.getInt("emp_id");
                String empName = rs.getString("emp_name");
                String idCard = rs.getString("id_card");
                String password = rs.getString("password");
                String dept = rs.getString("dept");
                String gender = rs.getString("gender");
                Integer age = rs.getInt("age");
                String phone = rs.getString("phone");
                Emp emp = new Emp(empId,empName,idCard,password,dept,gender,age,phone);
                list.add(emp);
            }
            JDBCUtils.closeConnection(conn,ps,rs);
        }catch(Exception e){
            e.printStackTrace();
        }
        Collections.reverse(list);
        return list;
    }

    public Emp findEmpById(Integer id){
        Connection conn = JDBCUtils.getConnection();
        String sql = "select * from emp where emp_id ="+id;
        //构建sql执行器
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                Integer empId = rs.getInt("emp_id");
                String empName = rs.getString("emp_name");
                String idCard = rs.getString("id_card");
                String password = rs.getString("password");
                String dept = rs.getString("dept");
                String gender = rs.getString("gender");
                Integer age = rs.getInt("age");
                String phone = rs.getString("phone");
                Emp emp = new Emp(empId,empName,idCard,password,dept,gender,age,phone);
                return emp;
            }
            JDBCUtils.closeConnection(conn,ps,rs);
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public Emp findEmpByIdCard(String card){
        Connection conn = JDBCUtils.getConnection();
        String sql = "select * from emp where id_card ='"+card+"'";
        //构建sql执行器
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                Integer empId = rs.getInt("emp_id");
                String empName = rs.getString("emp_name");
                String idCard = rs.getString("id_card");
                String password = rs.getString("password");
                String dept = rs.getString("dept");
                String gender = rs.getString("gender");
                Integer age = rs.getInt("age");
                String phone = rs.getString("phone");
                Emp emp = new Emp(empId,empName,idCard,password,dept,gender,age,phone);
                return emp;
            }
            JDBCUtils.closeConnection(conn,ps,rs);
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public Integer insertEmp(Emp emp){
        Connection conn = JDBCUtils.getConnection();
        String sql = "insert into emp (emp_name,id_card,password,dept,gender,age,phone)values(?,?,?,?,?,?,?)";
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement(sql);
            //补齐sql的问号，数字是几就是第几个问号
            ps.setString(1,emp.getEmpName());
            ps.setString(2,emp.getIdCard());
            ps.setString(3,emp.getPassword());
            ps.setString(4,emp.getDept());
            ps.setString(5,emp.getGender());
            ps.setInt(6,emp.getAge());
            ps.setString(7,emp.getPhone());
            //返回受影响的行数
            int count = ps.executeUpdate();
            JDBCUtils.closeConnection(conn,ps,null);
            return count;
        }catch(Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    public Integer deleteEmp(Integer id){
        Connection conn = JDBCUtils.getConnection();
        String sql = "delete from emp where emp_id ="+id;
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

    public Integer updateEmp(Emp emp,Integer id){
        Connection conn = JDBCUtils.getConnection();
        String sql = "update emp set emp_name=?, id_card=?, password=?, dept=?, gender=?, age=?, phone=? where emp_id = ?";
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement(sql);
            ps.setString(1,emp.getEmpName());
            ps.setString(2,emp.getIdCard());
            ps.setString(3,emp.getPassword());
            ps.setString(4,emp.getDept());
            ps.setString(5,emp.getGender());
            ps.setInt(6,emp.getAge());
            ps.setString(7,emp.getPhone());
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
