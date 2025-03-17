package com.aditya.quiz.service;

import com.aditya.quiz.entity.JavaQuestion;
import com.aditya.quiz.entity.SpringQuestion;
import com.aditya.quiz.entity.SqlQuestion;
import com.aditya.quiz.repo.JavaRepo;
import com.aditya.quiz.repo.SpringRepo;
import com.aditya.quiz.repo.SqlRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class  QuestionService {

    @Autowired
    JavaRepo javaRepo;

    @Autowired
    SqlRepo sqlRepo;

    @Autowired
    SpringRepo springRepo;

    public List<JavaQuestion> getAllJavaQuestions()
    {
        List<JavaQuestion> javaRepoAll = javaRepo.findAll();
        return javaRepoAll;
    }

    public JavaQuestion saveJavaQuestion(JavaQuestion question){
        JavaQuestion save = javaRepo.save(question);
        return save;
    }

    public void saveJavaList(List<JavaQuestion> questionList) {
        javaRepo.saveAll(questionList);
    }

    public List<SqlQuestion> getAllSqlQuestions()
    {
        List<SqlQuestion> sqlRepoAll = sqlRepo.findAll();
        return sqlRepoAll;
    }

    public SqlQuestion saveSqlQuestion(SqlQuestion question)
    {
        SqlQuestion save = sqlRepo.save(question);
        return save;
    }

    public void saveSqlList(List<SqlQuestion> questionList) {
        sqlRepo.saveAll(questionList);
    }

    public List<SpringQuestion> getAllSpringQuestions()
    {
        List<SpringQuestion> springRepoAll = springRepo.findAll();
        return springRepoAll;
    }

    public SpringQuestion saveSpringQuestion(SpringQuestion question){
        SpringQuestion save = springRepo.save(question);
        return save;
    }

    public void saveSpringList(List<SpringQuestion> questionList) {
        springRepo.saveAll(questionList);
    }

}
