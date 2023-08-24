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
        return "loginForm";
    }

    @PostMapping("/login")
    public String login(@RequestParam String studentNumber, @RequestParam String password, Model model) {
        // 학번과 비밀번호로 로그인을 처리하는 로직을 구현해야 합니다.
        // 이 부분은 MemberService의 authenticate 메서드 등을 활용하여 구현할 수 있습니다.

        boolean loginSuccess = memberService.authenticate(Integer.parseInt(studentNumber), password);

        if (loginSuccess) {
            return "redirect:/"; // 로그인 성공 시 홈 페이지로 리다이렉트
        } else {
            model.addAttribute("error", "로그인에 실패하였습니다."); // 로그인 실패 시 에러 메시지 전달
            return "loginForm"; // 로그인 폼 페이지로 이동
        }
    }
}
