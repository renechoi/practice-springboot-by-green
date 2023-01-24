package work.atm.step2.domain.command;

import work.atm.step2.domain.bank.Bank;
import work.atm.step2.domain.bank.Result;

public interface Command {
    boolean support(String userInput);

    Result doBankJob(Bank bank);

}
