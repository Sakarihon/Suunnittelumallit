public abstract class Organization {
    protected String name;

    public Organization(String name) {
        this.name = name;
    }

    //xml
    public abstract void printOrganizationStructure();

    public abstract double salary();
    public abstract void addEmployee(Organization employee);
    public abstract void removeEmployee(Organization employee);
    public abstract void addDepartment(Organization department);
    public abstract void removeDepartment(Organization department);
}