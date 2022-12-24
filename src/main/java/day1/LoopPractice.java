package day1;

public class LoopPractice {
    public static void main(String[] args) {



    }

    private static void compareLoopByPosition() {
        for (int k = 1; k <= 10; k++) {
            if (k % 2 == 0) {
                continue;
            }
            System.out.println(k);
        }

        int i = 1;
        while (i <= 10) {
            if (i % 2 == 0) {
                i++;    // 밑에 있는 i++가 증가되지 않아서 무한 반복에 빠지게 된다.
                continue;
            }
            System.out.println(i);
            i++;
        }
    }

    private static void whileLoop2() {
        // flag를 이용한 종료
        int j = 0;
        boolean run = true;
        while (run) {
            System.out.println(j + "");
            if (j == 10) {
                run = false;
            }
            j++;
        }
    }

    private static void whileLoop1() {
        // break로 종료
        int i = 0;
        while (true) {
            System.out.println(i + "");
            if (i == 10) {
                break;
            }
            i++;
        }
    }


}
