package day4;

class Ex02{
    int num = 100;      // 멤버 변수

    void type1(){
        int num = 10;   // 지역 변수
        System.out.println("type 1 호출");
        System.out.println(this);
        System.out.println(this.num);
    }

    void type2(int num){

    }

}

public class Test2 {
    public static void main(String[] args) {
        Ex02 ex02 = new Ex02();
        ex02.type1();

        ex02.type2(50);
    }
}
