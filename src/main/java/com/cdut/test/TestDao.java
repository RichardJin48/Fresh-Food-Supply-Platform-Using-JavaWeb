package com.cdut.test;

import com.cdut.dao.CustomerDao;
import com.cdut.dao.EmpDao;
import com.cdut.dao.ProductDao;
import com.cdut.dao.ShoppingCartDao;
import com.cdut.entity.Customer;
import com.cdut.entity.Emp;
import com.cdut.entity.Product;
import com.cdut.entity.ShoppingCart;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.sql.Date;
import java.util.List;

public class TestDao {
    public static void main(String[] args) {
//        EmpDao dao = new EmpDao();
//        List<Emp> emps = dao.listEmp();
//        System.out.println(emps);
//        Emp emp = dao.findEmpById(1);
//        System.out.println(emp);
//        Emp emp = new Emp(null,"Beryl","09876","09876","IT","Male",20,"123456789");
//        Integer count = dao.insertEmp(emp);
//        Integer count = dao.deleteEmp(3);
//        Integer count = dao.updateEmp(emp,4);
//        System.out.println(count);
//        List<Emp> emps = dao.listEmp();
//        System.out.println(emps);
//        CustomerDao dao2 = new CustomerDao();
//        Customer cus = dao2.findCustomerByName("jzc");
//        System.out.println(cus);
//        ProductDao dao = new ProductDao();
//        Product product = new Product(null,"ABC",9876L,new BigDecimal("1.25"),Byte.parseByte("1"),Date.valueOf("2022-12-12"),"12345","qwer",1.1F,1.1F,1.1F,new Timestamp(System.currentTimeMillis()),new Timestamp(System.currentTimeMillis()));
//        dao.updateProduct(product,4L);
//        List<Product> products = dao.listProduct();
//        System.out.println(products);
        ShoppingCartDao dao = new ShoppingCartDao();
        ShoppingCart cart = new ShoppingCart(null,1,123L,12,new BigDecimal(12.22),new Timestamp(System.currentTimeMillis()),new Timestamp(System.currentTimeMillis()));
        dao.updateShoppingCart(cart,1L);
        List<ShoppingCart> products = dao.listShoppingCart();
        System.out.println(products);
    }
}
