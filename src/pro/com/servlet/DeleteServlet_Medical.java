package pro.com.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pro.com.dao.MedicalDao;

/**
 * Servlet implementation class DeleteServelt_Medical
 */
@WebServlet("/DeleteServlet_Medical")
public class DeleteServlet_Medical extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//解决 请求与相应的中文乱码问题
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		MedicalDao dao=new MedicalDao();
		String midString=request.getParameter("id_worring");
		int mid=Integer.parseInt(midString);
		boolean b=false;
		try {
			b=dao.delete(mid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (b) {
			System.out.println("删除成功！");
		}else {
			System.out.println("删除失败！");
		}
		request.getRequestDispatcher("TabChangeServlet?show=medicalManager&currentPage=1").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
