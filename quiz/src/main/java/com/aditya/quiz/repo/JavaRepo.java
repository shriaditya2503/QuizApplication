package com.aditya.quiz.repo;

import com.aditya.quiz.entity.JavaQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JavaRepo extends JpaRepository<JavaQuestion,Long> {
}
