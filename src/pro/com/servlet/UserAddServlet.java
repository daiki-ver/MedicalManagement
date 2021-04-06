package pro.com.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pro.com.service.UserAdminService;

/**
 * Servlet implementation class UserAddServlet
 */
@WebServlet("/UserAddServlet")
public class UserAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//解决 请求与相应的中文乱码问题
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String email=request.getParameter("email_add");
		String name=request.getParameter("name_add");
		String username=request.getParameter("username_add");
		String password=request.getParameter("password_add");
		String address=request.getParameter("address_add");
		String phone=request.getParameter("phone_add");
		String job=request.getParameter("job_add");
		String sex=request.getParameter("sex_add");
		String role=request.getParameter("role_add");
		boolean b=false;
		try {
			b=UserAdminService.UserAdd(email, name, username, password, address, phone, job, sex, role);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (b) {
			System.out.println("插入用户成功！");
		}else {
			System.out.println("抱歉，插入失败！");
		}
		request.getRequestDispatcher("UserAdminServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
