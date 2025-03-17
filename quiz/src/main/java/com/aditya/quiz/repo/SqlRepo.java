package com.aditya.quiz.repo;

import com.aditya.quiz.entity.SqlQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SqlRepo extends JpaRepository<SqlQuestion,Long> {
}
