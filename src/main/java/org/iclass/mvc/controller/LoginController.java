package org.iclass.mvc.controller;

import lombok.RequiredArgsConstructor;
import org.iclass.mvc.dto.BookUser;
import org.iclass.mvc.service.BookUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Map;

@Controller
@RequiredArgsConstructor
@SessionAttributes(names = {"user","cart","tno"})
public class LoginController {

    private final BookUserService service;

    @GetMapping("/login")
    public void login(){

    }
    @PostMapping("/login")
    public String loginProc(@RequestParam Map<String,String> param, RedirectAttributes reattr, Model model){
        String url="/";
        BookUser member = service.login(param);
        if(member==null){
            reattr.addFlashAttribute("incorrect","y");
            reattr.addFlashAttribute("result","로그인 실패");
            url="login";
        }else{
            model.addAttribute("user",member);
            reattr.addFlashAttribute("result","로그인 성공 !! "+member.getName()+"님 환영합니다.");
        }
        return "redirect:"+url;
    }

    @GetMapping("logout")
    public String logout(SessionStatus session, RedirectAttributes redirectAttributes){
        session.setComplete();
        redirectAttributes.addFlashAttribute("result","로그아웃 되었습니다.");
        return "redirect:/";
    }

}
