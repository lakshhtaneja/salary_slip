import java.util.Locale;
import java.util.Scanner;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter; 

class SalarySlip{
    static LocalDate currentDate = LocalDate.now();
    static Locale locale = Locale.US;
    static String properCase(String name){
        String fullName = "";
        for (String n: name.split(" ")){
           fullName += String.valueOf(n.charAt(0)).toUpperCase() + n.substring(1);
        }
        return fullName.trim();
    }

    static String formattedCurrency(double unformatted, Locale locale){  
        NumberFormat formatter = NumberFormat.getCurrencyInstance(locale); //reference variable
        String formatted = formatter.format(unformatted);
        return formatted;
    }

    static String formattedDate(LocalDate date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd mm yyyy");
        String formatted = formatter.format(date);
        return formatted;
    }

    static void input(){
        Scanner scanner= new Scanner(System.in);

        System.out.println("Press 1 for English");
        System.out.println("Appuyez sur 2 pour le français");
        // System.out.println("हिंदी के लिए 3 दबाएँ");
        
        int choice = scanner.nextInt();
        
        switch (choice) {
            case 1:
                break;
            case 2:
                locale = Locale.FRANCE;
                break;
             // case 3:
             //     locale = Locale.of("hi", "IN"); //>= JAVA 19
             //     break;
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

        String hra_f = formattedCurrency(hra, locale);
        String da_f = formattedCurrency(da, locale);
        String ta_f = formattedCurrency(ta, locale);
        String ma_f = formattedCurrency(ma, locale);
        String pf_f = formattedCurrency(pf, locale);
        String basicSalary_f = formattedCurrency(basicSalary, locale);

        print(id, name, basicSalary_f, hra_f, pf_f, da_f, ta_f, ma_f);

    }
    
    static void print(int id, String name, String basicSalary, String hra, String pf, String da, String ta, String ma){
       System.out.println("\n\t\t\t" + currentDate);
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