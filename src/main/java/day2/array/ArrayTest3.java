package day2.array;

import java.util.Arrays;

public class ArrayTest3 {
    public static void main(String[] args) {

        problem3();
        problem3();
        problem1();

    }

    private static void problem3() {
        // 문제3) 아래는 시험결과 이다 시험에 합격한 사람의 번호만 win2 에 저장 (60점이상 합격)
        int data[] = {1001, 80, 1002, 23, 1003, 78};
        int win2[] = {0, 0, 0};
        // 예) win2[] = {1001, 1003, 0};

        int count = 0;
        for (int i = 0; i < data.length/2; i++) {    // 1 3 5
           if (data[i*2+1] >=60){
               win2[count++] = data[i*2];
           }
        }
        System.out.println(Arrays.toString(win2));
    }

    private static void problem2() {
        // 문제2) 아래는 시험결과 이다. 시험에 합격한사람의 번호만 win 에 저장 (60점이상합격)
        int num[] = {1001, 1002, 1003};
        int score[] = {50, 83, 78};
        int win[] = {0, 0, 0};
        // 예) win[]= {1002, 1003, 0};

        int count = 0;
        for (int i=0; i< score.length; i++){
            if (score[i] >= 60){
                win[count++] = num[i];
            }
        }
        System.out.println(Arrays.toString(win));
    }

    private static void problem1() {
        // 문제 1) 아래 배열 a 와 b 를 비교해서 둘의 합이 짝수 일때만 c에 저장

        //
        int a[] = {10, 20, 30, 40, 50};
        int b[] = {13, 54, 17, 42, 1};
        int c[] = {0, 0, 0, 0, 0};

        // 예) c[] = {74,82,0,0,0}

        int idx =0;
        for (int i =0;i <a.length;i++){
            if ( (a[i] + b[i])  % 2 == 0) {
                c[idx++] = a[i] + b[i];
            }
        }
        System.out.println(Arrays.toString(c));
    }
}
