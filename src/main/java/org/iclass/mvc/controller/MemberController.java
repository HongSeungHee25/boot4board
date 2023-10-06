package org.iclass.mvc.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.iclass.mvc.dto.BookUser;
import org.iclass.mvc.service.BookUserService;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
@SessionAttributes(names = {"user","cart","tno"})
@Log4j2
public class MemberController {

    private final BookUserService service;

    @GetMapping("/join")
    public void joinView(){

    }
    @PostMapping("/save")
    public String join(BookUser dto, RedirectAttributes redirectAttributes){
        service.join(dto);
        redirectAttributes.addFlashAttribute("result","회원가입이 완료되었습니다.");

        return "redirect:/login";
    }
    @GetMapping("/update")
    public void update(Model model,String id){
        model.addAttribute("vo",service.selectId(id));
    }

    @PostMapping("/update")
    public String save(BookUser vo,RedirectAttributes redirectAttributes){
        service.update(vo);
        redirectAttributes.addFlashAttribute("result","회원정보 수정이 완료되었습니다.");

        return "redirect:/";
    }

}
