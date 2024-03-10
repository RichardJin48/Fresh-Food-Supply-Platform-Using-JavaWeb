package com.cdut.web;

import com.cdut.dao.BehDao;
import com.cdut.dao.CustomerDao;
import com.cdut.dao.EmpDao;
import com.cdut.dao.ProductDao;
import com.cdut.entity.Beh;
import com.cdut.entity.Customer;
import com.cdut.entity.Emp;
import com.cdut.entity.Product;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = "/product")
public class ProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");

        String opt = req.getParameter("opt");
        if ("list".equals(opt)) {
            listProduct(req, resp);
        } else if ("toAdd".equals(opt)) {
            toAdd(req, resp);
        } else if ("addProduct".equals(opt)) {
            addProduct(req, resp);
        } else if ("toDelete".equals(opt)) {
            toDelete(req, resp);
        } else if ("deleteProduct".equals(opt)) {
            deleteProduct(req, resp);
        } else if ("toEdit".equals(opt)) {
            toEdit(req, resp);
        } else if ("editProduct".equals(opt)) {
            editProduct(req, resp);
        } else if ("show".equals(opt)) {
            show(req, resp);
        } else if ("search".equals(opt)) {
            search(req, resp);
        } else if ("category".equals(opt)) {
            category(req, resp);
        } else if ("categorySearch".equals(opt)) {
            categorySearch(req, resp);
        }
    }

    private void listProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductDao dao = new ProductDao();
        List<Product> products = dao.listProduct();

        //将数据设置到请求中
        req.setAttribute("products", products);
        //通过身份证号识别登录的用户
        String userCard = req.getParameter("userCard");
        EmpDao dao2 = new EmpDao();
        Emp user = dao2.findEmpByIdCard(userCard);
        req.setAttribute("user", user);
        //通过转发器将数据交给jsp
        req.getRequestDispatcher("/product/productlist.jsp").forward(req, resp);
    }

    private void toAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userCard = req.getParameter("userCard");
        req.setAttribute("title", "Add a Product");
        req.setAttribute("url1", "/product?opt=addProduct&userCard=" + userCard);
        req.setAttribute("url2", "/product?opt=list&userCard=" + userCard);

        req.getRequestDispatcher("/product/add.jsp").forward(req, resp);
    }

    private void addProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ProductName = req.getParameter("productName");
        Long CategoryId = Long.valueOf(req.getParameter("categoryId"));
        String Recommend = req.getParameter("recommend");
        Byte PublishStatus = Byte.valueOf(req.getParameter("publishStatus"));
        BigDecimal price = new BigDecimal(req.getParameter("price"));
        Float Weight = Float.valueOf(req.getParameter("weight"));
        String productionDate = req.getParameter("productionDate");
        if (productionDate.equals("")) {
            productionDate = "1970-01-01";
        }
        String Descript = req.getParameter("descript");
        Integer stock = Integer.valueOf(req.getParameter("stock"));
        Timestamp InDate = new Timestamp(System.currentTimeMillis());
        Timestamp modifiedTime = new Timestamp(System.currentTimeMillis());
        String pic = "";
        Product product = new Product(null, ProductName, CategoryId, price, PublishStatus, Date.valueOf(productionDate), Descript, Recommend, Weight, stock, 0, InDate, modifiedTime, pic);
        ProductDao dao = new ProductDao();   //Long productId, String productName, Long categoryId, BigDecimal price, Byte publishStatus, Date productionDate, String descript, String recommend, Float weight, Float stock, Float salesVolume, Date indate, Date modifiedTime
        Integer count = dao.insertProduct(product);
        String userCard = req.getParameter("userCard");
        if (count > 0) {
            resp.sendRedirect("/product?opt=list&userCard=" + userCard);
        }
    }

    private void toDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ProductId = req.getParameter("productId");
        String userCard = req.getParameter("userCard");
        ProductDao dao = new ProductDao();
        Product Product = dao.findProductById(Long.parseLong(ProductId));
        String ProductName = Product.getProductName();
        req.setAttribute("inf", "Delete the " + ProductName + "?");
        req.setAttribute("url1", "/product?opt=list&userCard=" + userCard);
        req.setAttribute("url2", "/product?opt=deleteProduct&productId=" + ProductId + "&userCard=" + userCard);
        req.getRequestDispatcher("/emp/confirm.jsp").forward(req, resp);
    }

    private void deleteProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ProductId = req.getParameter("productId");
        ProductDao dao = new ProductDao();
        Integer count = dao.deleteProduct(Long.parseLong(ProductId));
        String userCard = req.getParameter("userCard");
        if (count > 0) {
            resp.sendRedirect("/product?opt=list&userCard=" + userCard);
        }
    }

    private void toEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ProductId = req.getParameter("productId");
        ProductDao dao = new ProductDao();
        Product product = dao.findProductById(Long.parseLong(ProductId));
        String off = "";
        String on = "";
        String no = "";
        String yes = "";
        if (product.getPublishStatus() == 0) {
            off = "checked";
        } else if (product.getPublishStatus() == 1) {
            on = "checked";
        }
        if (product.getRecommend().equals("No")) {
            no = "checked";
        } else if (product.getRecommend().equals("Yes")) {
            yes = "checked";
        }
        req.setAttribute("product", product);
        req.setAttribute("off", off);
        req.setAttribute("on", on);
        req.setAttribute("no", no);
        req.setAttribute("yes", yes);
        String userCard = req.getParameter("userCard");
        req.setAttribute("title", "Edit the Product");
        req.setAttribute("url1", "/product?opt=editProduct&userCard=" + userCard);
        req.setAttribute("url2", "/product?opt=list&userCard=" + userCard);


        req.getRequestDispatcher("/product/edit.jsp").forward(req, resp);
    }

    private static String getSubmittedFileName(Part part) {
        for (String cd : part.getHeader("content-disposition").split(";")) {
            if (cd.trim().startsWith("filename")) {
                String fileName = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
                return fileName.substring(fileName.lastIndexOf('/') + 1).substring(fileName.lastIndexOf('\\') + 1); // MSIE fix.
            }
        }
        return null;
    }

    private void editProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean isMultipart = ServletFileUpload.isMultipartContent(req);
        if (!isMultipart) {
            // Not a file upload request
            return;
        }

        DiskFileItemFactory factory = new DiskFileItemFactory();

        // Create a new file upload handler
        ServletFileUpload upload = new ServletFileUpload(factory);

        // Parse the request
        List<FileItem> items = null;
        try {
            items = upload.parseRequest(req);
        } catch (FileUploadException e) {
            e.printStackTrace();
        }

        String productId = null;
        String productName = null;
        Long categoryId = null;
        String recommend = null;
        Byte publishStatus = null;
        BigDecimal price = null;
        Float weight = null;
        String productionDate = null;
        String descript = null;
        Integer stock = null;
        Integer salesVolume = null;
        String fileName = null;
        String uniqueFileName ="";
        String imagePath =null;

        // Process the uploaded items
        for (FileItem item : items) {
            if (item.isFormField()) {
                // Process regular form field (input type="text|radio|checkbox|etc", select, textarea).
                String fieldName = item.getFieldName();
                String fieldValue = item.getString();
                switch (fieldName) {
                    case "productId":
                        productId = fieldValue;
                        break;
                    case "productName":
                        productName = fieldValue;
                        System.out.println(productName);
                        break;
                    case "categoryId":
                        categoryId = Long.valueOf(fieldValue);
                        break;
                    case "recommend":
                        recommend = fieldValue;
                        break;
                    case "publishStatus":
                        publishStatus = Byte.valueOf(fieldValue);
                        break;
                    case "price":
                        price = new BigDecimal(fieldValue);
                        break;
                    case "weight":
                        weight = Float.valueOf(fieldValue);
                        break;
                    case "productionDate":
                        productionDate = fieldValue.equals("") ? "1970-01-01" : fieldValue;
                        break;
                    case "descript":
                        descript = fieldValue;
                        break;
                    case "stock":
                        stock = Integer.valueOf(fieldValue);
                        break;
                    case "salesVolume":
                        salesVolume = Integer.valueOf(fieldValue);
                        break;
                }
            } else {
                // Process uploaded file.
                fileName = item.getName();
                if (!fileName.isEmpty()) {
                    uniqueFileName = System.currentTimeMillis() + "_" + fileName;
                    String savePath = getServletContext().getRealPath("/static/images/") + File.separator + uniqueFileName;
                    try {
                        item.write(new File(savePath));
                        imagePath = "static/images/" + uniqueFileName;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        ProductDao dao = new ProductDao();

        // if no new image is uploaded, use the old image path
        if (imagePath == null) {
            Product oldProduct = dao.findProductById(Long.parseLong(productId));
            imagePath = oldProduct.getPic();
        }

        Timestamp inDate = dao.findProductById(Long.parseLong(productId)).getIndate();
        Timestamp modifiedTime = new Timestamp(System.currentTimeMillis());

        Product product = new Product(null, productName, categoryId, price, publishStatus, Date.valueOf(productionDate), descript, recommend, weight, stock, salesVolume, inDate, modifiedTime, imagePath);

        Integer count = dao.updateProduct(product, Long.parseLong(productId));
        if (count > 0) {
            String userCard = req.getParameter("userCard");
            resp.sendRedirect("/product?opt=list&userCard=" + userCard);
        }
    }

    private void show(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CustomerDao dao = new CustomerDao();
        String userName = req.getParameter("userName");
        Customer user = dao.findCustomerByName(userName);
        req.setAttribute("user", user);
        ProductDao dao2 = new ProductDao();
        Long productId = Long.parseLong(req.getParameter("productId"));
        Product product = dao2.findProductById(productId);
        req.setAttribute("product", product);
        //通过转发器将数据交给jsp
        req.getRequestDispatcher("new/product.jsp").forward(req, resp);
    }

    private void search(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //该功能仅对用户开放
        CustomerDao dao = new CustomerDao();
        String userName = req.getParameter("userName");
        Customer user = dao.findCustomerByName(userName);
        req.setAttribute("user", user);
        String keyword = req.getParameter("keyword");
        ProductDao dao2 = new ProductDao();
        List<Product> p = dao2.searchProductPub(keyword);
        String noResult = "";
        if (p.isEmpty()) {
            noResult = "Sorry! There is no result related to " + keyword + ".";
        }
        req.setAttribute("noResult", noResult);
        req.setAttribute("p", p);
        req.setAttribute("keyword", keyword);
        //通过转发器将数据交给jsp
        req.getRequestDispatcher("/new/search.jsp").forward(req, resp);
    }

    private void category(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //该功能仅对用户开放
        CustomerDao dao = new CustomerDao();
        String userName = req.getParameter("userName");
        Customer user = dao.findCustomerByName(userName);
        req.setAttribute("user", user);
        Integer category = Integer.parseInt(req.getParameter("category"));
        ProductDao dao2 = new ProductDao();
        List<Product> p = dao2.listProductPubByCategory(category);
        String cateName = "";
        if (category == 1) {
            cateName = "Fresh Fruit";
        } else if (category == 2) {
            cateName = "Seafood & Aquatic";
        } else if (category == 3) {
            cateName = "Selected Meats";
        } else if (category == 4) {
            cateName = "Frozen Food";
        } else if (category == 5) {
            cateName = "Vegetables & Eggs";
        }
        String noResult = "";
        if (p.isEmpty()) {
            noResult = "Sorry! There is no product in " + cateName + " category.";
        }
        req.setAttribute("noResult", noResult);
        req.setAttribute("p", p);
        req.setAttribute("category", category);
        req.setAttribute("cateName", cateName);
        //通过转发器将数据交给jsp
        req.getRequestDispatcher("/new/category.jsp").forward(req, resp);
    }

    private void categorySearch(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //该功能仅对用户开放
        CustomerDao dao = new CustomerDao();
        String userName = req.getParameter("userName");
        Customer user = dao.findCustomerByName(userName);
        req.setAttribute("user", user);
        Integer category = Integer.parseInt(req.getParameter("category"));
        String keyword = req.getParameter("keyword");
        ProductDao dao2 = new ProductDao();
        List<Product> p = dao2.searchProductPubByCategory(keyword, category);
        String cateName = "";
        if (category == 1) {
            cateName = "Fresh Fruit";
        } else if (category == 2) {
            cateName = "Seafood & Aquatic";
        } else if (category == 3) {
            cateName = "Selected Meats";
        } else if (category == 4) {
            cateName = "Frozen Food";
        } else if (category == 5) {
            cateName = "Vegetables & Eggs";
        }
        String noResult = "";
        if (p.isEmpty()) {
            noResult = "Sorry! There is no product in " + cateName + " category.";
        }
        req.setAttribute("noResult", noResult);
        req.setAttribute("p", p);
        req.setAttribute("category", category);
        req.setAttribute("keyword", keyword);
        req.setAttribute("cateName", cateName);
        //通过转发器将数据交给jsp
        req.getRequestDispatcher("/new/category.jsp").forward(req, resp);
    }

}
