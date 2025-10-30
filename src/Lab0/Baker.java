package Lab0;

class Baker extends Employee {

    public Baker(String name, String surname) {
        super(name, surname, "Baker", 1000);
    }

    @Override
    public void work() {
        System.out.println("The baker is working.");
    }
}
