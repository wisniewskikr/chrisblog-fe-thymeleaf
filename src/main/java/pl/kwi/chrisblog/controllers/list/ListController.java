package pl.kwi.chrisblog.controllers.list;

import java.util.Arrays;

import jakarta.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.slf4j.Slf4j;
import pl.kwi.chrisblog.commands.list.ListCommand;
import pl.kwi.chrisblog.controllers.abstr.AbstrPaginationController;
import pl.kwi.chrisblog.db.entities.ArticleEntity;
import pl.kwi.chrisblog.db.repositories.ArticleRepository;
import pl.kwi.chrisblog.db.repositories.CategoryRepository;
import pl.kwi.chrisblog.db.repositories.TagRepository;
import pl.kwi.chrisblog.enums.SortingEnum;
import pl.kwi.chrisblog.utils.SessionUtils;


@Slf4j
@Controller
@RequestMapping(value="/")
public class ListController extends AbstrPaginationController {
	
	
	public static final String HOME = "home";

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ArticleRepository articleRepository;
	
	@Autowired
	private TagRepository tagRepository;
	
	@ModelAttribute
	public void addAttributes(Model model) {
	    model.addAttribute("categories", categoryRepository.findAll());
	    model.addAttribute("sorting", Arrays.asList(SortingEnum.values()));	    
	}
	
	@Value(value = "${articles.on.page}")
    private int articlesOnPage;
	@Value(value = "${pagination.items.on.page}")
    private int paginationItemsOnPage;

	
	@RequestMapping(method = RequestMethod.GET)
	public String init(
			@ModelAttribute("command") ListCommand command,
			HttpSession session) {
		
		mapSessionToCommand(command, session);
		handleList(command);
		
		log.info("Command class: {}", command );
		return "list/list";
		
	}	
	
	@RequestMapping(method = RequestMethod.POST)
	public String display(
			@ModelAttribute("command") ListCommand command) {
		
		handleList(command);
		
		log.info("Command class: {}", command );
		return "list/list";
		
	}	
	
	@RequestMapping(value="/article", method = RequestMethod.POST)
	public String submitArticle(
			@ModelAttribute("command") ListCommand command,
			HttpSession session) {
						
		SessionUtils.mapCommandToSession(command, session);		
		log.info("Command class: {}", command );
		return "redirect:/article/" + command.getSelectedArticle();
		
	}
	
	private void mapSessionToCommand(ListCommand command, HttpSession session) {
		
		if (session.getAttribute("currentPage") == null) {
			return;
		}
		
		SessionUtils.mapSessionToCommand(command, session);
		
	}
	
	private void handleList(ListCommand command) {
		
		Page<ArticleEntity> page = null;
		
		if(isTag(command)) {
			log.debug("Type of List: TAG");
			page = handleTag(command);
		} else if(isSearch(command)) {
			log.debug("Type of List: SEARCH");
			page = handleSearch(command);
		} else if(isHomeCategory(command)) {
			log.debug("Type of List: HOME CATEGORY");
			page = handleHomeCategory(command);
		} else {
			log.debug("Type of List: OTHER CATEGORIES");
			page = handleOtherCategories(command);
		}	
		
		handlePagination(command, page, paginationItemsOnPage);
		
	}
	
	private boolean isTag(ListCommand command) {		
		return (command.getSelectedTag() != null) ? true : false;		
	}
	
	private boolean isSearch(ListCommand command) {		
		return (StringUtils.isNotBlank(command.getSearchText())) ? true : false;		
	}
	
	private boolean isHomeCategory(ListCommand command) {		
		return (HOME.equals(command.getSelectedCategory())) ? true : false;		
	}
	
	private Page<ArticleEntity> handleTag(ListCommand command) {
		
		Pageable pageable = PageRequest.of(command.getCurrentPage() - 1, articlesOnPage, handleSorting(command.getSelectedSorting()));
		Page<ArticleEntity> page = articleRepository.findByTagIdAsPage(command.getSelectedTag(), pageable);
		command.setArticles(page.getContent());
		command.setTags(tagRepository.findAllByCategoryId(Long.valueOf(command.getSelectedCategory())));
		return page;
		
	}
	
	private Page<ArticleEntity> handleSearch(ListCommand command) {
		
		Pageable pageable = PageRequest.of(command.getCurrentPage() - 1, articlesOnPage, handleSorting(command.getSelectedSorting()));
		Page<ArticleEntity> page = null;
		if (HOME.equals(command.getSelectedCategory())) {
			page = articleRepository.findBySearchTextAsPage(command.getSearchText().toLowerCase(), pageable);
		} else {
			page = articleRepository.findBySearchTextAndCategoryIdAsPage(command.getSearchText().toLowerCase(), Long.valueOf(command.getSelectedCategory()), pageable);
			command.setTags(tagRepository.findAllByCategoryId(Long.valueOf(command.getSelectedCategory())));
		}		
		command.setArticles(page.getContent());		
		return page;
		
	}
	
	private Page<ArticleEntity> handleHomeCategory(ListCommand command) {
		
		Pageable pageable = PageRequest.of(command.getCurrentPage() - 1, articlesOnPage, handleSorting(command.getSelectedSorting()));
		Page<ArticleEntity> page = articleRepository.findAll(pageable);
		command.setArticles(page.getContent());		
		return page;
		
	}
	
	private Page<ArticleEntity> handleOtherCategories(ListCommand command) {
		
		Pageable pageable = PageRequest.of(command.getCurrentPage() - 1, articlesOnPage, handleSorting(command.getSelectedSorting()));
		Page<ArticleEntity> page = articleRepository.findByCategoryIdAsPage(Long.valueOf(command.getSelectedCategory()), pageable);
		command.setArticles(page.getContent());
		command.setTags(tagRepository.findAllByCategoryId(Long.valueOf(command.getSelectedCategory())));
		return page;
		
	}
	
	private Sort handleSorting(String selectedSorting) {
		
		SortingEnum sortingEnum = SortingEnum.getEnum(selectedSorting);
		
		switch (sortingEnum) {
		case TITLE_INCREASING:
			return Sort.by(Sort.Direction.ASC, "title");
		case TITLE_DECREASING:
			return Sort.by(Sort.Direction.DESC, "title");	
		case DATE_INCREASING:
			return Sort.by(Sort.Direction.ASC, "date");
		case DATE_DECREASING:
			return Sort.by(Sort.Direction.DESC, "date");
		case AUTHOR_INCREASING:
			return Sort.by(Sort.Direction.ASC, "author");
		case AUTHOR_DECREASING:
			return Sort.by(Sort.Direction.DESC, "author");
		default:
			return Sort.by(Sort.Direction.DESC, "title");
		}
		
	}
	
	
}