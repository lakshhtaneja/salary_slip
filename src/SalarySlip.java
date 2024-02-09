import java.util.Locale;
import java.util.Scanner;
import java.text.NumberFormat; 

class SalarySlip{

    static String properCase(String name){
        String fullName = "";
        for (String n: name.split(" ")){
           fullName += String.valueOf(n.charAt(0)).toUpperCase() + n.substring(1);
        }
        return fullName.trim();
    }

    static String currencyFormat(double unformatted, Locale locale){  
        NumberFormat formatter = NumberFormat.getCurrencyInstance(locale); //reference variable
        String formatted = formatter.format(unformatted);
        return formatted;
    }

    static void input(){
        Scanner scanner= new Scanner(System.in);
        Locale locale = Locale.US;

        System.out.println("Press 1 for English");
        System.out.println("हिंदी के लिए 2 दबाएँ");
        System.out.println("Appuyez sur 3 pour le français");
        
        int choice = scanner.nextInt();
        
        switch (choice) {
            case 1:
                break;
            case 2:
                locale = Locale.of("hi", "IN");
                break;
            case 3:
                locale = Locale.FRANCE;
                break;
            default:
                System.out.println("Invalid Choice, default language [English(US)] set");
                break;
        }

        System.out.println("Enter your Id: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        
        System.out.println("Enter your name: ");
        String name = scanner.nextLine();

        System.out.println("Enter your basic Salary: ");
        double basicSalary = scanner.nextDouble();
        compute(id, name, basicSalary, locale);
        scanner.close();

    }

    static void compute(int id, String name, double basicSalary, Locale locale){

        double hra = basicSalary * 0.5;
        double da = basicSalary * 0.2;
        double ta = basicSalary * 0.4;
        double ma = basicSalary * 0.25;
        double pf = basicSalary * 0.05;

        String hra_f = currencyFormat(hra, locale);
        String da_f = currencyFormat(da, locale);
        String ta_f = currencyFormat(ta, locale);
        String ma_f = currencyFormat(ma, locale);
        String pf_f = currencyFormat(pf, locale);
        String basicSalary_f = currencyFormat(basicSalary, locale);

        print(id, name, basicSalary_f, hra_f, pf_f, da_f, ta_f, ma_f);

    }
    
    static void print(int id, String name, String basicSalary, String hra, String pf, String da, String ta, String ma){
       
        System.out.println("\nId: " + id);
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
        input();
    }
}