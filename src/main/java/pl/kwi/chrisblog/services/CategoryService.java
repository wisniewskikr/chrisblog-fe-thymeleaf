package pl.kwi.chrisblog.services;

import java.util.List;
import java.util.stream.StreamSupport;
import org.springframework.stereotype.Service;
import pl.kwi.chrisblog.clients.CategoryClient;
import pl.kwi.chrisblog.dtos.CategoryResponse;
import pl.kwi.chrisblog.entities.CategoryEntity;

@Service
public class CategoryService {

    private final CategoryClient categoryClient;

    public CategoryService(CategoryClient categoryClient) {
        this.categoryClient = categoryClient;
    }

    public List<CategoryEntity> findAll() {
        CategoryResponse categoryResponse = categoryClient.findCategories();
        return StreamSupport.stream(categoryResponse.categories().spliterator(), false)
                                         .toList();
    }
	
}
