package pro.com.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pro.com.bean.DoctorBean;
import pro.com.service.DoctorAdminService;

@WebServlet("/DoctorSearchServlet")

public class DoctorSearchServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//解决 请求与相应的中文乱码问题
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		//从搜索框获取信息
		String idString=request.getParameter("id_search");
		String name=request.getParameter("name_search");
		String room=request.getParameter("room_search");
		String job=request.getParameter("job_search");
		int id=0;
		if (idString!="") {
			id=Integer.parseInt(idString);
		}
		//当搜索框为空，刷新界面
		if (id==0&&name==""&&room==""&&job=="") {
			request.getRequestDispatcher("TabChangeServlet?show=doctorManager&currentPage=1").forward(request, response);
			return;
		}
		List<DoctorBean> doctorList=null;
		try {
			doctorList = DoctorAdminService.Search(id,name,room,job);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("doctorList", doctorList);
		request.getRequestDispatcher("\\DoctorAdmin\\index.jsp").forward(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
