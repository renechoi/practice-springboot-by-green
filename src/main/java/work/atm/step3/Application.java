package work.atm.step3;

import work.atm.step2.domain.bank.Controller;

public class Application {
    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.openBank();
    }
}
