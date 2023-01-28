package day4;

class Ex03{


    int type1(){
        return 10;
    }

    void type2(int num){

    }

}

public class Test3 {
    public static void main(String[] args) {
        Ex03 ex02 = new Ex03();
        int i = ex02.type1();

        ex02.type2(50);
    }
}
