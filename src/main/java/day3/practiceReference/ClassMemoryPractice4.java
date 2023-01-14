package day3.practiceReference;

import java.util.Arrays;

class Sample04 {
    int[] arr = {1, 2, 3, 4, 5};
}

class Sample05 {
    int[] arr = {5, 4, 3, 2, 1};
}

public class ClassMemoryPractice4 {
    public static void main(String[] args) {

        Sample04 s4 = new Sample04();
        Sample05 s5 = new Sample05();

        s4.arr = s5.arr;
        s5.arr = s4.arr;

        System.out.println(Arrays.toString(s4.arr));
        System.out.println(Arrays.toString(s5.arr));


        // 두 개 배열을 교체해보자 ! => 5 4 3 2 1 <=> 1 2 3 4 5

        s4.arr = convert2(s5.arr);
        System.out.println(Arrays.toString(s4.arr));


        arrayConversion(s4, s5);

    }

    private static void arrayConversion(Sample04 s4, Sample05 s5) {
        int[] temp = s5.arr;
        s5.arr = s4.arr;
        s4.arr = temp;
    }

    private static int[] convert1(int[] array) {

        int[] newArray = new int[array.length];

        int count = 0;
        for (int i = array.length - 1; i >= 0; i--) {
            newArray[i] = array[count];
            count++;
        }
        return newArray;

    }

    private static int[] convert2(int[] array) {

        int temp;
        for (int i = 0; i < array.length; i++) {
            temp = array[array.length - 1-i];
            array[array.length - 1 - i] = array[i];
            array[i] = temp;
        }
        return array;

    }

}