package work.atm.step3.domain.command;

import work.atm.step2.domain.bank.Bank;
import work.atm.step2.domain.bank.Result;
import work.atm.step2.domain.command.Command;

import java.util.Arrays;
import java.util.List;

public class CommandReader {

    private final List<work.atm.step2.domain.command.Command> commands;

    public CommandReader(Command... commands) {
        this.commands = Arrays.asList(commands);
    }

    public Result handleCommand(Bank bank, String userInput) {
        return commands.stream()
                .filter(command -> command.support(userInput))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("지원하지 않는 명령입니다."))
                .doBankJob(bank);
    }
}
