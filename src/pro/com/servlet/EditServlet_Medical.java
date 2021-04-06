package pro.com.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pro.com.bean.MedicalBean;
import pro.com.dao.MedicalDao;


@WebServlet("/EditServlet_Medical")
public class EditServlet_Medical extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//解决 请求与相应的中文乱码问题
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String midString=request.getParameter("mid_edit");
		int mid=Integer.parseInt(midString);
		MedicalBean medical=new MedicalBean();
		MedicalDao dao=new MedicalDao();
		try {
			medical=dao.find(mid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("medical_person", medical);
		request.getRequestDispatcher("\\MedicalAdmin\\index_message.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
