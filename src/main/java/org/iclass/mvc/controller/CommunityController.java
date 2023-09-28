package org.iclass.mvc.controller;

import org.iclass.mvc.dto.Community;
import org.iclass.mvc.dto.CommunityComments;
import org.iclass.mvc.service.CommunityService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;

@Controller
@RequestMapping("/community")
public class CommunityController {

    private final CommunityService service;

    private CommunityController(CommunityService service){
        this.service = service;
    }

    @GetMapping("/list")
    public void list(@RequestParam(defaultValue = "1") int page, Model model){
        model.addAttribute("list",service.pagelist(page).get("list"));
        model.addAttribute("paging",service.pagelist(page).get("paging"));
        model.addAttribute("today", LocalDate.now());
    }

    @GetMapping("/read")
    public void read(long idx, @ModelAttribute("page") int page,Model model){
        model.addAttribute("vo",service.read(idx));
        model.addAttribute("cmtlist",service.commentsList(idx));
    }

    @GetMapping("/write")
    public void write(){

    }
    @PostMapping("/write")
    public String save(Community dto, RedirectAttributes redirectAttributes){
        service.insert(dto);

        redirectAttributes.addFlashAttribute("message","글 등록이 완료되었습니다.");
        return "redirect:/community/list";
    }
    @PostMapping("/update")
    public void update(long idx, @ModelAttribute("page")int page, Model model){
        model.addAttribute("vo",service.selectByIdx(idx));
    }

    @PostMapping("/save")
    public String updateSave(int page, Community vo, RedirectAttributes redirectAttributes){
        service.update(vo);

        redirectAttributes.addAttribute("idx",vo.getIdx());
        redirectAttributes.addAttribute("page",page);
        redirectAttributes.addFlashAttribute("message","글 수정이 완료되었습니다.");

        return "redirect:/community/read";
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute("page") int page, long idx, RedirectAttributes redirectAttributes){
        service.delete(idx);

        redirectAttributes.addAttribute("page",page);
        redirectAttributes.addFlashAttribute("message","글 삭제가 완료되었습니다.");

        return "redirect:/community/list";
    }

    @PostMapping("/comments")
    public String comments(int page, int f, CommunityComments dto, RedirectAttributes redirectAttributes){
        service.comments(dto,f);
        redirectAttributes.addAttribute("page",page);
        redirectAttributes.addAttribute("idx",dto.getMref());

        String message = null;
        if(f==1)message = "댓글 등록 하였습니다.";
        else if(f==2)message = "댓글 삭제 하였습니다";

        redirectAttributes.addFlashAttribute("message",message);

        return "redirect:/community/read";
    }

}
