//import java.util.ArrayList;
//import java.util.List;
import java.io.Serializable;
import java.util.Scanner;

public class Department implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String departmentName;
//	List<String> listOfEmployee = new ArrayList<String>();
	static Scanner sc = new Scanner(System.in);
	public Department() {

	}
	public Department(int id, String departmentName) {
		super();
		this.id = id;
		this.departmentName = departmentName;
//		this.listOfEmployee = listOfEmployee;
	}
	//getter && setter
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

}
