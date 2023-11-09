package com.example.firstproject.controller;

import com.example.firstproject.dto.MemberForm;
import com.example.firstproject.entity.Member;
import com.example.firstproject.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
@Slf4j
public class MemberController {
    public final MemberRepository memberRepository;
//    @Autowired
//    MemberRepository memberRepository;

    @GetMapping("/signup")
    public String signUppage(){
        return "members/new";
    }

    @PostMapping("/join") // new.mustache의 액션과 동일해야한다
    public String join(MemberForm memberForm){
//        System.out.println(memberForm.toString());
        log.info(memberForm.toString());
        Member member = memberForm.toEntity();
//        System.out.println(member.toString());
        log.info(member.toString());
        Member saved = memberRepository.save(member);
//        System.out.println(saved.toString());
        log.info(saved.toString());

        return "redirect:/members/" + saved.getId();
    }
    // 게터,세터 방법
//    public String join(MemberForm memberForm) {
//        Member member = new Member();
//        member.setUsername(memberForm.getUsername());
//        member.setEmail(memberForm.getEmail());
//
//        Member saved = memberRepository.save(member);
//
//        return "";
//    }

    @GetMapping("/members/{id}")
    public String show(@PathVariable Long id, Model model){
        Member member = memberRepository.findById(id).orElse(null);
        model.addAttribute("member",member);
        return "members/show";
    }

    @GetMapping("/members")
    public String index(Model model){
        Iterable<Member> members = memberRepository.findAll();
        model.addAttribute("members", members);
        return "members/index";
    }

    @GetMapping("/members/{id}/edit")
    public String edit(@PathVariable Long id, Model model){
        Member memberEntity = memberRepository.findById(id).orElse(null);
        model.addAttribute("member", memberEntity);
        return "members/edit";
    }

    @PostMapping("/members/update")
    public String update(MemberForm form){
        log.info(form.toString());
        // 엔티티로 변환
        Member memberEntity = form.toEntity();
        // DB에서 데이터를 가져옴
        Member target = memberRepository.findById(memberEntity.getId()).orElse(null);
        // 만약 데이터가 있다면 내용 갱신
        if(target != null){
            memberRepository.save(memberEntity);
        }
        // 수정 결과 페이지로 리다이렉트
        return "redirect:/members/" + memberEntity.getId();
    }

    @GetMapping("/members/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes rttr, Model model){
        log.info("삭제 요청이 들어왔습니다");
        // 1. 삭제 대상을 가져옴
        Member target = memberRepository.findById(id).orElse(null);
        log.info(target.toString());
        // 2. 대상 삭제
        if(target != null){
            memberRepository.delete(target);
            rttr.addFlashAttribute("msg","삭제되었습니다");
        }
        // 결과 페이지
        return "redirect:/members";
    }
}
