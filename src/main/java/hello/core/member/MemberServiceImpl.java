package hello.core.member;

public class MemberServiceImpl implements MemberService{

    // new 가 없으면 null point exception 발생
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
