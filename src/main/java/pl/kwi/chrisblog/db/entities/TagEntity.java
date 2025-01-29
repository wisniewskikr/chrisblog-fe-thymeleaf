package pl.kwi.chrisblog.db.entities;

import java.util.HashSet;
import java.util.Set;

public class TagEntity {
	
    private Long id;
    private String name;
    private Set<ArticleEntity> articles = new HashSet<ArticleEntity>();
    
	public TagEntity() {
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
