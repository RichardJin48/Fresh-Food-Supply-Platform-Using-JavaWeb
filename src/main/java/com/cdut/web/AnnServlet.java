package com.cdut.web;

import com.cdut.dao.AnnDao;
import com.cdut.dao.EmpDao;
import com.cdut.entity.Ann;
import com.cdut.entity.Emp;
import com.cdut.utils.CheckUtils;
import com.cdut.utils.Md5Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

@WebServlet(name = "AnnServlet", urlPatterns = "/ann")
public class AnnServlet extends HttpServlet {
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
            listAnn(req, resp);
        }
        else if("toAdd".equals(opt)){
            toAdd(req, resp);
        }
        else if("addAnn".equals(opt)){
            addAnn(req, resp);
        }
        else if("toDelete".equals(opt)){
            toDelete(req, resp);
        }
        else if("deleteAnn".equals(opt)){
            deleteAnn(req, resp);
        }
        else if("toEdit".equals(opt)){
            toEdit(req, resp);
        }
        else if("editAnn".equals(opt)){
            editAnn(req, resp);
        }
    }

    private void listAnn(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AnnDao dao = new AnnDao();
        List<Ann> anns = dao.listAnn();
        //将数据设置到请求中
        req.setAttribute("anns",anns);
        //通过身份证号识别登录的用户
        String userCard = req.getParameter("userCard");
        EmpDao dao2 = new EmpDao();
        Emp user = dao2.findEmpByIdCard(userCard);
        req.setAttribute("user",user);
        //通过转发器将数据交给jsp
        req.getRequestDispatcher("/ann/annlist.jsp").forward(req,resp);
    }

    private void toAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userCard = req.getParameter("userCard");
        req.setAttribute("title","Add an Announcement");
        req.setAttribute("url1","/ann?opt=addAnn&userCard="+userCard);//点击确认后跳转链接
        req.setAttribute("url2","/ann?opt=list&userCard="+userCard);//点击取消后跳转链接
        req.getRequestDispatcher("/ann/add.jsp").forward(req,resp);
    }

    private void addAnn(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        String content = req.getParameter("content");
        Timestamp releaseTime = new Timestamp(System.currentTimeMillis());
        Timestamp modifiedTime = new Timestamp(System.currentTimeMillis());
        Ann ann = new Ann(null, title, content, releaseTime, modifiedTime);
        AnnDao dao = new AnnDao();
        Integer count = dao.insertAnn(ann);
        String userCard = req.getParameter("userCard");
        if (count > 0) {
            resp.sendRedirect("/ann?opt=list&userCard=" + userCard);
        }
    }

    private void toDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String annId = req.getParameter("annId");
        String userCard = req.getParameter("userCard");
        AnnDao dao = new AnnDao();
        Ann ann = dao.findAnnById(Integer.parseInt(annId));
        String title = ann.getTitle();
        req.setAttribute("inf","Delete the "+title+"?");
        req.setAttribute("url1","/ann?opt=list&userCard="+userCard);//点击取消后跳转链接
        req.setAttribute("url2","/ann?opt=deleteAnn&annId="+annId+"&userCard="+userCard);//点击确认后跳转链接
        req.getRequestDispatcher("/emp/confirm.jsp").forward(req, resp);
    }

    private void deleteAnn(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String annId = req.getParameter("annId");
        AnnDao dao = new AnnDao();
        Integer count = dao.deleteAnn(Integer.parseInt(annId));
        String userCard = req.getParameter("userCard");
        if(count>0){
            resp.sendRedirect("/ann?opt=list&userCard="+userCard);
        }
    }

    private void toEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String annId = req.getParameter("annId");
        AnnDao dao = new AnnDao();
        Ann ann = dao.findAnnById(Integer.parseInt(annId));
        req.setAttribute("ann",ann);
        String userCard = req.getParameter("userCard");
        req.setAttribute("title","Edit the Announcement");
        req.setAttribute("url1","/ann?opt=editAnn&userCard="+userCard);//点击确认后跳转链接
        req.setAttribute("url2","/ann?opt=list&userCard="+userCard);//点击取消后跳转链接
        req.getRequestDispatcher("/ann/edit.jsp").forward(req,resp);
    }

    private void editAnn(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String annId = req.getParameter("annId");
        String title = req.getParameter("title");
        String content = req.getParameter("content");
        AnnDao dao = new AnnDao();
        Timestamp releaseTime = dao.findAnnById(Integer.parseInt(annId)).getReleaseTime();
        Timestamp modifiedTime = new Timestamp(System.currentTimeMillis());
        Ann ann = new Ann(null, title, content, releaseTime, modifiedTime);
        Integer count = dao.updateAnn(ann, Integer.parseInt(annId));
        if (count > 0) {
            //重新刷新列表页面
            String userCard = req.getParameter("userCard");
            resp.sendRedirect("/ann?opt=list&userCard=" + userCard);
        }
    }
}
