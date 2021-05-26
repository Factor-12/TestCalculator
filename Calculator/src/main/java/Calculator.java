import java.util.Scanner;

public class Calculator {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String inputString = scanner.nextLine();
    CalculatorStringParser.parse(inputString);
  }
}
