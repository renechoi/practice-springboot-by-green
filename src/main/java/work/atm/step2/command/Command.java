package work.atm.step2.command;

import work.atm.step2.Bank;
import work.atm.step2.Result;

public interface Command {
    boolean support(String userInput);

    Result doBankJob(Bank bank);

}
