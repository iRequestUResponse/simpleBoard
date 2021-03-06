package kr.or.ddit.dbConnection.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.encrypt.kisa.sha256.KISA_SHA256;

/**
* User.java
*
* @author PC-17
* @version 1.0
* @see
*
* <pre>
* << 개정이력(Modification Information) >>
*
* 수정자 수정내용
* ------ ------------------------
* PC-17 최초 생성
*
* </pre>
*/
public class User {
	private static final Logger logger = LoggerFactory.getLogger(User.class);
	
	private String userNm;		// 사용자 이름
	private String pass;		// 사용자 비밀번호
	private String userId;		// 사용자 아이디
	private String alias;		// 별명
	private Date reg_dt;		// 등록일
	private String addr1;		// 주소1
	private String addr2;		// 주소2
	private String zipcode;		// 우편번호
	private String filename;		// 실제 파일명(사용자 업로드 파일명)
	private String realfilename;	// 물리 파일명
	private String realfilename2;	//
	
	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public Date getReg_dt() {
		return reg_dt;
	}
	
	public String getReg_dt_sdf() {
		logger.debug("getReg_dt_sdf method call");
		return new SimpleDateFormat("yyyy-MM-dd").format(reg_dt);
	}

	public void setReg_dt(Date reg_dt) {
		this.reg_dt = reg_dt;
	}

	public String getUserNm() {
		return userNm;
	}

	public void setUserNm(String userName) {
		this.userNm = userName;
	}

	public User() {}
	
	public User(String userName) {
		this.userNm = userName;
	}

	public User(String userName, String userId, String pass) {
		this.userNm = userName;
		this.userId = userId;
		this.pass = pass;
	}

	public User(String userId, String userNm, String alias, Date reg_dt, String addr1, String addr2,
			String zipcode, String pass, String filename, String realfilename) {
		this.userId = userId;
		this.userNm = userNm;
		this.alias = alias;
		this.reg_dt = reg_dt;
		this.addr1 = addr1;
		this.addr2 = addr2;
		this.zipcode = zipcode;
		this.pass = pass;
		this.filename = filename;
		this.realfilename = realfilename;				
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getAddr1() {
		return addr1;
	}

	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}

	public String getAddr2() {
		return addr2;
	}

	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	
	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getRealfilename() {
		return realfilename;
	}

	public void setRealfilename(String realfilename) {
		this.realfilename = realfilename;
	}

	public String getRealfilename2() {
		return realfilename2;
	}

	public void setRealfilename2(String realfilename2) {
		this.realfilename2 = realfilename2;
	}

	@Override
	public String toString() {
		return "User [userNm=" + userNm + ", pass=" + pass + ", userId=" + userId + ", alias=" + alias + ", reg_dt="
				+ reg_dt + ", addr1=" + addr1 + ", addr2=" + addr2 + ", zipcode=" + zipcode + ", filename=" + filename
				+ ", realfilename=" + realfilename + "]";
	}

	public boolean checkLoginValidate(String userId, String pass) {
		// 암호화 문장끼리 비교
		return userId.equals(this.getUserId()) && KISA_SHA256.encrypt(pass).equals(this.getPass());
	}
}
