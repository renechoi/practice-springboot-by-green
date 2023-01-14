package day3;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ControllerStep1 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        // 추가 : 중복 값 존재하면 삽입 불가
        // 추가 : 중복 값 전체 삭제
        int[] arr = {10, 30, 40, 0, 0};
        int[] arr2 = {10, 10, 20, 30, 40};
        int[] arr3 = {10, 10, 20, 30, 30};
        int cnt = getCountCurrentArray(arr);

        deleteAsValue(10, arr2);
        System.out.println(Arrays.toString(arr2));
//        delAllDuplicate(arr2);

        boolean run = true;
        while (run) {

            for (int i = 0; i < cnt; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();

            System.out.println("[1]추가");
            System.out.println("[2]삭제(인덱스)");
            System.out.println("[3]삭제(값)");
            System.out.println("[4]삽입");
            System.out.println("[5]중복 전체 삭제");
            System.out.println("[6]종료");
            System.out.print("메뉴 선택 : ");
            int command = scan.nextInt();

            if (command == 1) {
                System.out.print("추가할 값 입력 : ");
                int data = scan.nextInt();

                if (isDuplicate(data, arr)) {
                    System.out.println("중복 값이 존재합니다!");
                    return;
                }

                if (getCountCurrentArray(arr) >= arr.length) {
                    System.out.println("full!");
                    return;
                }
                arr[getCountCurrentArray(arr)] = data;

                System.out.printf("%d 번째 %d 삽입 완료!\n", getCountCurrentArray(arr) + 1, data);

                showCurrentArray(arr);

            } else if (command == 2) {
                System.out.print("삭제 인덱스 입력 : ");
                int delIdx = scan.nextInt();

                if ( isIndexEmpty(arr) || isArrayIndexOutOfRange(delIdx, arr) ) {
                    return;
                }

                IntStream.range(delIdx, getCountCurrentArray(arr)).forEach(v -> {
                    Runnable delIndexFunction = delIdx == 4 ? () -> arr[4] = 0 : () -> arr[v] = arr[v + 1];
                    delIndexFunction.run();
                });

                showCurrentArray(arr);

            } else if (command == 3) {
                System.out.print("삭제 값 입력 : ");
                int delVal = scan.nextInt();

                if ( isIndexEmpty(arr) || !isValueExist(delVal, arr) ) {
                    return;
                }

                deleteAsValue(delVal, arr);

                showCurrentArray(arr);

            } else if (command == 4) {
                System.out.print("삽입 인덱스 입력 : ");
                int index = scan.nextInt();

                if(isArrayIndexOutOfRange(index, arr)){
                    return;
                }

                System.out.print("삽입 값 입력 : ");
                int data = scan.nextInt();

                for (int i = getCountCurrentArray(arr) - 1; i >= index; i--) {
                    arr[i + 1] = arr[i];
                }
                arr[index] = data;

                showCurrentArray(arr);

            } else if (command == 5) {
                delAllDuplicate(arr2);
                break;
            } else if (command == 6){
                break;
            } else {
                System.out.print("입력 오류");
            }

        }
    }

    private static void deleteAsValue(int delVal, int[] arr) {
        IntStream.range(0, arr.length).forEach(v -> {
            Runnable delFunction = arr[v] == delVal ? () -> {

                IntStream.range(v, getCountCurrentArray(arr)).forEach(i -> arr[i] = arr[i + 1]);

            } : () -> System.out.printf("%d번째 pass!\n", v);
            delFunction.run();
        });
    }

    private static int getCountCurrentArray(int[] array) {
        return (int) Arrays.stream(array).filter(v -> v != 0).count();
    }

    private static boolean isIndexEmpty(int[] array) {
        if (getCountCurrentArray(array) == 0) {
            System.out.println("배열이 비어있습니다!");
            return true;
        }
        return false;
    }

    private static boolean isValueExist(int request, int[] array){
        if (Arrays.stream(array).noneMatch(v->v==request)){
            System.out.println("값이 존재하지 않습니다!");
            return false;
        }
        return true;
    }

    private static boolean isArrayIndexOutOfRange(int request, int[] array) {
        if (request >= getCountCurrentArray(array) || request < 0) {
            System.out.println("배열 범위 바깥의 범위를 입력했습니다");
            return true;
        }
        System.out.println("index 정상 입력!");
        return false;
    }

    private static void showCurrentArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    private static boolean isDuplicate(int valueRequested, int[] array) {
        return Arrays.stream(array).anyMatch(v -> v == valueRequested);

    }

    private static void delAllDuplicate(int[] array) {
//        IntStream.range(0, getCountCurrentArray(array)).filter(v->array[v] == )
        //         int[] arr2 = {10, 10, 20, 30, 40};
//        Arrays.stream(array).forEach(value -> {
//            Runnable delAllFunction = isDuplicate(value, array) ? () -> deleteAsValue(value, array) : () -> System.out.printf("%s pass!\n", value);
//            delAllFunction.run();
//        });

//        Arrays.stream(array).filter(v->isDuplicate(v,array))
//                .forEach(v->{
//
//                    IntStream.range(0, getCountCurrentArray(array)).filter(i->array[i]==v).forEach(k->{
//                        array[k] = array[k + 1];
//                    });
//                });

    }
}

