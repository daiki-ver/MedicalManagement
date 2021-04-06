package pro.com.servlet;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pro.com.bean.MedicalBean;
import pro.com.dao.MedicalDao;


@WebServlet("/EditServlet_Medical_Sure")
public class EditServlet_Medical_Sure extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//解决 请求与相应的中文乱码问题
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String midString=request.getParameter("mid_edit");
//		String indateString=request.getParameter("indate_edit");
//		String outdateString=request.getParameter("outdate_edit");
//		String pname=request.getParameter("pname_edit");
		String psex=request.getParameter("psex_edit");
		String pid_card=request.getParameter("pid_card_edit");
		String idString=request.getParameter("id_edit");
		String hnumString=request.getParameter("hnum_edit");
		String bnumString=request.getParameter("bnum_edit");
		String dname=request.getParameter("dname_edit");
		String diagnosis=request.getParameter("diagnosis_edit");
		String outresult=request.getParameter("outresult_edit");
		String suit=request.getParameter("suit_edit");
		String nowill=request.getParameter("nowill_edit");
		String oldill=request.getParameter("oldill_edit");
		String marriagehis=request.getParameter("marriagehis_edit");
		String bodycheck=request.getParameter("bodycheck_edit");
		String othercheck=request.getParameter("othercheck_edit");
		String describe=request.getParameter("describe_edit");
		int mid=Integer.parseInt(midString);
		int id=Integer.parseInt(idString);
		Integer hnum=null;
		Integer bnum=null;
		if (hnumString!=""&&hnumString!=null) {
			hnum=Integer.parseInt(hnumString);
		}
		if (bnumString!=""&&bnumString!=null) {
			bnum=Integer.parseInt(bnumString);
		}
//		SimpleDateFormat date=new SimpleDateFormat("yyyy-mm-dd");
//		Date indate=null;
//		Date outDate=null;
//		try {
//			indate=(Date) date.parse(indateString);
//			outDate=(Date) date.parse(outdateString);
//		} catch (ParseException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		
		
		
		MedicalBean medicalBean=new MedicalBean();
		MedicalDao dao=new MedicalDao();
		boolean b=false;
		try {
			medicalBean=dao.find(mid);
//			medicalBean.setIndate(indate);
//			medicalBean.setOutDate(outDate);
//			medicalBean.setPname(pname);
			medicalBean.setPsex(psex);
			medicalBean.setPid_card(pid_card);
			medicalBean.setId(id);
			medicalBean.setHnum(hnum);
			medicalBean.setBnum(bnum);
			medicalBean.setDname(dname);
			medicalBean.setDiagnosis(diagnosis);
			medicalBean.setOutresult(outresult);
			medicalBean.setSuit(suit);
			medicalBean.setNowill(nowill);
			medicalBean.setOldill(oldill);
			medicalBean.setMarriagehis(marriagehis);
			medicalBean.setBodycheck(bodycheck);
			medicalBean.setOthercheck(othercheck);
			medicalBean.setDescribe(describe);
			b=dao.update(medicalBean);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//刷新页面
		MedicalBean medical=new MedicalBean();
		try {
			medical=dao.find(mid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("medical_person", medical);
		request.getRequestDispatcher("\\MedicalAdmin\\index_message.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
