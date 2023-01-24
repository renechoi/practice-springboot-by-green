package work.atm.step2.command;

import work.atm.step2.Bank;
import work.atm.step2.Result;

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
