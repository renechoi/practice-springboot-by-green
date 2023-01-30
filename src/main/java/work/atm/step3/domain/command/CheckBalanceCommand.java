package work.atm.step3.domain.command;

import work.atm.step3.domain.bank.Bank;
import work.atm.step3.domain.bank.Result;

public class CheckBalanceCommand implements Command {
    @Override
    public boolean support(String userInput) {
        return "8".equals(userInput);
    }

    @Override
    public Result doBankJob(Bank bank) {
        return bank.checkBalance();
    }
}
