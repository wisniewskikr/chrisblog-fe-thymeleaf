package pl.kwi.chrisblog.clients;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import pl.kwi.chrisblog.dtos.ArticleResponse;
import pl.kwi.chrisblog.entities.ArticleEntity;

@HttpExchange
public interface ArticleClient {

    @GetExchange("/api/v1/article")
    public ArticleResponse findArticles(
        @RequestParam("categoryId") Long categoryId,
        @RequestParam(value = "tagId", required = false) Long tagId,
        @RequestParam("page") int page,
        @RequestParam("sorting") String sorting,
        @RequestParam(value = "searchText", required = false) String searchText 
        );

    @GetExchange("api/v1/article/{id}")
    public ArticleEntity findArticleById(@PathVariable Long id);

}