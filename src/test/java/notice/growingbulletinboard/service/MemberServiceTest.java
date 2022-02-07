package notice.growingbulletinboard.service;

import notice.growingbulletinboard.domain.Address;
import notice.growingbulletinboard.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@Transactional
@SpringBootTest
public class MemberServiceTest {

    @Autowired MemberService memberService;

    @Test
    public void 회원가입() throws Exception {
        //given
        Member member = new Member();
        member.setName("park");
        member.setAddress(new Address("city","111","111"));
        //when
        Long savedId = memberService.joinMember(member);
        //then
        assertThat(savedId).isEqualTo(member.getId());
    }

    @Test
    public void 회원조회() throws Exception {
        //given
        Member member1 = new Member();
        member1.setName("park");
        member1.setAddress(new Address("city","111","111"));

        Member member2 = new Member();
        member2.setName("lee");
        member2.setAddress(new Address("city","111","111"));

        memberService.joinMember(member1);
        memberService.joinMember(member2);
        //when
        Member findMember1 = memberService.findMember(member1.getId());
        Member findMember2 = memberService.findMember(member2.getId());

        List<Member> members = memberService.findMembers();
        //then
        assertThat(member1).isEqualTo(findMember1);
        assertThat(member2).isEqualTo(findMember2);

        assertThat(members.size()).isEqualTo(2);
    }
}
