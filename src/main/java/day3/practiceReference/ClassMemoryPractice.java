package day3.practiceReference;

public class ClassMemoryPractice {

    public static void main(String[] args) {
        Sample01 s1 = new Sample01();
        int num = 50;
        s1 = new Sample01();
        s1.a = 10;
        s1 = null;

        s1 = new Sample01();
        s1.b = num;

    }
}
