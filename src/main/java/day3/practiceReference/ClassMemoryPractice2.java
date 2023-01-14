package day3.practiceReference;

class Sample02 {
    int[] list;
    int num;
    int[] arr = {10, 20, 30, 40, 50};
}

public class ClassMemoryPractice2 {
    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5};

        Sample02 s4 = new Sample02();

        Sample02 temp = s4;
        s4 = null;

        s4.arr = arr;

    }

}