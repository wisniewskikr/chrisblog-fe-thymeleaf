package pl.kwi.chrisblog.db.repositories;

import java.util.List;
import org.springframework.stereotype.Service;
import pl.kwi.chrisblog.clients.TagClient;
import pl.kwi.chrisblog.db.entities.TagEntity;
import pl.kwi.chrisblog.enums.SortingEnum;

@Service
public class TagRepository {

	private final TagClient tagClient;

	public TagRepository(TagClient tagClient) {
		this.tagClient = tagClient;
	}

	public List<TagEntity> findAllByCategoryId(long categoryId) {
		return tagClient.findTags(categoryId, null, 1, SortingEnum.DATE_INCREASING.toString(), null);
	}
	
}
