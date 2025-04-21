package com.th.sbdeveloper.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.th.sbdeveloper.domain.Article;
import com.th.sbdeveloper.dto.AddArticleRequest;
import com.th.sbdeveloper.dto.UpdateArticleRequest;
import com.th.sbdeveloper.repository.BlogRepository;

import java.util.List;

@RequiredArgsConstructor //final이나 @Notnull이 붙은 필드에 대한 생성자를 추가
@Service // register Bean
public class BlogService {
    private final BlogRepository blogRepository;

    public Article save(AddArticleRequest request) {
        return blogRepository.save(request.toEntity());
    }

    public List<Article> findAll(){
        return blogRepository.findAll();
    }

    public Article findById(long id) {
        return blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Article not found:" + id));
    }

    public void deleteById(long id) {
        blogRepository.deleteById(id);
    }

    @Transactional
    public Article update(long id, UpdateArticleRequest request) {
        Article article = blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found : " + id));

        article.update(request.getTitle(), request.getContent());

        return article;
    }
}
