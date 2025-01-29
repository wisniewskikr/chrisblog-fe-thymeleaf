package pl.kwi.chrisblog.db.repositories;

import java.util.List;

import org.springframework.stereotype.Service;

import pl.kwi.chrisblog.clients.CategoryClient;
import pl.kwi.chrisblog.db.entities.CategoryEntity;

@Service
public class CategoryRepository {

    private final CategoryClient categoryClient;

    public CategoryRepository(CategoryClient categoryClient) {
        this.categoryClient = categoryClient;
    }

    public List<CategoryEntity> findAll() {
        return categoryClient.findCategories();
    }
	
}
