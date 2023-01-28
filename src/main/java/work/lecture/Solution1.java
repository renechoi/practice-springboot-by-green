package work.lecture;

import java.util.Scanner;

public class Solution1 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int MAX = 5;
        // 0 1 2 3 4
        int[] arId = new int[MAX]; // {0,0,0,0,0}
        int[] arPw = new int[MAX];// {0,0,0,0,0}
        int[] arMoney = new int[MAX];// {0,0,0,0,0}

        int[] tempIds = { 1111, 2222, 3333, 0, 0 };
        int[] tempPws = { 1111, 2222, 3333, 0, 0 };
        int[] tempMoneys = { 5000, 12000, 3000, 0, 0 };
        arId = tempIds;
        arPw = tempPws;
        arMoney = tempMoneys;

        // int cnt = 0;
        int cnt = 3;
        int log = -1; // 로그인 회원 -> 2 인덱스 전부 동일한 회원데이터 : 인덱스 : -1:로그아웃

        String menu = "=== 그린 IT ATM ===";
        String mainMenu = "1.회원가입\n2.로그인\n0.종료\n";
        String loginMenu = "3.입금\n4.이체\n5.잔액조회\n6.로그아웃\n7.탈퇴\n0.종료\n";
        // menu += "1.회원가입\n2.회원탈퇴\n3.로그인\n4.로그아웃\n";
        // menu += "5.입금\n6.이체\n7.잔액조회\n0.종료";

        while (true) {

            System.out.println(menu);
            if (log == -1) {
                System.out.println(mainMenu);
            } else {
                System.out.println(arId[log] + "님 잔액" + arMoney[log] + " 원");
                System.out.println(loginMenu);
            }

            int sel = scan.nextInt();

            if (sel == 1 && log == -1) {
                if (cnt == MAX) {
                    System.out.println(" 정원 초가 가입 불가");
                    continue;
                }
                System.out.println("[ 회원 가입 ]");
                int id = 0;
                while (true) {
                    System.out.print(" 신규 ID :");
                    id = scan.nextInt();

                    boolean check = false;

                    // for(배열요소타입 이름 : 배열이름) { 0~배열 끝까지 자동 num 꺼내온다 : 인덱스
                    for (int num : arId) {
                        if (id == num) {
                            check = true;
                            break;
                        }
                    }

                    if (check) {
                        System.out.println("이미 존재하는 id 입니다");
                    } else {
                        break;
                    }
                }

                System.out.print(" 신규 PW :");
                int pw = scan.nextInt();

                arId[cnt] = id;
                arPw[cnt] = pw;
                arMoney[cnt] = 1000;
                cnt++;
                System.out.println("회원가입 완료 ");

            } else if (sel == 2 && log == -1) {
                // 아이디불일치 패스워드 불일치 로그인 성공 로그인 실패
                // 아이디불일치 , 아이디일치-> 패스워드가 불일치 ,
                System.out.println("[ 로그인 ]");
                System.out.print("ID :");
                int id = scan.nextInt();
                System.out.print("PW :");
                int pw = scan.nextInt();

                int idx = -1;
                for (int i = 0; i < cnt; i++) {
                    if (id == arId[i]) {
                        idx = i;
                        break;
                    }
                }

                if (idx == -1) {
                    System.out.println("아이디 불일치");
                } else if (arPw[idx] == pw) {
                    // idx != -1 && arPw[idx] == pw
                    log = idx;
                    System.out.println(" 로그인 성공 ");
                    continue; // 밑에 실행 안하고 다시 반복문 처음으로 돌아감
                } else {

                    // idx != -1 && arPw[idx] != pw
                    System.out.println(" 패스워드 불일치 ");
                }
                System.out.println("로그인 실패");
            } else if (sel == 3 && log != -1) {

                System.out.println("[ 입 금 ]");
                System.out.print("금액 :");
                int money = scan.nextInt();
                if (money < 1000) {
                    System.out.println("천원 이상 입금 가능합니다");
                    continue;
                }
                arMoney[log] += money;

            } else if (sel == 4 && log != -1) {
                System.out.println("[ 이 체 ]");
                // 계좌번호 존재여부, 본인계좌 이체 불가능, 금액 1000원 이상 이체 , 통장 잔액 이하
                System.out.print("계좌 :");
                int acc = scan.nextInt();
                int idx = -1;
                for (int i = 0; i < cnt; i++) {
                    if (acc == arId[i]) {
                        idx = i;
                        break;
                    }
                }
                if (idx == -1) {
                    System.out.println("존재하지 않는 계좌번호");
                    continue;
                } else if (idx == log) {
                    System.out.println("본인 계좌 이체 불가능");
                    continue;
                }

                System.out.print("금액 :");
                int money = scan.nextInt();
                if (money < 1000) {
                    System.out.println("천원 이상 입금 가능합니다");
                    continue;
                }
                if (money > arMoney[log]) {
                    System.out.println(" 한도 초과 금액 이체 불가능");
                    continue;
                }
                arMoney[log] -= money;
                arMoney[idx] += money;

                System.out.println("이체 완료");
            } else if (sel == 5 && log != -1) {
                System.out.println("[ 잔액 조회 ]");
                for (int i = 0; i < cnt; i++) {
                    System.out.printf(" [%-5d ] [%10d 원]\n", arId[i], arMoney[i]);
                    ;
                }
            } else if (sel == 6 && log != -1) {
                System.out.println("[ 로그아웃 완료]");
                log = -1;
            } else if (sel == 7 && log != -1) {
                System.out.println("[ 회원탈퇴 완료]");
                for (int i = log; i < cnt - 1; i++) {
                    arId[i] = arId[i + 1];
                    arPw[i] = arPw[i + 1];
                    arMoney[i] = arMoney[i + 1];
                }
                cnt--;
                log = -1;
            } else if (sel == 0) {
                System.out.println("종료합니다.");
                break;
            } else if (sel < 0 || sel > 7) {
                System.out.println("메뉴번호 입력 오류");
            } else {
                if (log == -1) {
                    System.out.println("로그인 먼저 해주세요");
                } else {
                    System.out.println(" 이미 로그인 한 상태입니다");
                }
            }
        }

    }

}