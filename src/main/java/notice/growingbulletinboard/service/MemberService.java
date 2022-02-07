package notice.growingbulletinboard.service;

import lombok.RequiredArgsConstructor;
import notice.growingbulletinboard.domain.Member;
import notice.growingbulletinboard.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public Long joinMember(Member member) {
        return memberRepository.save(member).getId();
    }

    public Member findMember(Long id) {
        return memberRepository.findById(id).get();
    }

    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

}
