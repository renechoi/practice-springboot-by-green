package day1;

import java.util.Arrays;

public class ArrayPractice {
    public static void main(String[] args) {

        int num = 10;
        num = 20;
        System.out.println(num);    // 20

        int[] arr = new int[5];
        System.out.println(arr); // [I@56cbfb61

        System.out.println(arr[0]); // 0

        double[] arrayDouble = new double[5];
        System.out.println(arrayDouble[0]); // 0.0

        int[] arr2 ={10, 20, 30};

        System.out.println(Arrays.toString(arr2));


    }
}
