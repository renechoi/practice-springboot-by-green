package day4.solution;

import java.util.Scanner;

class Member{
    private int number;
    private String id;
    private String name;

    public Member(int number, String id, String name) {
        this.number = number;
        this.id = id;
        this.name = name;
    }
}

class Account{
    String account;
    String password;

}

class AtmVer1 {
    Scanner scanner = new Scanner(System.in);
    final int MAX = 5;
    int[] arId;
    int[] arPw;
    int[] arMoney;
    int log = -1;

    void init(){
        int[] tempIds = {1111, 2222, 3333, 0, 0};
        int[] tempPws = {1111, 2222, 3333, 0, 0};
        int[] tempMoneys = {5000, 12000, 3000, 0,0 };
        arId = tempIds;
        arPw = tempPws;
        arMoney = tempMoneys;
    }

    void joinMember(){}
    void login(){}
    void deposit(){}
    void transfer(){}
    void logout(){}
    void deleteMember(){}

    void run(){
        while (true){
            int sel = Integer.parseInt(scanner.nextLine());

            if (sel ==1 && log == -1){
                joinMember();
            }
            else if (sel ==2){
                login();
            }

        }
    }

}