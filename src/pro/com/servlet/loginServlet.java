package pro.com.servlet;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pro.com.bean.userBean;
import pro.com.dao.UserDao;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//解决 请求与相应的中文乱码问题
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		//获取提交信息
		String emailSubmit=request.getParameter("email");
		String passwordSubmit=request.getParameter("password");
		UserDao dao=new UserDao();
		userBean userbean=new userBean();
		try {
			userbean=dao.find(emailSubmit);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (userbean==null) {
		//	response.getWriter().print("用户不存在！");
			request.setAttribute("user", userbean);
			request.setAttribute("userNull", "该用户不存在！");
			request.getRequestDispatcher("/login.jsp").forward(request,response);
			return;
		}
		//密码校验
		if (passwordSubmit!=null&&!passwordSubmit.equals(userbean.getPassword())) {
		//	response.getWriter().println("密码错误！");
			request.setAttribute("userbean", userbean);
			request.setAttribute("passwordWrong", "密码错误！");
			request.getRequestDispatcher("/login.jsp").forward(request,response);
			return;
		}
		
		request.getSession().setAttribute("userbean", userbean);
		request.getRequestDispatcher("MainServlet").forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
