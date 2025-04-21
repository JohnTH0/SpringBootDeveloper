package com.th.sbdeveloper.dto;

import com.th.sbdeveloper.domain.Article;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddArticleRequest {

    private String title;
    private String content;

    public Article toEntity() { // 생성자를 사용해 객체를 생성, DTO to Entity
        return Article.builder()
                .title(title)
                .content(content)
                .build();
    }
}
