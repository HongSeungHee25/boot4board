package org.iclass.mvc.controller;

import org.iclass.mvc.service.CommunityService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/sample")	//url 이 DispatcherServlet 으로부터 community 로 시작하면 CommunityController 가 위임받아 처리합니다.
public class SampleController {

	private final CommunityService service;
	
	private SampleController(CommunityService service) {
		this.service = service;
	}
	
	@GetMapping("/hello")
	public void hello(Model model) {
		model.addAttribute("message","하이는 무슨 ㅡㅡ 개빡치네");
		model.addAttribute("list", List.of("모모","나연","나나","쯔위"));
	}

	
	
	
	
 }
