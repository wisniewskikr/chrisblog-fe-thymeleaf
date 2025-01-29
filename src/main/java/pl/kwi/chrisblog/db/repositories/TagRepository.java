package pl.kwi.chrisblog.db.repositories;

import java.util.List;
import org.springframework.stereotype.Service;
import pl.kwi.chrisblog.db.entities.TagEntity;

@Service
public class TagRepository {
	
	public List<TagEntity> findAllByCategoryId(long categoryId) {
		return null;
	}
	
}
