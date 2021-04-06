package pro.com.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pro.com.bean.DoctorBean;
import pro.com.dao.DoctorDao;


@WebServlet("/EditServlet_Doctor_Sure")
public class EditServlet_Doctor_Sure extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//解决 请求与相应的中文乱码问题
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String dname=request.getParameter("dname_edit");
		String djob=request.getParameter("djob_edit");
		String dphone=request.getParameter("dphone_edit");
		String dsex=request.getParameter("dsex_edit");
		String daddress=request.getParameter("daddress_edit");
		String droom=request.getParameter("droom_edit");
		String did_card=request.getParameter("did_card_edit");
		//表单提交过来的id
		String idString=request.getParameter("id");
		int id=Integer.parseInt(idString);
		DoctorDao dao=new DoctorDao();
		boolean b=false;
		DoctorBean doctorBean=new DoctorBean();
		try {
			doctorBean=dao.find(id);
			doctorBean.setDname(dname);
			doctorBean.setDjob(djob);
			doctorBean.setDphone(dphone);
			doctorBean.setDsex(dsex);
			doctorBean.setDaddress(daddress);
			doctorBean.setDroom(droom);
			doctorBean.setDid_card(did_card);
			b=dao.update(doctorBean);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//刷新页面
		DoctorBean doctor=new DoctorBean();
		try {
			doctor=dao.find(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (doctor.getDid_card()!=""||doctor.getDid_card()!=null) {
			String id_card=doctor.getDid_card();
			String year=id_card.substring(6,10);
			String month=id_card.substring(10,12);
			String day=id_card.substring(12,14);
			String birthday=""+year+"年"+month+"月"+day+"日";
			request.setAttribute("doctor_person_birthday", birthday);
		}
		request.setAttribute("doctor_person",doctor);
		request.getRequestDispatcher("\\DoctorAdmin\\index_message.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
