package pl.kwi.chrisblog.db.repositories;

import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import pl.kwi.chrisblog.clients.ArticleClient;
import pl.kwi.chrisblog.commands.list.ListCommand;
import pl.kwi.chrisblog.db.entities.ArticleEntity;
import pl.kwi.chrisblog.dtos.ArticleResponse;

@Service
public class ArticleRepository {

	public static final String HOME = "home";

	private final ArticleClient articleClient;

	public ArticleRepository(ArticleClient articleClient) {
		this.articleClient = articleClient;
	}

	public void findAll(ListCommand command) {			
		
		Long categoryId = (HOME.equals(command.getSelectedCategory())) ? 0L : Long.valueOf(command.getSelectedCategory());
		Long tagId = (command.getSelectedTag() == null) ? 0L : command.getSelectedTag();
		int page = command.getCurrentPage() - 1;
		String sorting = command.getSelectedSorting();
		String searchText = (StringUtils.isNotBlank(command.getSearchText())) ? command.getSearchText().toLowerCase() : null;

		ArticleResponse articleResponse = articleClient.findArticles(categoryId, tagId, page, sorting , searchText);
		command.setArticles(articleResponse.articles());
		command.setPages(articleResponse.pages());
		command.setDisableNext(articleResponse.disableNext());
		command.setDisablePrevious(articleResponse.disablePrevious());
		
	}

	public Optional<ArticleEntity> findById(long articleId) {
		return Optional.ofNullable(articleClient.findArticleById(articleId));
	}
	
}
