package cn.dennishucd.neverforget.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private long id;
	
	@Column(name = "loginName", nullable = false)
	private String loginName;
	
	@Column(name = "passwd", nullable = false)
	private String passwd;
	
	@Column(name = "mobile", nullable = false)
	private String mobile;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("id: "+id);
		sb.append(", loginName: "+loginName);
		sb.append(", passwd: "+passwd);
		sb.append(", mobile: "+mobile);
		
		return sb.toString();
	}
}
