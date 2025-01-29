package pl.kwi.chrisblog.commands.article;

import lombok.ToString;
import pl.kwi.chrisblog.commands.abstr.AbstrBlogCommand;
import pl.kwi.chrisblog.db.entities.ArticleEntity;

@ToString
public class ArticleCommand extends AbstrBlogCommand {
	
	
	private ArticleEntity article;
	private Long articleId;

	
	public ArticleEntity getArticle() {
		return article;
	}
	public void setArticle(ArticleEntity article) {
		this.article = article;
	}
	
	public Long getArticleId() {
		return articleId;
	}
	public void setArticleId(Long articleId) {
		this.articleId = articleId;
	}
	
	
}
