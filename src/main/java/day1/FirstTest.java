package day1;

import java.util.Random;
import java.util.Scanner;

public class FirstTest {
    public static void main(String[] args) {
    }

    private static void test1() {
        /*
		[페이징 훼이크]
		[이상한 나라의 숫자규칙]
		숫자 1~5 사이를 a 에저장하면 , num 에 1 저장후 출력
		숫자 6~10 사이를 a 에저장하면 , num 에 2 저장후 출력
		숫자 11~15 사이를 a에 저장하면, num 에 3 저장후 출력
		숫자 16~20 사이를 a 에 저장하면, num 에 4 저장후 출력
		....
		....
		숫자 96~100 사이를 a 에 저장하면 , num 에 20을 저장후 출력
	    */

        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int answer = (num / 5) + 1;

        System.out.println(answer);
    }


    private static void test2() {

        /*
	    [문제]
	    [1] 48의 약수중 일의자리가 2~6사이인 수를 출력하시오.
	    [2] 위 조건의 약수의 개수도 출력하시오.
	    [정답]
	    2 3 4 6 12 16 24
	    악수의 개수 : 7개
	    */

        int number = 48;

        for (int i = 1; i < number; i++) {
            if (isDivisor(number, i) && isFirstDigitTwoBetweenSix(i)) {
                System.out.println(i);
            }
        }

//        for (int i=2; i<number; i++){
//            if (number % i == 0){
//                System.out.println(i);
//            }
//        }
    }

    private static boolean isFirstDigitTwoBetweenSix(int number) {
        int firstDigit = number % 10;
        return firstDigit >= 2 && firstDigit <= 6;
    }

    private static void test3() {

        /*
	    [문제]
		128의 3번째 약수 부터 6번째 약수의 전체합을 출력하시오.
	    [정답]
		3번째 약수 부터 6번째 약수의 전체합 : 60
        */

        int count = 0;
        int sum = 0;
        int number = 128;
        int betweenStart = 3;
        int betweenEnd = 6;

        for (int i = 1; i < number; i++) {
            if (isDivisor(number, i)) {
                count++;

                if (isDivisorInBetween(count, betweenStart, betweenEnd)) {
                    sum += i;
                }
            }
        }
        System.out.println(sum);
    }

    private static boolean isDivisorInBetween(int count, int start, int end) {
        return count >= start && count <= end;
    }

    private static boolean isDivisor(int number, int dividedNumber) {
        return number % dividedNumber == 0;
    }

    private static void test4() {

        /*
	    [즉석복권]
	    랜덤으로 1또는 7 을 10번출력한다.
		7이 연속으로 3번이상이면 "당첨" 아니면 "꽝" 출력하시오.
	    [예시]
		7 7 1 1 1 7 1 : 꽝
		1 7 7 7 1 1 7 : 당첨
        */

        int numberStart = 10;

        Random random = new Random();
        int count = 0;
        while (numberStart-- > 0) {
            int randomNumber = ((random.nextInt(2) + 6) % 7) + 1;

            if (randomNumber == 7) {
                count++;
            }
        }
        System.out.println(judgeWin(count));

        // 간단하게 랜덤 숫자를 설정하는 법
//        if (number == 0) {
//            number = 1;
//        }

        // String msg = win ? "당첨" : "꽝;
        // sout(msg)
    }

    private static String judgeWin(int count) {
        if (count >= 3) {
            return "당첨";
        }
        return "꽝";
    }
}
