package Lab2;

class Employee {
    private String firstName;
    private String lastName;
    private double monthlySalary;

    public Employee(String firstName, String lastName, double monthlySalary) {
        this.firstName = firstName;
        this.lastName = lastName;
        if (monthlySalary > 0.0)
            this.monthlySalary = monthlySalary;
    }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public double getMonthlySalary() { return monthlySalary; }
    public void setMonthlySalary(double monthlySalary) {
        if (monthlySalary > 0.0)
            this.monthlySalary = monthlySalary;
    }

    public double getAnnualSalary() {
        return monthlySalary * 12;
    }

    public void raiseSalary(double percent) {
        if (percent > 0)
            monthlySalary += monthlySalary * percent / 100.0;
    }
}

public class lab22 {
    public static void main(String[] args) {
        Employee emp1 = new Employee("Иван", "Иванов", 3000);
        Employee emp2 = new Employee("Пётр", "Петров", 4000);

        System.out.println(emp1.getFirstName() + " " + emp1.getLastName() +
                " - годовая зарплата: " + emp1.getAnnualSalary());
        System.out.println(emp2.getFirstName() + " " + emp2.getLastName() +
                " - годовая зарплата: " + emp2.getAnnualSalary());

        emp1.raiseSalary(10);
        emp2.raiseSalary(10);

        System.out.println("\nПосле увеличения зарплаты на 10%:");
        System.out.println(emp1.getFirstName() + " " + emp1.getLastName() +
                " - годовая зарплата: " + emp1.getAnnualSalary());
        System.out.println(emp2.getFirstName() + " " + emp2.getLastName() +
                " - годовая зарплата: " + emp2.getAnnualSalary());
    }
}
