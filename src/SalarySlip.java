import java.util.Scanner;

class SalarySlip{

    static String properCase(String name){
        String names[] = name.split(" ");
        String fullName = "";
        for (int i = 0 ; i < names.length; i++){
            String n = names[i];
            char firstChar = n.charAt(0);
            String capLetter = String.valueOf(firstChar).toUpperCase();
            String remString = n.substring(1).toLowerCase();
            String capitalized = capLetter + remString;

            fullName = fullName + capitalized + "";
        }
        return fullName.trim();
    }

    static void input(){
        Scanner scanner= new Scanner(System.in);

        System.out.println("Enter your Id: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        
        System.out.println("Enter your name: ");
        String name = scanner.nextLine();

        System.out.println("Enter your basic Salary: ");
        double basicSalary = scanner.nextDouble();
        compute(id, name, basicSalary);
        scanner.close();

    }

    static void compute(int id, String name, double basicSalary){
        double hra = basicSalary * 0.5;
        double da = basicSalary * 0.2;
        double ta = basicSalary * 0.4;
        double ma = basicSalary * 0.25;
        
        double pf = basicSalary * 0.05;

        double grossSalary = basicSalary + hra + da + ta + ma;

        print(id, name, basicSalary, hra, pf, da, ta, ma);

    }

    static void print(int id, String name, double basicSalary, double hra, double pf, double da, double ta, double ma){
        System.out.println("Id: " + id);
        System.out.println("Name: " + properCase(name) + "\n");
        System.out.println("Basic Salary: " + basicSalary);
        System.out.print("Earning Allowances\t\t");
        System.out.println("Deductions");
        System.out.print("HRA: " + hra + "\t\t\t");
        System.out.println("PF: " + pf);
        System.out.println("DA: " + da);
        System.out.println("TA: " + ta);
        System.out.println("MA: " + ma);
    }

    public static void main(String[] args) {
        // SalarySlip sp = new SalarySlip();
        input();
    }
}