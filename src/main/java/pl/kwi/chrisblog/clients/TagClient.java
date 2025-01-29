package pl.kwi.chrisblog.clients;

import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import pl.kwi.chrisblog.db.entities.TagEntity;

@HttpExchange
public interface TagClient {

    @GetExchange("/api/v1/tag")
    public List<TagEntity> findTags(
        @RequestParam("categoryId") Long categoryId,
        @RequestParam(value = "tagId", required = false) Long tagId,
        @RequestParam("page") int page,
        @RequestParam("sorting") String sorting,
        @RequestParam(value = "searchText", required = false) String searchText
        );

}