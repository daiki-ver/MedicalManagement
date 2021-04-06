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
import pro.com.bean.MedicalBean;
import pro.com.bean.PageBean;
import pro.com.bean.PatientBean;
import pro.com.bean.userBean;
import pro.com.service.PageDoctorAdminService;
import pro.com.service.PageMedicalAdminService;
import pro.com.service.PagePatientAdminService;
import pro.com.service.PageUserAdminService;

/**
 * Servlet implementation class TabChangeServlet
 */

@WebServlet("/TabChangeServlet")
public class TabChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String show=request.getParameter("show");
		
	    switch (show) {
		case "systemManager":		
			//获取当前页
			Integer currentPage = Integer.parseInt(request.getParameter("currentPage"));
	        //获取PageBean对象
	        PageBean<userBean> page=null;
			try {
				page = PageUserAdminService.page(7, currentPage,request);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	        List<userBean> pageBean = page.getPageBean();
	        request.setAttribute("page", page);
	        request.setAttribute("userList",pageBean);
			
			request.getRequestDispatcher("\\UserAdmin\\index.jsp").forward(request, response);
			break;
		case "patientManager":
			//获取当前页
			Integer currentPage1 = Integer.parseInt(request.getParameter("currentPage"));
	        //获取PageBean对象
	        PageBean<PatientBean> page1=null;
			try {
				page1 = PagePatientAdminService.page(7, currentPage1,request);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			List<PatientBean> pageBean1 = page1.getPageBean();
	        request.setAttribute("page", page1);
	        request.setAttribute("patientList",pageBean1);
			request.getRequestDispatcher("\\PatientAdmin\\index.jsp").forward(request, response);
			break;
		case "medicalManager":
			//获取当前页
			Integer currentPage2 = Integer.parseInt(request.getParameter("currentPage"));
	        //获取PageBean对象
	        PageBean<MedicalBean> page2=null;
			try {
				page2 = PageMedicalAdminService.page(7, currentPage2,request);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			List<MedicalBean> pageBean2 = page2.getPageBean();
	        request.setAttribute("page", page2);
	        request.setAttribute("medicalList",pageBean2);
			
			request.getRequestDispatcher("\\MedicalAdmin\\index.jsp").forward(request, response);
			break;
		case "doctorManager" :
			//获取当前页
			Integer currentPage3 = Integer.parseInt(request.getParameter("currentPage"));
	        //获取PageBean对象
			System.out.println(currentPage3);
	        PageBean<DoctorBean> page3=null;
			try {
				page3 = PageDoctorAdminService.page(7, currentPage3,request);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			List<DoctorBean> pageBean3 = page3.getPageBean();
	        request.setAttribute("page", page3);
	        request.setAttribute("doctorList",pageBean3);
			
			request.getRequestDispatcher("\\DoctorAdmin\\index.jsp").forward(request, response);
			break;
		default:
			break;
		}
	    return;
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
