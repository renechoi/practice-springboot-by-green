package day2.string;

import java.util.Arrays;

public class StringTest1 {
    public static void main(String[] args) {
        int[] scores = {11, 87, 54, 63, 100, 2};
        // 100 87 63 54 11 2
//        bubbleSort2(scores);

        problem1();

    }

    private static void problem1() {
        // 문제 ) 사전 순으로 이름 정렬
        String[] names = {"홍길동", "김유신", "마동석", "자바킹", "서동요"};

//        // solution 1
//        int[] nameAsNumbers = new int[5];
//        for (int i = 0; i < names.length; i++) {
//            for (int j = 0; j < names[i].length(); j++) {
//                nameAsNumbers[i] += names[i].charAt(j);
//            }
//        }

        // solution 2

        for (int i = 0; i < names.length; i++) {
            for (int j = i; j < names.length; j++) {
                if(names[i].compareTo(names[j]) > 0){
                    // 값교체
                    String temp = names[i];
                    names[i] = names[j];
                    names[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(names));
    }

    private static void bubbleSort(int[] scores) {

        for (int i = 0; i < scores.length; i++) {
            for (int j = 0; j < scores.length; j++) {
                if (scores[i] > scores[j]) {
                    int temp = scores[i];
                    scores[i] = scores[j];
                    scores[j] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(scores));
    }

    private static void bubbleSort2(int[] scores) {

        for (int i = 0; i < scores.length; i++) {
            for (int j = i; j < scores.length; j++) {
                if (scores[i] < scores[j]) {
                    int temp = scores[i];
                    scores[i] = scores[j];
                    scores[j] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(scores));
    }
}
