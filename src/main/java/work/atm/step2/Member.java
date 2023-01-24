package work.atm.step2;

public class Member {
    public static final int initialAmount = 1000;
    private int memberNumber;
    private String name;
    private String memberId;
    private String password;
    private Account account;

    public Member(String name, String memberId, String password) {
        this(name, memberId, password, new Account(initialAmount, memberId));
    }

    public Member(String name, String memberId, String password, Account account) {
        this.name = name;
        this.memberId = memberId;
        this.password = password;
        this.account = account;
    }

    public boolean matchId(String requestedId) {
        return memberId.equals(requestedId);
    }

    public boolean matchIdAndPassword(String requestedId, String requestedPassword) {
        return memberId.equals(requestedId) && password.equals(requestedPassword);
    }

    public void deposit(int amount) {
        account.addAmount(amount);
    }

    public void withdraw(int amount) {
        account.subtractAmount(amount);
    }

    public void showAccount() {
        System.out.println(String.format("""
                        <잔액 조회>
                        고객번호: %s
                        계좌번호: %s
                        계좌명: %s
                        아이디: %s
                        잔액: %s
                        """,
                memberNumber,
                account.getAccountNumber(),
                name,
                memberId,
                account.getBalance()));
    }

    public void setMemberNumber(int memberNumber) {
        this.memberNumber = memberNumber;
    }

    public void setMemberAccountNumber(int accountNumber) {
        this.account.setAccountNumber(accountNumber);
    }
}
