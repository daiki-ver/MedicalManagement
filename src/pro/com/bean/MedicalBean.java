package pro.com.bean;

import java.sql.Date;

public class MedicalBean {
	int mid;//病历编号
	int id; //主治医生编号
	int pid; //患者编号
	String pid_card; //患者身份证号
	String pname; //患者姓名
	String psex;
	String dname; //主治医生姓名
	String droom; //科室
	Date indate; //入院日期
	Date outDate; //出院日期
	String diagnosis; //诊断结果
	String outresult; //出院结果
	int hnum; //住院号
	int bnum; //病床号
	String curepass; //治疗经过
	String suit; //主诉
	String nowill; //现病史
	String oldill; //既往史
	String marriagehis; //婚姻史
	String bodycheck; //体检
	String othercheck; //辅助检查
	String describe; //描述
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPid_card() {
		return pid_card;
	}
	public void setPid_card(String pid_card) {
		this.pid_card = pid_card;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPsex() {
		return psex;
	}
	public void setPsex(String psex) {
		this.psex = psex;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getDroom() {
		return droom;
	}
	public void setDroom(String droom) {
		this.droom = droom;
	}
	public Date getIndate() {
		return indate;
	}
	public void setIndate(Date indate) {
		this.indate = indate;
	}
	public Date getOutDate() {
		return outDate;
	}
	public void setOutDate(Date outDate) {
		this.outDate = outDate;
	}
	public String getDiagnosis() {
		return diagnosis;
	}
	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}
	public String getOutresult() {
		return outresult;
	}
	public void setOutresult(String outresult) {
		this.outresult = outresult;
	}
	public int getHnum() {
		return hnum;
	}
	public void setHnum(int hnum) {
		this.hnum = hnum;
	}
	public int getBnum() {
		return bnum;
	}
	public void setBnum(int bnum) {
		this.bnum = bnum;
	}
	public String getCurepass() {
		return curepass;
	}
	public void setCurepass(String curepass) {
		this.curepass = curepass;
	}
	public String getSuit() {
		return suit;
	}
	public void setSuit(String suit) {
		this.suit = suit;
	}
	public String getNowill() {
		return nowill;
	}
	public void setNowill(String nowill) {
		this.nowill = nowill;
	}
	public String getOldill() {
		return oldill;
	}
	public void setOldill(String oldill) {
		this.oldill = oldill;
	}
	public String getMarriagehis() {
		return marriagehis;
	}
	public void setMarriagehis(String marriagehis) {
		this.marriagehis = marriagehis;
	}
	public String getBodycheck() {
		return bodycheck;
	}
	public void setBodycheck(String bodycheck) {
		this.bodycheck = bodycheck;
	}
	public String getOthercheck() {
		return othercheck;
	}
	public void setOthercheck(String othercheck) {
		this.othercheck = othercheck;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	
}
