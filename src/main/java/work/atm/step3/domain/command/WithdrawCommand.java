package work.atm.step3.domain.command;

import work.atm.step2.domain.bank.Bank;
import work.atm.step2.domain.bank.Result;
import work.atm.step2.domain.command.Command;
import work.atm.step2.ui.InputView;

public class WithdrawCommand implements Command {
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
