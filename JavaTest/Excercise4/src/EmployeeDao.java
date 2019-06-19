import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;


public class EmployeeDao {
	private static final String EMPLOYEE_FILE_NAME = "Employee.txt";
	public void write(List<Employee> employeeList) {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream(new File(EMPLOYEE_FILE_NAME));
			oos = new ObjectOutputStream(fos);
			oos.writeObject(employeeList);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			closeStream(fos);
			closeStream(oos);
		}
	}
	
	public List<Employee> read(){
        List<Employee> employeeList = new ArrayList<>();
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(new File(EMPLOYEE_FILE_NAME));
            ois = new ObjectInputStream(fis);
            employeeList = (List<Employee>) ois.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeStream(fis);
            closeStream(ois);
        }
        return employeeList;

	}
	private void closeStream(ObjectInputStream ois) {
		if(ois !=null) {
			try {
				ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	private void closeStream(FileInputStream fis) {
		if(fis !=null) {
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	private void closeStream(OutputStream os) {
        if (os != null) {
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
