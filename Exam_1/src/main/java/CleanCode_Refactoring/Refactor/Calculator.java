package CleanCode_Refactoring.Refactor;

public class Calculator {

//    public static int calculate(int a, int b, char o) {
//        switch (o) {
//            case '+':
//                return a + b;
//            case '-':
//                return a - b;
//            case '*':
//                return a * b;
//            case '/':
//                if (b != 0)
//                    return a / b;
//                else
//                    throw new RuntimeException("Can not divide by 0");
//            default:
//                throw new RuntimeException("Unsupported operation");
//        }
//    }


    public static final char ADDITION = '+';    // tách hằng từ + thành một từ có nghĩa ADDITION
    public static final char SUBTRACTION = '-';
    public static final char MULTIPLICATION = '*';
    public static final char DIVISION = '/';


    public static int calculate(int firstOperand, int secondOperand, char operator) { // tách biến a = firstOperand, b = secondOperand, o = operator
        switch (operator) {
            case ADDITION:
                return firstOperand + secondOperand;
            case SUBTRACTION:
                return firstOperand - secondOperand;
            case MULTIPLICATION:
                return firstOperand * secondOperand;
            case DIVISION:
                if (secondOperand != 0)
                    return firstOperand / secondOperand;
                else
                    throw new RuntimeException("Can not divide by 0");
            default:
                throw new RuntimeException("Unsupported operation");
        }
    }

//    public static void main(String[] args) {
//        int result = calculate(5,10,ADDITION);
//        System.out.println(result);
//
//        int result1 = calculate(5,10, SUBTRACTION);
//        System.out.println(result1);
//
//        int result2 = calculate(5,10,MULTIPLICATION);
//        System.out.println(result2);
//
//        int result3 = calculate(5, 5, DIVISION);
//        System.out.println(result3);
//    }
}
