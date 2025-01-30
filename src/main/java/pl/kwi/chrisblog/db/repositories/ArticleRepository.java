package pl.kwi.chrisblog.db.repositories;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.kwi.chrisblog.clients.ArticleClient;
import pl.kwi.chrisblog.commands.list.ListCommand;
import pl.kwi.chrisblog.db.entities.ArticleEntity;
import pl.kwi.chrisblog.dtos.ArticleResponse;

@Service
public class ArticleRepository {

	private final ArticleClient articleClient;

	public ArticleRepository(ArticleClient articleClient) {
		this.articleClient = articleClient;
	}

	public void findAll(ListCommand command) {	
		
		String searchText = null;
		StringUtils.isNotBlank(command.getSearchText()) {
			searchText = command.getSearchText().toLowerCase();
		}

		ArticleResponse articleResponse = articleClient.findArticles(Long.valueOf(command.getSelectedCategory()), command.getSelectedTag(), command.getCurrentPage() - 1, command.getSelectedSorting(), searchText);
		command.setArticles(articleResponse.articles());
		command.setPages(articleResponse.pages());
		command.setDisableNext(articleResponse.disableNext());
		command.setDisablePrevious(articleResponse.disablePrevious());
	}

	public Optional<ArticleEntity> findById(long articleId) {
		return Optional.ofNullable(articleClient.findArticleById(articleId));
	}
	
}
