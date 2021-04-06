package pro.com.bean;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

/**
 * 有些没必要设置get/set,为了节省时间,不搞了
 *
 * @param <T>
 */
public class PageBean<T> {
	
    private int currentPage=1; //当前页
    private int pageSize; //每页记录数
    private int totalPage;//总页数
    private List<T> pageBean;//当前页对象
    private String url;//用来设置Servlet访问路径及method参数
    private int totleCount;//总数据数
    
    public PageBean() {
    	
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getPageBean() {
        return pageBean;
    }

    public void setPageBean(List<T> pageBean) {
        this.pageBean = pageBean;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url,HttpServletRequest request) {
        String uri = request.getRequestURI();    //返回“项目名/请求Servlet名”的字符串
        String quString = request.getQueryString(); //获取请求的参数部分
         url = uri + "?" + quString;   //拼串，请求地址：项目名/servlet名？参数
     if (url.contains("&currentPage")) {
            //截串，将没有用的参数截去，只留下用于反射的method参数
         url = url.substring(0, url.indexOf("&currentPage"));
        }
      this.url=url;
    }

    public int getTotleCount() {
        return totleCount;
    }

    public void setTotleCount(int totleCount) {
        this.totleCount = totleCount;
    }
}
