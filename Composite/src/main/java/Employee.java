public class Employee extends Organization {
    private double employeeSalary;

    public Employee(String name, double salary) {
        super(name);
        this.employeeSalary = salary;
    }

    @Override
    public void printOrganizationStructure() { //xml
        System.out.println("<Employee name=\"" + name + "\" salary=\"" + employeeSalary + "\"/>");
    }

    @Override
    public double salary() {
        return employeeSalary;
    }

    @Override
    public void addEmployee(Organization employee) {}

    @Override
    public void removeEmployee(Organization employee) {}

    @Override
    public void addDepartment(Organization department) {}

    @Override
    public void removeDepartment(Organization department) {}
}
