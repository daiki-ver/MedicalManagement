package pro.com.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pro.com.bean.PatientBean;
import pro.com.service.PatientAdminService;

/**
 * Servlet implementation class PatientSearchServlet
 */
@WebServlet("/PatientSearchServlet")
public class PatientSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//解决 请求与相应的中文乱码问题
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		//从搜索框获取信息
		String idString=request.getParameter("id_search");
		String natplace=request.getParameter("natplace_search");
		String name=request.getParameter("name_search");
		String sex=request.getParameter("sex_search");
		int id=0;
		if (idString!="") {
			id=Integer.parseInt(idString);
		}
		//当搜索框全为空时  提交到原页面
		if (id==0&&natplace==""&&name==""&&sex=="") {
			request.getRequestDispatcher("TabChangeServlet?show=patientManager&currentPage=1").forward(request, response);
			return;
		}
		List<PatientBean> patientList=null;
		try {
			patientList=PatientAdminService.Search(id, natplace, name, sex);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("patientList", patientList);
		request.getRequestDispatcher("\\PatientAdmin\\index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
