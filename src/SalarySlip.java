import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.text.DateFormat;
import java.text.NumberFormat;

class SalarySlip{
    static ResourceBundle rb;
    static Locale locale = Locale.US;

    static void loadResourceBundle(){
        rb = ResourceBundle.getBundle("message", locale);
    }
    static String properCase(String name){
        String fullName = "";
        for (String n: name.split(" ")){
           fullName += String.valueOf(n.charAt(0)).toUpperCase() + n.substring(1);
        }
        return fullName.trim();
    }

    static String formatCurrency(double unformatted, Locale locale){  
        NumberFormat formatter = NumberFormat.getCurrencyInstance(locale); //reference variable
        String formatted = formatter.format(unformatted);
        return formatted;
    }

    static String formatDate(){ 
        Date date = new Date();
        DateFormat formatter = DateFormat.getDateInstance(DateFormat.SHORT, locale);
        String formatted = formatter.format(date);
        return formatted;
    }

    static void input(){
        Scanner scanner= new Scanner(System.in);

        System.out.println("Press 1 for English");
        System.out.println("Appuyez sur 2 pour le français");
        System.out.println("हिंदी के लिए 3 दबाएँ");
        
        int choice = scanner.nextInt();
        
        switch (choice) {
            case 1:
                break;
            case 2:
                locale = Locale.FRANCE;
                break;
            case 3:
                locale = Locale.of("hi", "IN"); //>= JAVA 19
                break;
            default:
                System.out.println("Invalid Choice, default language [English(US)] set");
                break;
        }

        loadResourceBundle();

        System.out.println(rb.getString("id.msg") + ": ");
        int id = scanner.nextInt();
        scanner.nextLine();
        
        System.out.println(rb.getString("name.msg") + ": ");
        String name = scanner.nextLine();

        System.out.println(rb.getString("salary.msg"));
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
        System.out.println(rb.getString("date.msg")+" "+ formatDate());
        System.out.println("Id: " + id);
        System.out.println("Name: " + properCase(name) + "\n"); 
        System.out.println("Basic Salary: " + formatCurrency(basicSalary, locale));
        System.out.print(rb.getString("allowances.msg") + "\t\t");
        System.out.println(rb.getString("deductions.msg"));
        System.out.print("HRA: " + formatCurrency(hra, locale) + "\t\t\t");
        System.out.println("PF: " + formatCurrency(pf, locale));
        System.out.println("DA: " + formatCurrency(da, locale));
        System.out.println("TA: " + formatCurrency(ta, locale));
        System.out.println("MA: " + formatCurrency(ma, locale));
    }

    public static void main(String[] args) {
        input();
    }
}