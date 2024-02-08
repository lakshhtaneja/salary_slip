import java.util.Scanner;

class SalarySlip{
    public static void main(String[] args) {
        // input
        Scanner scanner= new Scanner(System.in);

        System.out.println("Enter your Id: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        
        System.out.println("Enter your name: ");
        String name = scanner.nextLine();

        System.out.println("Enter your basic Salary: ");
        double basicSalary = scanner.nextDouble();

        scanner.close();

        //compute
        double hra = basicSalary * 0.5;
        double da = basicSalary * 0.2;
        double ta = basicSalary * 0.4;
        double ma = basicSalary * 0.25;
        
        double pf = basicSalary * 0.05;

        double grossSalary = basicSalary + hra + da + ta + ma;


        //console output
        System.out.println("Id: " + id);
        System.out.println("Name: " + name + "\n");
        System.out.println("Basic Salary: " + basicSalary);
        System.out.print("Earning Allowances\t\t");
        System.out.println("Deductions");
        System.out.print("HRA: " + hra + "\t\t\t");
        System.out.println("PF: " + pf);
        System.out.println("DA: " + da);
        System.out.println("TA: " + ta);
        System.out.println("MA: " + ma);
    }
}