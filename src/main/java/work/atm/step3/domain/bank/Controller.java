package work.atm.step3.domain.bank;

import work.atm.step2.domain.bank.Bank;
import work.atm.step2.domain.bank.Result;
import work.atm.step2.domain.command.*;
import work.atm.step2.ui.InputView;

public class Controller {

    public void openBank() {
        work.atm.step2.domain.bank.Bank bank = new work.atm.step2.domain.bank.Bank();
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

        runBank(bank, commandReader);
    }

    private void runBank(Bank bank, CommandReader commandReader) {
        try {
            bank.showCurrentlyLogin();
            Result result = commandReader.handleCommand(bank, InputView.getSystemCommand());
            result.show();
            if (result.isQuit()) {
                return;
            }
            runBank(bank, commandReader);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            runBank(bank, commandReader);
        }
    }
}
