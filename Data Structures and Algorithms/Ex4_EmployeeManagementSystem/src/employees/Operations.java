package employees;

public class Operations {
    private Employee[] employees;
	    private int size;

	    public Operations(int capacity) {
	        employees = new Employee[capacity];
	        size = 0;
	    }

	    public void addEmployee(Employee employee) {
	        if (size < employees.length) {
	            employees[size++] = employee;
	        } else {
	            System.out.println("Employee array is full.");
	        }
	    }

	    public Employee searchEmployee(String employeeId) {
	        for (Employee emp : employees) {
	            if (emp != null && emp.getEmployeeId().equals(employeeId)) {
	                return emp;
	            }
	        }
	        return null;
	    }

	    public void traverseEmployees() {
	        for (Employee emp : employees) {
	            if (emp != null) {
	                System.out.println(emp.getEmployeeId() + ": " + emp.getName() + ", Position: " + emp.getPosition() + ", Salary: " + emp.getSalary());
	            }
	        }
	    }

	    public void deleteEmployee(String employeeId) {
	        for (int i = 0; i < size; i++) {
	            if (employees[i].getEmployeeId().equals(employeeId)) {
	                for (int j = i; j < size - 1; j++) {
	                    employees[j] = employees[j + 1];
	                }
	                employees[--size] = null;
	                return;
	            }
	        }
	        System.out.println("Employee not found.");
	    }
	}
