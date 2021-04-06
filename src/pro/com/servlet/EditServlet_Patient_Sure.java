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
 * Servlet implementation class EditServlet_Patient_Sure
 */
@WebServlet("/EditServlet_Patient_Sure")
public class EditServlet_Patient_Sure extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//解决 请求与相应的中文乱码问题
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PatientBean patientBean=new PatientBean();
		PatientDao dao=new PatientDao();
		String pidString=request.getParameter("pid_edit");
		String pemail=request.getParameter("pemail_edit");
		String pusername=request.getParameter("pusername_edit");
		String pageString=request.getParameter("page_edit");
		String pjob=request.getParameter("pjob_edit");
		String pnation=request.getParameter("pnation_edit");
		String pnatplace=request.getParameter("pnatplace_edit");
		String paddress=request.getParameter("paddress_edit");
		String pphone=request.getParameter("pphone_edit");
		String allergy=request.getParameter("allergy_edit");//过敏史
		String pid_card=request.getParameter("pid_card_edit");
		String pdiseases=request.getParameter("pdiseases_edit");//重要疾病
		String pmarriage=request.getParameter("pmarriage_edit");//婚姻
		String psex=request.getParameter("psex_edit");
		String pdescribe=request.getParameter("pdescribe_edit");
		String role=request.getParameter("role_edit");
		int pid=Integer.parseInt(pidString);
		Integer page=null;
		boolean b=false;
		if (pageString!=""&&pageString!=null) {
			page=Integer.parseInt(pageString);
		}
		try {
			patientBean=dao.find(pid);
			patientBean.setPemail(pemail);
			patientBean.setPusername(pusername);
			patientBean.setPage(page);
			patientBean.setPjob(pjob);
			patientBean.setPnation(pnation);
			patientBean.setPnatplace(pnatplace);
			patientBean.setPaddress(paddress);
			patientBean.setPphone(pphone);
			patientBean.setAllergy(allergy);
			patientBean.setPid_card(pid_card);
			patientBean.setPdiseases(pdiseases);
			patientBean.setPmarriage(pmarriage);
			patientBean.setPsex(psex);
			patientBean.setPdescribe(pdescribe);
			patientBean.setRole(role);
			b=dao.update(patientBean);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//刷新页面
		PatientBean patient=new PatientBean();
		try {
			patient=dao.find(pid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		request.setAttribute("patient_person", patient);
		request.getRequestDispatcher("\\PatientAdmin\\index_message.jsp").forward(request, response);
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
