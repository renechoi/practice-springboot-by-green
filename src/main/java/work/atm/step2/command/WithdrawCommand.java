package work.atm.step2.command;

import work.atm.step2.Bank;
import work.atm.step2.Result;
import work.atm.step2.ui.InputView;

public class WithdrawCommand implements Command{
    @Override
    public boolean support(String userInput) {
        return "6".equals(userInput);
    }

    @Override
    public Result doBankJob(Bank bank) {
        return bank.withdraw(requestWithdrawAmount());
    }

    private int requestWithdrawAmount() {
        return InputView.getAmount("출금");
    }
}
