package day2;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayTest2 {
    public static void main(String[] args) {
        problem1();
        problem2();
        problem3();
        problem4();
    }

    private static void problem1() {
        // 문제1)  인덱스(방번호)를 입력하면 값출력
        int a[] = {10, 20, 30, 40, 50};
        // 예) 3 ==> 40

        int number = getInputNumber();

        System.out.println(a[number]);

    }

    private static int getInputNumber() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private static void problem2() {
        // 문제2) 아래배열중 가장큰값 출력
        int b[] = {12, 54, 23, 87, 1};
        // 예) 87

        int max = 0;
        for (int number : b) {
            if (number > max) {
                max = number;
            }
        }
        System.out.println(max);
    }

    private static void problem3() {

        // 문제3) 아래 배열중 홀수의 개수 출력
        int c[] = {12, 54, 23, 87, 1};
        // 예) 홀수의 개수 : 3

        int oddCounts = 0;
        for (int i = 0; i < c.length; i++) {
            if (isOddNumber(c[i])) {
                oddCounts++;
            }
        }
        System.out.println(oddCounts);
    }

    private static boolean isOddNumber(int a) {
        return a % 2 != 0;
    }

    private static void problem4() {

        // 문제4) 아래배열을 거꾸로 저장
        int d[] = {1, 2, 3, 4, 5};
        int e[] = {0, 0, 0, 0, 0};
        //예)  ={5,4,3,2,1};

        int idx = 0;
        for (int i = d.length - 1; i >= 0; i--) {
            e[idx++] = d[i];
        }

        System.out.println(Arrays.toString(e));
    }
}
