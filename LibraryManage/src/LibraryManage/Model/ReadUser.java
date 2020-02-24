package LibraryManage.Model;


public class ReadUser {
	
	private String  readerid;
	private String username;
	private String password;
	private String department;
	private String address;
	private String phone;
	
	public ReadUser() {}
	
	
	public ReadUser(String readerid,String username,String  password,String department,String address,String  phone) {
		this.readerid = readerid;
		this.username=username;
		this.password=password;
		this.department=department;
		this.address=address;
		this.phone=phone;
	}
	

	public String getReaderid() {
		return readerid;
	}
	public void setReaderid(String readerid) {
		this.readerid = readerid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

}

