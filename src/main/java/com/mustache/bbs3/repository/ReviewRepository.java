package com.mustache.bbs3.repository;

import com.mustache.bbs3.domain.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
