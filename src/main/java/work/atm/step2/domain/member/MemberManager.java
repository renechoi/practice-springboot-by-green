package work.atm.step2.domain.member;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MemberManager {
    private List<Member> members = new ArrayList<>();

    public MemberManager() {
    }

    public MemberManager(Member... members) {
        this.members = Arrays.asList(members);
    }

    public void add(Member member) {
        members.add(member);
        assignMemberNumber(member);
        assignAccountNumber(member);
    }

    public void delete(String requestedId) {
        members.remove(getMember(requestedId));
    }

    public void deposit(String currentlyLogin, int amount) {
        getMember(currentlyLogin).deposit(amount);
    }

    public void withdraw(String currentlyLogin, int amount) {
        getMember(currentlyLogin).withdraw(amount);
    }

    public void transfer(String memberFrom, String memberTo, int requestTransferAmount) {
        try {
            getMember(memberFrom).withdraw(requestTransferAmount);
        } catch (RuntimeException e) {
            throw new IllegalArgumentException("송금 잔액이 부족합니다.");
        }
        getMember(memberTo).deposit(requestTransferAmount);
    }

    public void checkBalance(String requestId) {
        getMember(requestId).showAccount();
    }

    public boolean exist(String requestedId) {
        return members.stream().anyMatch(member -> member.matchId(requestedId));
    }

    public boolean match(String requestedId, String requestedPassword) {
        return members.stream()
                .anyMatch(member -> member.matchIdAndPassword(requestedId, requestedPassword));
    }

    private Member getMember(String currentlyLogin) {
        return members.stream()
                .filter(member -> member.matchId(currentlyLogin))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("찾는 아이디가 없습니다"));
    }

    private int getMemberCount() {
        return members.size();
    }

    private void assignMemberNumber(Member member) {
        member.setMemberNumber(1000 + getMemberCount() - 1);
    }

    private void assignAccountNumber(Member member) {
        member.setMemberAccountNumber(1111 + ((getMemberCount() - 1) * 1111));
    }
}
