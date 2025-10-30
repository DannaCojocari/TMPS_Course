package Lab0;

abstract class Employee {
    private String name;
    private String surname;
    private String role;
    private int salary;

    protected Employee(String name, String surname, String role, int salary) {
        this.name = name;
        this.surname = surname;
        this.role = role;
        this.salary = salary;
    }

    public abstract void work();

    public String getName() { return name; }
    public String getSurname() { return surname; }
    public String getRole() { return role; }
    public int getSalary() { return salary; }
}

