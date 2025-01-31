package pl.kwi.chrisblog.entities;

import java.util.HashSet;
import java.util.Set;

import pl.kwi.chrisblog.dtos.ArticleEntity;

public class CategoryEntity {

	private Long id;
    private String name;
    private Set<ArticleEntity> articles = new HashSet<ArticleEntity>();
    
	public CategoryEntity() {
	}	

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Set<ArticleEntity> getArticles() {
		return articles;
	}
	public void setArticles(Set<ArticleEntity> articles) {
		this.articles = articles;
	}

}
