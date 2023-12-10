package com.ll.cha;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/articles")
public class ApiV1ArticlesController {
    List<Article> articles = new ArrayList<>() {{
        new Article(1L, "title1");
        new Article(2L, "title2");
    }};

    @GetMapping("")
    public List<Article> getArticles() {
        return articles;
    }

    @Setter
    @Getter
    public static class WriteRequestBody {
        private String title;
        private String body;
    }

    @PostMapping("")
    public Map write(@RequestBody WriteRequestBody requestBody) {
        articles.add(new Article(3L, requestBody.getTitle()));

        return Map.of("msg", "게시물이 작성되었습니다.");
    }
}
