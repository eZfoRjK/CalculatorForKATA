import java.util.Scanner;

/**
 * Супер много костылей, но для меня эта первая высокая задача, раннее решал задачи сугубо те которые были в книгах,
 * а тут  прямо эффект вау, при этом было супер интересно и супер позновательно
 */
public class Main {
    public static String calc(String input) throws Exception {

        int num1 = 0;
        int num2 = 0;

        String num_1 = "";
        String num_2 = "";

        String result = "";

        boolean isRoman;

        String[] operation = input.split(" ");
        if (operation.length != 3){
            throw new Exception("Формат математической операции не удовлетворяет заданию\nВведите 2 числа(арабские или римские) и оператор(+, -, /, *) через пробел");
        } //Сделал финт :D

        try {
            num1 = Integer.parseInt(operation[0]);
            num2 = Integer.parseInt(operation[2]);
            isRoman = false;

        } catch (Exception e) {
            num_1 = operation[0];
            num_2 = operation[2];
            isRoman = true;
        }

        if (isRoman) {
            num1 = ConvertToRoman.convertToArabian(num_1);
            num2 = ConvertToRoman.convertToArabian(num_2);
        }

        if (num1 >= 1 && num1 <= 10 && num2 >= 1 && num2 <= 10) {

            switch (operation[1]) {
                case "+":
                    result = String.valueOf(num1 + num2);
                    break;
                case "-":
                    result = String.valueOf(num1 - num2);
                    break;
                case "/":
                    result = String.valueOf(num1 / num2);
                    break;
                case "*":
                    result = String.valueOf(num1 * num2);
                    break;
                default:
                    throw new Exception("т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
            }

        } else throw new Exception("Ввод чисил только от 1 до 10 в однои формате(Арабские либо Римские числа)");


        if (isRoman) {
            result = ConvertToRoman.convertToRoman(Integer.parseInt(result));
        }
        return String.valueOf(result);
    }

    public static void main(String[] args) throws Exception {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Введите 2 числа(арабские или римские) и оператор(+, -, /, *) через пробел:");
        System.out.println(calc(keyboard.nextLine()));

    }
}
