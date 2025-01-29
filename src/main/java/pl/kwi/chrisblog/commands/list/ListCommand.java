package pl.kwi.chrisblog.commands.list;

import lombok.ToString;
import pl.kwi.chrisblog.commands.abstr.AbstrBlogCommand;
import pl.kwi.chrisblog.db.entities.ArticleEntity;
import pl.kwi.chrisblog.db.entities.TagEntity;

@ToString
public class ListCommand extends AbstrBlogCommand {
		
	private Iterable<ArticleEntity> articles;
	private Long selectedArticle;
	private Iterable<TagEntity> tags;

	
	public Iterable<ArticleEntity> getArticles() {
		return articles;
	}
	public void setArticles(Iterable<ArticleEntity> articles) {
		this.articles = articles;
	}
	
	public Long getSelectedArticle() {
		return selectedArticle;
	}
	public void setSelectedArticle(Long selectedArticle) {
		this.selectedArticle = selectedArticle;
	}
	
	public Iterable<TagEntity> getTags() {
		return tags;
	}
	public void setTags(Iterable<TagEntity> tags) {
		this.tags = tags;
	}
	
	
}