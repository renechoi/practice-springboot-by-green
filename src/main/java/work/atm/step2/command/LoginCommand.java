package work.atm.step2.command;

import work.atm.step2.Bank;
import work.atm.step2.Result;
import work.atm.step2.ui.InputView;

public class LoginCommand implements Command {
    @Override
    public boolean support(String userInput) {
        return "3".equals(userInput);
    }

    @Override
    public Result doBankJob(Bank bank) {
        return bank.login(requestMemberId(),  requestMemberPassword());
    }

    private String requestMemberId() {
        return InputView.getMemberId("로그인");
    }

    private String requestMemberPassword() {
        return InputView.getMemberPassword("로그인");
    }

}
