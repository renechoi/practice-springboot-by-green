package day2.array;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ArrayTest1 {
    public static void main(String[] args) {
        problem1();

    }

    private static void problem1() {
        int a[] = {10, 49, 51, 36, 17};
        // 문제 1) 다음 리스트를 값을 입력하면   번호 출력
        // 예) 51 ==> 2
        // 예) 10 ==> 0

        // 추가조건 : 없는 값을 입력했을시 "값이 존재하지 않습니다"를 출력

        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        try {
            int answer = IntStream.range(0, a.length)
                    .filter(v -> a[v] == number)
                    .boxed()
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("값이 존재하지 않습니다"));

            System.out.println(answer);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }


    private static void problem2() {
        // 문제 2) 다음 리스트를 이용해서 a 의 값중 홀수만 b 에 저장(위치는 동일한위치에 저장)
        // 예) b = [0, 49, 51, 0, 17]
        int a[] = {10, 49, 51, 36, 17};
        int b[] = {0, 0, 0, 0, 0};

        for (int i = 0; i < a.length; i++) {
            if (isOddNumber(a[i])) {
                b[i] = a[i];
            }
        }
        System.out.println(Arrays.toString(b));
    }

    private static boolean isOddNumber(int a) {
        return a % 2 != 0;
    }

    private static void problem3() {

        // 문제 3) 다음 리스트를 이용해서 a 의 값중 홀수만 c 에 저장(위치는 앞에서 부터  저장)
        // 2번문제와 조금 다름
        // 예) c = [49, 51, 17, 0, 0]
        int a[] = {10, 49, 51, 36, 17};
        int c[] = {0, 0, 0, 0, 0};

        int count = 0;
        for (int i = 0; i < a.length; i++) {
            if (isOddNumber(a[i])) {
                c[count++] = a[i];
            }
        }
        System.out.println(Arrays.toString(c));
    }

    private static void problem4() {
        //-------------------------------------------------
        int arr[] = {1001, 20, 1002, 45, 1003, 54};
        // 학번과 점수가 한쌍이다. ==>  1001:20 , 1002:45 , 1003:54

        // 문제4) 학번을 입력하면 점수 출력
        // 예) 1001==>20 , 1003 ==> 54

        Scanner scanner = new Scanner(System.in);

        int studentId = scanner.nextInt();

        // solution 1
        for (int i = 0; i < arr.length / 2; i++) {     // 0 2 4
            if (arr[i * 2] == studentId) {
                System.out.printf("%d => %d\n", studentId, arr[i * 2 + 1]);
            }
        }

        // solution 2

        for (int i = 0; i < arr.length; i += 2) {
            if (arr[i] == studentId) {
                System.out.println(arr[i + 1]);
            }
        }

        // solution 3
//        for (int i = 0; i < arr.length; i++) {     // 0 2 4
//            if (isOddNumber(i)) {
//                continue;
//            }
//            if (arr[i] == studentId) {
//                System.out.println(arr[i + 1]);
//            }
//        }
    }

    private static void problem5() {
        // 문제5) 점수를 입력하면 학번 출력
        // 예) 20 ==> 1001 , 45 ==> 1002

        int arr[] = {1001, 20, 1002, 45, 1003, 54};

        Scanner scanner = new Scanner(System.in);

        int score = scanner.nextInt();

        for (int i = 0; i < arr.length; i++) {     // 0 2 4
            if (!isOddNumber(i)) {
                continue;
            }
            if (arr[i] == score) {
                System.out.println(arr[i - 1]);
            }
        }
    }
}
