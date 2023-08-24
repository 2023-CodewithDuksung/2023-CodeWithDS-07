package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    private final MemberService memberService;

    @Autowired
    public LoginController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/login")
    public String loginForm() {
        return "login"; // login.html 템플릿을 반환
    }

    @PostMapping("/login")
    public String login(@RequestParam String studentNumber, @RequestParam String password, Model model) {
        boolean loginSuccess = memberService.authenticate(Integer.parseInt(studentNumber), password);

        if (loginSuccess) {
            return "redirect:/index.html"; // 로그인 성공 시 index.html로 리다이렉트
        } else {

            return "index"; // login-result.html 템플릿을 반환
        }
    }

    @GetMapping("/index") // 로그인 성공 페이지로 이동
    public String loginSuccess() {
        return "index"; // login-success.html 템플릿을 반환
    }
}
