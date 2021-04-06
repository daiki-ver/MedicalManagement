package pro.com.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pro.com.dao.DoctorDao;

@WebServlet("/DeleteServlet_Doctor")

public class DeleteServlet_Doctor extends HttpServlet {


	private static final long serialVersionUID = 1L;


	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//解决 请求与相应的中文乱码问题
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		DoctorDao dao=new DoctorDao();
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
		request.getRequestDispatcher("TabChangeServlet?show=doctorManager&currentPage=1").forward(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
