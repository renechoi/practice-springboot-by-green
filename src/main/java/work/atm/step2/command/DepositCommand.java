package work.atm.step2.command;

import work.atm.step2.Bank;
import work.atm.step2.Result;
import work.atm.step2.ui.InputView;

public class DepositCommand implements Command {
    @Override
    public boolean support(String userInput) {
        return "5".equals(userInput);
    }

    @Override
    public Result doBankJob(Bank bank) {
        return bank.deposit(requestDepositAmount());
    }

    private int requestDepositAmount() {
        return InputView.getAmount("입금");
    }

}
