public class Main {
    public static void main(String[] args) {

        Employee e1 = new Employee("Juho", 3000);
        Employee e2 = new Employee("Pekka", 2500);
        Employee e3 = new Employee("Olli", 2000);
        Employee e4 = new Employee("Liisa", 1800);

        Department department1 = new Department("Department 1");
        Department department2 = new Department("Department 2");
        Department department3 = new Department("Department 3");
        Department company = new Department("Company");

        department1.addEmployee(e1);
        department2.addEmployee(e2);
        department2.addEmployee(e3);
        department3.addEmployee(e4);


        department2.addDepartment(department3);

        company.addDepartment(department1);
        company.addDepartment(department2);


        company.printOrganizationStructure();

        System.out.println("Total salary: " + company.salary());
    }
}
