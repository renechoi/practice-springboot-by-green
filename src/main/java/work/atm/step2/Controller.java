package work.atm.step2;

import work.atm.step2.command.*;
import work.atm.step2.ui.InputView;

public class Controller {

    public void openBank() {
        Bank bank = new Bank();
        CommandReader commandReader = new CommandReader(
                new RegisterCommand(),
                new UnregisterCommand(),
                new LoginCommand(),
                new LogoutCommand(),
                new DepositCommand(),
                new WithdrawCommand(),
                new TransferCommand(),
                new CheckBalanceCommand(),
                new QuitCommand()
        );

        try {
            runBank(bank, commandReader);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            runBank(bank, commandReader);
        }
    }

    private void runBank(Bank bank, CommandReader commandReader) {
        bank.showCurrentlyLogin();
        Result result = commandReader.handleCommand(bank, InputView.getSystemCommand());
        result.show();
        if (result.isQuit()) {
            return;
        }
        runBank(bank, commandReader);
    }
}
