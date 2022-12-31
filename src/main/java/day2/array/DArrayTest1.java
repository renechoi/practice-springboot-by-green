package day2.array;

public class DArrayTest1 {
    public static void main(String[] args) {
        int[][] arr = new int[3][3];

        int k = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                arr[i][j] = 10 * k;
                k += 1;
            }
        }

        problem1(arr);
        problem2(arr);
        problem3(arr);
        problem4(arr);
    }

    private static void problem4(int[][] arr) {
        // 문제 4) 4의 배수의 개수 출력
        // 정답 4) 4
        int count = 0;
        for (int[] numbers : arr) {
            for (int number : numbers) {
                if (number % 4 == 0) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    private static void problem3(int[][] arr) {
        // 문제 3) 4의 배수의 합 출력
        // 정답 3) 200
        int sum = 0;
        for (int[] numbers : arr) {
            for (int number : numbers) {
                if (number % 4 == 0) {
                    sum += number;
                }
            }
        }
        System.out.println(sum);
    }

    private static void problem2(int[][] arr) {
        // 문제 2) 4의 배수만 출력
        // 정답 2) 20 40 60 80
        StringBuilder stringBuilder = new StringBuilder();
        for (int[] numbers : arr) {
            for (int number : numbers) {
                if (number % 4 == 0) {
                    stringBuilder.append(number).append(" ");
                }
            }
        }
        System.out.println(stringBuilder);
    }

    private static void problem1(int[][] arr) {
        // 문제 1) 전체 합 출력
        // 정답 1) 450
        int sum = 0;
        for (int[] numbers : arr) {
            for (int number : numbers) {
                sum += number;
            }
        }
        System.out.println(sum);
    }
}
