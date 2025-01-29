package pl.kwi.chrisblog.db.repositories;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import pl.kwi.chrisblog.db.entities.ArticleEntity;

@Service
public class ArticleRepository {

	public Page<ArticleEntity> findAll(Pageable pageable) {
		return null;
	}

	public Optional<ArticleEntity> findById(long articleId) {
		return null;
	}
	
	public Page<ArticleEntity> findByCategoryIdAsPage(long categoryId, Pageable pageable) {
		return null;
	}
	
	public Page<ArticleEntity> findByTagIdAsPage(long tagId, Pageable pageable) {
		return null;
	}
	
	public Page<ArticleEntity> findBySearchTextAsPage(String searchText, Pageable pageable) {
		return null;
	}
	
	public Page<ArticleEntity> findBySearchTextAndCategoryIdAsPage(String searchText, long categoryId, Pageable pageable) {
		return null;
	}
	
}
