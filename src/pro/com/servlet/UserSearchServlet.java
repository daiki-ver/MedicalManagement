package pro.com.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pro.com.bean.userBean;
import pro.com.service.UserAdminService;

/**
 * Servlet implementation class UserSearchServlet
 */
@WebServlet("/UserSearchServlet")
public class UserSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//解决 请求与相应的中文乱码问题
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		//从搜索框获取信息
		String email=request.getParameter("email_search");
		String name=request.getParameter("name_search");
		String username=request.getParameter("username_search");
		String job=request.getParameter("job_search");
		String sex=request.getParameter("sex_search");
		//当搜索框全为空时  提交到原页面
		if (email==""&&name==""&&username==""&&job==""&&sex=="") {
			request.getRequestDispatcher("MainServlet").forward(request, response);
			return;
		}
		List<userBean> userlist=null;
		try {
			//调用用户管理服务中的Search方法
			userlist = UserAdminService.Search(email, name, username, job, sex);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("userList", userlist);
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
