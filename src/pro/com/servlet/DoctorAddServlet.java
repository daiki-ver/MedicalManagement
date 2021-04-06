package pro.com.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pro.com.service.DoctorAdminService;

@WebServlet("/DoctorAddServlet")

public class DoctorAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//解决 请求与相应的中文乱码问题
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String email=request.getParameter("email_add");
		String password=request.getParameter("password_add");
		String name=request.getParameter("name_add");
		String room=request.getParameter("room_add");
		String job=request.getParameter("job_add");
		String sex=request.getParameter("sex_add");
		String phone=request.getParameter("phone_add");
		String address=request.getParameter("address_add");
		String ageString=request.getParameter("age_add");
		String role="doctor";
		int age=Integer.parseInt(ageString);
		boolean b=false;
		System.out.println(phone);
		try {
			System.out.println(email);
			b=DoctorAdminService.DoctorAdd(email, password, name, room, job, sex, age, phone, address, role);
			System.out.println(name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (b) {
			System.out.println("添加医生成功！");
		}else {
			System.out.println("添加医生失败！");
		}
		request.getRequestDispatcher("TabChangeServlet?show=doctorManager&currentPage=1").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
