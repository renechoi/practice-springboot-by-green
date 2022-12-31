package day2.string;

import java.util.Scanner;

public class PracticeString {
    public static void main(String[] args) {
        String name1 = "홍길동";
        String name2 = "홍길동";

        Scanner scanner = new Scanner(System.in);
        String myName = scanner.nextLine();     // 홍길동으로 입력을 한다고 해보자

        System.out.printf("name1==name2 : %b\n", name1==name2);
        System.out.printf("name1==myName : %b\n", name1==myName);

        String name3 = new String("홍길동");

        System.out.printf("name1==name3 : %b\n", name1==name3);

    }

    private static void printValue(String name1, String name2, String myName, String name3) {
        System.out.println(name1.equals(name2));
        System.out.println(name1.equals(myName));
        System.out.println(name1.equals(name3));
    }

    private static void printReference(String name1, String name2, String myName, String name3) {
        System.out.println(System.identityHashCode(name1));
        System.out.println(System.identityHashCode(name2));
        System.out.println(System.identityHashCode(myName));
        System.out.println(System.identityHashCode(name3));
    }
}
