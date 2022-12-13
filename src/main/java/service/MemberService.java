package service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import domain.Member;
import repository.MemoryMemberRepository;

import repository.MemberRepository;

@Service
public class MemberService {

    private final MemberRepository memberRepository;
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Long join(Member member) {

        validateDuplicateMember(member);

        memberRepository.save(member);
        return member.getId();
    }

    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }

    private void validateDuplicateMember (Member member) {
        memberRepository.findByName(member.getName())
            .ifPresent(n -> {throw new IllegalStateException("repeated ppl");});
    }
    
}
