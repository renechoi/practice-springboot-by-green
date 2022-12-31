package day2.string;

public class PracticeString2 {
    public static void main(String[] args) {
        String name ="홍길동";

        char[] myName = {'홍', '길', '동'};

        char a1 = '가';
        char a2 = '나';
        char a3 = '다';

        String str1 = "가";
        String str2 = "나";
        String str3 = "다";

        System.out.println(str1.compareTo(str1));   // '가' - '가' 비교
        System.out.println(str1.compareTo(str2));   // '가' - '나' 비교
        System.out.println(str3.compareTo(str2));   // '다' - '나' 비교


        System.out.println(a1 - a1);
        System.out.println(a1 - a2);
        System.out.println(a3 - a2);

    }
}
