package work.atm.step2.command;

import work.atm.step2.Bank;
import work.atm.step2.Result;

public class QuitCommand implements Command{
    @Override
    public boolean support(String userInput) {
        return "0".equals(userInput);
    }

    @Override
    public Result doBankJob(Bank bank) {
        return bank.quit();
    }
}
