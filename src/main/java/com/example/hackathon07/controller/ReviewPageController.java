package main.java.com.example.hackathon07.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/review")
public class ReviewPageController {

    /**
     * review 리스트 페이지
     */
    @GetMapping("/list")
    public String openReviewList() {
        return "review/list";
    }

    /**
     * review 등록 페이지
     */
    @GetMapping("/write_copy")
    public String openReviewWrite(@RequestParam(required = false) final Long review_id, Model model) {
        model.addAttribute("review_id", review_id);
        return "review/write_00";
    }

    /**
     * review 상세 페이지
     */
    @GetMapping("/view/{review_id}")
    public String openReviewView(@PathVariable final Long review_id, Model model) {
        model.addAttribute("review_id", review_id);
        return "review/view";
    }

}