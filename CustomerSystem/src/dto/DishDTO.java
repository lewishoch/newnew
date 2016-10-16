package dto;

import java.util.Date;
import java.util.List;

public class DishDTO {
	long merchantUuid;
	long dishId;
	String dishName;
	String dishFolderPath;
	Date createdDtGmt;
	Date lastModifiedDtGmt;
	List<String> dishPath;
	
	public long getMerchantUuid() {
		return merchantUuid;
	}
	public void setMerchantUuid(long merchantUuid) {
		this.merchantUuid = merchantUuid;
	}
	public long getDishId() {
		return dishId;
	}
	public void setDishId(long dishId) {
		this.dishId = dishId;
	}
	public String getDishName() {
		return dishName;
	}
	public void setDishName(String dishName) {
		this.dishName = dishName;
	}
	public String getDishFolderPath() {
		return dishFolderPath;
	}
	public void setDishFolderPath(String dishFolderPath) {
		this.dishFolderPath = dishFolderPath;
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
	public List<String> getDishPath() {
		return dishPath;
	}
	public void setDishPath(List<String> dishPath) {
		this.dishPath = dishPath;
	}
	
	
	
}
