package LibraryManage.Model;

public class Administer {
	
	
	private String ID ;
	private String name;
	private String password;
	private String department;
	private String address;
	private String phone;
	
	

	
	public Administer(String ID,String name,String  password,String department,String address,String  phone) {
		this.ID = ID;
		this.name = name ;
		this.password = password;
		this.department=department;
		this.address=address;
		this.phone=phone;
	}
	
	public Administer() {
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

	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
