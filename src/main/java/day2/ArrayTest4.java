package day2;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayTest4 {
    public static void main(String[] args) {
        problem1();

        problem2();
    }

    private static void problem1() {
        // 문제 1) 아래 배열 a 에서 내가 입력한 값만 빼고 b 에 저장
        int a[] = {10, 20, 30, 40, 50};
        int b[] = {0, 0, 0, 0, 0};
        // 예) 30 ==> b[] = {10,20,40,50,0};

        int idx = 0;
        int inputNumber = getInputNumber();
        for (int number : a) {
            if (number == inputNumber) {
                continue;
            }
            b[idx++] = number;
        }

        if (idx == 5) {
            System.out.println("배열에 없는 값을 입력했습니다!");
            return;
        }
        System.out.println(Arrays.toString(b));
    }

    private static void problem2() {
        // 문제 2) 아래 배열에서 내가 입력한 번호 와 값 만 빼고 d 에 저장
        int c[] = {1001, 40, 1002, 65, 1003, 70};
        int d[] = {0, 0, 0, 0, 0, 0};
        // 예) 1002 ==> d[] = {1001, 40, 1003, 70 , 0, 0};

        int idx = 0;
        int inputNumber = getInputNumber();

        for (int i = 0; i < c.length / 2; i++) {
            if (c[i * 2] == inputNumber) {
                continue;
            }
            d[idx++] = c[i * 2];
            d[idx++] = c[i * 2 + 1];
        }

        if (idx == 6) {
            System.out.println("배열에 없는 값을 입력했습니다!");
            return;
        }
        System.out.println(Arrays.toString(d));
    }

    private static int getInputNumber() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
