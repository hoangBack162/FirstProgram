import java.io.Serializable;

public class Employee implements Payable, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String ssn, firstName, lastName, birthDate, phone, email;
	private int id;
	private String nameOfDepartment;
	public Employee() {

	}

	public Employee(int id, String ssn, String firstName, String lastName, String birthDate, String phone, String email, String nameOfDepartment) {
		super();
		this.id = id;
		this.ssn = ssn;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.phone = phone;
		this.email = email;
		this.nameOfDepartment = nameOfDepartment;
	}
	
	//getter && setter
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getNameOfDepartment() {
		return nameOfDepartment;
	}

	public void setNameOfDepartment(String type) {
		this.nameOfDepartment = type;
	}
	@Override
	public void getPaymentAmount() {
		// TODO Auto-generated method stub
		
	}

}
