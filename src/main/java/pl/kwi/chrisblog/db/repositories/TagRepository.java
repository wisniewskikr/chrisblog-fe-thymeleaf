package pl.kwi.chrisblog.db.repositories;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import pl.kwi.chrisblog.clients.TagClient;
import pl.kwi.chrisblog.commands.list.ListCommand;
import pl.kwi.chrisblog.db.entities.TagEntity;
import pl.kwi.chrisblog.dtos.TagResponse;
import pl.kwi.chrisblog.enums.SortingEnum;

@Service
public class TagRepository {

	private final TagClient tagClient;

	public TagRepository(TagClient tagClient) {
		this.tagClient = tagClient;
	}

	public void findAll(ListCommand command) {

		String searchText = null;
		StringUtils.isNotBlank(command.getSearchText()) {
			searchText = command.getSearchText().toLowerCase();
		}

		TagResponse tagResponse = tagClient.findTags(Long.valueOf(command.getSelectedCategory()), command.getSelectedTag(), command.getCurrentPage() - 1, command.getSelectedSorting(), searchText);
		command.setTags(tagResponse.tags());
	}
	
}
