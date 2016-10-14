package po;

import java.util.Date;

public class MerchantProfile {
	private long uuid;
	private String mName;
	private int mAge;
	private String mGender;
	private String sName;
	private String sAddr;
	private int sTel;
	private String sLogoPath;
	private Date creDt;
	private Date lastModDt;
	private long mAccountUuid;
	public long getUuid() {
		return uuid;
	}
	public void setUuid(long uuid) {
		this.uuid = uuid;
	}
	public String getmName() {
		return mName;
	}
	public void setmName(String mName) {
		this.mName = mName;
	}
	public int getmAge() {
		return mAge;
	}
	public void setmAge(int mAge) {
		this.mAge = mAge;
	}
	public String getmGender() {
		return mGender;
	}
	public void setmGender(String mGender) {
		this.mGender = mGender;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public String getsAddr() {
		return sAddr;
	}
	public void setsAddr(String sAddr) {
		this.sAddr = sAddr;
	}
	public int getsTel() {
		return sTel;
	}
	public void setsTel(int sTel) {
		this.sTel = sTel;
	}
	public String getsLogoPath() {
		return sLogoPath;
	}
	public void setsLogoPath(String sLogoPath) {
		this.sLogoPath = sLogoPath;
	}
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
	public long getmAccountUuid() {
		return mAccountUuid;
	}
	public void setmAccountUuid(long mAccountUuid) {
		this.mAccountUuid = mAccountUuid;
	}
}
