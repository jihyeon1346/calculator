package scripts;

import java.util.InputMismatchException;
import java.util.Scanner;

public class cal {
    public static void main() {
        Scanner sc = new Scanner(System.in);
        double result = 0;
        double num1 = 0;
        double num2 = 0;
        String operations = "";
        String choice = "";
        String msg = "";
        int n = 0;
        String[] msg_list = new String[3];

        while (true) {
            System.out.println("=== 계산기 메뉴 ===");
            System.out.println("1. 계산하기");
            System.out.println("2. 계산 이력 보기");
            System.out.println("3. 이력 지우기");
            System.out.println("0. 종료");
            System.out.print(" 선택: ");
            choice = sc.nextLine();

            // 계산하기
            if (choice.equals("1"))
            {
                System.out.println("=== Java 계산기 ===");

                // 숫자 입력 처리
                while (true)
                {
                    try
                    {
                        System.out.print("첫번째 숫자를 입력하세요: ");
                        num1 = sc.nextDouble();
                        sc.nextLine();
                        break;
                    } catch (InputMismatchException e)
                    {
                        System.out.println("숫자를 입력해야 합니다!");
                        sc.nextLine();
                    }
                }

                // 연산자 입력
                while (true)
                {
                    System.out.print("연산자를 입력하세요 (+, -, *, /, %, ^, sqrt(제곱근): ");
                    operations = sc.nextLine();

                    if (operations.equals("+") || operations.equals("-") || operations.equals("*") ||
                            operations.equals("/") || operations.equals("%") || operations.equals("^") ||
                            operations.equals("sqrt"))
                        break;
                    else
                        System.out.println("지원하지 않는 연산자입니다. 다시 입력하세요.");

                }

                // sqrt는 두 번째 숫자 불필요
                if (!operations.equals("sqrt"))
                {
                    while (true)
                    {
                        try
                        {
                            System.out.print("두 번째 숫자를 입력하세요: ");
                            num2 = sc.nextDouble();
                            sc.nextLine();
                            break;
                        } catch (InputMismatchException e)
                        {
                            System.out.println("숫자를 입력해야 합니다!");
                            sc.nextLine();
                        }
                    }
                }

                // 연산 처리
                switch (operations)
                {
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
                        if (num2 == 0)
                        {
                            System.out.println("0으로 나눌 수 없습니다.");
                            continue;
                        }
                        result = num1 / num2;
                        break;

                    case "%":
                        result = num1 % num2;
                        break;

                    case "^":
                        result = Math.pow(num1, num2);
                        break;

                    case "sqrt":
                        if (num1 < 0)
                        {
                            System.out.println("음수의 제곱근은 계산할 수 없습니다.");
                            continue;
                        }
                        result = Math.sqrt(num1);
                        break;
                }

                // 결과 저장
                if (operations.equals("sqrt"))
                {
                    msg = "결과: sqrt(" + num1 + ") = " + result;
                } else {
                    msg = "결과: " + num1 + " " + operations + " " + num2 + " = " + result;
                }

                msg_list[n % msg_list.length] = msg;
                n++;

                System.out.println(msg);


                System.out.println("Enter를 누르면 메뉴로 돌아갑니다.");
                sc.nextLine();
            }
            // 계산 이력 보기
            else if (choice.equals("2"))
            {
                for (int i = 0; i < msg_list.length; i++)
                    if (msg_list[i] != null)
                        System.out.println(msg_list[i]);
                System.out.println("Enter를 누르면 메뉴로 돌아갑니다.");
                sc.nextLine();
            }

            // 이력 삭제
            else if (choice.equals("3"))
            {
                msg_list = new String[3];
                n = 0;
                System.out.println("이력을 모두 삭제했습니다.");
                System.out.println("Enter를 누르면 메뉴로 돌아갑니다.");
                sc.nextLine();
            }

            // 종료
            else if (choice.equals("0"))
            {
                return;
            } else {
                System.out.println("숫자를 입력해주세요");
            }
        }
    }
}
