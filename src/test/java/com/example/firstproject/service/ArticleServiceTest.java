package com.example.firstproject.service;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ArticleServiceTest {
    @Autowired
    ArticleService articleService;

    @Test
    void index() {
        // 1. 예상 data
        Article a = new Article(1L,"aaa","111");
        Article b = new Article(2L,"bbb","222");
        Article c = new Article(3L,"ccc","333");
        List<Article> expected = new ArrayList<Article>(Arrays.asList(a, b, c));

        // 2. 실제 data


        List<Article> articles = articleService.index();

        // 3. 비교 및 검증
        assertEquals(expected.toString(), articles.toString());

    }

    @Test
    void show_succeed_exist_id_input() {
        // 1. 예상 데이터
        Long id = 1L;
        Article expected = new Article(id, "aaa", "111");

        // 2. 실제 data
        Article article = articleService.show(id);

        // 3. 비교 및 검증
        assertEquals(expected.toString(), article.toString());

    }

    @Test
    void show_fail_no_exist_id_input(){
        Long id = -1L;
        Article expected = null;
        Article article = articleService.show(id);
        assertEquals(expected, article);

    }


    @Test
    @Transactional
    void create_succeed_dtoHasOnlyTitleAndContent_input() {
        String title = "ddd";
        String content = "444";
        ArticleForm dto = new ArticleForm(null, title, content);
        Article expected = new Article(4L, title, content);

        Article article = articleService.create(dto);

        assertEquals(expected.toString(), article.toString());
    }

    @Test
    void create_fail(){

    }
}