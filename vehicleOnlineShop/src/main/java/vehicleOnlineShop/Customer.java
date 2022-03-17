package vehicleOnlineShop;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer {
	@Id 
	private int id ;
	private String name;
	private String password ;
	private int phone_no ;
	private String address ;
	private int roll_id ;
	private String gender;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public int getPhone_no() {
		return phone_no;
	}
	public void setPhone_no(int phone_no) {
		this.phone_no = phone_no;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getRoll_id() {
		return roll_id;
	}
	public void setRoll_id(int roll_id) {
		this.roll_id = roll_id;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", password=" + password + ", phone_no=" + phone_no
				+ ", address=" + address + ", roll_id=" + roll_id + ", gender=" + gender + "]";
	}
	
	
	
	
	

}
