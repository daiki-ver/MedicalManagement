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

@WebServlet("/EditServlet_Doctor")
public class EditServlet_Doctor extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//解决 请求与相应的中文乱码问题
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String idString=request.getParameter("id_edit");
		int id=Integer.parseInt(idString);
		DoctorBean doctor=new DoctorBean();
		DoctorDao dao=new DoctorDao();
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


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
