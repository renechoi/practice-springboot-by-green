package work.atm.step2.domain.command;

import work.atm.step2.domain.bank.Bank;
import work.atm.step2.domain.bank.Result;
import work.atm.step2.ui.InputView;

public class LogoutCommand implements Command {
    @Override
    public boolean support(String userInput) {
        return "4".equals(userInput);
    }

    @Override
    public Result doBankJob(Bank bank) {
        return bank.logout();
    }

    private String requestMemberId() {
        return InputView.getMemberId("로그아웃");
    }
}
