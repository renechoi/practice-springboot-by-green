package day3.quizOMR;


import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;



public class QuizOmr2 {
    public static void main(String[] args) {
        /*
         * # OMR카드 : 클래스 + 변수
         * 1. 배열 answer는 시험문제의 정답지이다.
         * 2. 배열 hgd에 1~5 사이의 랜덤 숫자 5개를 저장한다.
         * 3. answer와 hgd 값을 비교해 정오표를 출력한다.
         * 4. 한 문제당 20점이다.
         * 예)
         * answer = {1, 3, 4, 2, 5}
         * hgd    = {1, 1, 4, 4, 3}
         * 정오표     = {O, X, O, X, X}
         * 성적        = 40점
         */


        int[] answer = {1, 3, 4, 2, 5}; // 시험답안
        int[] hgd = new int[5]; // 학생답안

        int cnt = 0; // 정답 맞춘 개수
        int score = 0; // 성적

        String[] answerSheet = new String[answer.length];

        for (int i = 0; i < answer.length; i++){
            compareAndDrawAnswerSheet(answer, hgd, answerSheet, i);
        }

        System.out.println(Arrays.toString(answerSheet));

//        System.out.println(Arrays.toString(answer));
//        System.out.println(Arrays.toString(hgd));
//        System.out.println(Arrays.toString(answerSheet));
//        System.out.printf("count: %s\n", cnt);
//        System.out.printf("score: %s점", score = cnt * 20);
    }

    private static void compareAndDrawAnswerSheet(int[] answer, int[] hgd, String[] answerSheet, int i) {
        if (answer[i] == hgd[i]) {
            answerSheet[i] = "O";
        }else {
            answerSheet[i] = "X";
        }
    }

    private static int getRandom(){
        Random random = new Random();
        return random.nextInt(1,6);
    }
}