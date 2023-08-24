// written by 20200207 PARK YEON WOO

package main.java.com.example.hackathon07.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hackathon07.dto.ReviewRequestDTO;
import com.example.hackathon07.dto.ReviewResponseDTO;
import com.example.hackathon07.dto.ReviewService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ReviewApiController {
    // field
    private final ReviewService reviewService;

    /**
     * review 생성
     */
    @PostMapping("/reviews")
    public Long save(@RequestBody final ReviewRequestDto params) {
        return reviewService.save(params);
    }

    /**
     * review 리스트 조회
     */
    @GetMapping("/reviews")
    public List<ReviewResponseDto> findAll() {
        return reviewService.findAll();
    }
    
    /**
     * review 수정
    */
    @PatchMapping("/reviews/{id}")
    public Long save(@PathVariable final Long review_id, @RequestBody final ReviewRequestDto params) {
        return reviewService.update(review_id, params);
    }
}
