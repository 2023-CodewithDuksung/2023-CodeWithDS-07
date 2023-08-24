package main.java.com.example.hackathon07.repository;

import main.java.com.example.hackathon07.domain.ReviewImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewImageRepository extends JpaRepository<File, Long> {
    
}
