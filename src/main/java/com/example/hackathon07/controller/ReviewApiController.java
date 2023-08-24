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
    public Long save(@RequestBody final ReviewRequestDTO params) {
        return reviewService.save(params);
    }

    /**
     * review 리스트 조회
     */
    @GetMapping("/reviews")
    public List<ReviewResponseDTO> findAll() {
        return reviewService.findAll();
    }
    
    /**
     * review 수정
    */
    @PatchMapping("/reviews/{review_id}")
    public Long save(@PathVariable final Long review_id, @RequestBody final ReviewRequestDTO params) {
        return reviewService.update(review_id, params);
    }

    /**
     * review 삭제
     */
    @DeleteMapping("/reviews/{review_id}")
    public Long delete(@PathVariable final Long review_id) {
        return reviewService.delete(review_id);
    }

    /**
     * review 상세정보 조회
     */
    @GetMapping("/reviews/{review_id}")
    public ReviewResponseDto findById(@PathVariable final Long review_id) {
        return reviewService.findById(review_id);
    }

    /**
     * API 컨트롤러에서는 ReviewService의 delete( )와 findById( ) 메서드와 URI만 매핑해주면 됨
     */
}
