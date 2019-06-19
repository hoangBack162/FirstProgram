import java.util.Scanner;

public class Main {
	public static Scanner sc = new Scanner(System.in);


	public static void main (String[]args) {
		String choose = null;
        boolean exit = false;
        DepartmentManager departmentManager = new DepartmentManager();
        EmployeeManager employeeManager = new EmployeeManager();
        int departmentId, employeeId;
     // show menu
        showMenu();
        while (true) {
            choose = sc.nextLine();
            switch (choose) {
            case "1":
            	//show Department Manager
            	showDepartmentManager();
            	boolean backMenuD = false;
            	while (true) {
            		choose = sc.nextLine();
            		switch (choose) {
            		case "1":
            			departmentManager.add();
                        break;
            		case "2":
            			departmentId = departmentManager.inputId();
            			departmentManager.edit(departmentId);
                        break;
            		case "3":
            			departmentId = departmentManager.inputId();
            			departmentManager.delete(departmentId);
                        break;  
            		case "4":
            			departmentManager.display();
                        break;
	            	case "0":
	            		System.out.println("Back to menu!");
	                    backMenuD = true;
	                    break;
	                default:
	                    System.out.println("invalid! please choose action in below menu:");
	                    break;
	                }
	                if (backMenuD) {
	                    break;
	                }
	              //show Department Manager
	            	showDepartmentManager();
            	}
                break;
            case "2":
            	//show Employee Manager
            	showEmployeeManager(); 
            	boolean backMenuE = false;
            	while (true) {
            		choose = sc.nextLine();
            		switch (choose) {
            		case "1":
            			employeeManager.add();
                        break;
            		case "2":
            			employeeId = employeeManager.inputId();
            			employeeManager.edit(employeeId);
                        break;
            		case "3":
            			employeeId = employeeManager.inputId();
            			employeeManager.delete(employeeId);
                        break;  
            		case "4":
            			employeeManager.display();
                        break;
	            	case "0":
	            		System.out.println("Back to menu!");
	                    backMenuE = true;
	                    break;

	                default:
	                    System.out.println("invalid! please choose action in below menu:");
	                    break;
	                }
	                if (backMenuE) {
	                    break;
	                }
					showEmployeeManager();
            	}
                break;
            case "3":
				showSearchMenu();
				boolean backMenuS = false;
				while (true) {
					choose = sc.nextLine();
					switch (choose) {
						case "1":
							employeeManager.searchByDepartment();
							break;
						case "2":
							employeeManager.searchByEmployerr();
							break;
						case "0":
							System.out.println("Back to menu!");
							backMenuS = true;
							break;
						default:
							System.out.println("invalid! please choose action in below menu:");
							break;
					}
					if (backMenuS) {
						break;
					}
					showSearchMenu();
				}
                break;
            case "4":
				employeeManager.report();
                break;
            case "0":
                System.out.println("exited!");
                exit = true;
                break;
            default:
                System.out.println("invalid! please choose action in below menu:");
                break;
            }
            if (exit) {
                break;
            }
            // show menu
            showMenu();
        }
    

	}

	private static void showEmployeeManager() {
		System.out.println("----------------Employee Manager-----------------");
        System.out.println("1. Add Employee.");
        System.out.println("2. Edit Employee.");
        System.out.println("3. Delete Employee.");
        System.out.println("4. Show Employee.");
        System.out.println("0. back to menu.");
        System.out.println("---------------------------");
        System.out.print("Please choose: ");
	}

	
	private static void showDepartmentManager() {
		System.out.println("----------------Department Manager-----------------");
        System.out.println("1. Add Department.");
        System.out.println("2. Edit Department.");
        System.out.println("3. Delete Department.");
        System.out.println("4. Show Department.");
        System.out.println("0. back to menu.");
        System.out.println("---------------------------");
        System.out.print("Please choose: ");
	}


	private static void showMenu() {
		System.out.println("-----------Menu------------");
        System.out.println("1. Department Manager.");
        System.out.println("2. Employee Manager.");
        System.out.println("3. Search.");
        System.out.println("4. Report.");
        System.out.println("0. exit.");
        System.out.println("---------------------------");
        System.out.print("Please choose: ");
	}

	private static void showSearchMenu() {
		System.out.println("-----------Search------------");
		System.out.println("1. Search by Department.");
		System.out.println("2. Search by Employee.");
		System.out.println("0. back to menu.");
		System.out.println("---------------------------");
		System.out.print("Please choose: ");
	}
}

