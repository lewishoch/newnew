package po;

import java.util.Date;

public class AdminAccount {
	long accountUuid;
	String userName;
	String password;
	Date createdDtGmt;
	Date lastModifiedDtGmt;
	public long getAccountUuid() {
		return accountUuid;
	}
	public void setAccountUuid(long accountUuid) {
		this.accountUuid = accountUuid;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getCreatedDtGmt() {
		return createdDtGmt;
	}
	public void setCreatedDtGmt(Date createdDtGmt) {
		this.createdDtGmt = createdDtGmt;
	}
	public Date getLastModifiedDtGmt() {
		return lastModifiedDtGmt;
	}
	public void setLastModifiedDtGmt(Date lastModifiedDtGmt) {
		this.lastModifiedDtGmt = lastModifiedDtGmt;
	}
	
}
