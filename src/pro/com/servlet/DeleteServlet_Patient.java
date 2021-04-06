package pro.com.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pro.com.dao.PatientDao;

/**
 * Servlet implementation class DeleteServlet_Patient
 */
@WebServlet("/DeleteServlet_Patient")
public class DeleteServlet_Patient extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//解决 请求与相应的中文乱码问题
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PatientDao dao=new PatientDao();
		String idString=request.getParameter("id_worring");
		int id=Integer.parseInt(idString);
		boolean b=false;
		try {
			b=dao.delete(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (b) {
			System.out.println("删除成功！");
		}else {
			System.out.println("删除失败！");
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
