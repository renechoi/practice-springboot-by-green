package day2.array;

import java.util.Scanner;

public class DArrayTest2 {
    public static void main(String[] args) {
        int[][] apt = {
                {101, 102, 103},
                {201, 202, 203},
                {301, 302, 303}
        };

        int[][] pay = {
                {1000, 2100, 1300},
                {4100, 2000, 1000},
                {3000, 1600, 800}
        };

        problem1(pay);
        problem2(apt, pay);
        problem3(apt, pay);
        problem4(apt, pay);
    }

    private static void problem4(int[][] apt, int[][] pay) {
        // 문제 4) 호 2개를 입력하면 관리비 교체

        Scanner scanner = new Scanner(System.in);
        int room1 = scanner.nextInt();
        int room2 = scanner.nextInt();

        if (room1 == room2) {
            System.out.println("서로 다른 호수를 입력해야 합니다!");
            return;
        }

        int room1i = 0;
        int room1j = 0;
        int room2i = 0;
        int room2j = 0;

        boolean found1 = false;
        boolean found2 = false;
        for (int i = 0; i < apt.length; i++) {
            for (int j = 0; j < apt[i].length; j++) {
                if (apt[i][j] == room1) {
                    room1i = i;
                    room1j = j;
                    found1 = true;
                }

                if (apt[i][j] == room2) {
                    room2i = i;
                    room2j = j;
                    found2 = true;
                }
            }
        }

        int temp = pay[room1i][room1j];
        pay[room1i][room1j] = pay[room2i][room2j];
        pay[room2i][room2j] = temp;

        if (!found1 || !found2) {
            System.out.println("찾는 호실 없음 !");
            return;
        }

        System.out.println(pay[room1i][room1j]);
        System.out.println(pay[room2i][room2j]);
    }

    private static void problem3(int[][] apt, int[][] pay) {
        // 문제 3) 관리비가 가장 많이 나온 집, 적게 나온 집 출력
        // 정답 3) 가장 많이 나온 집(201), 가장 적게 나온 집(303)

        int maxPayment = 0;
        int maxRoom = 0;
        int minPayment = pay[0][0];
        int minRoom = 0;

        for (int i = 0; i < apt.length; i++) {
            for (int j = 0; j < apt[i].length; j++) {
                int paymentEach = pay[i][j];
                if (paymentEach > maxPayment) {
                    maxRoom = apt[i][j];
                    maxPayment = paymentEach;
                }
                if (paymentEach < minPayment) {
                    minRoom = apt[i][j];
                    minPayment = paymentEach;
                }
            }
        }

        System.out.printf("%d %d, %d %d\n", maxRoom, maxPayment, minRoom, minPayment);
    }

    private static void problem2(int[][] apt, int[][] pay) {
        // 문제 2) 호를 입력하면 관리비 출력
        // 예    2) 입력 : 202	관리비 출력 : 2000

        Scanner scanner = new Scanner(System.in);
        int requestedRoom = scanner.nextInt();

        for (int i = 0; i < apt.length; i++) {
            for (int j = 0; j < apt[i].length; j++) {
                if (apt[i][j] == requestedRoom) {
                    System.out.print(pay[i][j] + "\n");
                    return;
                }
            }
        }

        System.out.println("찾는 호수가 없습니다!");
    }

    private static void problem1(int[][] pay) {
        // 문제 1) 각층별 관리비 합 출력
        // 정답 1) 4400, 7100, 5400

        for (int[] payByFloor : pay) {
            int floorPaySum = 0;
            for (int payEach : payByFloor) {
                floorPaySum += payEach;
            }
            System.out.print(floorPaySum + " ");
        }
    }
}
