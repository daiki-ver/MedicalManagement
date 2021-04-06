package pro.com.service;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import pro.com.bean.PageBean;
import pro.com.bean.PatientBean;
import pro.com.dao.PagePatientAdminDao;

public class PagePatientAdminService {
	//分页+查询全部
	public static PageBean<PatientBean> page(Integer pagesize, Integer currentPage,HttpServletRequest request) throws SQLException {
		PageBean<PatientBean> pageBean = new PageBean<>();
        //页面大小
        pageBean.setPageSize(pagesize);
        //从数据库得到总记录数,将其放在pageBean里面
        pageBean.setTotleCount(PagePatientAdminDao.totleCount());
        //总页码
        pageBean.setTotalPage(pageBean.getTotleCount() % pageBean.getPageSize() == 0
                ? pageBean.getTotleCount() / pageBean.getPageSize()
                : pageBean.getTotleCount() / pageBean.getPageSize() + 1);
        //当前页
        pageBean.setCurrentPage(currentPage);
        //设置url
 //       pageBean.setUrl("/PageUserAdminServlet?",request);
        //从数据库获取当前页面数据集合,传值给pageBean对象
        pageBean.setPageBean(PagePatientAdminDao.getPatientList((pageBean.getCurrentPage() - 1)*pageBean.getPageSize(), pageBean.getPageSize()));
        return pageBean;
    }
}
