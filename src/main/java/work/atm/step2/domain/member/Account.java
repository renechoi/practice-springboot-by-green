package work.atm.step2.domain.member;

public class Account {
    private int accountNumber;
    private int balance;
    private final String memberId;

    public Account(int balance, String memberId) {
        this.balance = balance;
        this.memberId = memberId;
    }

    public void addAmount(int amount) {
        this.balance = this.balance + amount;
    }

    public void subtractAmount(int amount) {
        validateAmount(amount);
        this.balance = this.balance - amount;
    }

    private void validateAmount(int amount) {
        if (this.balance < amount) {
            throw new IllegalArgumentException("잔액이 충분하지 않습니다.");
        }
    }

    public String getMemberId() {
        return memberId;
    }

    public int getBalance() {
        return balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }
}
