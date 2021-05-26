public class RomanArabicTranslator {

  private static final int[] numbers = {100, 90, 50, 40, 10, 9, 5, 4, 1};

  private static final String[] letters = {"C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

  public String toString(int arabic) {
    if (arabic < 1) {
      throw new NumberFormatException("Значение меньше I");
    }
    StringBuilder roman = new StringBuilder();
    for (int i = 0; i < numbers.length; i++) {
      while (arabic >= numbers[i]) {
        roman.append(letters[i]);
        arabic -= numbers[i];
      }
    }
    return roman.toString();
  }

  public static int toInt(String roman) {
    if (roman.length() == 0) {
      throw new NumberFormatException("Введите данные.");
    }

    roman = roman.toUpperCase();

    int i = 0;
    int arabic = 0;

    while (i < roman.length()) {

      char letter = roman.charAt(i);
      int number = letterToNumber(letter);

      if (number < 0) {
        throw new NumberFormatException("Число \"" + letter + "\" не является римской цифрой.");
      }

      i++;
      if (i == roman.length()) {
        arabic += number;
      } else {
        int nextNumber = letterToNumber(roman.charAt(i));
        if (nextNumber > number) {
          arabic += (nextNumber - number);
          i++;
        } else {
          arabic += number;
        }
      }
    }

    return arabic;
  }

  private static int letterToNumber(char letter) {
    switch (letter) {
      case 'I':
        return 1;
      case 'V':
        return 5;
      case 'X':
        return 10;
      case 'L':
        return 50;
      case 'C':
        return 100;
      default:
        return -1;
    }
  }
}
