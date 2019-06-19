import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class  EmployeeManager {
	public static Scanner sc = new Scanner(System.in);
	private List<Employee> employeeList;
	private EmployeeDao employeeDao;

	DepartmentManager departmentManager = new DepartmentManager();

	/**
	 * init EmployeeDao object and
	 * read list employee when init EmployeeManager object
	 */
	public EmployeeManager() {
		employeeDao = new EmployeeDao();
		employeeList = employeeDao.read();
	}

	/**
	 * add employee to employeeList
	 */
	public void add() {
		int id = (employeeList.size() > 0) ? (employeeList.size() + 1) : 1;
		System.out.println("Employee id = " + id);
		String ssn = inputSsn();
		String firstName = inputFirstName();
		String lastName = inputLastName();
		String birthDate = inputBirthDate();
		String phone = inputPhone();
		String email = inputEmail();
		String nameOfDepartment = inputDepartmentName();
		Employee employee = new Employee(id, ssn, firstName, lastName, birthDate, phone, email, nameOfDepartment);
		employeeList.add(employee);
		employeeDao.write(employeeList);
	}


	/**
	 * edit Employee by id
	 *
	 * @param id
	 */
	public void edit(int id) {
		boolean isExisted = false;
		int size = employeeList.size();
		for (int i = 0; i < size; i++) {
			if (employeeList.get(i).getId() == id) {
				isExisted = true;
				employeeList.get(i).setSsn(inputSsn());
				employeeList.get(i).setFirstName(inputFirstName());
				employeeList.get(i).setLastName(inputLastName());
				employeeList.get(i).setBirthDate(inputBirthDate());
				employeeList.get(i).setPhone(inputPhone());
				employeeList.get(i).setEmail(inputEmail());
				employeeList.get(i).setNameOfDepartment(inputDepartmentName());
				break;
			}
		}
		if (!isExisted) {
			System.out.printf("id = %d not existed.\n", id);
		} else {
			employeeDao.write(employeeList);
		}
	}

	/**
	 * delete Employee by id
	 *
	 * @param id: Employee id
	 */
	public void delete(int id) {
		Employee employee = null;
		int size = employeeList.size();
		for (int i = 0; i < size; i++) {
			if (employeeList.get(i).getId() == id) {
				employee = employeeList.get(i);
				break;
			}
		}
		if (employee != null) {
			employeeList.remove(employee);
			employeeDao.write(employeeList);
		} else {
			System.out.printf("id = %d not existed.\n", id);
		}
	}

	/**
	 * input employee id
	 *
	 * @return employee id
	 */
	public int inputId() {
		System.out.print("Input Employee id: ");
		while (true) {
			try {
				int id = Integer.parseInt((sc.nextLine()));
				return id;
			} catch (NumberFormatException ex) {
				System.out.print("invalid! Input Employee id again: ");
			}
		}
	}

	/**
	 * input employee first name
	 *
	 * @return employee first name
	 */
	private String inputFirstName() {
		System.out.print("Input Employee first Name: ");
		return sc.nextLine();
	}

	/**
	 * input employee last name
	 *
	 * @return employee last name
	 */
	private String inputLastName() {
		System.out.print("Input Employee last Name: ");
		return sc.nextLine();
	}

	/**
	 * input email
	 *
	 * @return email
	 */
	private String inputEmail() {
		String regex = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		Pattern mailPattern = Pattern.compile(regex);

		boolean flag;
		do {
			System.out.print("Input Email: ");
			String email = sc.nextLine();
			Matcher matcher = mailPattern.matcher(email);
			if (!matcher.matches()) {
				flag = false;
				System.out.println("Email must is correct format");

			} else {
				return email;
			}
		} while (flag == true);
		return inputEmail();
	}

	/**
	 * input phone
	 *
	 * @return phone
	 */
	private String inputPhone() {
		String regex = "^[0-9]*$";
		Pattern phonePattern = Pattern.compile(regex);
		sc = new Scanner(System.in);
		boolean flag;
		do {
			System.out.print("Input Phone: ");
			String phone = sc.nextLine();
			Matcher matcher = phonePattern.matcher(phone);
			if (phone.length()< 7) {
				flag = false;
				System.out.println("Phone number must be minimum 7 positive integers");
			} else {
				if(!matcher.matches()) {
					flag = false;
					System.out.println("Phone number must is number");
				}else {
					return phone;
				}
			}
		} while (flag == true);
		return inputPhone();
	}

	/**
	 * input birth date
	 *
	 * @return birthDate
	 */
	private String inputBirthDate() {
		boolean flag;
		String regex = "^(?:(?:(?:0?[13578]|1[02])(\\/|-|\\.)31)\\1|" +
				"(?:(?:0?[1,3-9]|1[0-2])(\\/|-|\\.)(?:29|30)\\2))" +
				"(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:0?2(\\/|-|\\.)29\\3" +
				"(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|" +
				"[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|" +
				"^(?:(?:0?[1-9])|(?:1[0-2]))(\\/|-|\\.)(?:0?[1-9]|1\\d|" +
				"2[0-8])\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";

		Pattern datePattern = Pattern.compile(regex);

		do {
			System.out.print("Input Birth Date: ");
			String birthDate = sc.nextLine();
			Matcher matcher = datePattern.matcher(birthDate);
			if (!matcher.matches()) {
				flag = false;
				System.out.println("Date to correct format(mm/dd/yyyy)");
			} else {
				return birthDate;
			}
		} while (flag == true);
		return inputBirthDate();
	}

	/**
	 * input Ssn
	 *
	 * @return Ssn
	 */
	private String inputSsn() {
		System.out.print("Input Ssn: ");
		return sc.nextLine();
	}

	/**
	 * input DepartmentName
	 *
	 * @return DepartmentName
	 */
	private String inputDepartmentName() {
		System.out.println("Select Department Name by Id: ");
		departmentManager.display();
		int choose = sc.nextInt();
		String nameOfDepartment = null;
		List<Department> departmentList = departmentManager.getDepartmentList();
		for (int i = 0; i < departmentList.size(); i++) {
			Department department = departmentList.get(i);
			if (choose == department.getId()) {
				nameOfDepartment = department.getDepartmentName();
				return nameOfDepartment;
			}
		}
		return inputDepartmentName();
	}

	public List<Employee> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}

	/**
	 * Report
	 */
	public void report() {
		List<Department> departmentList = departmentManager.getDepartmentList();
		System.out.printf("%-5s %40s %n", "Department", "Number of Employees");
		for (Department department : departmentList) {
			int numberOfEmployee = 0;

			for (Employee employee : employeeList) {
				if (department.getDepartmentName().equals(employee.getNameOfDepartment())) {
					numberOfEmployee = numberOfEmployee + 1;
				}
			}
			System.out.printf("%-5s %40s %n", department.getDepartmentName(), numberOfEmployee);
		}
	}

	/**
	 * Search
	 */

	public void searchByDepartment() {
		System.out.print("Search by Deapartment: ");
		String searchDepartName = sc.nextLine();

		Pattern pattern = Pattern.compile(".*" + searchDepartName + ".*", Pattern.CASE_INSENSITIVE);
		List<Employee> match = new ArrayList<>();
		System.out.printf("%-5s %5s %15s %15s %15s %15s %15s %15s  %n", "Id", "Ssn", "First Name", "Last Name", "Birth Date", "Phone", "Email", "Department Name");

		for (Employee employee : employeeList) {
			String nameOfDepartment = employee.getNameOfDepartment();
//			String firstName  = employee.getFirstName();

			if (nameOfDepartment != null) {
				Matcher matcher = pattern.matcher(nameOfDepartment);
				if (matcher.matches()) {
					System.out.printf("%-5s %5s %15s %15s %15s %15s %15s %15s %n",
							employee.getId(),
							employee.getSsn(),
							employee.getFirstName(),
							employee.getLastName(),
							employee.getBirthDate(),
							employee.getPhone(),
							employee.getEmail(),
							employee.getNameOfDepartment());
				}
			}
		}
	}

	public void searchByEmployerr() {
		System.out.print("Search by Employee - Input First Name or Last Name: ");
		String searchEmpName = sc.nextLine();
		Pattern pattern = Pattern.compile(".*" + searchEmpName + ".*", Pattern.CASE_INSENSITIVE);
		List<Employee> match = new ArrayList<>();
		System.out.printf("%-5s %5s %15s %15s %15s %15s %15s %15s  %n", "Id", "Ssn", "First Name", "Last Name", "Birth Date", "Phone", "Email", "Department Name");

		for (Employee employee : employeeList) {
			String lastNameOfEmp = employee.getLastName();
//			String firstName  = employee.getFirstName();

			if (lastNameOfEmp != null) {
				Matcher matcher = pattern.matcher(lastNameOfEmp);
				if (matcher.matches()) {
					System.out.printf("%-5s %5s %15s %15s %15s %15s %15s %15s %n",
							employee.getId(),
							employee.getSsn(),
							employee.getFirstName(),
							employee.getLastName(),
							employee.getBirthDate(),
							employee.getPhone(),
							employee.getEmail(),
							employee.getNameOfDepartment());
				}
			}
		}
		for (Employee employee : employeeList) {
			String firstNameOfEmp = employee.getFirstName();
//			String firstName  = employee.getFirstName();

			if (firstNameOfEmp != null) {
				Matcher matcher = pattern.matcher(firstNameOfEmp);
				if (matcher.matches()) {
					System.out.printf("%-5s %5s %15s %15s %15s %15s %15s %15s %n",
							employee.getId(),
							employee.getSsn(),
							employee.getFirstName(),
							employee.getLastName(),
							employee.getBirthDate(),
							employee.getPhone(),
							employee.getEmail(),
							employee.getNameOfDepartment());
				}
			}
		}
	}

	public void display() {
		System.out.printf("%-5s %5s %15s %15s %15s %15s %15s %15s  %n", "Id", "Ssn", "First Name", "Last Name", "Birth Date", "Phone", "Email", "Department Name");
		for (Employee employee : employeeList) {
			System.out.printf("%-5s %5s %15s %15s %15s %15s %15s %15s %n",
					employee.getId(),
					employee.getSsn(),
					employee.getFirstName(),
					employee.getLastName(),
					employee.getBirthDate(),
					employee.getPhone(),
					employee.getEmail(),
					employee.getNameOfDepartment());
		}

	}


}
