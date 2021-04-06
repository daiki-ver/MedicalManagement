package pro.com.servlet;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pro.com.bean.userBean;
import pro.com.dao.UserDao;

/**
 * Servlet implementation class EditSetServlet
 */
@WebServlet("/EditSetServlet_User_Sure")
public class EditServlet_User_Sure extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//解决 请求与相应的中文乱码问题
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		userBean user=new userBean();
		UserDao dao=new UserDao();
		try {
			user=dao.find(request.getParameter("email_edit"));
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		user.setName(request.getParameter("name_edit"));
		user.setUsername(request.getParameter("username_edit"));
//		user.setPassword(request.getParameter("password_edit"));
		user.setSex(request.getParameter("sex_edit"));
		user.setJob(request.getParameter("job_edit"));
		user.setPhone(request.getParameter("phone_edit"));
		user.setDescribe(request.getParameter("describe_edit"));
		user.setAddress(request.getParameter("address_edit"));
		user.setRole(request.getParameter("role_edit"));
		String bir=request.getParameter("birthday_edit");
		SimpleDateFormat date=new SimpleDateFormat("yyyy-mm-dd");
//		Date birthday=null;
//		try {
//			birthday=(Date) date.parse(bir);
//		} catch (ParseException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		user.setBirthday(birthday);
		boolean b=false;
		try {
			b=UserDao.update(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (b) {
			System.out.println("修改成功！");
		}else {
			System.out.println("修改失败！");
		}
		//刷新页面
		try {
			user=dao.find(user.getEmail());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("userEdit", user);
		request.getRequestDispatcher("\\UserAdmin\\index_message.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
