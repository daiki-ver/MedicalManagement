package pro.com.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
 * Servlet implementation class EditServlet_Patient
 */
@WebServlet("/EditServlet_Patient")
public class EditServlet_Patient extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//解决 请求与相应的中文乱码问题
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PatientBean patientBean=new PatientBean();
		PatientDao dao=new PatientDao();
		String pidString=request.getParameter("pid_edit");
		int pid=Integer.parseInt(pidString);
		try {
			patientBean=dao.find(pid);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//病历表
		List<MedicalBean> medicalList=new ArrayList<MedicalBean>();
		MedicalDao mDao=new MedicalDao();
		try {
			medicalList=mDao.findPid(pid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("medicalList",medicalList);
		request.setAttribute("patient_person", patientBean);
		request.getRequestDispatcher("\\PatientAdmin\\index_message.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
