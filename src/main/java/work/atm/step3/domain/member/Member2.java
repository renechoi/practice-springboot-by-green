package work.atm.step3.domain.member;

import java.util.Objects;

public class Member2 {
    public static final int initialAmount = 1000;
    private int memberNumber;
    private String name;
    private String memberId;
    private String password;
    
    public Member2(String name, String memberId, String password) {
        this.name = name;
        this.memberId = memberId;
        this.password = password;
    }

    public boolean matchId(String requestedId) {
        return memberId.equals(requestedId);
    }


    public boolean matchIdAndPassword(String requestedId, String requestedPassword) {
        return memberId.equals(requestedId) && password.equals(requestedPassword);
    }

//
//
//    public void showAccount() {
//        System.out.println(String.format("""
//                        <잔액 조회>
//                        고객번호: %s
//                        계좌번호: %s
//                        계좌명: %s
//                        아이디: %s
//                        잔액: %s
//                        """,
//                memberNumber,
//                account.getAccountNumber(),
//                name,
//                memberId,
//                account.getBalance()));
//    }

    public void setMemberNumber(int memberNumber) {
        this.memberNumber = memberNumber;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member2 member = (Member2) o;
        return Objects.equals(memberId, member.memberId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberId);
    }

    public String getMemberId() {
        return memberId;
    }
}
