import java.util.ArrayList;
import java.util.Scanner;

class Employee {
    int id;
    String name;
    double salary;

    Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}

public class EmployeeManagement {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Employee\n2. Update Employee\n3. Remove Employee\n4. Search Employee\n5. Display All Employees\n6. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Salary: ");
                    double salary = scanner.nextDouble();
                    employees.add(new Employee(id, name, salary));
                    break;

                case 2:
                    System.out.print("Enter Employee ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    for (Employee emp : employees) {
                        if (emp.id == updateId) {
                            System.out.print("Enter new Name: ");
                            emp.name = scanner.nextLine();
                            System.out.print("Enter new Salary: ");
                            emp.salary = scanner.nextDouble();
                            break;
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter Employee ID to remove: ");
                    int removeId = scanner.nextInt();
                    employees.removeIf(emp -> emp.id == removeId);
                    break;

                case 4:
                    System.out.print("Enter Employee ID to search: ");
                    int searchId = scanner.nextInt();
                    for (Employee emp : employees) {
                        if (emp.id == searchId) {
                            System.out.println(emp);
                            break;
                        }
                    }
                    break;

                case 5:
                    for (Employee emp : employees) {
                        System.out.println(emp);
                    }
                    break;

                case 6:
                    System.exit(0);

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
