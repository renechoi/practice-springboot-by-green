package work.atm.step2;

public class Bank {

    public static final MemberManager MEMBER_MANAGER = new MemberManager();
    private String currentlyLogin = "-1";

    public Result register(Member member) {
        try {
            MEMBER_MANAGER.add(member);
        } catch (RuntimeException e) {
            return new Result("회원 가입에 실패하였습니다", false);
        }
        return new Result("회원 가입에 성공하였습니다", true);
    }

    public Result unRegister() {
        validateLoginOff();
        try {
            MEMBER_MANAGER.delete(validateLoginId(currentlyLogin));
        } catch (RuntimeException e) {
            return new Result("회원 탈퇴에 실패하였습니다", false);
        }
        setLoginStatusNone();
        return new Result("회원 탈퇴에 성공하였습니다", true);
    }

    public Result login(String requestedId, String requestedPassword) {
        try {
            validateLoginOn();
        } catch (RuntimeException e) {
            return new Result("로그인에 실패하였습니다 \n" + e.getMessage(), false);
        }
        this.currentlyLogin = validateLoginIdAndPassword(requestedId);
        return new Result("로그인에 성공하였습니다", true);
    }

    public Result logout() {
        try {
            validateLoginId(currentlyLogin);
        } catch (RuntimeException e) {
            return new Result("로그아웃에 실패하였습니다", false);
        }
        setLoginStatusNone();
        return new Result("로그아웃에 성공하였습니다", true);
    }

    private void setLoginStatusNone() {
        this.currentlyLogin = "-1";
    }

    public Result deposit(int amount) {
        validateLoginOff();
        try {
            MEMBER_MANAGER.deposit(this.currentlyLogin, amount);
        } catch (RuntimeException e) {
            return new Result("입금에 실패하였습니다", false);
        }
        return new Result("입금에 성공하였습니다", true);
    }

    public Result withdraw(int amount) {
        validateLoginOff();
        try {
            MEMBER_MANAGER.withdraw(this.currentlyLogin, amount);
        } catch (RuntimeException e) {
            return new Result("출금에 실패하였습니다", false);
        }
        return new Result("출금에 성공하였습니다", true);
    }

    public Result transfer(String requestMemberId, int requestTransferAmount) {
        validateLoginOff();
        try {
            MEMBER_MANAGER.transfer(this.currentlyLogin, requestMemberId, requestTransferAmount);
        } catch (RuntimeException e) {
            return new Result("송금에 실패하였습니다", false);
        }
        return new Result("송금에 성공하였습니다", true);
    }

    public Result checkBalance() {
        MEMBER_MANAGER.checkBalance(currentlyLogin);
        return new Result("조회에 성공하였습니다", true);
    }

    public Result quit() {
        return new Result("종료합니다", true);
    }

    private void validateLoginOff() {
        if (currentlyLogin.equals("-1")) {
            throw new IllegalArgumentException("로그인이 되어 있지 않습니다.");
        }
    }

    private void validateLoginOn() {
        if (!currentlyLogin.equals("-1")) {
            throw new IllegalArgumentException("현재 로그인이 되어 있습니다.");
        }
    }

    private String validateLoginId(String requestedId) {
        if (!currentlyLogin.equals(requestedId)) {
            throw new IllegalArgumentException("아이디가 일치하지 않습니다.");
        }
        return requestedId;
    }

    public String validateLoginIdAndPassword(String requestedId) {
        if (!MEMBER_MANAGER.match(requestedId)) {
            throw new IllegalArgumentException("로그인 가능한 아이디가 없습니다.");
        }
        return requestedId;
    }

    public void showCurrentlyLogin() {
        Runnable show = currentlyLogin.equals("-1") ?
                () -> System.out.print("") :
                () -> System.out.printf("[시스템] 현재 로그인한 계정: %s\n", currentlyLogin);
        show.run();
    }
}
