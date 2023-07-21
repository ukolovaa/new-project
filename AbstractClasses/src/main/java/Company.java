import java.util.*;
public class Company {
    private final List<Employee> employees = new ArrayList<Employee>();
    public void hire(Employee employee) {
        this.employees.add(employee);
    }
    public void hireAll(Collection<Employee> employees) {
        this.employees.addAll(employees);
    }
    public void fire(Employee employee) {
        employees.remove(employee);
    }
    public static int getIncome() {
        return 15000000;
    }
    public List<Employee> getTopSalaryStaff(int count) {
        List<Employee> topSalary = new ArrayList<Employee>(employees);
        topSalary.sort(Comparator.comparing(Employee::getMonthSalary).reversed());
        return topSalary.subList(0, count);
    }
    public List<Employee> getLowestSalaryStaff(int count) {
        List<Employee> lowSalary = new ArrayList<>(employees);
        lowSalary.sort(Comparator.comparing(Employee::getMonthSalary));
        return lowSalary.subList(0, count);
    }
    public int countEmployees() {
        return employees.size();
    }
    public List<Employee> getEmployees() {
        return employees;
    }
}
