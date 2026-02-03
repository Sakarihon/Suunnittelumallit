import java.util.ArrayList;
import java.util.List;

public class Department extends Organization {
    private List<Organization> members = new ArrayList<>();

    public Department(String name) {
        super(name);
    }

    @Override
    public void printOrganizationStructure() { //xml
        System.out.println("<Department name=\"" + name + "\">");
        for (Organization member : members) {
            member.printOrganizationStructure();
        }
        System.out.println("</Department>");
    }


    @Override
    public double salary() {
        double total = 0;
        for (Organization member : members) {
            total += member.salary();
        }
        return total;
    }

    @Override
    public void addEmployee(Organization employee) {
        members.add(employee);
    }

    @Override
    public void removeEmployee(Organization employee) {
        members.remove(employee);
    }

    @Override
    public void addDepartment(Organization department) {
        members.add(department);
    }

    @Override
    public void removeDepartment(Organization department) {
        members.remove(department);
    }
}
