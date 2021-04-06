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
import pro.com.dao.DoctorDao;
import pro.com.dao.MedicalDao;
import pro.com.dao.PatientDao;

/**
 * Servlet implementation class MedicalAddServlet_Sure
 */
@WebServlet("/MedicalAddServlet_Sure")
public class MedicalAddServlet_Sure extends HttpServlet {
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
		medical.setPid(patient.getPid());
		medical.setPid_card(patient.getPid_card());
		medical.setPname(patient.getPname());
		String dname=request.getParameter("dname_edit");
		String idString=request.getParameter("id_edit");
		String diagnosis=request.getParameter("diagnosis_edit");
		String outresult=request.getParameter("outresult_edit");
		String hnumString=request.getParameter("hnum_edit");
		String bnumString=request.getParameter("bnum_edit");
		String curepass=request.getParameter("curepass_edit");
		String suit=request.getParameter("suit_edit");
		String nowill=request.getParameter("nowill_edit");
		String oldill=request.getParameter("oldill_edit");
		String marriagehis=request.getParameter("marriagehis_edit");
		String bodycheck=request.getParameter("bodycheck_edit");
		String othercheck=request.getParameter("othercheck_edit");
		String describe=request.getParameter("describe_edit");
		Integer id=null;
		Integer hnum=null;
		Integer bnum=null;
		if (idString!="")
			id=Integer.parseInt(idString);
		if (hnumString!="") 
			hnum=Integer.parseInt(hnumString);
		if (bnumString!="")
			bnum=Integer.parseInt(bnumString);
		medical.setDname(dname);
		medical.setId(id);
		medical.setDiagnosis(diagnosis);
		medical.setOutresult(outresult);
		medical.setHnum(hnum);
		medical.setBnum(bnum);
		medical.setCurepass(curepass);
		medical.setSuit(suit);
		medical.setNowill(nowill);
		medical.setOldill(oldill);
		medical.setMarriagehis(marriagehis);
		medical.setBodycheck(bodycheck);
		medical.setOthercheck(othercheck);
		medical.setDescribe(describe);
		try {
			mdao.insert(medical);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<MedicalBean> medicalList=new ArrayList<MedicalBean>();
		MedicalDao mDao=new MedicalDao();
		try {
			medicalList=mDao.findPid(pid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("medicalList",medicalList);
		request.setAttribute("patient_person",patient);
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
