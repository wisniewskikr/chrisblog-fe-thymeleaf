package pl.kwi.chrisblog.clients;

import java.util.List;

import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import pl.kwi.chrisblog.db.entities.CategoryEntity;

@HttpExchange
public interface CategoryClient {

    @GetExchange("/api/v1/category")
    public List<CategoryEntity> findCategories();

}