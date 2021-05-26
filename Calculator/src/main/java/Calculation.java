public class Calculation {

  public int calculate(int a, int b, char operation) {
    int result;
    if ((a < 0 || a > 10) || (b < 0 || b > 10)) {
      throw new IllegalArgumentException("Неверный формат! Введите числа от 1 до 10!");
    }
    switch (operation) {
      case '+':
        result = a + b;
        break;
      case '-':
        result = a - b;
        break;
      case '*':
        result = a * b;
        break;
      case '/':
        result = a / b;
        break;
      default:
        throw new IllegalArgumentException("Неверный знак! Введите + или - или / или *");
    }
    return result;
  }
}
