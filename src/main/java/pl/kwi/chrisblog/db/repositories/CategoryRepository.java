package pl.kwi.chrisblog.db.repositories;

import java.util.List;
import java.util.stream.StreamSupport;
import org.springframework.stereotype.Service;
import pl.kwi.chrisblog.clients.CategoryClient;
import pl.kwi.chrisblog.db.entities.CategoryEntity;
import pl.kwi.chrisblog.dtos.CategoryResponse;

@Service
public class CategoryRepository {

    private final CategoryClient categoryClient;

    public CategoryRepository(CategoryClient categoryClient) {
        this.categoryClient = categoryClient;
    }

    public List<CategoryEntity> findAll() {
        CategoryResponse categoryResponse = categoryClient.findCategories();
        return StreamSupport.stream(categoryResponse.categories().spliterator(), false)
                                         .toList();
    }
	
}
