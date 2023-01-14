package day3;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ControllerStep2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        // 추가 : 중복 값 존재하면 삽입 불가
        // 추가 : 중복 값 전체 삭제
        int[] arr = {10, 20, 30, 40};
//        int[] arr = null;


        boolean run = true;
        while (run) {

            showCurrentArray(arr);
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

                arr = deepCopy(arr, data);
                showCurrentArray(arr);

            } else if (command == 2) {
                if (isNullOrEmpty(arr)) {
                    System.out.println("null or empty");
                    return;
                }

                System.out.print("삭제 인덱스 입력 : ");
                int delIdx = scan.nextInt();

                arr = delAsIndex(arr, delIdx);
                showCurrentArray(arr);

            } else if (command == 3) {
                if (isNullOrEmpty(arr)) {
                    System.out.println("null or empty");
                    return;
                }

                System.out.print("삭제 값 입력 : ");
                int delVal = scan.nextInt();

                arr = delAsValue(arr, delVal);
                showCurrentArray(arr);

            } else if (command == 4) {
                System.out.print("삽입 인덱스 입력 : ");
                int index = scan.nextInt();
                System.out.print("삽입 값 입력 : ");
                int data = scan.nextInt();

                arr = deepCopy(arr, data, index);
                showCurrentArray(arr);

            } else if (command == 5) {
                break;
            } else if (command == 6) {
                break;
            } else {
                System.out.print("입력 오류");
            }

        }
    }

    private static boolean isNullOrEmpty(int[] arr) {
        if (arr == null) {
            System.out.println("null !!! ");
            return true;
        }

        if (arr.length == 0) {
            System.out.println("empty !!!");
            return true;
        }
        return false;
    }


    private static int[] deepCopy(int[] source) {
        source = handleNullWithAddFunction(source);
        int[] temp = source;
        source = new int[temp.length + 1];

        for (int i = 0; i < temp.length; i++) {
            source[i] = temp[i];
        }

        source[source.length - 1] = 0;
        return source;
    }

    private static int[] deepCopy(int[] source, int valueToBeAdded) {
        source = handleNullWithAddFunction(source);
        int[] temp = source;
        source = new int[temp.length + 1];

        for (int i = 0; i < temp.length; i++) {
            source[i] = temp[i];
        }

        source[source.length - 1] = valueToBeAdded;
        return source;
    }

    private static int[] deepCopy(int[] source, int valueToBeAdded, int index) {
        source = insert(deepCopy(source), valueToBeAdded, index);
        return source;
    }

    private static int[] insert(int[] source, int valueToBeAdded, int index) {
        for (int i = getCountCurrentArray(source) - 1; i >= index; i--) {
            source[i + 1] = source[i];
        }
        source[index] = valueToBeAdded;
        return source;
    }

    private static int[] delAsIndex(int[] source, int indexToBeDeleted) {
        int[] temp = source;
        source = new int[temp.length - 1];
        for (int i = indexToBeDeleted; i < temp.length - 1; i++) {
            source[i] = temp[i + 1];
        }

        return source;
    }

    private static int[] delAsValue(int[] source, int valueToBeDeleted) {
        int[] temp = source;

        int[] newSource = new int[temp.length - 1];
        Arrays.stream(temp).filter(v -> v == valueToBeDeleted).forEach(v -> {
            IntStream.rangeClosed(0, getIndex(valueToBeDeleted, source)).forEach(i -> newSource[i] = temp[i]);
            IntStream.range(getIndex(valueToBeDeleted, source), newSource.length).forEach(
                    i -> newSource[i] = temp[i + 1]);
        });

        return newSource;
    }

    private static int[] handleNullWithAddFunction(int[] array) {
        return Arrays.stream(array != null ? array : new int[0]).toArray();
    }

    private static int getCountCurrentArray(int[] array) {
        return (int) Arrays.stream(array != null ? array : new int[0]).filter(v -> v != 0).count();
    }

    private static void showCurrentArray(int[] source) {
        if (source == null) {
            System.out.println("null !");
            return;
        }
        System.out.println(Arrays.toString(source));
    }

    private static int getIndex(int value, int[] arr) {
        return IntStream.range(0, arr.length).filter(i -> arr[i] == value).findFirst().getAsInt();
    }

}


