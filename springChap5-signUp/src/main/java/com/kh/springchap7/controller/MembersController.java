package com.kh.springchap7.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.springchap7.model.Members;
import com.kh.springchap7.service.MemberService;

@Controller
@RequestMapping("/members")
public class MembersController {
	
	@Autowired
	private MemberService memberService;
	
	
	@GetMapping("/register")
	public String showRegisterForm(Model model) {
		model.addAttribute("members", new Members());
		return "register";
		
	}
	
	@PostMapping("/register")
	public String registerMember(Members members) {
		memberService.SignUpMember(members);
		return "redirect:/members/register";
	}
	
	@GetMapping("/List")
	public String showMemberList(Model model) {
		model.addAttribute("members", memberService.getAllMembers());
		return "memberList";
	}
	
	
	@PostMapping("/update")
	public String updateForm(Members members) {
		memberService.MemberUpdate(members);
		return "redirect:/members/List";
	}
	
	@GetMapping("/update")
	public String displayUpdateForm(@RequestParam ("id") Long id, Model model) {
			Members members = memberService.getMemberById(id);
			model.addAttribute("members", members);
			return "member_update";
	}
	
	
	@GetMapping("/delete")
	public String showDeleteform(@RequestParam ("id") Long id) {
		memberService.deleteMember(id);
		return "redirect:/members/List";
	}
	
	
	
	
	
	
	

}
