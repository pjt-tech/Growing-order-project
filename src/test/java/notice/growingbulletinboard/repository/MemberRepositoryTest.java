package notice.growingbulletinboard.repository;

import notice.growingbulletinboard.entity.Address;
import notice.growingbulletinboard.entity.Member;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;

@Rollback(value = false)
@Transactional
@SpringBootTest
class MemberRepositoryTest {

    @Autowired MemberRepository memberRepository;

    @Test
    public void 회원가입() throws Exception {
        //given
        Member member = Member.builder()
                .name("park")
                .address(new Address("city","street","1000"))
                .build();
        memberRepository.save(member);
        //when
        Member findMember = memberRepository.findById(member.getId()).get();
        //then
        assertThat(findMember.getName()).isEqualTo(member.getName());
        assertThat(findMember.getId()).isEqualTo(member.getId());
        assertThat(findMember.getAddress()).isEqualTo(member.getAddress());
        assertThat(findMember).isEqualTo(member);

    }
}