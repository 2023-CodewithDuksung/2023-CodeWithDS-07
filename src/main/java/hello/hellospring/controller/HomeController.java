package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        // 홈 뷰를 반환하는 로직
        return "index"; // "home.html" 또는 해당하는 뷰의 이름
    }
}

