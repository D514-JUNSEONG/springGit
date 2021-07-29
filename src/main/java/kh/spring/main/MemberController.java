
package kh.spring.main;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kh.spring.dto.MemberDTO;
import kh.spring.service.MemberService;



@Controller
@RequestMapping("/member")
public class MemberController {

	@Autowired
	private MemberService mService;

	
	@Autowired
	private HttpSession session;
	
	@RequestMapping("signup")
	public String signup() {
		return "member/signup";
	}
	
	
	@RequestMapping("signupProc")
	public String signupProc(MemberDTO dto) {
		
		
		mService.insert(dto);
		
		
		return "redirect:/";
	}
	
	
	@RequestMapping("loginProc")
	public String loginProc(String id, String pw) {
		
		MemberDTO dto = new MemberDTO();
		
		dto.setId(id);
		dto.setPw(pw);
		System.out.println(dto.getId() + dto.getPw());
		int result= mService.login(dto);
		
		if(result > 0) {
			session.setAttribute("loginID",dto);
		}
		return "redirect:/";
	}
	
	
	//濡쒓렇�븘�썐
	@RequestMapping("logout")
	public String logout() {
		session.invalidate();

		return "redirect:/";
	}
	
	

	@ResponseBody
	@RequestMapping(value="duplCheck",produces="text/html;charset=utf8")
	public String idDuplCheck(MemberDTO dto) {
		
		dto.setId("id");
		
		int result = mService.idDuplCheck(dto);
		
		return String.valueOf(result);
	}
	
	@RequestMapping("memberOut")
	public String memberOut() {
		String id = (String)session.getAttribute("loginID");
		mService.memberOut(id);
		session.invalidate();
		return "redirect:/";
		
	}
}