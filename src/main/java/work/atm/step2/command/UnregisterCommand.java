package work.atm.step2.command;

import work.atm.step2.Bank;
import work.atm.step2.Result;

public class UnregisterCommand implements Command {
    @Override
    public boolean support(String userInput) {
        return "2".equals(userInput);
    }

    @Override
    public Result doBankJob(Bank bank) {
        return bank.unRegister();
    }
}
