package com.example.firstproject.controller;


import com.example.firstproject.dto.MemberForm;
import com.example.firstproject.entity.Member;
import com.example.firstproject.repository.MemberRepositoty;
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
    private  final MemberRepositoty memberRepositoty;

    @GetMapping("/signup")
    public String signUppage(){
        return "members/new";
    }
    @PostMapping("/join")
    public String join(MemberForm memberForm){
        //System.out.println(memberForm.toString());
        log.info(memberForm.toString());
        Member member = memberForm.toEntity();
        //System.out.println(member.toString());
        log.info(member.toString());
        Member saved = memberRepositoty.save(member);
        //System.out.println(saved.toString());
        log.info(saved.toString());
        return "redirect:/members/"+ saved.getId();
    }
    @GetMapping("/members/{id}")
    public String show(@PathVariable Long id, Model model){
        Member member = memberRepositoty.findById(id).orElse(null);
        model.addAttribute("member",member);
        return "members/show";
    }
    @GetMapping("/members")
    public String index(Model model){
       Iterable<Member> members = memberRepositoty.findAll();
       model.addAttribute("members",members);
       return "members/index";
    }
@GetMapping("/members/{id}/edit")
    public String edit(@PathVariable Long id, Model model){
      Member memberEntity  = memberRepositoty.findById(id).orElse(null);
      model.addAttribute("member",memberEntity);
        return "members/edit";
}
    @PostMapping("/members/update")
    public String update(MemberForm form) {
        log.info(form.toString());
        Member memberEntity = form.toEntity();
        Member target = memberRepositoty.findById(memberEntity.getId()).orElse(null);
        if (target != null) {
            memberRepositoty.save(memberEntity);
        }
        return "redirect:/members/" + memberEntity.getId();
    }

@GetMapping("/members/{id}/delete")
    public String delete(@PathVariable Long id,
                         RedirectAttributes rttr,
                         Model model){
    log.info("삭제 요청이 들어왔습니다.");
    //1. 삭제 대상을 가져옴
    Member target =   memberRepositoty.findById(id).orElse(null);
    log.info(target.toString());
    //2. 대상 삭제
    if(target != null){
       memberRepositoty.delete(target);
       rttr.addFlashAttribute("msg","삭제됐습니다.");
    }
    //결과페이지로 리다이렉트
    return "redirect:/members";
    }



}
