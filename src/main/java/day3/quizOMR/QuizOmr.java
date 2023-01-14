package day3.quizOMR;


import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

class Ex06 {
    int[] answer = {1, 3, 4, 2, 5}; // 시험답안
    int[] hgd = new int[5]; // 학생답안

    int cnt = 0; // 정답 맞춘 개수
    int score = 0; // 성적
}

public class QuizOmr {
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


        Ex06 ex06 = new Ex06();

        IntStream.range(0, ex06.hgd.length).forEach(i->ex06.hgd[i] = getRandom());

        String[] answerSheet = new String[ex06.hgd.length];
        IntStream.range(0, ex06.hgd.length).forEach(i->{
            Runnable drawFunction = ex06.answer[i] == ex06.hgd[i] ? ()-> {answerSheet[i]="O"; ex06.cnt++;} :()-> answerSheet[i]="X";
            drawFunction.run();
        });

        System.out.println(Arrays.toString(ex06.answer));
        System.out.println(Arrays.toString(ex06.hgd));
        System.out.println(Arrays.toString(answerSheet));
        System.out.printf("count: %s\n", ex06.cnt);
        System.out.printf("score: %s점", ex06.score = ex06.cnt * 20);
    }

    private static int getRandom(){
        Random random = new Random();
        return random.nextInt(1,6);
    }
}