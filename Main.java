import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите выражение:");
        Scanner scanner = new Scanner(System.in);
        System.out.println(calc(scanner.nextLine()));
    }
    public static String calc(String input) {
        Conv convert = new Conv();
        String[] str = input.split(" ");
        String s = "";

        if (str.length < 4) {
            if (Conv.isRoman(str[0]) == Conv.isRoman(str[2])) {
                int num1;
                int num2;
                boolean yes = Conv.isRoman(str[0]);
                if (yes) {
                    num1 = Conv.romanToInt(str[0]);
                    num2 = Conv.romanToInt(str[2]);

                } else {
                    num1 = Integer.parseInt(str[0]);
                    num2 = Integer.parseInt(str[2]);
                }
                String op = str[1];
                int result;
                if (num1 < 11 && num2 < 11 && num1 > 0 && num2 > 0) {
                    switch (op) {
                        case "+":
                            result = num1 + num2;
                            break;
                        case "-":
                            result = num1 - num2;
                            break;
                        case "*":
                            result = num1 * num2;
                            break;
                        case "/":
                            result = num1 / num2;
                            break;
                        default:
                            throw new IllegalArgumentException("Неверный знак операции!");
                    }
                } else {
                    throw new IllegalArgumentException("Диапазон чисел от 1 до 10!!!");
                }
                if(yes) {
                    System.out.println(convert.intToRoman(result));
                }
                else {
                    System.out.println(result);
                }
            } else {
                throw new NumberFormatException("Числа должны быть в одном формате!");
            }
        } else {
            throw new NumberFormatException("Слишком длинное выражение!");
        }
        return s;
    }

}