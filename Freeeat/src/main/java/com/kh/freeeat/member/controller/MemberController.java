package com.kh.freeeat.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kh.freeeat.member.model.service.MemberService;
import com.kh.freeeat.member.model.vo.Member;

@Controller
public class MemberController {
	
	@Autowired //전제조건? 빈등록을 해야 한다?
	private MemberService memberService;
	
	@Autowired
	private BCryptPasswordEncoder bcryptPasswordEncoder;
	
	//로그인 화면 띄우기
	@RequestMapping("loginForm.yj")
	public String loginForm() {
		return "member/loginEnrollForm";
	}
	
	//로그인 처리
	@RequestMapping(value="login.yj")
	public ModelAndView loginMember(Member m, ModelAndView mv, HttpSession session) {
		
		  Member loginMem = memberService.loginMember(m);
		  
		  System.out.println(loginMem);
		
		  if(loginMem != null && bcryptPasswordEncoder.matches(m.getMemPwd(),loginMem.getMemPwd())) {
			  session.setAttribute("loginMem",loginMem);
			  
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
	
	//회원가입
	@RequestMapping("insert.yj")
	public String insertMember(Member m, Model model) {
		
		//암호화 작업(암호문을 만들어내는 과정)
		  String encPwd = bcryptPasswordEncoder.encode(m.getMemPwd());
		  
		  m.setMemPwd(encPwd); 
		  
		  int result = memberService.insertMember(m);

		  if(result > 0 ) {
			  return "redirect:joinCompleteForm.yj";
		  } else {
			  model.addAttribute("errorMsg","회원가입 실패");
			  
			  return "common/errorPage";
		  }
	}
	
	//로그아웃
	@RequestMapping("logout.yj")
	public String logoutMember(HttpSession session) {
		
		session.invalidate(); // invalidate() : session 비우기
		return "redirect:/";
	}
	
	//회원가입 완료 화면으로 보내기	
	@RequestMapping("joinCompleteForm.yj")
	public String joinCompleteForm() {
		return "member/joinCompleteForm";
	}
	
	//마이페이지 띄우기
	@RequestMapping("mypage.yj")
	public String myPage() {
		return "member/MyPage";
	}
	
	@RequestMapping("update.yj")
	public String updateMember(Member m, Model model, HttpSession session) {
		
		if(memberService.updateMember(m) > 0) {
			
			session.setAttribute("loginMem", memberService.loginMember(m));
			
			//session에 일회성 알람문 띄우기
			 session.setAttribute("alertMsg", "성공적으로 변경되었습니다!!");
			 
			 return "redirect:mypage.yj";
			
		} else { //수정 실패 => 에러문구 담아서 에러페이지로 포워딩
			
			model.addAttribute("errorMsg", "회원 정보 변경 실패");
			System.out.println("수정 실패!");
			
			 return "common/errorPage";
		}
	}
	
	@RequestMapping("delete.yj")
	public String deleteMember(String memId, String memPwd,HttpSession session) {
		  //memPwd : 회원 탈퇴 요청 시 사용자가 입력한 비밀번호 평문
		  //session의 loginUser Member객체의 memPwd필드 : DB에 기록된 암호화 된 비밀번호
		String encPwd = ((Member)session.getAttribute("loginMem")).getMemPwd();
		
		if(bcryptPasswordEncoder.matches(memPwd, encPwd)) { 
			//(평문, 암호문) 둘이 같으면 true반환 
			//=>평문을 암호문으로 바꾼 다음에 비교 -> true,false
			
			int result = memberService.deleteMember(memId);
			
			if(result > 0) {
				 //탈퇴처리 성공 => session에서 loginUser지움, alert문구 담기 => 메인페이지 url요청
				  session.removeAttribute("loginMem");
				  session.setAttribute("alertMsg", "잘가고!");
				  
				  return "redirect:/";
			} else {
				
				 session.setAttribute("errorMsg", "실패");
				  return "common/errorPage";
			}
			
		} else {
			
			  session.setAttribute("alertMsg", "비밀번호틀렸어~");
			  return "redirect:mypage.yj";
		}
	}
	
	@ResponseBody
	@RequestMapping("idCheck.yj")
	public String idCheck(String checkId) {
		
		int result = memberService.idCheck(checkId);
		
		if(result > 0) { //이미 존재하는 아이디 => 사용불가능(NNNNN)
			 return "NNNNN";
		} else { // 사용가능(NNNNY)
			 return "NNNNY";
		}
	}
	
}
