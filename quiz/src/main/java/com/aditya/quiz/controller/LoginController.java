package com.aditya.quiz.controller;

import com.aditya.quiz.dto.LoginRequest;
import com.aditya.quiz.entity.JavaQuestion;
import com.aditya.quiz.entity.SpringQuestion;
import com.aditya.quiz.entity.SqlQuestion;
import com.aditya.quiz.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/quiz")
public class LoginController {


    @Autowired
    QuestionService questionService;

    // Hardcoded credentials for now
    private final String USERNAME = "user";
    private final String PASSWORD = "password";

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest) {
        if (USERNAME.equals(loginRequest.getUsername()) && PASSWORD.equals(loginRequest.getPassword())) {
            return "Login Successful!";
        } else {
            return "Invalid username or password";
        }
    }
    @GetMapping("/java-questions")
    public List<JavaQuestion> getJavaQuestions() {
            return questionService.getAllJavaQuestions();
    }

    @PostMapping(value = "/save-java", consumes = "application/json", produces = "application/json")
    public JavaQuestion saveJavaQuestion(@RequestBody JavaQuestion question) {
        return questionService.saveJavaQuestion(question);
    }

    @PostMapping("/save-javaList")
    public void saveJavaQuestions(@RequestBody List<JavaQuestion> questionList) {
        questionService.saveJavaList(questionList);
    }

    @GetMapping("/sql-questions")
    public List<SqlQuestion> getSqlQuestions() {
        return questionService.getAllSqlQuestions();
    }

    @PostMapping(value = "/save-sql", consumes = "application/json", produces = "application/json")
    public SqlQuestion saveSqlQuestion(@RequestBody SqlQuestion question) {
        return questionService.saveSqlQuestion(question);
    }

    @PostMapping("/save-sqlList")
    public void saveSqlQuestions(@RequestBody List<SqlQuestion> questionList) {
        questionService.saveSqlList(questionList);
    }

    @GetMapping("/spring-questions")
    public List<SpringQuestion> getSpringQuestions() {
        return questionService.getAllSpringQuestions();
    }

    @PostMapping(value = "/save-spring", consumes = "application/json", produces = "application/json")
    public SpringQuestion saveJavaQuestion(@RequestBody SpringQuestion question) {
        return questionService.saveSpringQuestion(question);
    }

    @PostMapping("/save-springList")
    public void saveSpringQuestions(@RequestBody List<SpringQuestion> questionList) {
        questionService.saveSpringList(questionList);
    }

}
