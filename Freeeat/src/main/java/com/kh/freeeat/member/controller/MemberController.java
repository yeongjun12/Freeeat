package com.kh.freeeat.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kh.freeeat.member.model.service.MemberService;
import com.kh.freeeat.member.model.vo.Member;

@Controller
public class MemberController {
	
	@Autowired //전제조건? 빈등록을 해야 한다?
	private MemberService memberService;
	
	@Autowired
	private BCryptPasswordEncoder bcryptPasswordEncoder;
	
	
	@RequestMapping("loginForm.yj")
	public String loginForm() {
		return "member/loginEnrollForm";
	}
	
	
	
	@RequestMapping(value="login.yj")
	public ModelAndView loginMember(Member m, ModelAndView mv, HttpSession session) {
		
		  Member loginMem = memberService.loginMember(m);
		  
		  System.out.println(loginMem);
		
		  if(loginMem != null && bcryptPasswordEncoder.matches(m.getMemPwd(),loginMem.getMemPwd())) {
			  session.setAttribute("loginUser",loginMem);
			  
			  System.out.println("로그인 성공!");
			  mv.setViewName("redirect:/");
			  
		  } else {
			  // model.addAttribute("키","밸류");
			  mv.addObject("errorMsg","응 안돼!");
			  mv.setViewName("common/errorPage");
		  }
	
		  return mv;
	}
	
	//회원가입 화면 띄우기
	@RequestMapping("enrollForm.yj")
	public String enrollForm() {
		return "member/joinEnrollForm";
	}
	
	
	@RequestMapping("insert.yj")
	public String insertMember(Member m, Model model) {
		
		//암호화 작업(암호문을 만들어내는 과정)
		  String encPwd = bcryptPasswordEncoder.encode(m.getMemPwd());
		  
		  m.setMemPwd(encPwd); 
		  
		  int result = memberService.insertMember(m);

		  if(result > 0 ) {
			  return "redirect:/";
		  } else {
			  model.addAttribute("errorMsg","회원가입 실패");
			  
			  return "common/errorPage";
		  }
	}
	
	
}
