import java.util.List;
import java.util.Scanner;

public class DepartmentManager {
	public static Scanner sc = new Scanner(System.in);
	private List<Department> departmentList;
	private DepartmentDao departmentDao;
	/**
     * init DepartmentDao object and
     * read list department when init DepartmentManager object
     */ 
	public DepartmentManager() {
		departmentDao = new DepartmentDao();
		departmentList = departmentDao.read();
	}
    /**
     * add department to departmentList
     * 
     * @param department
     */
	public void add() {
        int id = (departmentList.size() > 0) ? (departmentList.size() + 1) : 1;
        System.out.println("Department id = " + id);
        String departmentName = inputName();
        Department department = new Department(id, departmentName);
        departmentList.add(department);
        departmentDao.write(departmentList);
    }
	/**
     * edit Department by id
     * 
     * @param id
     */
    public void edit(int id) {
        boolean isExisted = false;
        int size = departmentList.size();
        for (int i = 0; i < size; i++) {
            if (departmentList.get(i).getId() == id) {
                isExisted = true;
                departmentList.get(i).setDepartmentName(inputName());
                break;
            }
        }
        if (!isExisted) {
            System.out.printf("id = %d not existed.\n", id);
        } else {
            departmentDao.write(departmentList);
        }
    }
 
    /**
     * delete Department by id
     * 
     * @param id: Department id
     */
    public void delete(int id) {
        Department department = null;
        int size = departmentList.size();
        for (int i = 0; i < size; i++) {
            if (departmentList.get(i).getId() == id) {
            	department = departmentList.get(i);
                break;
            }
        }
        if (department != null) {
            departmentList.remove(department);
            departmentDao.write(departmentList);
        } else {
            System.out.printf("id = %d not existed.\n", id);
        }
    }

	/**
     * input department id
     * 
     * @return department id
     */
    public int inputId() {
        System.out.print("Input Department id: ");
        while (true) {
            try {
                int id = Integer.parseInt((sc.nextLine()));
                return id;
            } catch (NumberFormatException ex) {
                System.out.print("invalid! Input Department id again: ");
            }
        }
    }

	/**
     * input department name
     * 
     * @return department name
     */
    private String inputName() {
        System.out.print("Input Department name: ");
        return sc.nextLine();
    }

    public List<Department> getDepartmentList() {
        return departmentList;
    }
 
    public void setDepartmentList(List<Department> departmentList) {
        this.departmentList = departmentList;
    }
	public void report() {
		// TODO Auto-generated method stub
		
	}
	public void display() {
		System.out.printf("%-15s %15s %n","Id","Department Name");
		  
		for (Department department : departmentList) {
			System.out.printf("%-15s %15s %n",department.getId(),department.getDepartmentName());
        }
	}


}
