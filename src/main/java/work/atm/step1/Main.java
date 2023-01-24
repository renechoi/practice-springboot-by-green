package work.atm.step1;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        /*
         * # ATM[1단계] : 전체 기능구현
         * 1. 회원가입
         * . id와 pw를 입력받아 가입
         * . 가입 시 돈 1000원 부여
         * . id 중복체크
         * 2. 회원탈퇴
         * . 로그인시에만 이용가능
         * 3. 로그인
         * . id와 pw를 입력받아 로그인
         * . 로그아웃 상태에서만 이용가능
         * 4. 로그아웃
         * . 로그인시에만 이용가능
         * 5. 입금
         * . 로그인시에만 이용가능
         * 6. 이체
         * . 로그인시에만 이용가능
         * 7. 잔액조회
         * . 로그인시에만 이용가능
         */


        int MAX = 5;

        int[] arId = new int[MAX];
        int[] arPw = new int[MAX];
        int[] arMoney = new int[MAX];

        int count = 0;
        int loginId = -1;

        String menu = "=== 그린 IT ATM ===\n";
        menu += "1.회원가입\n2.회원탈퇴\n3.로그인\n4.로그아웃\n";
        menu += "5.입금\n6.이체\n7.잔액조회\n0.종료";

        while (true) {

            System.out.println(menu);

            int sel = Integer.parseInt(scanner.nextLine());

            if (sel == 1) {
                System.out.print("[가입] id: ");
                int id = getInput();
                if (isIdDuplicate(id, arId)) {
                    System.out.print("[가입] id 중복입니다!\n");
                    continue;
                }

                if (count>6){
                    System.out.println("[가입] 가입은 5개까지만 가능합니다");
                    continue;
                }

                System.out.print("[가입] password: ");
                int pw = getInput();

                arId[count] = id;
                arPw[count] = pw;
                arMoney[count] = 1000;
                count++;
            } else if (sel == 2) {
                if (!isLogin(loginId)) {
                    System.out.println("로그인 먼저!");
                    continue;
                }
                System.out.print("[탈퇴] id: ");
                int idToBeDeleted = getInput();

                IntStream.range(0, arId.length).forEach(v -> {
                    Runnable delFunction =
                            arId[v] == idToBeDeleted ?
                                    () -> IntStream.range(v, getCountCurrentArray(arId)).forEach(i -> arId[i] = arId[i + 1]) :
                                    () -> System.out.printf("%d번째 pass!\n", v);
                    delFunction.run();
                });

                count--;
            } else if (sel == 3) {
                System.out.print("[로그인] id: ");
                int id = getInput();

                System.out.print("[가입] password: ");
                int pw = getInput();

                try {
                    validateIdAndPwMatch(arId, arPw, id, pw);
                }catch (IllegalArgumentException e){
                    System.out.println(e.getMessage());
                }

                loginId = id;

            } else if (sel == 4) {

                if (loginId==-1){
                    System.out.println("로그인 먼저!");
                    continue;
                }

                loginId = -1;


            } else if (sel == 5) {
                if (loginId==-1){
                    System.out.println("로그인 먼저!");
                    continue;
                }

                int index = getIndexById(arId, loginId);

                System.out.print("[입금] 금액: ");
                int amount = getInput();
                arMoney[index] = arMoney[index] + amount;



            } else if (sel == 6) {
                if (loginId==-1){
                    System.out.println("로그인 먼저!");
                    continue;
                }

                int index = getIndexById(arId, loginId);

                System.out.print("[출금] 금액: ");
                int amount = getInput();

                if (arMoney[index] < amount){
                    System.out.println("금액이 부족합니다");
                    continue;
                }
                arMoney[index] = arMoney[index] - amount;



            } else if (sel == 7) {
                if (loginId==-1){
                    System.out.println("로그인 먼저!");
                    continue;
                }

                int index = getIndexById(arId, loginId);

                System.out.printf("[잔액 조회] 잔액: %s\n", arMoney[index]);



            } else if (sel == 0) {
                System.out.println("종료합니다.");
                break;
            }
        }
    }

    private static int getIndexById(int[] arId, int loginId) {
        return IntStream.range(0, arId.length).filter(i -> arId[i] == loginId).findFirst().getAsInt();
    }

    private static void validateIdAndPwMatch(int[] arId, int[] arPw, int id, int pw) {
        int idLoginIndex = IntStream.range(0, arId.length).filter(i -> arId[i] == id)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("그런 id는 없습니다"));

        if (Arrays.stream(arPw).noneMatch(v-> arPw[idLoginIndex] == pw)) {
            throw new IllegalArgumentException("pw가 일치하지 않습니다.");
        }
    }

    private static boolean isLogin(int loginId) {
        return loginId != -1;
    }

    private static boolean isIdDuplicate(int id, int[] arId) {
        return Arrays.stream(arId).anyMatch(idRegistered -> idRegistered == id);
    }

    private static int getInput() {
        return Integer.parseInt(scanner.nextLine());
    }

    private static int getCountCurrentArray(int[] array) {
        return (int) Arrays.stream(array).filter(v -> v != 0).count();
    }

}
