package recursion;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
                    System.out.print("Enter current value: ");
                    double currentValue = scanner.nextDouble();
                    System.out.print("Enter growth rate (as a decimal): ");
                    double growthRate = scanner.nextDouble();
                    System.out.print("Enter number of years: ");
                    int years = scanner.nextInt();
                    scanner.nextLine(); 

                    double futureValue = FinancialForecasting.predictFutureValue(currentValue, growthRate, years);
                    System.out.println("Predicted Future Value: " + futureValue);
               

   
        scanner.close();
    }
}
