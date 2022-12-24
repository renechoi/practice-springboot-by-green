package day1;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class SecondTest {
    public static void main(String[] args) {
        problem8();

    }

    private static void problem1() {
    /*
	[문제]
 		array1배열 과 array2배열의 각자리별 합을 temp1에저장
 		temp1 = {10 + 5 , 20 + 8, 30 + 54, 40 + 32, 50 + 1};
	[문제]
 		array1배열 과 array2배열의 각자리별 차를 temp2에저장
 		temp2 = {10 - 5 , 20 - 8, 30 - 54, 40 - 32, 50 - 1};
    */

        int[] array1 = {10, 20, 30, 40, 50};
        int[] array2 = {5, 8, 54, 32, 1};
        int[] temp1 = new int[5];
        int[] temp2 = new int[5];

        for (int i = 0; i < 5; i++) {
            temp1[i] = array1[i] + array2[i];
            temp2[i] = array1[i] - array2[i];
        }
    }

    private static void problem2() {
    /*
	[문제]
		array[] = {10, 43, 25, 76, 3, 100, 56};
		인덱스 2개를 입력받고 작은인덱스에서 큰인덱스까지의 값들의 합을 출력한다.
	[조건]
  		index1 이 index2 보다 더크더라도
       	작은인덱스부터 큰인덱스까지의 합을 출력한다.
    [예] index1 = 1;  index2 = 3;
		43 + 25 + 76

  	[예] index1 = 4;  index2 = 1;
 		43 + 25 + 76 + 3
    */

        int array[] = {10, 43, 25, 76, 3, 100, 56};
        int index1 = 0;
        int index2 = 0;
        int min = 0;
        int max = 0;
        int sum = 0;

        Scanner scanner = new Scanner(System.in);
        index1 = scanner.nextInt();         // 값 받을 때 예외 범위 처리
        index2 = scanner.nextInt();

        if (index1 > index2) {
            max = index1;
        } else {
            min = index2;
        }

//        changeValue(index1, index2);

        for (int i = min; i <= max; i++) {
            sum += array[i];
        }

        System.out.println(sum);
    }

    private static void changeValue(int number1, int number2) {
        int temp = number1;
        number1 = number2;
        number2 = temp;
    }


    private static void problem3() {
        /*
	[문제]
		array 배열에 -100~100사이의 랜덤값중 홀수만 5개 저장한다.
		그중 가장작은값의 인덱스와 값을 출력한다.
*/
        int array[] = new int[5];

        Random random = new Random();

        // 저장
        for (int i = 0; i < 5; i++) {
            array[i] = random.nextInt(200) - 101;
        }

        // 가져오기
        int min = 100;
        int index = 0;
        for (int i = 0; i < 5; i++) {
            if (array[i] < min) {
                min = array[i];
                index = i;
            }
        }

        // 출력
        System.out.printf("%d %d \n", min, index);
    }

    private static void problem4() {
    /*
	[문제] 다음 리스트를 이용해서 a 의 값중 홀수만 c 에 저장
	[조건] 위치는 뒤에서 부터 저장한다.
	[예]   c = { 0, 0, 17, 51, 49 }
    */

        int arr[] = {10, 49, 51, 36, 17};
        int c[] = {0, 0, 0, 0, 0};

        for (int i = 4; i >= 0; i--) {
            if (arr[i] %2 != 0) {
                c[i] = arr[i];
            }
        }

    }

    private static void problem5() {
        /*
	아래배열들을 반으로 나누고 서로 같은모양인지 판별하시오.
	같은모양이면 true , 다른모양이면 false 출력
	[예시]
		154451 은 절반으로 나누면 서로 같은모양이다.
		154751 은 절반으로 나누면 서로 다른모양이다.
 */
        int[] arr1 = {1, 5, 4, 4, 5, 1};
        int[] arr2 = {1, 5, 4, 7, 5, 1};

        System.out.println(isSame(arr1, arr2, 0, arr1.length / 2));
        System.out.println(isSame(arr1, arr2, arr1.length / 2, arr1.length));

    }

    private static boolean isSame(int[] arr1, int[] arr2, int startNumber, int endNumber) {
        boolean isSame = true;
        for (int i = startNumber; i < endNumber; i++) {
            if (arr1[i] == arr2[i]) {
                continue;
            }
            isSame = false;
            break;
        }
        return isSame;
    }

    private static void problem6() {
        /*
        인덱스를 입력받고 해당 인덱스의 값을  0으로 변경

        추가조건 : 해당 값 양옆의 값들도 8로 변경
        단, 0, 4 인덱스일경우는 양옆중 한개만 8로 변경

        (예) 1 ==> {8,0,8,9,9}
        (예) 4 ==> {9,9,9,8,0}

        */

        int arr[] = {9, 9, 9, 9, 9};

        Scanner scanner = new Scanner(System.in);
        int numberChoice = scanner.nextInt();

        changeChoiceIdx(arr, numberChoice);
        changeSides(arr, numberChoice);

        System.out.println(Arrays.toString(arr));
    }

    private static void changeSides(int[] array, int idx) {
        if (idx == 0) {
            array[1] = 8;
            return;
        }

        if (idx == array.length - 1) {
            array[array.length - 2] = 8;
            return;
        }

        array[idx - 1] = 8;
        array[idx + 1] = 8;
    }

    private static void changeChoiceIdx(int[] array, int idx) {
        array[idx] = 0;
    }


    private static void problem7() {
        /*
	편의점 물건채우기
	철수는 편의점에서 아르바이트를 하고있다.
	오늘 장사가 잘되서 라면이 많이 판매되었다.
	라면진열장에 라면들이 전부 채워질수있도록 라면을 채워보자.

	라면은 진열장은 한칸에 최대 5개씩 진열할수있으며,
	재고는 6개 밖에 없고 앞에서부터 순차적으로 채워넣는다.
	재고를 다채웠을때 라면진열장의 모습을 출력해보자.

	[예]
		{3,5,2,1,2}

		1번은 3이므로 2개를 추가해 ==> -2
		2번은 5이므로 0개를 추가해 ==> -0
		3번은 2이므로 3개를 추가해 ==> -3
		4번은 1이므로 4개를 추가해야되지만 재고가 1개밖에없어서 -1
		최종으론 {5,5,5,2,2} 가된다.
*/

        int[] showcase = {3, 5, 2, 1, 2};

        int stock = 6;

        for (int i = 0; i < showcase.length; i++) {
            stock = stockNoodle(i, showcase, stock);
            if (isStockEmpty(stock)) {
                break;
            }
        }
        System.out.println(Arrays.toString(showcase));
    }

    private static boolean isStockEmpty(int stock) {
        return stock <= 0;
    }

    private static int stockNoodle(int i, int[] showcase, int stock) {
        if (showcase[i] < 5) {
            while (showcase[i] != 5 && !isStockEmpty(stock)) {
                showcase[i]++;
                stock--;
            }
        }
        return stock;
    }

    private static void problem8() {

        /*
	[문제]
		철수는 수학시험을 보았다.
		철수는 실수로 답을 한칸씩 밀려 적었다.
		철수가 원래대로 마킹했더라면 몇점인가?
		각문제별로 점수는 다르다.
		예)
		정답= {1,4,3,3,2};
		점수표 = {20,30,15,15,20};

		철수가 제출한 답안지(mistake)   {0,1,3,2,2)
		원래제출하고싶었던 답안지(fixed) {1,3,2,2,0};

	[정답]
		첫번째 한문제만 정답이이고 , 해당점수는 20점이므로
		20점
 */

        int[] answer = {1, 4, 3, 3, 2};
        int[] scores = {20, 30, 15, 15, 20};
        int[] mistake = {0, 1, 3, 2, 2};        // 1 3 2 2 0
        int fixed[] = originallyWanted(mistake);

        System.out.println(calculateScore(fixed, answer, scores));
    }

    private static int calculateScore(int[] submitted, int[] answer, int[] scores) {
        int sum = 0;
        for (int i = 0; i < submitted.length; i++) {
            if (isCorrect(submitted[i], answer[i])) {
                sum += scores[i];
            }
        }
        return sum;
    }

    private static boolean isCorrect(int numberSubmitted, int numberAnswer) {
        return numberAnswer == numberSubmitted;
    }

    private static int[] originallyWanted(int[] mistake) {

        int fixed[] = new int[5];

        for (int i = 0; i < mistake.length - 1; i++) {
            fixed[i] = mistake[i + 1];
        }

        return fixed;

    }

    private static void problem9() {
        /*
	[기념일]
	철수와 영희는 3월 3일에 만났다.
	철수는 영희와 100일 기념일에 축하파티를 할려고한다.
	만난지 100일뒤는  몇월몇일인가?
	단 윤년은 계산하지않는다.
*/

        int monthList[] =
                {31, 28, 31, 30,
                        31, 30, 31, 31,
                        30, 31, 30, 31};
        int day = 3;
        int month = 3;

        // 3월 => 31 - 3 => 28 + 1
        // 4월 => 30 - 1 => 29 + 1
        // 5월 => 31 -1 => 30 + 1

        for (int i = 1; i <= 100; i++) {

        }

    }


    private static void problem10() {

        /*
	[왼쪽오른쪽]
	랜덤으로 숫자(1,2)를 저장하고
	숫자가 1이면 왼쪽으로 밀기
	숫자가 2이면 오른쪽으로 밀기
 	예) 1) left ==> arr = {2,3,4,5,0,0,0,0,0};
 	예) 2) right ==> arr = {0,0,0,0,0,2,3,4,5};
*/
        int arr[] = {0, 2, 0, 3, 4, 0, 0, 5, 0};
        int select = 2;

        int idx = 0;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {

            arr[count] = i;
        }


    }
}
