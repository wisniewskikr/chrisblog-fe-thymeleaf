package pl.kwi.chrisblog.dtos;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;
import pl.kwi.chrisblog.enums.TemplateEnum;

public class ArticleEntity {
	
    private Long id;
    private String pageDescription;
    private String title;
    private String description;
    private Date date;
    private String author;
    private TemplateEnum template;
    private String url;
    private String content;
    private CategoryEntity category;
    private Set<TagEntity> tags = new HashSet<TagEntity>();
    
	public ArticleEntity() {
	}	

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}	

	public String getPageDescription() {
		return pageDescription;
	}
	public void setPageDescription(String pageDescription) {
		this.pageDescription = pageDescription;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}	
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}

	public TemplateEnum getTemplate() {
		return template;
	}
	public void setTemplate(TemplateEnum template) {
		this.template = template;
	}

	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}	

	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	public CategoryEntity getCategory() {
		return category;
	}
	public void setCategory(CategoryEntity category) {
		this.category = category;
	}
	
	public Set<TagEntity> getTags() {
		return tags;
	}
	public void setTags(Set<TagEntity> tags) {
		this.tags = tags;
	}	

}
