package pro.com.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pro.com.service.PatientAdminService;

/**
 * Servlet implementation class PatientAddServlet
 */
@WebServlet("/PatientAddServlet")
public class PatientAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//解决 请求与相应的中文乱码问题
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String name=request.getParameter("name_add");
		String email=request.getParameter("email_add");
		String password=request.getParameter("password_add");
		String nation=request.getParameter("nation_add");
		String ageString=request.getParameter("age_add");
		String sex=request.getParameter("sex_add");
		String address=request.getParameter("address_add");
		int age=0;
		boolean b=false;
		if (ageString=="") {
			System.out.println("添加失败，年龄不能为空。");
		}else {
			age=Integer.parseInt(ageString);
			try {
				b=PatientAdminService.PatientAdd(name, email, password, nation, age, sex, address);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (b) {
			System.out.println("添加患者成功！");
		}else {
			System.out.println("添加患者失败!");
		}
		request.getRequestDispatcher("TabChangeServlet?show=patientManager&currentPage=1").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
