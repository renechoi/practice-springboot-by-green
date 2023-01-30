package work.atm.step3.domain.member;


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
    }

    public void delete(String requestedId) {
        members.remove(getMember(requestedId));
    }

    public boolean exist(String requestedId) {
        return members.stream().anyMatch(member -> member.matchId(requestedId));
    }

    public boolean exist(Member requestedMember) {
        return members.stream().anyMatch(member -> member.equals(requestedMember));
    }

    public boolean match(String requestedId, String requestedPassword) {
        return members.stream()
                .anyMatch(member -> member.matchIdAndPassword(requestedId, requestedPassword));
    }

    public Member getMember(String currentlyLogin) {
        return members.stream()
                .filter(member -> member.matchId(currentlyLogin))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("찾는 아이디가 없습니다"));
    }

    public int getMemberCount() {
        return members.size();
    }

    private void assignMemberNumber(Member member) {
        member.setMemberNumber(1000 + getMemberCount() - 1);
    }



}
