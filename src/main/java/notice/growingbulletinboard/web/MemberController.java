package notice.growingbulletinboard.web;

import lombok.RequiredArgsConstructor;
import notice.growingbulletinboard.domain.Address;
import notice.growingbulletinboard.domain.Member;
import notice.growingbulletinboard.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@RequiredArgsConstructor
@Controller
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/members/new")
    public String createMemberForm(Model model) {
        model.addAttribute("memberForm", new MemberDto());
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String createMember(@Valid MemberDto dto, BindingResult result) {

        if(result.hasErrors()) {
            return "members/createMemberForm";
        }
        Member member = new Member();
        member.setName(dto.getName());
        member.setAddress(new Address(dto.getCity(),dto.getStreet(),dto.getZipcode()));
        memberService.joinMember(member);

        return "redirect:/";
    }

    @GetMapping("/members")
    public String getMemberList(Model model) {

        model.addAttribute("members",memberService.findMembers());

        return "members/memberList";
    }
}
