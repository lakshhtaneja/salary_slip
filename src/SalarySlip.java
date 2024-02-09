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

    static String formattedDate(LocalDate date){  // Define the pattern for formatting
        String pattern = "EEEE, dd MMMM, yyyy";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern, locale);
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
        print(id, name, basicSalary, hra, pf, da, ta, ma);

    }
    
    static void print(int id, String name, double basicSalary, double hra, double pf, double da, double ta, double ma){
        System.out.println("\n\t\t\t" + formattedDate(currentDate));
        System.out.println("\nId: " + id);
        System.out.println("Name: " + properCase(name) + "\n"); 
        System.out.println("Basic Salary: " + formattedCurrency(basicSalary, locale));
        System.out.print("Earning Allowances\t\t");
        System.out.println("Deductions");
        System.out.print("HRA: " + formattedCurrency(hra, locale) + "\t\t\t");
        System.out.println("PF: " + formattedCurrency(pf, locale));
        System.out.println("DA: " + formattedCurrency(da, locale));
        System.out.println("TA: " + formattedCurrency(ta, locale));
        System.out.println("MA: " + formattedCurrency(ma, locale));
    }

    public static void main(String[] args) {
        input();
    }
}