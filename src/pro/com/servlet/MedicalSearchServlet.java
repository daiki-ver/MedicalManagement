package pro.com.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pro.com.bean.MedicalBean;
import pro.com.service.MedicalAdminService;

@WebServlet("/MedicalSearchServlet")
public class MedicalSearchServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//解决 请求与相应的中文乱码问题
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		//获取搜索信息
		String midString=request.getParameter("mid_search");
		String pname=request.getParameter("pname_search");
		String dname=request.getParameter("dname_search");
		int mid=0;
		if (midString!="") {
			mid=Integer.parseInt(midString);
		}
		//当搜索框全为空，提交到原页面
		if (mid==0&&pname==""&&dname=="") {
			request.getRequestDispatcher("TabChangeServlet?show=medicalManager&currentPage=1").forward(request, response);
			return;
		}
		//不全为空时 返回list；
		List<MedicalBean> medicalList = null;
		try {
			medicalList=MedicalAdminService.Search(mid, pname, dname);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("medicalList", medicalList);
		request.getRequestDispatcher("\\MedicalAdmin\\index.jsp").forward(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
