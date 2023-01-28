package day4;

class Ex01{
    // 메서드 타입1: 유산 x, 외부값 x
    // 메서드 구조 : 1 유산형태, 2 메서드 이름, 3 외부값 4 메서드 영역
    void type1(){
        System.out.println("type 1 호출");
        System.out.println(this);
    }

}

public class Test1 {
    public static void main(String[] args) {
        Ex01 ex01 = new Ex01();
        ex01.type1();

    }
}
