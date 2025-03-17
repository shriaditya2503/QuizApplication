package com.aditya.quiz.repo;

import com.aditya.quiz.entity.SpringQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringRepo extends JpaRepository<SpringQuestion, Long> {
}
