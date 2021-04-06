package pro.com.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pro.com.bean.MedicalBean;
import pro.com.bean.PatientBean;
import pro.com.dao.MedicalDao;
import pro.com.dao.PatientDao;

/**
 * Servlet implementation class MedicalAddServlet
 */
@WebServlet("/MedicalAddServlet")
public class MedicalAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//解决 请求与相应的中文乱码问题
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String pidString=request.getParameter("pid");
		int pid=Integer.parseInt(pidString);
		MedicalBean medical=new MedicalBean();
		PatientBean patient=new PatientBean();
		PatientDao pdao=new PatientDao();
		MedicalDao mdao=new MedicalDao();
		try {
			patient=pdao.find(pid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("medical_person",patient);
		request.getRequestDispatcher("\\PatientAdmin\\index_add.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
