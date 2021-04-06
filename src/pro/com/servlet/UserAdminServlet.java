package pro.com.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pro.com.bean.PageBean;
import pro.com.bean.userBean;
import pro.com.dao.PageUserAdminDao;
import pro.com.service.PageUserAdminService;

/**
 * Servlet implementation class UserAdmin
 */
@WebServlet("/UserAdminServlet")
public class UserAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
			Integer currentPage;
			try {
				currentPage = Integer.parseInt(request.getParameter("currentPage"));
			} catch (Exception e1) {
				// TODO: handle exception
				currentPage = 1;
			}
			
	        //获取PageBean对象
	        PageBean<userBean> page=null;
			try {
				page = PageUserAdminService.page(7, currentPage,request);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			List<userBean> userList=new ArrayList<userBean>();
			try {
				userList=PageUserAdminDao.getUserList((currentPage-1)*7, 7);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
	        request.setAttribute("page", page);
	        request.setAttribute("userList",userList);
			
//			request.getSession().setAttribute("userList", userList);
			
			request.getRequestDispatcher("\\UserAdmin\\index.jsp").forward(request, response);
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
