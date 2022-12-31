package day2;

import java.util.Arrays;

public class ArrayTest5 {
    public static void main(String[] args) {
        problem1();

        problem2();

        problem3();
    }

    private static void problem1() {
        // 문제1)  a의 값과 b의 값을 번갈아가면서 c에 저장
        // 예) c = {10,40,20,50,30,60}
        int a[] = {10, 20, 30};
        int b[] = {40, 50, 60};
        int c[] = {0, 0, 0, 0, 0, 0};

        // solution 1
        int idx = 0;
        for (int i = 0; i <= a.length - 1; i++) {
            c[idx++] = a[i];
            c[idx++] = b[i];
        }
        System.out.println(Arrays.toString(c));

        // solution 2
        for (int i = 0; i < a.length; i++) {
            c[i * 2] = a[i];
            c[i * 2 + 1] = b[i];
        }
        System.out.println(Arrays.toString(c));
    }

    private static void problem2() {
        // 문제 2) aa 배열의 값들을 앞으로 한칸씩 당기고 맨뒤에 bb의  값을 저장
        int aa[] = {10, 20, 30, 40, 50};
        int bb = 90;
        // 예) aa = {20,30,40,50,90};

        for (int i = 0; i < aa.length - 1; i++) {
            aa[i] = aa[i + 1];
        }
        aa[aa.length - 1] = bb;

        System.out.println(Arrays.toString(aa));
    }

    private static void problem3() {
        // 문제 3) cc 의 배열을 뒤로 하나씩 밀어낸후 맨 앞에 dd의 값을 저장
        int cc[] = {10, 20, 30, 40, 50};
        int dd = 60;
        // 예) cc[] = {60,10,20,30,40};

        for (int i = cc.length - 1; i > 0; i--) {
            cc[i] = cc[i - 1];
        }
        cc[0] = dd;

        System.out.println(Arrays.toString(cc));
    }
}
