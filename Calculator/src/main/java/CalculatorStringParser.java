public class CalculatorStringParser {

  public static void parse(String inputString) {
    String firstNumber, secondNumber;
    char operationSign;
    int a, b;
    boolean isNumb = true;
    String[] arguments = inputString.split("[+-/*]");
    if (arguments.length != 2) {
      throw new IllegalArgumentException(
          "Неверный формат! Введите в формате a * b, a + b, a - b, a / b");
    }
    firstNumber = arguments[0].trim();
    operationSign = inputString.charAt(arguments[0].length());
    secondNumber = arguments[1].trim();

    if (isNumeric(firstNumber) && isNumeric(secondNumber)) {
      a = Integer.parseInt(firstNumber);
      b = Integer.parseInt(secondNumber);
    } else if (isRoman(firstNumber.toUpperCase()) && isRoman(secondNumber.toUpperCase())) {
      a = RomanArabicTranslator.toInt(firstNumber);
      b = RomanArabicTranslator.toInt(secondNumber);
      isNumb = false;
    } else {
      throw new NumberFormatException("Неверный формат!");
    }
    Calculation calculation = new Calculation();
    RomanArabicTranslator romanArabicTranslator = new RomanArabicTranslator();
    String roman_result;
    int result = calculation.calculate(a, b, operationSign);
    if (!isNumb) {
      roman_result = romanArabicTranslator.toString(result);
      System.out.println(roman_result);
    } else {
      System.out.println(result);
    }
  }

  public static boolean isNumeric(String inputString) {
    return inputString.matches("\\d");
  }

  public static boolean isRoman(String inputString) {
    return inputString.matches("^X{0,3}(IX|IV|V?I{0,3})$");
  }
}
