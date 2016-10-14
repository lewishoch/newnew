package po;

import java.util.Date;

public class Merchant {
	private long uuid;
	private int status;
	private String uname;
	private String psd;
	private Date creDt;
	private Date lastModDt;
	public Date getCreDt() {
		return creDt;
	}
	public void setCreDt(Date creDt) {
		this.creDt = creDt;
	}
	public Date getLastModDt() {
		return lastModDt;
	}
	public void setLastModDt(Date lastModDt) {
		this.lastModDt = lastModDt;
	}
	public long getUuid() {
		return uuid;
	}
	public void setUuid(long uuid) {
		this.uuid = uuid;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPsd() {
		return psd;
	}
	public void setPsd(String psd) {
		this.psd = psd;
	}
}
